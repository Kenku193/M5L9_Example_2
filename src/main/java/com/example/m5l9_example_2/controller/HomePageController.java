package com.example.m5l9_example_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

        @RequestMapping(method = RequestMethod.GET, value = "/")
        public String getHomerPage(){
            return "redirect:/users/";
        }

}
