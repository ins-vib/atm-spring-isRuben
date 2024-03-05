package com.daw.atm.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.atm.models.ATM;
import com.daw.atm.models.DTO.Credencials;



@Controller
public class ATMController {

    @Autowired
    ATM atm;
     
    @GetMapping("/")
    public String inici() {
        return "prova";
    }

    @GetMapping("/prova")
    public String prova() {
        return "plantilla";
    }

    @GetMapping("/login")
    public String mostrarformulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "login";
    }

    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials) {
        System.out.println(credencials.getNumber());
        System.out.println(credencials.getPIN());
        return "prova";
    }
}
