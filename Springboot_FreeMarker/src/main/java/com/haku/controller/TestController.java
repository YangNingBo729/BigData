package com.haku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testFM")
    public ModelAndView testFM(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("id", "2");
        mav.addObject("name", "chenps");
        mav.addObject("password", "123456");
        return mav;

    }
}
