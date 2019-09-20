/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

/**
 *
 * @author michl
 */
public class Logica {
    
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;
    Jugador jugador4;
    Jugador jugador5;
    Jugador jugador6;
    Jugador jugador7;
    Jugador jugador8;
    Jugador jugador9;
    
    public Logica(){
    }
    
    public void comenzar(){
        Equipo equipoAmarillo = new Equipo("Amarillo");
        Equipo equipoVerde = new Equipo("Verde");
        Equipo equipoRojo = new Equipo("Rojo");
        
        //creacion de los hilos en memoria
        jugador1 = new Jugador(equipoAmarillo, 0,"A1");
        jugador2 = new Jugador(equipoAmarillo, 1,"A2");
        jugador3 = new Jugador(equipoAmarillo, 2,"A3");
        jugador4 = new Jugador(equipoVerde,0,"V1");
        jugador5 = new Jugador(equipoVerde,1,"V2");
        jugador6 = new Jugador(equipoVerde,2,"V3");
        jugador7 = new Jugador(equipoRojo,0,"R1");
        jugador8 = new Jugador(equipoRojo,1,"R2");
        jugador9 = new Jugador(equipoRojo,2,"R3");
        
        
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
