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
public abstract class Fabrica_enemigos {
    protected static Fabrica_enemigos fa=null;
    
    public static Fabrica_enemigos get_fabrica(){
        
        return fa;
    }
    
    public abstract Enemigo get_enemigo();
    public abstract Proyectil get_proyectil(int x,int y,String se,int tam);
    
}
