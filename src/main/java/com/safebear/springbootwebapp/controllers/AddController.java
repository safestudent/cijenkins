package com.safebear.springbootwebapp.controllers;

import com.safebear.springbootwebapp.functions.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CCA_Student on 05/03/2018.
 */

@Controller
public class AddController {

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Calculator calculator){
        return "result";
    }

}
