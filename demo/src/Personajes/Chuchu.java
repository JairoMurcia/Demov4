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
public class Chuchu extends Enemigo{

    public Chuchu() {
           this.nombre="chuchu";
           this.dx=15;
           this.dy=0;
           String [] tipos={"agua","metal"};
    }
    
    
    @Override
    protected void asignar_rango() {
        switch(this.accion){
            case "caminar":
                rango=4;
                break;
            case "caminar_atacar":
                rango=4;
            case "pararse":
                rango=4;
            default :
                rango=4;
    }
    }

    @Override
    protected boolean esta_indefenso(Personaje p, ArrayList<Proyectil> pro) {
        if(!p.getAccion().equals("atacar") && !p.getNombre().equals("escudo")){
            return true;
        }else if(p.getNombre().equals("escudo") && !p.getAccion().equals("atacar")){
            P_escudo pe=(P_escudo) p;
            if(pe.getP().getNombre().equals("zora")){
                return true;
            }
        }
        return false;
        
        
    }

    public String getAccion() {
      if(this.accion.equals("caminar_atacar")){
          return "caminar";
      }
          
        return accion;
    }

   
    protected void evadir(Proyectil p) {
        if(p.dx>0){
            this.dx=Math.abs(this.dx);
        }else{
            if(this.dx>0){
                this.dx*=-1;
            }
        }
        this.accion="caminar_atacar";
    }

    @Override
    public void asignarAccion(){
        String aux = this.ruta + this.nombre + "/";
     
        if(this.accion.equals("atacar_parabolico") || this.accion.equals("atacar")){
            aux+="pararse";
        }else if(this.accion.equals("caminar_atacar")){
            aux+="caminar";
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
                System.out.println(aux+(i+1)+".png");
                this.imagenes[i] = ImageIO.read(new File(aux+(i+1)+".png"));
                
                
            } catch (IOException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

   
    

  
    
    
}
