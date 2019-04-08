/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerarelevoshilos;

/**
 * Clase Utilitaria la cual genera un numero Ramdon que sera las pociciones que
 * avanzen los corredores
 * @author Edward Ramos - Sebastian Rincon
 */

public class Utilitaria {
    /**
     * El metodo generaNumero se encarga de generar un numero aleatorio 
     * entre 1 y 3 
     * @return numero ramdon
     */
    public static int generaNumero(){
        int numero = (int) (Math.random() * 3) + 1;
        return numero;
    }
    
}
