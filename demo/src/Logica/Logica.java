/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Personajes.*;
import Vista.Lienzo;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class Logica {

    private Lienzo l;
    private String t;
    private final int tam = 50;
    private final int tam1x = 25;
    private final int tam1y = 25;
    private final int dis = 100;
    private Personaje prototipo = new Deku();
    private Fabrica_enemigos fe=Fabrica_chuchu.get_fabrica();
    private Poblacion poblacion = new Poblacion();
    private Poblacion_enemigos pe=new Poblacion_enemigos();
    private Fabrica_personajes fp;
    private ArrayList<Personaje> clones = new ArrayList<>();
    private ArrayList<Proyectil> pro = new ArrayList<>();
    private ArrayList<Piso> pisos=new ArrayList<>();
    private Rectangle r = null;
    private String [] pro_ene={"chuchu","mothfire","rana"};
    public void setT(String t) {
        this.t = t;
    }

    public Logica(Lienzo l) {
        this.l = l;
        prototipo.setAccion("pararse");
        prototipo.setDireccion("derecha");
        prototipo.setE(new Normal(prototipo));
    }

    public void setR(Rectangle r) {
        this.r = r;

    }

    public void intersectar(int x, int y) {
        for (int i = 0; i < clones.size(); i++) {
            if (clones.get(i).getX() <= x && clones.get(i).getX() + tam >= x) {
                if (clones.get(i).getY() <= y && clones.get(i).getY() + tam >= y) {
                    if (poblacion.getP().contains(clones.get(i))) {
                        poblacion.eliminar(clones.get(i));
                    } else {
                        poblacion.agregar(clones.get(i));
                    }

                }

            }
        }
    }

    public void intersectar(Rectangle r) {
        for (int i = 0; i < clones.size(); i++) {
            if (probar(clones.get(i), r)) {
                if (!poblacion.getP().contains(clones.get(i))) {
                    poblacion.agregar(clones.get(i));

                }
            }
        }
    }

    public void actualizar() {
        for (int i = 0; i < clones.size(); i++) {
            clones.get(i).avanzar();
            if (clones.get(i).getAccion().equals("atacar") && clones.get(i).Lanza()) {
                
                pro.add(consegir_proyectil(clones.get(i), t));
            } else if (clones.get(i).getAccion().equals("atacar_parabolico") && clones.get(i).Lanza()) {
                Proyectil p = consegir_proyectil(clones.get(i), t);
                pro.add(new Proyectil_parabolico(p.getX(), p.getY(), p));
            }
        }
        for (int i = 0; i < pro.size(); i++) {
            pro.get(i).mover();
            if (pro.get(i).getX() - tam1x <= 0 || pro.get(i).getX() - tam1x >= l.getWidth()) {
                pro.remove(pro.get(i));

            }
        }
        if (r != null) {
            l.dibujar_rectangulo(r);
        }
        for(Enemigo e:this.pe.getEnem()){
            for(Personaje per:clones){
                if(per.getY()==e.getY()){
                    e.ia(per, pro);
                    break;
                }
                
            }
            if(e.getAccion().equals("atacar")){
                pro.add(consegir_proyectil(e,t));
            }else if(e.getAccion().equals("atacar_parabolico")){
                Proyectil p=consegir_proyectil(e,t);
                pro.add(new Proyectil_parabolico(p.getX(),p.getY(),p));
            }
                
        }
        
        interseccion();
        l.dibujar_personajes(clones, tam, tam, poblacion);
        l.dibujar_proyectiles(pro, tam1x, tam1y);
        l.dibujar_prototipo(prototipo, tam, tam);
        l.dibujar_pisos(pisos);
        l.dibujar_enemigos(pe.getEnem(), tam, tam);
        l.getEstrategia().show();
        l.paint(l.getg());
    }

    public void iniciar() {
        l.iniciar();
        l.consegir_g();
        prototipo.asignarAccion();
        prototipo.setE(new Normal (prototipo));
    }

    private Proyectil consegir_proyectil(Personaje p, String t) {
        switch (p.getNombre().toLowerCase()) {
            case "deku":
                fp = Fabrica_deku.get_fabrica();
                
                break;
            case "zora":
                fp = Fabrica_zora.get_fabrica();
                break;
            case "goron":
                fp = Fabrica_goron.get_fabrica();
                break;
            case "gerudo":
                fp = Fabrica_gerudo.get_fabrica();
                break;
            //--------------------------------    
            case("escudo"):
                P_escudo pe =(P_escudo) p;
                return consegir_proyectil(pe.getP(),t);
            
        }
        
        return fp.get_proyectil(""+p.getTipo_pro(), p.getX(), p.getY(), p.getDireccion(),tam-20);
    }
     private Proyectil consegir_proyectil(Enemigo e, String t) {
        
        return this.fe.get_proyectil(e.getX(), e.getY(), e.getDireccion(),tam-20);
    }

    public void agregar() {
        try {
            clones.add(prototipo.clonar());
            clones.get(clones.size()-1).setE(new Normal( clones.get(clones.size()-1)));
            int i = clones.size() - 1;
            if (i == 0) {
                int x = clones.get(i).getX();
                clones.get(i).setX(0);
                clones.get(i).setY(clones.get(i).getY()+tam);
                clones.get(i).asignarAccion();
                clones.get(i).setE(new Normal(clones.get(i)));
                pisos.add(new Piso(clones.get(i).getY()+tam));
            } else {
                
                int y = clones.get(i-1).getY()+2*tam;
                clones.get(i).setY(y);
                clones.get(i).setE(new Normal(clones.get(i)));
                pisos.add(new Piso(y+tam));

            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void asignar_tipo(String t) {

        switch (t) {
            case "deku":
                fp = Fabrica_deku.get_fabrica();
                break;
            case "zora":
                fp = Fabrica_zora.get_fabrica();
                break;
            case "goron":
                fp = Fabrica_goron.get_fabrica();
                break;
            case "gerudo":
                fp = Fabrica_gerudo.get_fabrica();
                break;
            default:
                break;

        }

        prototipo = fp.get_personaje();
        prototipo.setAccion("pararse");
        prototipo.setDireccion("derecha");
        prototipo.setE(new Normal(prototipo));
    }

    private boolean probar(Personaje p, Rectangle r) {
        return (p.getX() >= r.x || p.getX() + tam >= r.x)
                && (p.getY() >= r.y || p.getY() + tam >= r.y)
                && (p.getX() <= r.x + r.width || p.getX() + tam <= r.x + r.width)
                && (p.getY() <= r.y + r.height || p.getY() + tam <= r.y + r.height);
    }

    public void cambiar_accion(String s) {
        this.poblacion.setAccion(s);
        this.poblacion.asignarAccion();
    }

    public void cambiar_dir(String d) {
        this.poblacion.setDireccion(d);
    }

    public void agregar_decorador(String a) {
        for(int i=0;i<poblacion.getP().size();i++){
            for(int j=0;j<clones.size();j++){
                if(clones.get(j).equals(poblacion.getP().get(i))){
                  if(!clones.get(j).getNombre().equals("escudo")){  
                    P_escudo pe=new P_escudo(clones.get(j));
                    clones.set(j,pe);
                    poblacion.getP().set(i, pe);
                  }else{
                      P_escudo p=(P_escudo)clones.get(j);
                      clones.set(j, p.getP());
                      poblacion.getP().set(i,p.getP());
                  }
                }
            }
        }
    }
    
    public void cambiar_proyectil(int i){
        poblacion.setTipo_pro(i);
    }
    
    public void agregar_enemigos(){
        int i=pe.getEnem().size();
        poblacion.getP().forEach((p) -> {
            if(pe.getEnem().isEmpty()){
                pe.getEnem().add(fe.get_enemigo());
                pe.getEnem().get(i).setY(p.getY());
                pe.getEnem().get(i).setX(l.getWidth()-tam);
                pe.getEnem().get(i).setAccion("pararse");
                pe.getEnem().get(i).setDireccion("izquierda");
                pe.getEnem().get(i).setE(new Optimo(pe.getEnem().get(i)));
            }else{
                try {
                    pe.getEnem().add(pe.getEnem().get(0).clonar());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
                pe.getEnem().get(i).setY(p.getY());
                pe.getEnem().get(i).setX(l.getWidth()-tam);
                pe.getEnem().get(i).setAccion("pararse");
                pe.getEnem().get(i).setDireccion("izquierda");
                pe.getEnem().get(i).setE(new Optimo(pe.getEnem().get(i)));
            }
        });
    }

    public void asignar_tipoe(String s) {
        switch(s){
            case "chuchu":
                fe=Fabrica_chuchu.get_fabrica();
                break;
            case "rana":
                fe=Fabrica_rana.get_fabrica();
                break;
            case "mothfire":
                fe=Fabrica_mothfire.get_fabrica();
                break;    
        }
        
        
        
        pe.setEnem(new ArrayList<>());
        clones.forEach((p) -> {
            if(pe.getEnem().isEmpty()){
                pe.getEnem().add(fe.get_enemigo());
                pe.getEnem().get(0).setY(p.getY());
                pe.getEnem().get(0).setX(l.getWidth()-tam);
                pe.getEnem().get(0).setAccion("pararse");
                pe.getEnem().get(0).setDireccion("izquierda");
                pe.getEnem().get(0).setE(new Optimo( pe.getEnem().get(0)));
            }else{
                try {
                    pe.getEnem().add(pe.getEnem().get(0).clonar());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
                int i=pe.getEnem().size()-1;
                pe.getEnem().get(i).setY(p.getY());
                pe.getEnem().get(i).setX(l.getWidth()-tam);
                pe.getEnem().get(i).setAccion("pararse");
                pe.getEnem().get(i).setDireccion("izquierda");
                pe.getEnem().get(i).setE(new Optimo( pe.getEnem().get(i)));
            }
        });
        
    }
    
    private void interseccion(){
        for(Personaje p:clones){
            for(Proyectil pr:pro){
                if( (pr.getX()>=p.getX() && pr.getX()<=p.getX()+tam) && (pr.getY()>=p.getY() && pr.getY()<=p.getY()+tam)){
                    for(String s:pro_ene){
                        if(s.equals(pr.getNombre()) && p.getE() instanceof Normal){
                            p.setE(new Golpeado(p));
                        }
                    }
                }
                
                
            }
        }
    }
    
}
