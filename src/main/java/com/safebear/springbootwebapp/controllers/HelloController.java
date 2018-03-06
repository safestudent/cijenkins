package com.safebear.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creates a 'Hello World' message on the /hello page
 *
 * @author Simon Stratton
 * @version 1.0
 * @since 05/03/18
 */

@Controller
public class HelloController {

    /**
     * Maps the /hello page to this response
     * @return String the Hello World message
     */
    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello World! Version 2";
    }

}
