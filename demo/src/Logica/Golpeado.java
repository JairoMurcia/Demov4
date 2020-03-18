/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.Personaje;
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
public class Golpeado extends Estado_personaje {

    private static int tiempo;
    private double mili;

    public void setMili(double mili) {
        this.mili = mili;
    }

    public Golpeado(Personaje p) {
        this.p = p;

        tiempo = 0;
        mili=Hilo.get_delay();
    }

    @Override
    public BufferedImage getImagen() {
        String aux = p.getRuta() + p.getNombre() + "/golpeado" + p.getDireccion().charAt(0) + "1.png";
        p.setX(p.getX() - p.getDx());
        tiempo += mili;
        actualizar();
        try {
            return ImageIO.read(new File(aux));
        } catch (IOException ex) {
            Logger.getLogger(Golpeado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public  void actualizar() {
        if (tiempo > 900) {
            p.setE(new Invencible_temporal(p));
        }
    }

}
