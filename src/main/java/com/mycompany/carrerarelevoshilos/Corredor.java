/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerarelevoshilos;

/**
 * Clase Corredor donde se declaran variables como el equipo del corredor su pocicion y su llegada
 * @author Edward Ramos - Sebastian Rincon
 */
public class Corredor extends Thread{
    Equipo equipo;
    private String nombreEquipo;
    private int posiciondeInicio;
    private int posiciondeLlegada;
    private String equipo1;
    private String equipo2;
    private String equipo3;
    
    /**
     * 
     * @param nombreEquipo variable del nombre del equipo
     * @param posiciondeInicio variable que toma la posicion inicial del corredor
     * @param posiciondeLlegada variable que toma la posicion final del corredor
     * @param equipo obejeto de la clase equipo
     */
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
    
    /**
     * el metodo avanzaCorredor1 inicia los primeros corredores de los equipo
     */
    
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
    
     /**
     * el metodo avanzaCorredor2 inicia los segundos corredores de los equipo
     */
    
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
    
     /**
     * el metodo avanzaCorredor3 inicia los tereros corredores de los equipo
     */
    
    public String avanzaCorredor3(){
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
                String cadena = "El " + equipo.getNombreEquipo()+" Gana la carrera !!!";
                System.out.println("El " + equipo.getNombreEquipo()+" Gana la carrera !!!");
                Inicio ini = new Inicio();
                ini.imprimeGanador(equipo.getNombreEquipo());
                return cadena;
            }
        }
    }
    
    /**
     * El metodo esperar se encarga de que los hilos esperen 
     */
    
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
    
     /**
      * El metodo correr hace que los corredores avanzen
      * @param corre variable de uno de los 3 atletas
      * @return 
      */
     
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
     
        /**
         * El metodo mostrarEquipo muestra a que equipo pertenece el corredor
         */
        
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
