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
public class Pro_zora_2 extends Proyectil{
    
    public Pro_zora_2(int x, int y,String sen) {
        super(x, y,sen);
        this.ruta+="zora/pro2.png";
        this.tipo="hielo";
        this.dx=20;
        this.sentido();
        this.nombre="zora2";
    }
    
}
