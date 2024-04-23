package com.daw.atm.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.daw.atm.models.ATM;
import com.daw.atm.models.Operacio;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.NuevoPin;
import com.daw.atm.models.DTO.Transfer;

@Controller
public class ATMController {
    
    @Autowired
    ATM atm;

    @GetMapping("/prova")
    public String prova() {
        return "plantilla";
    }

    @GetMapping("/")
    public String mostrarFormulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "login";
    }

    @PostMapping("/login")
    public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model) {
        System.out.println(credencials.getNumber());
        System.out.println(credencials.getPIN());
        try {
            int PIN = Integer.parseInt(credencials.getPIN());
            boolean ok = atm.assignarTargeta(credencials.getNumber(), PIN);
            if (!ok) {
                model.addAttribute("missatge", "Error en les credencials");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("missatge", "Error en el PIN, ha de ser numeric");
            return "login";
        }
        return "redirect:/operacions";
    }

    @GetMapping("/operacions")
    public String operacions(Model model) {
        String usuari = atm.getTargetaActual().getCompteCorrent().getPropietari().getNom();
        model.addAttribute("usuari", usuari);
        return "operacions";
    }

    @GetMapping("/ingressar")
    public String ingressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ingressar";
    }

    @PostMapping("/ingressar")
    public String processaringressar(@ModelAttribute Diners diners, Model model) {
        try {
            int quantitat = Integer.parseInt(diners.getQuantitat());
            atm.ingressar(quantitat);
            model.addAttribute("missatge", "S'ha realitzat el ingrés");
        } catch (Exception e) {
            model.addAttribute("missatge", "Quantitat ha de ser un enter");
        }
        return "ingressar";
    }

    @GetMapping("/retirar")
    public String retirar(Model model) {
        model.addAttribute("diners", new Diners());
        return "retirar";
    }

    @PostMapping("/retirar")
    public String processarretirar(@ModelAttribute Diners diners, Model model) {
        try {
            int quantitat = Integer.parseInt(diners.getQuantitat());
            atm.retirar(quantitat);
            model.addAttribute("missatge", "S'han tret els diners");
        } catch (Exception e) {
            model.addAttribute("missatge", "Quantitat ha de ser un enter");
        }
        return "retirar";
    }

    @GetMapping("/transferencia")
    public String transferencia(Model model) {
        model.addAttribute("transfer", new Transfer());
        String llistacomptes[] =atm.getBanc().getNumCompte();
        model.addAttribute("llistacomptes", llistacomptes);
        return "transferencia";
    }
    @PostMapping("/transferencia")
    public String processarTransferencia(@ModelAttribute Transfer transf, Model model){

        if (!atm.isLogged()) {
            return "redirect:";
        }

        try {
            double quantitat = Double.parseDouble(transf.getQuantitat());
            if(atm.transferencia(quantitat, transf.getNumero())){
            model.addAttribute("missatge", "Operació efectuada");}
            else{
                model.addAttribute("missatge","(ERR0R) Operació incorrecta");
            }
        } catch (Exception e) {
            model.addAttribute("transfer", "(ERR0R) Transferència.");
        }
        String llistacomptes[]=atm.getBanc().getNumCompte();
        model.addAttribute("llistacomptes", llistacomptes);
        return "transferencia";
    }

    @GetMapping("/saldo")
    public String saldo(Model model){
        double saldo=atm.getTargetaActual().getCompteCorrent().getSaldo();
        model.addAttribute("saldo",saldo);
        return "saldo";
    }

    @GetMapping("/moviments")
    public String moviments(Model model) {
        ArrayList<Operacio> operacions = atm.getTargetaActual().getCompteCorrent().getLlistaMoviments();
        model.addAttribute("operacions", operacions);
        return "moviments";
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
                model.addAttribute("missatge", "(PIN) Cambiado Exitosamente!");
            } else {
                model.addAttribute("missatge", "(PIN) No se pudo cambiar. Verifica tus credenciales!");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("missatge", "(PIN) Debe ser numérico!");
        }
        return "cambiar_pin";
    }
}
