package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte {
    
    //atributs
    @Id
    protected String numero;
    protected double saldo;
    protected LocalDate DataObertura;
    protected Client propietari;

    static public String format ="ES1025";
    static public int comptador=0;

    //protected Operacio[] llistaMoviments;
    protected ArrayList<Operacio> llistaMoviments;

    public boolean transferencia(Compte desti, double quantitat) {
        if(this.retirar(quantitat)) {
        return true;
        }
        return false;
    }

    public ArrayList<Operacio> getLlistaMoviments() {
        return llistaMoviments;
    }

    public Persona getPropietari() {
        return propietari;
    }
    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public LocalDate getDataObertura() {
        return DataObertura;
    }
    public void setDataObertura(LocalDate dataObertura) {
        DataObertura = dataObertura;
    }
    @Override
    public String toString() {
        return numero +" "+saldo+" "+ DataObertura+ " "+ propietari.getDni();
    }
    public Compte(double saldo, Client propietari) {
        comptador++;

        this.numero = format+String.format("%08d", comptador);
        this.saldo = saldo;
        this.DataObertura = LocalDate.now();
        this.propietari= propietari;
        //llistaMoviments = new Operacio[10];
        llistaMoviments = new ArrayList<Operacio>();
        llistaMoviments.add(new Operacio());
        llistaMoviments.add(new Operacio());
        llistaMoviments.add(new Operacio());
        
        llistaMoviments.remove(0);
        //for(int i = 0; i < llistaMoviments.size(); i++) {
        //System.out.println(llistaMoviments.get(i));
        //}

        for(Operacio operacio: llistaMoviments) {
            System.out.println(operacio);
        }
    }
    

    public void ingressar(int quantitat){
        this.saldo= this.saldo +quantitat;
        Operacio op = new Operacio();
        op.setDescripcio("Ingres de" + quantitat + "€");
        llistaMoviments.add(op);
    }
    public boolean retirar(double quantitat){
        if (quantitat>saldo) {
            return false;
        }
        else{
            this.saldo = this.saldo - quantitat;
            Operacio op = new Operacio();
            op.setDescripcio("Retir de" + quantitat + "€");
            llistaMoviments.add(op);
            System.out.println(op);
            return true;
        }
    }

    public Compte(){

    }
    
    
}