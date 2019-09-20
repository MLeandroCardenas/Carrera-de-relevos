/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerarelevos;

/**
 *
 * @author Michael Cardenas
 * interface que guarda los colores de la impresion de los equipos
 */
public interface IColores {
    
    /**
     * colores de cada impresion
     */
        public static final String ANSI_VERDE = "\u001B[32m";
        public static final String ANSI_AMARILLO = "\u001B[33m";
        public static final String ANSI_ROJO = "\u001B[31m";
        public static final String ANSI_RESET = "\u001B[0m";
        
}
