/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jairo
 */
public class P_escudo extends Personaje{
    protected Personaje p;
    protected P_escudo delegado;
    protected String tipo="madera";
    public P_escudo (Personaje p){
        this.p=p;
        this.ruta=p.ruta;
        this.nombre="escudo";
        this.tipo_pro=p.tipo_pro;
        this.e=p.e;
        }
    
        
    @Override
    public void asignarAccion() {
        p.asignarAccion();
    }
    public int getX() {
        return p.getX();
    }

    public int getY() {
        return p.getY();
    }

    public void setX(int x) {
        p.setX(x);
    }

    public void setY(int y) {
        p.setY(y);
    }
    
    
    public BufferedImage getEscudo() {
        if(p.getNombre().equals("Deku")){
            BufferedImage i2;
            try {
                i2 = ImageIO.read(new File("src/personajes/imagenes/deku/em.png"));
                return i2;
            } catch (IOException ex) {
                Logger.getLogger(P_escudo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        delegado= new PE_gerudo(p);
        this.tipo=delegado.tipo;
        return delegado.getEscudo(); 
    }

    public String getTipo() {
        return tipo;
    }
    
    
 
    public void setDireccion(String direccion) {
        p.setDireccion(direccion);
    }
    
    
    public  void avanzar(){
        p.indice=(p.indice+1)%p.imagenes.length;
    }
    
   
    public String getDireccion() {
        return p.getDireccion();
    }

    public String getAccion() {
        return p.getAccion();
    }

    public Personaje getP(){
        return p;
    }
    public void setAccion(String accion) {
        p.setAccion(accion);
    }
    public boolean Lanza() {
        return p.Lanza();
    }
    @Override
    protected void asignar_rango() {
        p.asignarAccion();
    }
    public BufferedImage getImagen() {
        return this.p.getImagen();
    }
}
