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
public abstract class Estado_personaje {
    protected Personaje p;
    
    
    public abstract BufferedImage getImagen();
}
