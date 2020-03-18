/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Logica;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author jairo
 */
public class Controlador_mouse implements MouseListener,MouseMotionListener{
    private Logica  h;
    private Point inicioArrastre,finArrastre;
   
    private Rectangle r=new Rectangle();
    @Override
    public void mouseClicked(MouseEvent me) {
      
    }

    

    @Override
    public void mousePressed (MouseEvent me) {
        
        inicioArrastre = new Point(me.getX(), me.getY());
       finArrastre = inicioArrastre;
            
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(r!=null){
        inicioArrastre = null;
        finArrastre = null;
        h.intersectar(r);        
        r=null;
        this.h.setR(r);}
        else{
            
             h.intersectar(me.getX(), me.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    public Controlador_mouse(Logica h) {
        this.h=h;
        
    }
    @Override
    public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
                
                finArrastre = new Point(e.getX(), e.getY());
                r=new Rectangle(Math.min(this.finArrastre.x,this.inicioArrastre.x),Math.min(this.finArrastre.y,this.inicioArrastre.y),Math.abs(this.finArrastre.x-this.inicioArrastre.x), Math.abs(this.finArrastre.y-this.inicioArrastre.y));
                h.setR(r);
            }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
}
