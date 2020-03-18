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
public class Pro_rana extends Proyectil {
    
    public Pro_rana(int x, int y, String sen) {
        super(x, y, sen);
        this.ruta+="rana/pro.png";
        this.tipo="agua";
        this.dx=25;
        this.sentido();
        this.nombre="rana";
    }
    
}
