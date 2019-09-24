/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 * clase en comun para todos los hilos se usa para sincronizar
 */
public class Equipo {
    
    /**
     * atributos de la clase
     */
    private byte posJugadorUno;
    private byte posJugadorDos;
    private byte posJugadorTres;
    private String carril;
    
    /**
     * constructor vacio
     */
    public Equipo(){
        
    }
    
    /**
     * imprime en tiempo real el circuito
     * @param color 
     */
    public void imprimirCiruito(String color){
   
        for (int i = 0; i < 100; i++) {
            if(i == posJugadorUno){
                carril += "J";
            }
            if(i == posJugadorDos){
                carril += "J";
            }
            if(i == posJugadorTres){
                carril += "J";
            } carril += "_";            
        }  
        System.out.println(color+ carril);
        carril="";
       
        espacios();
        
        try {
            if("\u001B[33m".equals(color)){
                Thread.sleep(500);
            }
            else if ("\u001B[32m".equals(color)){
                Thread.sleep(500);
            }else if("\u001B[31m".equals(color)){
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * separa las impresiones
     */
    public void espacios(){
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    /**
     * metodos publicos
     * @return 
     */
    public byte getPosJugadorUno() {
        return posJugadorUno;
    }

    public void setPosJugadorUno(byte posJugadorUno) {
        this.posJugadorUno = posJugadorUno;
    }

    public byte getPosJugadorDos() {
        return posJugadorDos;
    }

    public void setPosJugadorDos(byte posJugadorDos) {
        this.posJugadorDos = posJugadorDos;
    }

    public byte getPosJugadorTres() {
        return posJugadorTres;
    }

    public void setPosJugadorTres(byte posJugadorTres) {
        this.posJugadorTres = posJugadorTres;
    }

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }
}
