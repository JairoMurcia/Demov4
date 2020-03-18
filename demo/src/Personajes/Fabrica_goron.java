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
public class Fabrica_goron extends Fabrica_personajes {

     private Fabrica_goron() {

    }

    public static Fabrica_personajes get_fabrica() {
        if (!(fa instanceof Fabrica_goron)) {
            fa = new Fabrica_goron();
        }
        return fa;
    }
    public Personaje get_personaje() {
        return new Goron();
    }

    @Override
    public Proyectil get_proyectil(String tipo, int x, int y, String sen,int tam) {
        if(sen.toLowerCase().charAt(0)=='d'){
        x+=tam;
        }
        if (tipo.equals("1")) {
            return new Pro_goron_1(x, y, sen);
        } else if (tipo.equals("2")) {
            return new Pro_goron_2(x, y, sen);
        } else {
            return null;
        }
    }

}
