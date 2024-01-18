package com.daw.atm;

import java.time.LocalDate;

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

		Compte compte2 = new Compte("2222222222222222", 10, LocalDate.now());

		System.out.println(compte2);
		compte2.ingresar(2100);
		System.out.println(compte2);
		compte2.retirar(20);
		System.out.println(compte2);
		compte2.retirar(2091);
		System.out.println(compte2);

		// System.out.println(compte1.numero + " " + compte1.saldo + " " + compte1.DataObertura);




	}

}
