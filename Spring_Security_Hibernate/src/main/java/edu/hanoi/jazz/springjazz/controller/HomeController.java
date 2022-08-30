package edu.hanoi.jazz.springjazz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Hello Java Class");
        return modelAndView;
    }

    @GetMapping("nguoi-dung")
    public ModelAndView forUser() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "This is protected page !");
        return modelAndView;
    }

    @GetMapping("dang-nhap")
    public ModelAndView login(@RequestParam(value = "error", required = false) Optional<String> error) {
        ModelAndView modelAndView = new ModelAndView("login");

        if (error.isPresent()) {
            modelAndView.addObject("error", "Incorrect username or password !");
        }

        return modelAndView;
    }
}
