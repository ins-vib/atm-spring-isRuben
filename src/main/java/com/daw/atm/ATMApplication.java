package com.daw.atm;

import java.time.LocalDate;
import java.util.Scanner;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.atm.models.atm;
import com.daw.atm.models.Compte;
import com.daw.atm.models.Persona;



@SpringBootApplication
public class ATMApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ATMApplication.class, args);

        /*System.out.println("Primeres proves");

        Persona p = new Persona("Ana", "Ponts Sants", "11111111A", LocalDate.parse("2000-01-08"));
        System.out.println(p);

        Compte c = new Compte("11111111111",200,LocalDate.now());
        c.setPropietari(p);

        System.out.println(c.getSaldo()); //200

    System.out.println(c.getPropietari().getNom());
/* 
    //Persona[] persones = new Persona[5];
    //for (int i = 0; i < persones.length; i++) {
    //      persones[i] = new Persona();
        /* 
        persones[0]= new Persona("Ana", "Ponts Sants", "11111111A", LocalDate.parse("2000-01-08"));
        persones[1]= new Persona("Carlos", "Ponts Sants", "22222222B", LocalDate.parse("2000-01-08"));
        persones[2]= new Persona("Felip", "Ponts Sants", "33333333C", LocalDate.parse("2000-01-08"));
        persones[3]= new Persona("Esther", "Ponts Sants", "44444444D", LocalDate.parse("2000-01-08"));
        persones[4]= new Persona("Sandra", "Ponts Sants", "55555555E", LocalDate.parse("2000-01-08"));*/
        Persona[] persones = {
            new Persona("Ana", "Ponts Sants", "11111111A", LocalDate.parse("2000-01-08")),
            new Persona("Carlos", "Ponts Sants", "22222222B", LocalDate.parse("2000-01-08")),
            new Persona("Felip", "Ponts Sants", "33333333C", LocalDate.parse("2000-01-08")),
            new Persona("Esther", "Ponts Sants", "44444444D", LocalDate.parse("2000-01-08")),
            new Persona("Sandra", "Ponts Sants", "55555555E", LocalDate.parse("2000-01-08"))
        };

        for (int i = 0; i < persones.length; i++) {
            System.out.println(persones[i].getNom());
        }

        //for (Persona pe : persones) {
        //  System.out.println(pe.getNom());
            Compte[] comptes = {
                new Compte(1000,LocalDate.now(),persones[0]),
                new Compte(1000,LocalDate.now(),persones[1]),
                new Compte(1000,LocalDate.now(),persones[2]),
                new Compte(1000,LocalDate.now(),persones[3]),
                new Compte(1000,LocalDate.now(),persones[4]),
            };

            for (Compte co : comptes) {
                System.out.println(co);
            }
System.out.println(Compte.format);


        atm atm = new atm("12A", "San Francisco","obert");
        atm atm2 = new atm("12B", "San Francisco","tancat");
        
        atm.obrir();
        System.out.println(atm);
        atm2.tancar();
        System.out.println(atm2);
        
        System.out.println(Persona.validarDNI("Q1111111A"));
            
            System.out.println("continuoooooooo...");
		
		try {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Entra un Numero: ");
		int numero = teclat.nextInt();
		System.out.println(numero);
		} catch(Exception e) {
			System.out.println("No has entrat un enter!");
		}

    
    
    
    }
        
        
        
}