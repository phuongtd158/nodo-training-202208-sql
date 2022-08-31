package edu.hanoi.jazz.springjazz.controller;

import edu.hanoi.jazz.springjazz.dao.GroupDAO;
import edu.hanoi.jazz.springjazz.dao.UserDAO;
import edu.hanoi.jazz.springjazz.model.Group;
import edu.hanoi.jazz.springjazz.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("add-or-update")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("user_form", "command", new User());
        modelAndView.addObject("groups", toGroupMap(groupDAO.list()));
        return modelAndView;
    }

    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("user_list");
        modelAndView.addObject("users", userDAO.list());
        return modelAndView;
    }

    @PostMapping("add-or-update")
    public ModelAndView addOrUpdate(@Valid @ModelAttribute("command") User user, BindingResult result) {
        ModelAndView modelAndView;
        if (result.hasErrors()) {
            modelAndView = new ModelAndView("user_form", "command", new User());
            modelAndView.addObject("groups", toGroupMap(groupDAO.list()));
            modelAndView.addObject("errors", result);
            return modelAndView;
        }
        if (user.getUsername() != null) {
            userDAO.update(user);
        } else {
            userDAO.insert(user);
        }
        modelAndView = new ModelAndView("redirect:/user/list");
        modelAndView.addObject("users", userDAO.list());
        return modelAndView;
    }

    @GetMapping("delete/{username}")
    public ModelAndView delete(@PathVariable("username") String username) {
        ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
        modelAndView.addObject("users", userDAO.list());
        modelAndView.addObject("groups", toGroupMap(groupDAO.list()));
        userDAO.delete(username);
        return modelAndView;
    }

    @GetMapping("edit/{username}")
    public ModelAndView edit(@PathVariable("username") String username) {
        ModelAndView modelAndView = new ModelAndView("user_form");
        modelAndView.addObject("groups", toGroupMap(groupDAO.list()));
        modelAndView.addObject("command", userDAO.get(username));
        return modelAndView;
    }

    private Map<Integer, String> toGroupMap(List<Group> groups) {
        Map<Integer, String> map = new HashMap<>();

        groups.forEach(group -> {
            map.put(group.getId(), group.getName());
        });

        return map;
    }

}
