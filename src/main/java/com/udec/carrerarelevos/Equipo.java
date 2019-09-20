/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

/**
 *
 * @author Michael Cardenas
 * clase que lleva el paso de los jugadores
 */
public class Equipo {
    
    /**
     * Nombre del equipo
     */
    private String nombre;
    
    /**
     * para acumular el paso que llevan los jugadores
     */
    private int paso = 0;

    /**
     * Constructor de la clase paraa inizializar el objeto
     * @param nombre nombre del equipo
     * @param paso paso que por defecto comienza en 0
     */
    public Equipo(String nombre, int paso) {
        this.nombre = nombre;
        this.paso=paso;
    }
    
    /**
     * metodos publicos para acceder a las variables privadas
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    } 
}
