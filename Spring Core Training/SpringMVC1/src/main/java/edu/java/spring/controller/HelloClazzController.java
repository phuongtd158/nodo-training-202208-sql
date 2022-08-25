package edu.java.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloClazzController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printMessage(@RequestParam(value = "data", required = false) String data) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message", data);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "welcome")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("clazz");
        mv.addObject("name", "Tran Duc Phuong!");
        return mv;
    }

    @GetMapping("site")
    public String site() {
        return "redirect:http://facebook.com";
    }

    @GetMapping(value = "data", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    String raw() {
        return "Xin chao moi nguoi";
    }
}
