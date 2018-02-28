package com.safebear.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Main page controller
 */

@Controller
public class HelloController {

    // map the home page request to 'hello world'
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }

}