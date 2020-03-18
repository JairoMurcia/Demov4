/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Logica.Estado_personaje;
import Logica.Golpeado;
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
public abstract class Personaje implements Cloneable{

    protected String direccion, nombre;
    protected BufferedImage imagenes[];
    protected int indice;

    public Estado_personaje getE() {
        return e;
    }
    protected int x, y,dx;
    protected Estado_personaje e;
   
    public void setE(Estado_personaje e) {
        this.e = e;
    }
    public int getDx() {
        return dx;
    }
    private String accion;
    protected int rango;
    protected int tipo_pro=1;

    public int getTipo_pro() {
        return tipo_pro;
    }

    public void setTipo_pro(int tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    public String getRuta() {
        return ruta;
    }
    public void setAccion(String accion) {
        this.accion = accion;
        indice = 0;
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

    public Personaje clonar() throws CloneNotSupportedException {
        return (Personaje) super.clone();
    }

    public String getNombre() {
        return this.nombre;
    }

    public BufferedImage getImagen() {
        return e.getImagen();
    }

    public BufferedImage[] getImagenes() {
        return imagenes;
    }

    public int getIndice() {
        return indice;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        asignarAccion();
    }

    public void avanzar() {
        this.indice = (this.indice + 1) % this.imagenes.length;
    }

    public void asignarAccion() {
        String aux = this.ruta + this.nombre + "/";
        if(this.accion.equals("atacar_parabolico")){
            aux+="atacar";
        }else{
            aux+=this.accion;
        }
        aux += this.direccion.toLowerCase().charAt(0);
        asignar_rango();
        this.imagenes = new BufferedImage[rango];
        for (int i = 0; i < rango; i++) {
            try {
                
                this.imagenes[i] = ImageIO.read(new File(aux+(i+1)+".png"));
                
            } catch (IOException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
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
}
