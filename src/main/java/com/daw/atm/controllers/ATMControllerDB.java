package com.daw.atm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.repositories.TargetaRepository;

@Controller
@RequestMapping("/ATM")
public class ATMControllerDB {
    
    @Autowired
    TargetaRepository targetaRepository;

    @GetMapping("/")
    public String mostrarformulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "ATMDB/login";
    }
    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model) {
        System.out.println("User:" + credencials.getNumber());
        System.out.println("PIN:" + credencials.getPIN());

        try {

            int PIN = Integer.parseInt(credencials.getPIN());

            targetaRepository.findById(credencials.getNumber());
            
            //boolean ok = atm.assignarTargeta(credencials.getNumber(), PIN);
            //if(!ok) {
               // model.addAttribute("missatge", "Error en les Credencals");
                //return "login";
            //}
        }
        catch(Exception e) {
            model.addAttribute("missatge", "Error, el PIN ha de ser numeric");
            return "ATMDB/login";

        }

        return "redirect: ATM/operacions";
    }
}
