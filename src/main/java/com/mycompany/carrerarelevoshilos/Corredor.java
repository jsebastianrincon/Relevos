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
    
    @Override
    public void run(){
        if(posiciondeInicio == 0){
           avanzaCorredor1(); 
        }else{
            esperar();
        }if(posiciondeInicio==30){
           avanzaCorredor2();    
        }else{
            esperar();
        }if(posiciondeInicio==60){
            avanzaCorredor3();
        }else{
            esperar();
        }
    }
    
    
    public void avanzaCorredor1(){
        while (true) {
            int posicion = correr(1);
            if (posicion >= 30) {
                equipo.setPosicion1(30);
                synchronized (equipo) {
                    equipo.notifyAll();
                    posiciondeInicio = 30;
                }
                break;
            }
        }
    }
    
    public void avanzaCorredor2(){
        while (true) {
            int posicion = correr(2);
            if (posicion >= 60) {
                equipo.setPosicion2(60);
                synchronized (equipo) {
                    equipo.notify();
                }
                break;
            }
        }
    }
    
    public void avanzaCorredor3(){
        while (true) {
            int posicion = correr(3);
            if (posicion >= 100) {
                equipo.setPosicion3(100);
                if(equipo.getNombreEquipo().equals("Equipo1")){
                    equipo.setNombreEquipo("Equipo 1");
                }else if(equipo.getNombreEquipo().equals("Equipo2")){
                    equipo.setNombreEquipo("Equipo 2");
                }else if(equipo.getNombreEquipo().equals("Equipo3")){
                    equipo.setNombreEquipo("Equipo 3");
                }
                System.out.println("El " + equipo.getNombreEquipo()+" Gana la carrera !!!");
                break;
            }
        }
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
