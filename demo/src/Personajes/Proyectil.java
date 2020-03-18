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
public abstract class Proyectil {

    protected int x, y, dx,dy=0,dvy=0;

    public int getDvy() {
        return dvy;
    }

    public int getDy() {
        return dy;
    }
    protected String ruta = "src/Personajes/imagenes/";
    protected String nombre;

    public String getNombre() {
        return nombre;
    }
    protected BufferedImage imagen;
    protected String tipo, sen;

    public String getTipo() {
        return tipo;
    }

    public void mover() {
        x += dx;
    }

    public int getX() {
        return x;
    }

    public int getDX() {
        return dx;
    }

    public int getY() {
        return y;
    }

    public Proyectil(int x, int y, String sen) {
        this.x = x;
        this.y = y;
        this.sen = sen;

    }

    public int getDx() {
        return dx;
    }

    public String getRuta() {
        return ruta;
    }

    public String getSen() {
        return sen;
    }

    public void leer_imagen() {
        try {
            this.imagen = ImageIO.read(new File(this.ruta));

        } catch (IOException ex) {
            Logger.getLogger(Proyectil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage getImagen() {
        this.leer_imagen();
        return this.imagen;
    }

    protected void sentido() {
        if (sen.toLowerCase().charAt(0) == 'i') {
            dx *= -1;
        }
    }
}
