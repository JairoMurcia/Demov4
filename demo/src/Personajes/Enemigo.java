/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Logica.Estado_enemigo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jairo
 */
public abstract class Enemigo implements Cloneable{
    protected String direccion, nombre,tipo="1";
    protected BufferedImage imagenes[];

    public String getTipo() {
        return tipo;
    }
    protected int indice=0;
    protected int x, y,dx,dy;
    protected String accion;
    protected int rango;
    protected String [] tipos; 
    protected Estado_enemigo e;

    public void setE(Estado_enemigo e) {
        this.e = e;
    }
    public void setAccion(String accion) {
        this.accion = accion;
        indice = 0;
        
    }

    public String getRuta() {
        return ruta;
    }

    public BufferedImage[] getImagenes() {
        return imagenes;
    }

    public int getIndice() {
        return indice;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    public Enemigo clonar() throws CloneNotSupportedException {
        return (Enemigo) super.clone();
    }

    protected String ruta = "src/Personajes/imagenes/";

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public BufferedImage getImagen() {
        avanzar();
        return  e.getImagen();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        asignarAccion();
    }

    public void avanzar() {
       if(this.rango!=0){ 
        this.indice = (this.indice + 1) % this.imagenes.length;
       }else{
           this.indice=0;
       }
       
       }

   

    public String getDireccion() {
        return direccion;
    }

    public String getAccion() {
        return accion;
    }

    public boolean Lanza() {
        
        return this.indice == (rango - 1);
    }

    protected abstract void asignar_rango();
    
    public void ia(Personaje p,ArrayList<Proyectil> pro){
       if(p.y==this.y){
           if(esta_indefenso(p,pro)){
               this.accion="atacar";
           }else{
               this.accion="escudarse";
              
           }
       }
        this.asignarAccion();
    }

    protected abstract boolean esta_indefenso(Personaje p, ArrayList<Proyectil> pro);  

    private  boolean evaluar_peligro(Proyectil p){
       
        int y=p.y+p.dy;
        int c=(p.x-this.x)/p.dx;
        c=(int) Math.pow(c, 2);
        y=p.dvy*c/2;
        return y==this.y;
        
    }
    private Proyectil mas_cercano(ArrayList<Proyectil> pro){
        Proyectil p=null;
        double distancia=-1;
        double d=0;
        for(Proyectil pr:pro){
            if(distancia<0 && es_enemigo(pr)){
                distancia=Math.sqrt( Math.pow(this.x-pr.x, 2) +   Math.pow(this.y-pr.y, 2) );
                p=pr;
            }else if (es_enemigo(pr)){
                d=Math.sqrt( Math.pow(this.x-pr.x, 2) +   Math.pow(this.y-pr.y, 2) );
                if(d<distancia){
                    distancia=d;
                    p=pr;
                }
            }
        }
        return p;
    }

    protected abstract void evadir(Proyectil p);
    
    
    protected boolean es_enemigo(Proyectil p){
        String [] nombres={"deku1","deku2","goron1","goron2","gerudo1","gerudo2","zora1","zora2"};
        for(int i=0;i<nombres.length;i++){
            if(nombres[i].equals(p.getNombre())){
                return true;
            }
        }
        return false;
    } 

    protected boolean es_debil(Proyectil p) {
        for(String i:tipos){
            if(i.equals(p.tipo)){
                return true;
            }
        }
        return false;
    }
    public abstract void asignarAccion();
    
}

