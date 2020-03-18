/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class Hilo implements Runnable {

    private Logica lo;
    private final long delay = 250;
    private static long d=250;
    public long getDelay() {
        return delay;
    }
    public static long get_delay(){
       return d;
    }

    public Hilo(Logica lo) {
        this.lo = lo;
    }

    @Override
    public void run() {
        lo.iniciar();
        while (true) {
            lo.actualizar();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
