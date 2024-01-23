package com.daw.atm;

import java.time.LocalDate;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.atm.models.Compte;
import com.daw.atm.models.Persona;

//import com.daw.atm.model.Person;


@SpringBootApplication
public class ATMApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(ATMApplication.class, args);		

		// Proves aquí....
		System.out.println("Primeres proves");

		Compte compte1 = new Compte();
		// compte1.numero = "111111111111111";
		// compte1.saldo = 33.0;
		// compte1.DataObertura = LocalDate.now();

		compte1.setNumero("1111111111111111");
		compte1.setSaldo(33.0);
		compte1.setDataObertura(LocalDate.now());

		System.out.println(compte1.getNumero() + " " + compte1.getSaldo() + " " + compte1.getDataObertura());

		System.out.println(compte1);

		Compte compte2 = new Compte(222222222, 10, LocalDate.now()); // Mostrar

		System.out.println(compte2);
		compte2.ingresar(2100); // Ingresar quantitat
		System.out.println(compte2);
		compte2.retirar(20); // Retirar quantitat
		System.out.println(compte2);
		compte2.retirar(2091); // Retirar pero no ha de deixar
		System.out.println(compte2);

		Persona p = new Persona("Alex", "Sants", "111111A", LocalDate.parse("2020-01-01"));
		System.out.println(p);

		Compte c = new Compte(1111111, 200, LocalDate.now());
		c.setPropietari(p);

		System.out.println(c.getSaldo()); //200

		System.out.println(c.getPropietari().getNom());

		//Persona[] persones = new Persona[5];
		// for (int i = 0; i < persones.length; i++) {
		// 	persones[1] = new Persona();		
	    //	}

		//persones[0] new Persona("Alex", "Suarez", "11111111A", LocalDate.parse("2020-01-01"));
		//persones[1] new Persona("Felpie", "Suarez", "22222222A", LocalDate.parse("2020-01-01"));
		//persones[2] new Persona("Carlos", "Suarez", "33333333A", LocalDate.parse("2020-01-01"));
		//persones[3] new Persona("Elisei", "Suarez", "44444444A", LocalDate.parse("2020-01-01"));
		//persones[4] new Persona("Roman", "Suarez", "55555555A", LocalDate.parse("2020-01-01"));

		Persona[] persones = {
	    new Persona("Alex", "Suarez", "11111111A", LocalDate.parse("2020-01-01")),
		new Persona("Felpie", "Suarez", "22222222A", LocalDate.parse("2020-01-01")),
		new Persona("Carlos", "Suarez", "33333333A", LocalDate.parse("2020-01-01")),
		new Persona("Elisei", "Suarez", "44444444A", LocalDate.parse("2020-01-01")),
		new Persona("Roman", "Suarez", "55555555A", LocalDate.parse("2020-01-01"))
		};

		for (int i = 0; i < persones,length; i++) {
		System.out.println(persones[1].getNom());
		}

		for (Persona e : persones) {
			System.out.println(pe.getNom());
		}






	}

}
