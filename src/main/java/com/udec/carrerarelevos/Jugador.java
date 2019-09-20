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
 * @author michl
 */
public class Jugador extends Thread implements IColores {
    
    private Equipo equipo;
    private Equipo equipo2 = new Equipo("");
    private Equipo equipo3 = new Equipo("");
    
    private int orden;
    
    private byte pasos;
    
    private String identificador;
    
    private long tiempo = 5;
    
     private boolean terminar = true;
    

    public Jugador(Equipo equipo, int orden, String identificador) {
        this.equipo = equipo;
        this.orden = orden;
        this.identificador = identificador;
    }
    
  /*  @Override
    public void run(){
        if(orden == 0) {
            while(equipo.getPaso() <= 32) {
                try {
                    equipo.setPaso((int) (Math.random()*3));
                    System.out.println("Identificador " + equipo.getPaso());
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
          
        }
        
    }*/
    
    @Override
    public void run(){
        if(orden==0|orden==0|orden==0){
            corredorUnoEquipoAmarillo();
            corredorUnoEquipoVerde();
            corredorUnoEquipoRojo();
        }
        else if(orden==1|orden==1|orden==1){
            corredorDosEquipoAmarillo();
            corredorDosEquipoVerde();
            corredorDosEquipoRojo();
            
        }
        else if(orden==2|orden==2|orden==2){
            while(terminar==true){
                corredorTresEquipoAmarillo();
                corredorTresEquipoVerde();
                corredorTresEquipoRojo();
            }
            
        }
    }
    
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
            synchronized(equipo2){
                if(terminoCarrera()==true){
                    equipo2.notify();
                    equipo2.setPaso(pasos);
                    break;
                }
            }   
            imprimir();
        }   
    }
    
    public   void corredorDosEquipoVerde(){
            synchronized(equipo2){
                try {
                     if(!terminoCarreraDos()){
                         equipo2.wait();
                    }
                } catch (InterruptedException ex) {
                     Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte posicion=(byte) equipo2.getPaso();
             pasos=(byte) equipo2.getPaso();
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
          synchronized(equipo2){
                if(terminoCarreraDos()==true){
                    equipo2.notify();
                    equipo2.setPaso(pasos);
                    break;
                }
            }
            imprimir();
        }
    }
    
    public   void corredorTresEquipoVerde(){
        synchronized(equipo2){
                try {
                    if(!terminoCarreraTres()){
                      equipo2.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        byte posicion=(byte) equipo2.getPaso();
        pasos=(byte) equipo2.getPaso();
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
                synchronized(equipo2){
                    if(terminoCarreraTres()==true){
                        equipo2.notify();
                        equipo2.setPaso(pasos);
                        Jugador.interrupted();
                        Jugador.interrupted();
                        ganadorEquipoVerde();
                        matarHilo();
                        break;
                    }
                }
            }
    }
    
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
            synchronized(equipo3){
                if(terminoCarrera()==true){
                    equipo3.notify();
                    equipo3.setPaso(pasos);
                    break;
                }
            }   
            imprimir();
        }  
    }
    
    public   void corredorDosEquipoRojo(){
            synchronized(equipo3){
                try {
                     if(!terminoCarreraDos()){
                         equipo3.wait();
                    }
                } catch (InterruptedException ex) {
                     Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte posicion=(byte) equipo3.getPaso();
             pasos=(byte) equipo3.getPaso();
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
          synchronized(equipo3){
                if(terminoCarreraDos()==true){
                    equipo3.notify();
                    equipo3.setPaso(pasos);
                    break;
                }
            }
            imprimir();
        }
    }
    
    public  void corredorTresEquipoRojo(){
                synchronized(equipo3){
                try {
                    if(!terminoCarreraTres()){
                      equipo3.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        byte posicion=(byte) equipo3.getPaso();
        pasos=(byte) equipo3.getPaso();
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
                synchronized(equipo3){
                    if(terminoCarreraTres()==true){
                        equipo3.notify();
                        equipo3.setPaso(pasos);
                        Jugador.interrupted();
                        Jugador.interrupted();
                        ganadorEquipoRojo();
                        matarHilo();
                        break;
                    }
                }
            }
    }
    
    public  boolean terminoCarrera(){
        boolean valor=false;
       if(pasos==32 || pasos>32){
           valor=true; 
       }
      return valor;
    }
    
    public  boolean terminoCarreraDos(){
        boolean valor=false;
       if(pasos==66 || pasos>66){
          valor=true; 
       }
      return valor;
    }
    
    public  boolean terminoCarreraTres(){
        boolean valor=false;
       if(pasos==100 || pasos>100){
          valor=true; 
       }
      return valor;
    } 
    public void imprimir(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
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
    
    public void matarHilo(){
        this.terminar=false;
    }
    
    public void ganadorEquipoAmarillo(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO AMARILLO");
    }
    
    public void ganadorEquipoVerde(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO VERDE");
    }
    
    public void ganadorEquipoRojo(){
        System.err.println(IColores.ANSI_RESET+"GANO EL EQUIPO ROJO");
    }

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

