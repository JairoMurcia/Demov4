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
public class Invencible_temporal extends Estado_personaje{
    
    private static int tiempo;
    private double mili;
    private boolean parpadeo=false;
    public void setMili(double mili) {
        this.mili = mili;
    }
    
    public BufferedImage getImagen() {
        if(parpadeo){
            parpadeo=false;
           try {
            return ImageIO.read(new File("src/Personajes/imagenes/invisible.png"));
        } catch (IOException ex) {
            Logger.getLogger(Golpeado.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        parpadeo=true;
        p.avanzar();
        tiempo+=mili;
        actualizar();
        this.mili=Hilo.get_delay();
        return p.getImagenes()[p.getIndice()];
        
    }

    public Invencible_temporal(Personaje p) {
        this.p=p;
    }
   
    
    public  void actualizar(){
        if(tiempo>3000){
           p.setE(new Normal(p));
        }
    } 
}
