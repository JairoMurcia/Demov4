/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Piso;
import Personajes.Enemigo;
import Personajes.P_escudo;
import Personajes.Personaje;
import Personajes.Poblacion;
import Personajes.Proyectil;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Lienzo extends Canvas {

    private Graphics g;
    private BufferStrategy estrategia;

    public Lienzo() {
        this.setBackground(Color.WHITE);
    }

    public void consegir_g() {
        g = estrategia.getDrawGraphics();
    }

    public Graphics getg() {
        return g;
    }

    public BufferStrategy getEstrategia() {
        return estrategia;
    }

    public void iniciar() {
        this.createBufferStrategy(2);
        estrategia = this.getBufferStrategy();
    }

    public void dibujar_personajes(ArrayList<Personaje> p, int tamx, int tamy, Poblacion po) {
        for (int i = 0; i < p.size(); i++) {
            if (po.getP().contains(p.get(i))) {
                g.setColor(Color.lightGray);
                g.fillRect(p.get(i).getX(), p.get(i).getY(), tamx, tamy);
            }
            g.drawImage(p.get(i).getImagen(), p.get(i).getX(), p.get(i).getY(), tamx, tamy, this);
            if(p.get(i).getNombre().equals("escudo")){
                P_escudo pe=(P_escudo) p.get(i);
                g.drawImage(pe.getEscudo(), p.get(i).getX(), p.get(i).getY(), tamx, tamy, this);
            }
        }
    }

    public void dibujar_proyectiles(ArrayList<Proyectil> p, int tamx, int tamy) {
        for (int i = 0; i < p.size(); i++) {
            
            g.drawImage(p.get(i).getImagen(), p.get(i).getX(), p.get(i).getY() + 10, tamx, tamy, this);
        }
    }

    public void dibujar_rectangulo(Rectangle r) {
        g.setColor(Color.BLACK);
        g.drawRect(r.x, r.y, r.width, r.height);
    }

    public void dibujar_prototipo(Personaje p, int tamx, int tamy) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, tamx, tamy);
        g.drawImage(p.getImagen(), p.getX(), p.getY(), tamx, tamy, this);
    }
    public void dibujar_pisos(ArrayList<Piso>p){
        for(Piso pi:p){
            g.drawLine(0,pi.getY(),this.getWidth(),pi.getY());
        }
    }
    public void dibujar_enemigos(ArrayList<Enemigo> e, int tamx, int tamy){
        for(Enemigo en:e){
          g.drawImage(en.getImagen(), en.getX(), en.getY(), tamx, tamy, this);  
        }
    }
}
