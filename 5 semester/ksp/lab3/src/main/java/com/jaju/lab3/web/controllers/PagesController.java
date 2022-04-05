package com.jaju.lab3.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(value = "*")
@Controller
public class PagesController {
    @GetMapping(path = {"*"})
    public String getStartPage() {
        return "tab1";
    }

    @GetMapping(path = "/tab2")
    public String getSecondPage() {
        return "tab2";
    }

    @GetMapping(path = "/tab3")
    public String getThirdPage() {
        return "tab3";
    }

}
