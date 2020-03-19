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
public class Rana extends Enemigo{
    
    
    public Rana(){
        this.nombre="rana";
    }
    
    @Override
    protected void asignar_rango() {
        switch(this.accion){
            case("atacar"):
                this.rango=3;
                break;
            case("atacar_salatar"):    
                this.rango=3;
            case("escudarse"):
                this.rango=1;
                break;
            case("pararse"):
                this.rango=3;
                break;
            case("saltar"):
                this.rango=2;
                break;
        }
    }

    @Override
    protected boolean esta_indefenso(Personaje p, ArrayList<Proyectil> pro) {
        if(!p.getAccion().equals("atacar") && !p.getNombre().equals("escudo")){
            return true;
        }else if(p.getNombre().equals("escudo") && !p.getAccion().equals("atacar")){
            P_escudo pe=(P_escudo) p;
            if(pe.getP().getNombre().equals("gerudo")){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void evadir(Proyectil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarAccion() {
        String aux = this.ruta + this.nombre + "/";
       
        if(this.accion.equals("atacar_parabolico") || this.accion.equals("atacar")){
            aux+="atacar";
        }else if(this.accion.equals("caminar_atacar")){
            aux+="saltar_atacar";
        }else if (this.accion.equals("escudarse")) {    
            
            aux+="escudarse";
        }else{
            aux+=this.accion;
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
