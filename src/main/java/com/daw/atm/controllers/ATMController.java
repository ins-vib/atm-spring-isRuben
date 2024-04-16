package com.daw.atm.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.atm.models.ATM;
import com.daw.atm.models.Operacio;

import java.lang.String;
import java.util.ArrayList;

import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.NuevoPin;
import com.daw.atm.models.DTO.Transfer;



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
        String usuari= atm.getTargetaActual().getCompteCorrent().getPropietari().getNom();
        model.addAttribute("usuari", usuari);
        return "operacions";
    }

    @GetMapping("/ingressar")
    public String ingressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ingressar";
    }

    @PostMapping("/ingressar")
    public String processarIngressar(@ModelAttribute Diners diners, Model model) {

        if(atm.isLogged()) {
            return "redirect: ";
        } 
        
        try {
            int quantitat = Integer.parseInt(diners.getQuantitat());
            model.addAttribute("missatge", "S'ha realitzat l'ingres.");
        }
        catch(Exception e) {
            model.addAttribute("missatge", "Quantitat ha de ser un enter");
        }
        return "ingressar";
    }

   @GetMapping("/moviments")
    public String moviments(Model model){
        ArrayList<Operacio> operacions= atm.getTargetaActual().getCompteCorrent().getLlistaMoviments();
        model.addAttribute("operacions", operacions);
        return "moviments";

    }

    @GetMapping("/retirar")
    public String retirar(Model model) {
        model.addAttribute("diners", new Diners());
        return "retirar";
    }

    @PostMapping("/retirar")
    public String processarretirar(@ModelAttribute Diners diners, Model model) {
        
        //if(!atm.isLogged()){
        //    return "redirect:";
        //}
        try {
            int quantitat= Integer.parseInt(diners.getQuantitat());
            atm.retirar(quantitat);
            model.addAttribute("missatge","S'ha efectuat el retir");
        } catch (Exception e) {
            model.addAttribute("missatge","Quantitat ha de ser un enter");
        }
        return "retirar";
    }

    @GetMapping ("/transferir")
    public String transferir(Model model) {
        model.addAttribute("transfer", new Transfer());
        return "transferir";
    }

    @PostMapping("/transferir")
    public String processarTransferencia(@ModelAttribute Transfer transf, Model model) {
    try {
        double quantitat = Double.parseDouble(transf.getQuantitat());
        if(atm.transferencia(quantitat, transf.getNumero()) ) {
            model.addAttribute("missatge", "Operacio Efectuada");
        } else {
            model.addAttribute("missatge", "Operacio Incorrecta");
        }
    }
    catch(Exception e){
        model.addAttribute("missatge", "Error en la Transferencia");
    }
    return "transferir";
}
    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model) {
        System.out.println("User:" + credencials.getNumber());
        System.out.println("PIN:" + credencials.getPIN());

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

     @GetMapping("/cambiarPin")
    public String mostrarFormularioCambiarPin(Model model) {
        model.addAttribute("nuevoPin", new NuevoPin());
        return "cambiar_pin";
    }

    @PostMapping("/cambiarPin")
public String procesarCambioPin(@ModelAttribute NuevoPin nuevoPin, Model model) {
    try {
        int pinActual = Integer.parseInt(nuevoPin.getPinActual());
        int nuevoPinValue = Integer.parseInt(nuevoPin.getNuevoPin());
        
        if (atm.cambiarPin(pinActual, nuevoPinValue)) {
            model.addAttribute("mensaje", "PIN cambiado exitosamente.");
        } else {
            model.addAttribute("mensaje", "No se pudo cambiar el PIN. Verifica tus credenciales.");
        }
    } catch (NumberFormatException e) {
        model.addAttribute("mensaje", "El PIN debe ser numérico.");
    }
    return "cambiar_pin";
}

    
}


