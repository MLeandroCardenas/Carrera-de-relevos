/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.carrerarelevos.Equipo;
import com.udec.carrerarelevos.Jugador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michl
 */
public class TestJugador {
    Jugador jugador;
    Equipo equipo;
    
    public TestJugador() {
        equipo = new Equipo();
        jugador = new Jugador(equipo,0,"Rojo");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void TestPasos() {
         byte resultado = jugador.correr();
         assertEquals(3,resultado);
     }
}
