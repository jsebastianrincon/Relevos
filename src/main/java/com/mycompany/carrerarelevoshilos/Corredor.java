/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerarelevoshilos;

/**
 *
 * @author SuperUs
 */
public class Corredor extends Thread{
    Equipo equipo;
    private String nombreEquipo;
    private int posiciondeInicio;
    private int posiciondeLlegada;
    private String equipo1;
    private String equipo2;
    private String equipo3;
    
    public Corredor(String nombreEquipo, int posiciondeInicio, int posiciondeLlegada, Equipo equipo ){
        this.nombreEquipo = nombreEquipo;
        this.posiciondeInicio = posiciondeInicio;
        this.posiciondeLlegada = posiciondeLlegada;
        this.equipo = equipo;
    }
    
    
     public void esperar(){       
        synchronized (equipo) {           
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                ex.getMessage();
                System.out.println("Error en Metodo Esperar");
            }
        }
    }
    
        public int correr(int corre) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.getMessage();
            System.out.println("Error en el Metodo Correr");
        }
        int numRam = Utilitaria.generaNumero();
        if (corre == 1) {
            equipo.setPosicion1(equipo.getPosicion1()+ numRam);
            mostrarEquipo();
            return equipo.getPosicion1();
        }
        if (corre == 2) {
            equipo.setPosicion2(equipo.getPosicion2()+ numRam);
            mostrarEquipo();
            return equipo.getPosicion2();
        }
        if (corre == 3) {
            equipo.setPosicion3(equipo.getPosicion3()+ numRam);
            mostrarEquipo();
            return equipo.getPosicion3();
        }
        return 0;
    }
     
    public void mostrarEquipo(){
        
        if(equipo.imprimirPuesto().contains("Equipo1")){
            equipo1 = equipo.imprimirPuesto();
                if(equipo1 != null){
                    System.out.println(equipo1);
                }
        }else if(equipo.imprimirPuesto().contains("Equipo2")){
            equipo2=equipo.imprimirPuesto();
                if(equipo2 != null){
                    System.out.println(equipo2);
                }
        }else if(equipo.imprimirPuesto().contains("Equipo3")){
            equipo3=equipo.imprimirPuesto();
                 if(equipo3 != null){
                     System.out.println(equipo3);
                   }
        }
        
    }
    
}
