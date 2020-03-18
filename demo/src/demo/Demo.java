/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import Controlador.*;
import Logica.Hilo;
import Logica.Logica;
import Vista.*;

/**
 *
 * @author jairo
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ventana v=new Ventana();
        Logica lo=new Logica(v.getLienzo());
        Hilo h=new Hilo(lo);
        Controlador_botones cb=new Controlador_botones(lo);
        Controlador_mouse cm=new Controlador_mouse(lo);
        Controlador_teclado ct=new Controlador_teclado(lo);
        v.agregar_listeners(cb, ct, cm, cm);
        v.mostrar();
        h.run();
       
    }
    
}
