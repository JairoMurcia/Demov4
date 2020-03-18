/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.Personaje;
import java.awt.image.BufferedImage;

/**
 *
 * @author jairo
 */
public class Normal extends Estado_personaje{

    public Normal(Personaje p) {
        this.p=p;
    }

    

    
    public BufferedImage getImagen() {
       
        
        return p.getImagenes()[p.getIndice()];
    }
    
}
