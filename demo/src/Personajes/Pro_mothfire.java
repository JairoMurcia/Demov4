/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

/**
 *
 * @author jairo
 */
public class Pro_mothfire extends Proyectil {
    
    public Pro_mothfire(int x, int y, String sen) {
        super(x, y, sen);
        this.ruta+="mothfire/pro.png";
        this.tipo="fuego";
        this.dx=15;
        this.sentido();
        this.nombre="mothfire";
    }
    
}
