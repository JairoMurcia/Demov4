/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

/**
 *
 * @author jairo
 */
public class Proyectil_parabolico extends Proyectil {
    
    
    private Proyectil p;
    
    public Proyectil_parabolico(int x, int y,Proyectil p) {
        super(x, y,p.sen);
        this.y=y;
        dvy=5;
        this.dy=-50;
        this.dx=p.dx;
        this.p=p;
        this.ruta=this.p.ruta;
        this.leer_imagen();
    }   

    /**
     *
     */
    @Override
    public void mover(){
        y+=dy;
        dy+=dvy;
        p.mover();
        x=p.x;
    }
    
}
