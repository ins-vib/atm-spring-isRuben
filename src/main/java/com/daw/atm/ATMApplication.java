package com.daw.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.atm.models.Persona;

//import com.daw.atm.model.Person;


@SpringBootApplication
public class ATMApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(ATMApplication.class, args);		

		// Proves aquí....
		System.out.println("Primeres proves");

		Persona persona1 = new Persona();
		persona1.nom = "Ruben";
		persona1.cognom = "Garcia";
		persona1.dni = "1111111A";

		System.out.println(persona1.nom + " " + persona1.cognom);
		System.out.println(persona1);
		persona1.parlar();
		persona1.parlar(idioma = "esp");

		Persona persona2 = new Persona();
		persona2.nom = "Alex";
		persona2.cognom = "Garcia";
		persona2.dni = "1212121B";

		System.out.println(persona2.nom + " " + persona2.cognom);
		System.out.println(persona2);
		persona2.parlar();


	}

}
