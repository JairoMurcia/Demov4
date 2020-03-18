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
public class Pro_zora_1 extends Proyectil {
    
    public Pro_zora_1(int x, int y,String sen) {
        super(x, y,sen);
        this.ruta+="zora/pro1.png";
        this.tipo="agua";
        this.dx=20;
        this.sentido();
        this.nombre="zora1";
    }
    
}
