/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.Enemigo;
import Personajes.Personaje;
import Personajes.Proyectil;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Mediator {
    private String [] pro_ene={"chuchu","mothfire","rana"};
    private String [] pro_per={"deku1","deku2","gerudo1","gerudo2","goron1","goron2","zora1","zora2"};
    public void mediar(ArrayList <Personaje> p,ArrayList<Proyectil> pr,ArrayList<Enemigo> e,int ancho,int tam){
        interseccion(p,pr,tam);
        interseccion_e(e,pr,tam);
        for(Personaje per:p){
            if(per.getX()+tam<0){
                per.setX(0);
            }else if(per.getX()>ancho){
                per.setX(ancho-tam);
            }
        }
        for(Enemigo per:e){
            if(per.getX()-tam<0){
                per.setX(0);
            }else if(per.getX()>ancho){
                per.setX(ancho-tam);
            }
            for(Personaje pe:p){
                if(pe.getY()==per.getY()){
                    per.ia(pe, pr);
                }
            }
        }
        
    }
    
    
    private void interseccion(ArrayList <Personaje> clones,ArrayList<Proyectil> pro,int tam){
        ArrayList<Proyectil> aux=new ArrayList<Proyectil>();
        for(Personaje p:clones){
            for(Proyectil pr:pro){
                if( (pr.getX()>=p.getX() && pr.getX()<=p.getX()+tam) && (pr.getY()>=p.getY() && pr.getY()<=p.getY()+tam)){
                    for(String s:pro_ene){
                        if(s.equals(pr.getNombre()) && p.getE() instanceof Normal && !p.getNombre().equals("escudo") && !p.getAccion().equals("escudarse") ){
                            p.setE(new Golpeado(p));
                        }else if(p.getNombre().equals("escudo") && p.getAccion().equals("escudarse")){
                            aux.add(pr);
                        }
                        
                    }
                }
                
                
            }
        }
        for(Proyectil p:aux){
            pro.remove(aux);
        }
        
        
    }
    private void interseccion_e(ArrayList <Enemigo> clones,ArrayList<Proyectil> pro,int tam){
        ArrayList<Proyectil> aux=new ArrayList<Proyectil>();
        for(Enemigo p:clones){
            for(Proyectil pr:pro){
                if( (pr.getX()>=p.getX() && pr.getX()<=p.getX()+tam) && (pr.getY()>=p.getY() && pr.getY()<=p.getY()+tam)){
                    for(String s:pro_per){
                        if(s.equals(pr.getNombre()) && p.getE() instanceof Optimo && !p.getNombre().equals("escudo") && !p.getAccion().equals("escudarse") ){
                            p.setE(new Herido(p));
                        }else if(p.getAccion().equals("escudarse")){
                            aux.add(pr);
                        }
                        
                    }
                }
                
                
            }
        }
        for(Proyectil p:aux){
            pro.remove(aux);
        }
        
        
    }
    
    
}
