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
public class Logica implements IColores{
    
    /**
     * constructor vacio de la clase
     */
    public Logica(){
    }
    
    /**
     * se crean los equipos y los hilos igual y se arrancan
     */
    public void comenzar(){
        Equipo equipoA = new Equipo();
        Equipo equipoB = new Equipo();
        Equipo equipoC = new Equipo();
        
        Jugador jugador1 = new Jugador(equipoA,0,IColores.ANSI_AMARILLO);
        Jugador jugador2 = new Jugador(equipoA,33,IColores.ANSI_AMARILLO);
        Jugador jugador3 = new Jugador(equipoA,66,IColores.ANSI_AMARILLO);
        
        Jugador jugador4 = new Jugador(equipoB,0,IColores.ANSI_VERDE);
        Jugador jugador5 = new Jugador(equipoB,33,IColores.ANSI_VERDE);
        Jugador jugador6 = new Jugador(equipoB,66,IColores.ANSI_VERDE);
        
        Jugador jugador7 = new Jugador(equipoC,0,IColores.ANSI_ROJO);
        Jugador jugador8 = new Jugador(equipoC,33,IColores.ANSI_ROJO);
        Jugador jugador9 = new Jugador(equipoC,66,IColores.ANSI_ROJO);
        
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
