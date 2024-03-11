package com.daw.atm.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.atm.models.ATM;
import java.lang.String;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;



@Controller
public class ATMController {

    @Autowired
    ATM atm;

    @GetMapping("/")
    public String mostrarformulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "login";
    }

    @GetMapping("/operacions")
    public String operacions(Model model) {
        return "operacions";
    }

    @GetMapping("/ingressar")
    public String ingressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ingressar";
    }

    @PostMapping("/ingressar")
    public String processaringressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ingressar";
    }

    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model) {
        System.out.println(credencials.getNumber());
        System.out.println(credencials.getPIN());

        try {

            int PIN = Integer.parseInt(credencials.getPIN());
            boolean ok = atm.assignarTargeta(credencials.getNumber(), PIN);
            model.addAttribute("missatge", "Error en les Credencals");
            if(!ok) return "login";
        }
        catch(Exception e) {
            model.addAttribute("missatge", "Error, el PIN ha de ser numeric");
            return "login";

        }

        return "redirect:/operacions";
    }
}

