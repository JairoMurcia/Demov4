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
public class Pro_goron_1 extends Proyectil{
    
    public Pro_goron_1(int x, int y,String sen) {
        super(x, y,sen);
        this.ruta+="goron/pro1.png";
        this.tipo="tierra";
        this.dx=20;
        this.sentido();
        this.nombre="goron1";
    }
    
}
