/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Hilo;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author jairo
 */
public class Ventana extends JFrame {
    private Lienzo l;
    private JButton clonar=new JButton("Clonar");
    private JRadioButton deku=new JRadioButton("Deku");
    private JRadioButton goron=new JRadioButton("Goron");
    private JRadioButton gerudo=new JRadioButton("Gerudo");
    private JRadioButton zora=new JRadioButton("Zora"); 
    private ButtonGroup grupo=new ButtonGroup();
    private JRadioButton chuchu=new JRadioButton("Chuchu");
    private JRadioButton rana=new JRadioButton("Rana");
    private JRadioButton mothfire=new JRadioButton("Mothfire"); 
    private ButtonGroup grupoe=new ButtonGroup();
    private JButton teclas=new JButton("Instrucciones");
     private JButton agregare=new JButton("agrgar enemigo");
    private JLabel p=new JLabel("Protitpo");
    public Ventana(){
        Container c=getContentPane();
        c.setLayout(null);
        l=new Lienzo();
        c.add(p);
        p.setBounds(10,10,60,20);
        c.add(l);
        l.setBounds(10,30,950,440);
        c.add(clonar);
        clonar.setBounds(10,480,120,20);
        c.add(deku);
        deku.setBounds(130,480,60,20);
        c.add(goron);
        goron.setBounds(190,480,60,20);
        c.add(gerudo);
        gerudo.setBounds(250,480,80,20);
        c.add(zora);
        zora.setBounds(330,480,60,20);
        c.add(teclas);
        teclas.setBounds(390,480,120,20);
        
        c.add(chuchu);
        chuchu.setBounds(520,480,70,20);
        c.add(rana);
        rana.setBounds(590,480,60,20);
        c.add(mothfire);
        mothfire.setBounds(660,480,80,20);
        c.add(agregare);
        agregare.setBounds(750,480,190,20);
        
        
        grupo.add(deku);
        grupo.add(goron);
        grupo.add(gerudo);
        grupo.add(zora);
        deku.setSelected(true);
        
        grupoe.add(chuchu);
        grupoe.add(rana);
        grupoe.add(mothfire);
        chuchu.setSelected(true);
    }
    public Lienzo getLienzo(){
        return l;
    }
    public void mostrar(){
        this.setSize(1000,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
    }
    public void agregar_listeners(ActionListener al,KeyListener ke,MouseListener cm,MouseMotionListener ml){
        this.l.addMouseListener(cm);
        this.l.addMouseMotionListener(ml);
        clonar.addActionListener(al);
        clonar.setActionCommand("clonar");
        clonar.setFocusable(false);
        clonar.setFocusTraversalKeysEnabled(true);
       
        teclas.addActionListener(al);
        teclas.setActionCommand("teclas");
        teclas.setFocusable(false);
        teclas.setFocusTraversalKeysEnabled(true);
        
        agregare.addActionListener(al);
        agregare.setActionCommand("agregar_enemigo");
        agregare.setFocusable(false);
        agregare.setFocusTraversalKeysEnabled(true);
        
        deku.addActionListener(al);
        deku.setActionCommand("deku");
        deku.setFocusable(false);
        deku.setFocusTraversalKeysEnabled(true);
        gerudo.addActionListener(al);
        gerudo.setActionCommand("gerudo");
        gerudo.setFocusable(false);
        gerudo.setFocusTraversalKeysEnabled(true);
        zora.addActionListener(al);
        zora.setActionCommand("zora");
        zora.setFocusable(false);
        zora.setFocusTraversalKeysEnabled(true);
        goron.addActionListener(al);
        goron.setActionCommand("goron");
        goron.setFocusable(false);
        goron.setFocusTraversalKeysEnabled(true);
        chuchu.addActionListener(al);
        chuchu.setActionCommand("chuchu");
        chuchu.setFocusable(false);
        chuchu.setFocusTraversalKeysEnabled(true);
        rana.addActionListener(al);
        rana.setActionCommand("rana");
        rana.setFocusable(false);
        rana.setFocusTraversalKeysEnabled(true);
        mothfire.addActionListener(al);
        mothfire.setActionCommand("mothfire");
        mothfire.setFocusable(false);
        mothfire.setFocusTraversalKeysEnabled(true);
        
        l.addKeyListener(ke);
        l.setFocusable(true);
        l.setFocusTraversalKeysEnabled(false);
     }

    
}
