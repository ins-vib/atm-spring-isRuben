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
		//persona1.nom = "Ruben";
		persona1.setNom("Ruben");
		persona1.setCognom("Garcia");
		persona1.setDni("1111111A");

		System.out.println(persona1.nom + " " + persona1.cognom);
		System.out.println(persona1);
		persona1.parlar();
		persona1.parlar(idioma : "esp");

		Persona persona2 = new Persona();
		persona2.setNom ("Alex");
		persona2.setCognom("Garcia");
		persona2.setDni("1212121B");

		System.out.println(persona2.nom + " " + persona2.cognom);
		System.out.println(persona2);
		persona2.parlar();

		Persona persona3 = new Persona(nom: "Felip", cognom:"Gomez", dni:"1231231C");


	}

}
