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
public class Deku extends Personaje {

    public Deku() {
        this.nombre = "Deku";
        this.dx=5;
    }

    protected void asignar_rango() {
        switch (getAccion()) {
            case "caminar":
                rango = 4;
                break;
            case "morir":
                rango = 4;
                break;
            case "saltar":
                rango = 2;
                break;
            case "pararse":
                rango = 1;
                break;
            case "escudarse":
                rango = 1;
                break;
            case "atacar":
                rango = 2;
                break;
            case "atacar_parabolico":
                rango = 2;
                break;    
            default:
                break;
        }
    }

}
