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
 * clase que hereda de la clase Thread para crear los hilos 
 */
public class Jugador extends Thread implements IColores {
    
    /**
     * varible que se usara para sincronizar 
     */
    final Equipo equipo;
    
    /**
     * orden de cada jugador para identificar el comienzo
     */
    private int orden;
    
    /**
     * variable para ir acumulando los pasos
     */
    private byte pasos;
    
    /**
     * identificador unico de cada jugador
     */
    private String identificador;
    
    /**
     * para cambiar el tiempo
     */
    private long tiempo = 5;
    
    /**
     * para saber si  el ultimo acabo
     */
     private boolean terminar = true;
    

     /**
      * constructor de la clase para inicializar el objeto
      * @param equipo nombre del equipo
      * @param orden orden de comiernzo de cada hilo
      * @param identificador identificador unico de cada jugador
      */
    public Jugador(Equipo equipo, int orden, String identificador) {
        this.equipo = equipo;
        this.orden = orden;
        this.identificador = identificador;
    }
   
    
    /**
     * metodo run que se sobreescribe donde va la logica de los hilos
     */
    @Override
    public void run(){
        if(orden==0){
            try {
                 
                Jugador.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredorUnoEquipoAmarillo();
        } 
        if(orden==3){
            try {   
                Jugador.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredorUnoEquipoVerde();
        } 
            
        if(orden==6){
            try {
                
                Jugador.sleep(tiempo);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredorUnoEquipoRojo();
        } 
            
        if(orden==1){
            try {
                
                Jugador.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredorDosEquipoAmarillo();
        } 
            
        if(orden==4){
            try {
               
                Jugador.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
              corredorDosEquipoVerde();
        }
           
        if(orden==7){
            try {
                Jugador.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredorDosEquipoRojo();
        }
            
        if(orden==2){
            while(terminar==true){
                try {
                    
                     Jugador.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                corredorTresEquipoAmarillo();
            }
                
        }
            
        if(orden==5){
            while(terminar==true){
                try {
                    
                    Jugador.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                corredorTresEquipoVerde();
            }
                
        }
            
        if(orden==8){
            while(terminar==true){
                try {
                     
                     Jugador.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                corredorTresEquipoRojo();
            }
        }   
    }
    
    
    /**
     * metodo para arracar el juhador 1
     */
    public void corredorUnoEquipoAmarillo(){
        byte posicion = 0;
        while(pasos<=33){
            byte numero = (byte) (Math.random()*3);
            if(numero==1){
                pasos+=1;
                posicion++;
            }
            else if(numero==2){
                pasos+=2;
                posicion+=2;
            }
            else if(numero==3){
                 pasos+=3;
                posicion+=3;
            }
            imprimirCarrera(posicion,IColores.ANSI_AMARILLO);
            synchronized(equipo){
                if(terminoCarrera()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }   
            imprimir();
        }        
    }
   
     /**
     * metodo para arracar el juhador 2
     */
    public  void corredorDosEquipoAmarillo(){
            synchronized(equipo){
                try {
                     if(!terminoCarreraDos()){
                         equipo.wait();
                    }
                } catch (InterruptedException ex) {
                     Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte posicion=(byte) equipo.getPaso();
             pasos=(byte) equipo.getPaso();
            while(pasos<66 || pasos==66){
                byte numero=(byte)(Math.random()*3);
                if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
            }
            imprimirCarrera(posicion,IColores.ANSI_AMARILLO);
          synchronized(equipo){
                if(terminoCarreraDos()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }
            imprimir();
        }
    }
    
     /**
     * metodo para arracar el juhador 3
     */
    public  void corredorTresEquipoAmarillo(){
        synchronized(equipo){
                try {
                    if(!terminoCarreraTres()){
                      equipo.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        byte posicion=(byte) equipo.getPaso();
        pasos=(byte) equipo.getPaso();
            while(pasos<=100){
                byte numero=(byte) (Math.random()*3);
                 if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
                }
                synchronized(equipo){
                    if(terminoCarreraTres()==true){
                        equipo.notify();
                        equipo.setPaso(pasos);
                        ganadorEquipoAmarillo();
                        matarHilo();
                        break;
                    }
                }
            }
    }
    
     /**
     * metodo para arracar el juhador 4
     */
    public void corredorUnoEquipoVerde(){
        byte posicion = 0;
        while(pasos<=33){
            byte numero = (byte) (Math.random()*3);
            if(numero==1){
                pasos+=1;
                posicion++;
            }
            else if(numero==2){
                pasos+=2;
                posicion+=2;
            }
            else if(numero==3){
                 pasos+=3;
                posicion+=3;
            }
            imprimirCarrera(posicion,IColores.ANSI_VERDE);
            synchronized(equipo){
                if(terminoCarrera()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }   
            imprimir();
        }   
    }
    
     /**
     * metodo para arracar el juhador 5
     */
    public   void corredorDosEquipoVerde(){
            synchronized(equipo){
                try {
                     if(!terminoCarreraDos()){
                         equipo.wait();
                    }
                } catch (InterruptedException ex) {
                     Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte posicion=(byte) equipo.getPaso();
             pasos=(byte) equipo.getPaso();
            while(pasos<66 || pasos==66){
                byte numero=(byte)(Math.random()*3);
                if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
            }
                imprimirCarrera(posicion,IColores.ANSI_VERDE);
          synchronized(equipo){
                if(terminoCarreraDos()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }
            imprimir();
        }
    }
    
     /**
     * metodo para arracar el juhador 6
     */
    public   void corredorTresEquipoVerde(){
        synchronized(equipo){
                try {
                    if(!terminoCarreraTres()){
                      equipo.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        byte posicion=(byte) equipo.getPaso();
        pasos=(byte) equipo.getPaso();
            while(pasos<=100){
                byte numero=(byte) (Math.random()*3);
                 if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
                }
                synchronized(equipo){
                    if(terminoCarreraTres()==true){
                        equipo.notify();
                        equipo.setPaso(pasos);
                        if(identificador.equals("A3"))
                           Jugador.interrupted();
                        if(identificador.equals("R3"))
                            Jugador.interrupted();
                        ganadorEquipoVerde();
                        matarHilo();
                        break;
                    }
                }
            }
    }
    
     /**
     * metodo para arracar el juhador 7
     */
    public  void corredorUnoEquipoRojo(){
        byte posicion = 0;
        while(pasos<=33){
            byte numero = (byte) (Math.random()*3);
            if(numero==1){
                pasos+=1;
                posicion++;
            }
            else if(numero==2){
                pasos+=2;
                posicion+=2;
            }
            else if(numero==3){
                 pasos+=3;
                posicion+=3;
            }
            imprimirCarrera(posicion,IColores.ANSI_ROJO);
            synchronized(equipo){
                if(terminoCarrera()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }   
            imprimir();
        }  
    }
    
     /**
     * metodo para arracar el juhador 8
     */
    public   void corredorDosEquipoRojo(){
            synchronized(equipo){
                try {
                     if(!terminoCarreraDos()){
                         equipo.wait();
                    }
                } catch (InterruptedException ex) {
                     Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte posicion=(byte) equipo.getPaso();
             pasos=(byte) equipo.getPaso();
            while(pasos<66 || pasos==66){
                byte numero=(byte)(Math.random()*3);
                if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
            }
                imprimirCarrera(posicion,IColores.ANSI_ROJO);
          synchronized(equipo){
                if(terminoCarreraDos()==true){
                    equipo.notify();
                    equipo.setPaso(pasos);
                    break;
                }
            }
            imprimir();
        }
    }
    
     /**
     * metodo para arracar el juhador 9
     */
    public  void corredorTresEquipoRojo(){
                synchronized(equipo){
                try {
                    if(!terminoCarreraTres()){
                      equipo.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        byte posicion=(byte) equipo.getPaso();
        pasos=(byte) equipo.getPaso();
            while(pasos<=100){
                byte numero=(byte) (Math.random()*3);
                 if(numero==1){
                    pasos+=1;
                    posicion++;
                }else if(numero==2){
                    pasos+=2;
                    posicion+=2;
                }else if(numero==3){
                    pasos+=3;
                   posicion+=3;
                }
                synchronized(equipo){
                    if(terminoCarreraTres()==true){
                        equipo.notify();
                        equipo.setPaso(pasos);
                        if(identificador.equals("A3"))
                            Jugador.interrupted();
                        if(identificador.equals("V3"))
                            Jugador.interrupted();
                        ganadorEquipoRojo();
                        matarHilo();
                        break;
                    }
                }
            }
    }
    
    /**
     * metodo para identificar los pasos que llevan los primeros jugadores de cada equipo
     * @return un valor verdadero o falso
     */
    public  boolean terminoCarrera(){
        boolean valor=false;
       if(pasos==32 || pasos>32){
           valor=true; 
       }
      return valor;
    }

        
    /**
     * metodo para identificar los pasos que llevan los segundos jugadores de cada equipo
     * @return un valor verdadero o falso
     */
    public  boolean terminoCarreraDos(){
        boolean valor=false;
       if(pasos==66 || pasos>66){
          valor=true; 
       }
      return valor;
    }
    
        
    /**
     * metodo para identificar los pasos que llevan los tereros jugadores de cada equipo
     * @return un valor verdadero o falso
     */
    public  boolean terminoCarreraTres(){
        boolean valor=false;
       if(pasos==100 || pasos>100){
          valor=true; 
       }
      return valor;
    } 
    /**
     * metodo para imprimir solamente un espacio
     */
    public void imprimir(){
        System.out.println();
        System.out.println();
        System.out.println(IColores.ANSI_RESET + "----------------------------------------------");

    }
    
    /**
     * metodo para imprimir la posicion en tiempo real de cada hilo
     * @param posicion la posicion final 
     * @param color color de la impresion
     */
    public synchronized void imprimirCarrera(byte posicion,String color){
            for(byte i=0;i<posicion;i++){
                System.out.print(color + ":p");
                try {
                    Thread.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    /**
     * para terminar el hilo
     */
    public void matarHilo(){
        this.terminar=false;
    }
    
    /**
     * imprime el ganador
     */
    public void ganadorEquipoAmarillo(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO AMARILLO");
    }
   
    
     /**
     * imprime el ganador
     */
    public void ganadorEquipoVerde(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO VERDE");
    }
    
    /**
     * imprime el ganador
     */
    public void ganadorEquipoRojo(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO ROJO");
    }

    
    /**
     * metodos publicos de para acceder a las variables privadas
     * @return 
     */
    public Equipo getEquipo() {
        return equipo;
    }
    
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public byte getPasos() {
        return pasos;
    }

    public void setPasos(byte pasos) {
        this.pasos = pasos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }    
}

