package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte {
    
    //atributs
    @Id
    protected String numero;
    protected double saldo;
    protected LocalDate DataObertura;


    @ManyToOne
    protected Client propietari;

    static public String format ="ES1025";
    static public int comptador=0;

    //protected Operacio[] llistaMoviments;
    @Transient
    protected ArrayList<Operacio> llistaMoviments;

    @OneToMany(mappedBy = "compte")
    protected List<Operacio> moviments= new ArrayList<Operacio>();

    public List<Operacio> getMoviments() {
        return moviments;
    }

    public void setMoviments(List<Operacio> moviments) {
        this.moviments = moviments;
    }

    public ArrayList<Operacio> getLlistaMoviments() {
        return llistaMoviments;
    }

    public boolean transferencia(Compte desti, double quantitat) {
        if(this.retirar(quantitat)) {
            desti.ingressar(quantitat);
            Operacio operacio = new Operacio();
            operacio.setDescripcio("Transferència de "+quantitat+" euros al compte "+desti);
        llistaMoviments.add(operacio);
        System.out.println(operacio);
        return true;
        }
        return false;
    }

    public Client getPropietari() {
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
    

    public void ingressar(double quantitat){
        this.saldo= this.saldo +quantitat;

        Operacio operacio = new Operacio();

        operacio.setDescripcio("Ingrés de "+quantitat+" euros");
        llistaMoviments.add(operacio);
        System.out.println(operacio);

    }
    public boolean retirar(double quantitat){
        if (quantitat>saldo) {
            return false;
        }
        else{
            this.saldo = this.saldo - quantitat;
            Operacio operacio = new Operacio();
            operacio.setDescripcio("Retir de "+quantitat+" euros");
            llistaMoviments.add(operacio);
            System.out.println(operacio);
            return true;
        }
        
    }

    public Compte(){
        llistaMoviments= new ArrayList<Operacio>();
    }
    
    
}