package com.safebear.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CCA_Student on 27/02/2018.
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }

}
