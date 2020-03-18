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
public class Pro_deku_1 extends Proyectil {
    
    public Pro_deku_1(int x, int y,String sen) {
        super(x, y,sen);
        this.ruta+="deku/pro1.png";
        this.tipo="acido";
        this.dx=25;
        this.sentido();
        this.nombre="deku1";
        
    }

    
    
}
