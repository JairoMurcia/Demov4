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
public class Pro_goron_2 extends Proyectil {
    
    public Pro_goron_2(int x, int y,String sen) {
        super(x, y,sen);
        this.ruta+="goron/pro2.png";
        this.tipo="fuego";
        this.dx=30;
        this.sentido();
        this.nombre="goron2";
    }
    
}
