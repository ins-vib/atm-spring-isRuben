package com.daw.atm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ATMController {
     
    @GetMapping("/")
    public String inici() {
        return "plantilla";
    }
}
