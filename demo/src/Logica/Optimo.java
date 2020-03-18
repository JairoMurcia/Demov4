/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.Enemigo;
import java.awt.image.BufferedImage;

/**
 *
 * @author jairo
 */
public class Optimo extends Estado_enemigo{

    Optimo(Enemigo e) {
        this.e=e;
    }

    @Override
    public BufferedImage getImagen() {
        return e.getImagenes()[e.getIndice()];
    }
    
}
