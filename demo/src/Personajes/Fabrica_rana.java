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
public class Fabrica_rana extends Fabrica_enemigos{
    
    private Fabrica_rana(){
        
    }
    public static Fabrica_enemigos get_fabrica(){
        fa=new Fabrica_rana();
        return fa;
    }
    @Override
    public Enemigo get_enemigo() {
       return new Rana();
    }

    @Override
    public Proyectil get_proyectil(int x, int y, String se, int tam) {
        if(se.toLowerCase().charAt(0)=='d'){
            x+=tam;
        };
        return new Pro_rana(x,y,se);
    }
    
}
