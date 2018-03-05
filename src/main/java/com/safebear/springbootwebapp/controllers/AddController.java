package com.safebear.springbootwebapp.controllers;

import com.safebear.springbootwebapp.functions.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This is the controller for the /add page. A GET request will return the form to capture
 * the two numbers to be added and the POST request will return the result of adding the two
 * numbers together.
 *
 * @author Simon Stratton
 * @version 1.0
 * @since 05/03/2018
 */

@Controller
public class AddController {

    /**
     * Here's where we handle a GET request for the website
     * @param model the Spring model that accesses Thymeleaf's 'views'
     * @return calculator.html - this is the template we sends to the browser to display the form
     * for capturing the two numbers to add together.
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    /**
     * Here's where we handle a POST request for the website
     * @param calculator we import the calculator attribute from the model
     * @return result.html - this is the template we send to the browser to display the result
     */
    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Calculator calculator){
        return "result";
    }

}
