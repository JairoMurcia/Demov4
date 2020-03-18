/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Poblacion_enemigos extends Enemigo{
    ArrayList<Enemigo> enem=new ArrayList<Enemigo>();

    public ArrayList<Enemigo> getEnem() {
        return enem;
    }
    
    
    
    public void ia(Personaje p,ArrayList<Proyectil> pro){
        for(Enemigo e:enem){
            e.ia(p, pro);
        }
    }
    
    
    @Override
    public void asignarAccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void asignar_rango() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean esta_indefenso(Personaje p, ArrayList<Proyectil> pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void evadir(Proyectil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnem(ArrayList<Enemigo> a) {
        enem=a;
    }
    
}
