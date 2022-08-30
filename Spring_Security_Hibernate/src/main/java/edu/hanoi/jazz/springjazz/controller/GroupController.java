package edu.hanoi.jazz.springjazz.controller;

import edu.hanoi.jazz.springjazz.dao.GroupDAO;
import edu.hanoi.jazz.springjazz.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/group")
public class GroupController {

    private static final Logger LOGGER = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupDAO groupDAO;

    @GetMapping("add-or-update")
    public ModelAndView addForm() {
        return new ModelAndView("group_from", "command", new Group());
    }

    @PostMapping("add-or-update")
    public ModelAndView addOrUpdate(@Valid @ModelAttribute("command") Group group,
                                    BindingResult result,
                                    @RequestParam("id") Optional<Integer> id) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView = new ModelAndView("group_from", "command", new Group());
            modelAndView.addObject("errors", result);
            return modelAndView;
        }
        if (id.isPresent()) {
            groupDAO.update(group);
        } else {
            groupDAO.insert(group);
        }
        modelAndView.addObject("groups", groupDAO.list());
        modelAndView.setViewName("group_list");
        return modelAndView;
    }

    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("group_list");
        modelAndView.addObject("groups", groupDAO.list());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Optional<Integer> id) {
        if (id.isEmpty()) {
            return new ModelAndView("redirect:/group/list");
        }
        return new ModelAndView("group_from", "command", groupDAO.get(id.get()));
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Optional<Integer> id) {
        if (id.isEmpty()) {
            return new ModelAndView("redirect:/group/list");
        }
        groupDAO.delete(id.get());
        LOGGER.info("Delete success");
        return new ModelAndView("redirect:/group/list");
    }

}
