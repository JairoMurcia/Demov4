/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.Enemigo;
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
public class Herido extends Estado_enemigo{
    private double tiempo=0,mili;

    public void setMili(double mili) {
        this.mili = mili;
    }
    public Herido(Enemigo e) {
        this.e=e;
    }

    @Override
    public BufferedImage getImagen() {
        String aux = e.getRuta() + e.getNombre() + "/golpeado" + e.getDireccion().charAt(0) + ".png";
        e.setX(e.getX() - e.getDx());
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
            e.setE(new Optimo(e));
        }
    }
    
}
