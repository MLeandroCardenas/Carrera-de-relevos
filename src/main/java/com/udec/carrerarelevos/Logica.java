/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

/**
 *
 * @author Michael Cardenas
 * aqui se crean los hilos y se arrancan
 */
public class Logica {
    
    /**
     * instacnias de la clase jugador representan los hilos
     */
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;
    Jugador jugador4;
    Jugador jugador5;
    Jugador jugador6;
    Jugador jugador7;
    Jugador jugador8;
    Jugador jugador9;
    
    /**
     * constructor vacio de la clase
     */
    public Logica(){
    }
    
    /**
     * se crean los equipos y los hilos igual y se arrancan
     */
    public void comenzar(){
        Equipo equipoAmarillo = new Equipo("Amarillo",0);
        Equipo equipoVerde = new Equipo("Verde",0);
        Equipo equipoRojo = new Equipo("Rojo",0);
        
        //creacion de los hilos en memoria
        jugador1 = new Jugador(equipoAmarillo, 0,"A1");
        jugador2 = new Jugador(equipoAmarillo, 1,"A2");
        jugador3 = new Jugador(equipoAmarillo, 2,"A3");
        jugador4 = new Jugador(equipoVerde,3,"V1");
        jugador5 = new Jugador(equipoVerde,4,"V2");
        jugador6 = new Jugador(equipoVerde,5,"V3");
        jugador7 = new Jugador(equipoRojo,6,"R1");
        jugador8 = new Jugador(equipoRojo,7,"R2");
        jugador9 = new Jugador(equipoRojo,8,"R3");
        
        
        //hilos ejecutandosen
        jugador1.start();
        jugador2.start();
        jugador3.start();
        jugador4.start();
        jugador5.start();
        jugador6.start();
        jugador7.start();
        jugador8.start();
        jugador9.start();
    }
}
