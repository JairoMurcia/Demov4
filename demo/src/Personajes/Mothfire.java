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
public class Mothfire extends Enemigo{

    @Override
    protected void asignar_rango() {
        switch(this.accion){
            case "pararse":
                this.rango=4;
                break;
            case "atacar":
                this.rango=4;
                break;
            default:
                this.rango=4;
        }
    }

    public Mothfire() {
        this.nombre="mothfire";
    }

    @Override
    protected boolean esta_indefenso(Personaje p, ArrayList<Proyectil> pro) {
         if(!p.getAccion().equals("atacar") && !p.getNombre().equals("escudo")){
            return true;
        }else if(p.getNombre().equals("escudo") && !p.getAccion().equals("atacar")){
            P_escudo pe=(P_escudo) p;
            if(pe.getP().getNombre().equals("deku")){
                System.out.println("indefenso");
                return true;
            }
        }
        return false;
    }

    @Override
    protected void evadir(Proyectil p) {
        this.dy=Math.abs(dy)*-1;
        this.accion="atacar_parabolico";
    }

    @Override
    public void asignarAccion() {
        String aux = this.ruta + this.nombre + "/";
        if(this.accion.equals("atacar_parabolico") || this.accion.equals("atacar")){
            aux+="atacar";
        }else if(this.accion.equals("escudarse")){    
            aux+="escudarse";
        }else{
            aux+="pararse";
        }
        aux += this.direccion.toLowerCase().charAt(0);
        asignar_rango();
        this.imagenes = new BufferedImage[rango];
        
        for (int i = 0; i < rango; i++) {
            try {
                
                this.imagenes[i] = ImageIO.read(new File(aux+(i+1)+".png"));
                
                
            } catch (IOException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
}
