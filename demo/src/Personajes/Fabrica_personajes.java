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
public abstract class Fabrica_personajes {
    protected static Fabrica_personajes fa=null;
    
    public static Fabrica_personajes get_fabrica(){
        
        return fa;
    }
    
    
    public abstract Personaje get_personaje();
    public abstract Proyectil get_proyectil(String tipo,int x,int y,String se,int tam);
}
