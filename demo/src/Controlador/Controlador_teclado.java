/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Logica;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jairo
 */
public class Controlador_teclado implements KeyListener{
    private Logica h;

    public Controlador_teclado(Logica h) {
        this.h = h;
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_UP){
            this.h.cambiar_accion("saltar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_C){
            this.h.cambiar_accion("caminar");
        }
       if(ke.getKeyCode()==KeyEvent.VK_E){
            this.h.agregar_decorador("a");
            
        }
        if(ke.getKeyCode()==KeyEvent.VK_SPACE){
            this.h.cambiar_accion("morir");
        }
        if(ke.getKeyCode()==KeyEvent.VK_Z){
            this.h.cambiar_accion("atacar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_A){
            this.h.cambiar_accion("atacar_parabolico");
        }
        if(ke.getKeyCode()==KeyEvent.VK_X){
            this.h.cambiar_accion("escudarse");
        }
        if(ke.getKeyCode()==KeyEvent.VK_V){
            this.h.cambiar_accion("pararse");
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT){
            this.h.cambiar_dir("izquierda");
        }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
            this.h.cambiar_dir("derecha");
        }
        if(ke.getKeyCode()==KeyEvent.VK_1 || ke.getKeyCode()==KeyEvent.VK_NUMPAD1){
            this.h.cambiar_proyectil(1);
        }
        if(ke.getKeyCode()==KeyEvent.VK_2 || ke.getKeyCode()==KeyEvent.VK_NUMPAD2){
            this.h.cambiar_proyectil(2);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
