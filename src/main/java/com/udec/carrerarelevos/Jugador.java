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
 * @author Michael Cardenas
 * clase que crea los hilos
 */
public class Jugador extends Thread {
    
    /**
     * atributos necesarios
     */
    private Equipo equipo;
    private int inicio;
    private String color;
    
    /**
     * cosntructro de la clase lleno
     * @param equipo
     * @param inicio
     * @param color 
     */
    public Jugador(Equipo equipo, int inicio, String color){
        this.equipo = equipo;
        this.inicio = inicio;
        this.color = color;
    }
    
    /**
     * metodo que ejecutan todos los hilos
     */
    @Override
    public void run(){
         if(inicio==0){
            primeros();
            despertar();
        }else {
            synchronized(equipo){
                esperar();
                 if(inicio==33){
                 segundos();
                 despertar();
                 }else{
                   synchronized(equipo){
                       esperar();
                   if(inicio==66){
                   terceros();
                   }
                 }
            }
        }
    }
   }
    
    /**
     * metodo que ddeja los hilos en espera
     */
    public void esperar(){
        try {
            equipo.wait();
        }catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    /**
     * para despertar a los hilos que estan esperando
     */
    public void despertar(){
        synchronized(equipo){
            equipo.notifyAll();
        }
    }
    /**
     * genera el numero randomico
     * @return 
     */
    public byte correr(){
        return (byte) (Math.random()*3);
    }
    
    /**
     * arranca los primeros jugadores
     */
    public void primeros(){
        byte pasos;
        while(equipo.getPosJugadorUno()<33){
            equipo.imprimirCiruito(getColor());
            pasos = correr();
            equipo.setPosJugadorUno((byte) (equipo.getPosJugadorUno()+pasos));
            if(equipo.getPosJugadorUno()>33){
                equipo.setPosJugadorUno((byte)33);
            }
        }
    }
    
    /**
     * arranca los segundos jugadores
     */
    public void segundos(){
        byte pasos;
        while(equipo.getPosJugadorUno()<66){
            equipo.imprimirCiruito(getColor());
            pasos = correr();
            equipo.setPosJugadorDos((byte) (equipo.getPosJugadorDos()+pasos));
            if(equipo.getPosJugadorDos()>66){
                equipo.setPosJugadorUno((byte)66);
            }
        }
    }
    
  /**
     * arranca los terceros jugadores
     */
    public void terceros(){
        byte pasos;
        while(equipo.getPosJugadorTres()<100){
            equipo.imprimirCiruito(getColor());
            pasos = correr();
            equipo.setPosJugadorTres((byte) (equipo.getPosJugadorTres()+pasos));
            if(equipo.getPosJugadorTres()>100){
                equipo.setPosJugadorUno((byte)100);
            }
        }
        decirGanador();
    }
    
    /**
     * cice el ganador final y cierra el hilo
     */
    public void decirGanador(){
            if("\u001B[33m".equals(color)){
                System.out.println(IColores.ANSI_RESET+"GANADOR EL EQUIPO A");
            }
            else if ("\u001B[32m".equals(color)){
                System.out.println(IColores.ANSI_RESET+"GANADOR EL EQUIPO B");
            }else if("\u001B[31m".equals(color)){
                System.out.println(IColores.ANSI_RESET+"GANADOR EL EQUIPO C");
            }
            System.exit(0);
    }

    /**
     * metodos publicos
     * @return 
     */
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
