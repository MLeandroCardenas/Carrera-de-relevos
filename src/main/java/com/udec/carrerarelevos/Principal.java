/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

/**
 *
 * @author Michael Cardenas
 * clase por donde arranca el programa
 */
public class Principal {
   
    /**
     * metodo que llama al metodo de la clase Logica que crea los hilos y los arranca
     * @param args 
     */
    public static void main(String... args){
        Logica logica = new Logica();
        logica.comenzar();
    }
    
}
