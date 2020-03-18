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
public class PE_gerudo extends P_escudo{
        
    public PE_gerudo(Personaje p) {
        super(p);
        this.tipo="electrico";
    }
    public BufferedImage getEscudo() {
        if(p.getNombre().equals("gerudo")){
            BufferedImage i2;
            try {
                i2 = ImageIO.read(new File("src/personajes/imagenes/gerudo/em.png"));
                return i2;
            } catch (IOException ex) {
                Logger.getLogger(P_escudo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        delegado= new PE_goron(p);
        
        return delegado.getEscudo(); 
    }
        
}
