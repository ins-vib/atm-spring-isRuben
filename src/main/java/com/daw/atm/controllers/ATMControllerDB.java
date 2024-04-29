package com.daw.atm.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.atm.models.Client;
import com.daw.atm.models.Compte;
import com.daw.atm.models.Diposit;
import com.daw.atm.models.Operacio;
import com.daw.atm.models.Targeta;
import com.daw.atm.models.DTO.Consulta;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.Transfer;
import com.daw.atm.repositories.ConsultaRepository;
import com.daw.atm.repositories.OperacioRepository;
import com.daw.atm.repositories.TargetaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ATM")
public class ATMControllerDB {

    @Autowired
    TargetaRepository targetaRepository;

    @Autowired
    OperacioRepository operacioRepository;
    
    List<String> novetats;

    private Diposit llistaDiposit[];

    public ATMControllerDB(){
        novetats = new ArrayList<String>();
        llistaDiposit = new Diposit[4];
        System.out.println("constructor del controlador");
        try{
        llistaDiposit = new Diposit[4];
        llistaDiposit[0] = new Diposit(50, 75);
        llistaDiposit[1] = new Diposit(20, 80);
        llistaDiposit[2] = new Diposit(10, 50);
        llistaDiposit[3] = new Diposit(5, 100);


            File f = new File("novetats.txt");
            if(f.exists()){
                System.out.println("Existeix l'arxiu");
                Scanner lectorFitxer = new Scanner(f);


                String linia;
                while(lectorFitxer.hasNextLine()) {
                    linia = lectorFitxer.nextLine();

                    novetats.add(linia);
                    System.out.println(linia);
            }
            lectorFitxer.close();
        }
            else{
                System.out.println("(ERR0R) No existeix l'Arxiu");
            }
        }
        catch(Exception exception){
            System.out.println("(ERR0R) No es pot accedir al fitxer");
        }
    }
    
    @GetMapping("/")
    public String mostrarFormulariLogin(Model model) {
        model.addAttribute("credencials", new Credencials());

        System.out.println(novetats.size());

        model.addAttribute("novetats", novetats);
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
            else{
            model.addAttribute("missatge","(ERR0R) PIN incorrecte.");
            targetaRepository.save(targetaActual);
            if (targetaActual.isBloquejada()) {
                model.addAttribute("missatge","Targeta bloquejada");
            }
        }model.addAttribute("novetats", novetats);
          return "ATMDB/login"; 
          }
          model.addAttribute("missatge","(ERR0R) Numero de targeta");
          return "login"; 
        //boolean ok= atm.assignarTargeta(credencials.getNumber(), PIN);
                
                //if (!ok) {
                  //  model.addAttribute("missatge","Error en les credencials");
                //return "login"; 
                //}
    }

        catch(Exception e){
            System.out.println(e);
            model.addAttribute("missatge","(ERR0R) PIN ha de ser numeric");
            return "ATMDB/login";
        }
        
        //return "redirect:/operacions";

        
    }

    @GetMapping("/operacions")
    public String operacions(Model model, HttpSession session) {
        String numeroTargetaActual= (String)session.getAttribute("numeroTargetaActual");
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual= optional.get();

        String usuari=targetaActual.getCompteCorrent().getPropietari().getNom();
        model.addAttribute("usuari", usuari);
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
        int quantitat= Integer.parseInt(diners.getQuantitat());
        String numeroTargetaActual= (String)session.getAttribute("numeroTargetaActual");
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual= optional.get();
        targetaActual.getCompteCorrent().ingressar(quantitat);
        System.out.println(targetaActual.getCompteCorrent());
        targetaRepository.save(targetaActual);
        model.addAttribute("missatge", "S'ha realitzat l'ingrés!");

        Operacio operacio = new Operacio();
        operacio.setDescripcio("Ingrés de "+quantitat+"€");
        operacio.setCompte(targetaActual.getCompteCorrent());
        operacioRepository.save(operacio);
        
        for (int i = 0; i < llistaDiposit.length; i++) {
            int bitllets = quantitat / llistaDiposit[i].getValor();
            quantitat=quantitat%llistaDiposit[i].getValor();
            int total= bitllets+llistaDiposit[i].getQuantitat();
            llistaDiposit[i].setQuantitat(total);
            System.out.println(llistaDiposit[i].getValor()+" "+ llistaDiposit[i].getQuantitat());

        }

        } 
        
        catch (Exception e) {
            model.addAttribute("missatge", "(ERR0R) Quantitat ha de ser Enter.");
        }

        
        
        return "ATMDB/ingressar";
    }
    
    @GetMapping("/transferencia")
public String transferencia(Model model, HttpSession session) {
    String numeroTarjetaActual = (String) session.getAttribute("numeroTarjetaActual");
    //List<Targeta> tarjetas = targetaRepository.findAllById(numeroTarjetaActual);
    //model.addAttribute("tarjetas", tarjetas);
    model.addAttribute("transfer", new Transfer());
    return "ATMDB/transferencia";
}

@PostMapping("/transferencia")
public String realizarTransferencia(@ModelAttribute Transfer transfer, Model model, HttpSession session) {
    String numeroTarjetaActual = (String) session.getAttribute("numeroTarjetaActual");
    Optional<Targeta> optionalTarjetaOrigen = targetaRepository.findById(numeroTarjetaActual);
    Optional<Targeta> optionalTarjetaDestino = targetaRepository.findById(transfer.getNumeroTarjetaDestino());

    if (optionalTarjetaOrigen.isPresent() && optionalTarjetaDestino.isPresent()) {
        Targeta tarjetaOrigen = optionalTarjetaOrigen.get();
        Targeta tarjetaDestino = optionalTarjetaDestino.get();
        int cantidad = transfer.getCantidad();

        tarjetaOrigen.getCompteCorrent().retirar(cantidad);
        tarjetaDestino.getCompteCorrent().ingressar(cantidad);

        targetaRepository.save(tarjetaOrigen);
        targetaRepository.save(tarjetaDestino);
    }

    return "redirect:/transferencia";
}



    @GetMapping("/retirar")
    public String retirar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ATMDB/retirar";
    }

    @PostMapping("/retirar")
    public String processarretirar(@ModelAttribute Diners diners, Model model,
    HttpSession session) {

        try {
        int quantitat= Integer.parseInt(diners.getQuantitat());
        String numeroTargetaActual= (String)session.getAttribute("numeroTargetaActual");
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual= optional.get();
        targetaActual.getCompteCorrent().retirar(quantitat);
        System.out.println(targetaActual.getCompteCorrent());
        targetaRepository.save(targetaActual);
        model.addAttribute("missatge", "S'han Retirat els diners!");

        Operacio operacio = new Operacio();
        operacio.setDescripcio("Retir de "+quantitat+"€");
        operacio.setCompte(targetaActual.getCompteCorrent());
        operacioRepository.save(operacio);

        } catch (Exception e) {
            model.addAttribute("missatge", "(ERR0R) Quantitat ha de ser Enter!");
        }
        
        return "ATMDB/retirar";
    }

     @GetMapping("/canviPin")
    public String mostrarFormulariCanviPin(Model model) {
        model.addAttribute("credencials", new Credencials());
        return "ATMDB/canviPin";
    }

    @PostMapping("/canviPin")
    public String CanviPin(@ModelAttribute Credencials credencials, Model model, HttpSession session){

    try {
        model.addAttribute("credencials",credencials);
        String numeroTargetaActual =(String) session.getAttribute("numeroTargetaActual");
        String nouPinString = credencials.getNouPin(); 

        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        
            Targeta targetaActual = optional.get();
            
            String pinActualString = String.valueOf(targetaActual.getPin());
            
            if (!pinActualString.equals(nouPinString)) {

                int nouPin = Integer.parseInt(nouPinString);
                targetaActual.setPin(nouPin);
                targetaRepository.save(targetaActual);
                model.addAttribute("missatge","(PIN) Canviat!");
                return "ATMDB/canviPin";
            } 
            
            else {
                model.addAttribute("missatge","(ERR0R) Credencials.");
            }
        
    } catch (Exception e) {
        model.addAttribute("missatge","(ERR0R) " + e.getMessage());
    }
    return "ATMDB/canviPin";
}
    @GetMapping("/saldo")
    public String saldo(Model model, HttpSession session){
    
    String numeroTargetaActual= (String)session.getAttribute("numeroTargetaActual");
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual= optional.get();

        Client client= targetaActual.getCompteCorrent().getPropietari();
        System.out.println(client.getComptes().toString());
        List<Compte> comptes= client.getComptes();
        model.addAttribute("comptes", client.getComptes());
        double saldo=0;
        
        for (int i = 0; i < comptes.size(); i++) {
            saldo= saldo +(comptes.get(i).getSaldo());
        }

        model.addAttribute("comptes",comptes);
        model.addAttribute("saldo", saldo);

    return "ATMDB/saldo";
  }

    @GetMapping("/moviments")
    public String moviments(Model model, HttpSession session){
    String numeroTargetaActual= (String)session.getAttribute("numeroTargetaActual");
        Optional<Targeta> optional = targetaRepository.findById(numeroTargetaActual);
        Targeta targetaActual= optional.get();

        List<Operacio> operacio= targetaActual.getCompteCorrent().getMoviments();
        model.addAttribute("operacio", operacio);
    return "ATMDB/moviments";
  }

   @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping("/consulta")
    public String mostrarFormularioConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "ATMDB/consulta";
    }

    @PostMapping("/consulta")
    public String procesarConsulta(@ModelAttribute Consulta consulta, Model model) {
        consultaRepository.save(consulta);
        model.addAttribute("mensaje", "La consulta se ha enviado correctamente.");
        return "ATMDB/consulta";
    }


}
