package edu.java.spring.controller;

import edu.java.spring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("add")
    public ModelAndView add() {
        return new ModelAndView(
                "student_form",
                "command",
                new Student());
    }

    @PostMapping("save")
    public ModelAndView save(@Valid @ModelAttribute("command") Student student,
                             BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView = new ModelAndView("student_form", "command", student);
            modelAndView.addObject("error", result);
            return modelAndView;
        }

        modelAndView.addObject("student", student);
        modelAndView.setViewName("student_view");

        return modelAndView;
    }
}
