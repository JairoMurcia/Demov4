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
public class Pro_chuchu extends Proyectil{
    
    public Pro_chuchu(int x, int y, String sen) {
        super(x, y, sen);
        this.ruta+="chuchu/pro.png";
        this.tipo="electrico";
        this.dx=30;
        this.sentido();
        this.nombre="chuchu";
    }
    
}
