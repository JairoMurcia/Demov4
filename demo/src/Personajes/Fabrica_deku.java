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
public class Fabrica_deku extends Fabrica_personajes {

    private Fabrica_deku() {

    }

    public static Fabrica_personajes get_fabrica() {
        if (!(fa instanceof Fabrica_deku)) {
            fa = new Fabrica_deku();
        }
        return fa;
    }

    public Personaje get_personaje() {
        return new Deku();
    }

    public Proyectil get_proyectil(String tipo, int x, int y, String sen,int tam) {
        if(sen.toLowerCase().charAt(0)=='d'){
            x+=tam;
        };
        if (tipo.equals("1")) {
            return new Pro_deku_1(x, y, sen);
        } else if (tipo.equals("2")) {
            return new Pro_deku_2(x, y, sen);
        }else{
            return null;
        }
    }

}
