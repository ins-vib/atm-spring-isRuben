package com.daw.atm.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.atm.models.Targeta;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.Transfer;
import com.daw.atm.repositories.TargetaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ATM")
public class ATMControllerDB {

    @Autowired
    TargetaRepository targetaRepository;
    
    @GetMapping("/")
    public String mostrarFormulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "ATMDB/login";
    }

    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model, HttpSession session){
        
        System.out.println(credencials.getNumber());
        System.out.println(credencials.getPIN());
        try{
        int PIN= Integer.parseInt(credencials.getPIN());
          Optional<Targeta> optional=targetaRepository.findById(credencials.getNumber());
          if(optional.isPresent()){
            Targeta targetaActual = optional.get();
            if(targetaActual.validarPin(PIN)){
                //TOT OK
                session.setAttribute("numeroTargetaActual", targetaActual.getNumero());
                return "redirect:/ATM/operacions";
            }
            model.addAttribute("missatge","Error en el PIN");
          return "ATMDB/login"; 
          }
          model.addAttribute("missatge","Error en el numero de targeta");
          return "ATMDB/login"; 
        //boolean ok= atm.assignarTargeta(credencials.getNumber(), PIN);
                
                //if (!ok) {
                  //  model.addAttribute("missatge","Error en les credencials");
                //return "login"; 
                //}
    }

        catch(Exception e){
            System.out.println(e);
            model.addAttribute("missatge","Error en el PIN, ha de ser numeric");
            return "ATMDB/login";
        }
        
        //return "redirect:/operacions";

        
    }

    @GetMapping("/operacions")
    public String operacions(Model model) {
        //String usuari= atm.getTargetaActual().getCompteCorrent().getPropietari().getNom();
        //model.addAttribute("usuari", usuari);
        return "ATMDB/operacions";
    }

    @GetMapping("/ingressar")
    public String ingressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ATMDB/ingressar";
    }

    @PostMapping("/ingressar")
    public String processaringressar(@ModelAttribute Diners diners, Model model,
    HttpSession session) {
        try {
            String numeroTargetaActual = (String)session.getAttribute("numeroTargetaActual");
            System.out.println(numeroTargetaActual);
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual = optional.get();
        targetaActual.getCompteCorrent().ingressar(100);        
        System.out.println(targetaActual.getCompteCorrent());
        targetaRepository.save(targetaActual);
        } catch (Exception e) {
            model.addAttribute("missatge", "Error a l'hora d'ingressar.");
        }
        return "ATMDB/ingressar";
    }
}