/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jairo
 */
public class Poblacion extends Personaje {

    private ArrayList<Personaje> p = new ArrayList<Personaje>();

    public void setDireccion(String direccion) {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).setDireccion(direccion);
        }
    }

    public void setAccion(String accion) {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).setAccion(accion);
        }
    }

    public ArrayList<Personaje> getP() {
        return p;
    }

    public void avanzar() {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).avanzar();
        }
    }

    public void asignarAccion() {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).asignarAccion();
        }

    }

    public void agregar(Personaje pe) {
        p.add(pe);
    }

    public void eliminar(Personaje pe) {
        p.remove(pe);
    }
    
    public void setTipo_pro(int i){
        for(Personaje j:p){
            j.setTipo_pro(i);
        }
    }

    protected void asignar_rango() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
