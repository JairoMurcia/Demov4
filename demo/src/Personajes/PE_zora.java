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
public class PE_zora extends P_escudo {

    public PE_zora(Personaje p) {
        super(p);
    }
    
    public BufferedImage getEscudo() {
        if(p.getNombre().equals("zora")){
            BufferedImage i2;
            try {
                i2 = ImageIO.read(new File("src/personajes/imagenes/zora/em.png"));
                return i2;
            } catch (IOException ex) {
                Logger.getLogger(P_escudo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        delegado= null;
        return delegado.getEscudo(); 
    }
}
