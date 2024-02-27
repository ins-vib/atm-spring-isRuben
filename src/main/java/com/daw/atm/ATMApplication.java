package com.daw.atm;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.atm.models.ATM;
import com.daw.atm.models.Banc;
import com.daw.atm.models.Client;
import com.daw.atm.models.Compte;
import com.daw.atm.models.CompteEstalvi;
import com.daw.atm.models.Empleat;
import com.daw.atm.models.Persona;
import com.daw.atm.models.Targeta;




@SpringBootApplication
public class ATMApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(ATMApplication.class, args);        



        // Proves aquí....
        //System.out.println("Primeres proves...");

        //compte compte1 = new compte();
        /*compte1.numero = "111111111111";
        compte1.saldo = 33.0;
        compte1.DataObertura = LocalDate.now();
        
        System.out.println(compte1.numero+"\n"+compte1.saldo+"\n"+compte1.DataObertura);*/
        
        // Versió private
        //persona persona1 = new persona();     
        
        //comentar esto
        //persona1.nom = "Ana";
    //  persona1.setNom("Ana");
    //  persona1.setCognom("Ponts García");
    //  persona1.setDni("12345678A");

    //  System.out.println(persona1.getNom() + " " + persona1.getDni());
    //  System.out.println(persona1);
    /*  persona1.parlar();
        persona1.cantar();
        persona1.parlar("esp");

        persona persona2 = new persona();

        persona2.setNom("Miquel");
        persona2.setCognom("Ponts García");
        persona2.setDni("23456789B");

        System.out.println(persona2.getNom() + " " + persona2.getCognom());
        System.out.println(persona2);
        persona2.parlar();
        persona2.cantar();

        persona persona3 = new persona("Felipe", "Gómez Sánchez", "34567890C");*/
        //  compte1.setNumero("111111111111");
        //  compte1.setSaldo(33.0);
        //  compte1.setDataObertura(LocalDate.now());

        /*  System.out.println(compte1.getNumero()+"\n"+compte1.getSaldo()+"\n"+compte1.getDataObertura());
            System.out.println(compte1);*/

        /*  compte compte2 = new compte("222222222222", 10.0, LocalDate.now());
            compte2.ingressar(1750);
            System.out.println(compte2);
            compte2.retirar(20);
            System.out.println(compte2);
            boolean resultat = compte2.retirar(2000);
            if(resultat == false)System.out.println("No pots retirar una quantitat major al teu saldo");
            else System.out.println("Retirada correcta");

            System.out.println(compte2);
 */
// semana antes del 5 de febrero
           /*  Persona[] persones ={
                new Persona("Ana", "Ponts", "12345678A",LocalDate.parse("2002-08-09")),
                new Persona("India", "Ulises", "23456789B",LocalDate.parse("2002-08-09")),
                new Persona("Miquel", "Ponts", "34567890D",LocalDate.parse("2002-08-09")),
                new Persona("Maia", "Iglesias", "45678901E",LocalDate.parse("2002-08-09"))
            };

           /* Compte[] comptes = {
                new Compte(1000.0,LocalDate.now(), persones[0]),
                new Compte(1000.0,LocalDate.now(), persones[1]),
                new Compte(1000.0,LocalDate.now(), persones[2]),
                new Compte(1000.0,LocalDate.now(), persones[3]),
            };

            for(Compte c:comptes){
                System.out.println(c);
            }
            System.out.println(Compte.format);

            ATM atm =  new ATM("01A","C/ Nunca jamás 3","Obert");
            ATM atm2 =  new ATM("02A","C/ Maravillas 5 1","Obert");
            atm.obrir();
            System.out.println(atm);
            atm2.tancar();
            System.out.println(atm2);

            System.out.println(Persona.validarDNI("Q2345678A"));
            System.out.println("Continuo");

            int[] numeros = {1,2,3};

            try{
                Scanner teclat = new Scanner(System.in);
                System.out.println("Entra un numero: ");
                int numero = teclat.nextInt();
                System.out.println(numero);
                numeros[100] = 10;
            }
            catch(Exception e){
                System.out.println("No has entrat un enter!");
            }*/
//5/2/2024
          /*   Persona p = new Persona();
            Empleat e  = new Empleat();
            e.setNom("Joan");
            e.setDataNaixement(LocalDate.parse("2000-10-20"));
            e.setSou(130000.0);

            System.out.println(e);
            System.out.println(e.edat());

            Client client1 = new Client();
            Client client2 = new Client("indiaU@prova.com");
            Client client3 = new Client("India", "Ulises", "12345678A", LocalDate.parse("2000-01-01"), "indiaU@prova.com");

            Compte c1 = new Compte();
            c1.setSaldo(1000);
            Compte c2 = new Compte();
            c2.setSaldo(1000);
            c1.transferencia(c2, 500);
            System.out.println(c1.setSaldo());
            System.out.println(c2.setSaldo());

            */

        //Banc banc = new Banc();
            //Compte[] comptes = banc.getLlistaComptes();
            //for(Compte c: comptes) {
            //    System.out.println(c);
            //}
        //Scanner scanner = new Scanner(System.in);
        //SpringApplication.run(ATMApplication.class, args);        
        //Targeta[] targetes= banc.getLlistaTargetes();
        
        //Targeta t= banc.getTargeta("11111111A");
       // if(t==null)System.out.println("No trobada");
        //else{
        //    t.validarPin(1234);
        //}

        //for (Targeta t : targetes){
        //    System.out.println(t.getCompteCorrent().getPropietari().getNom());
        //}

        //ATM atm = new ATM("TM123", "Plaça de la Font, 3", "Obert");
       // boolean acces = atm.assignarTargeta("11112222333A", 1234);
        // System.out.println(acces);



            
    }

}