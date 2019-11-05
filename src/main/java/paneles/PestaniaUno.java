/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;


/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaUno extends JPanel implements ActionListener, ChangeListener {
    
    JButton botonNormal;
    JButton botonNormal1;
    JToggleButton botonTog;
    JButton boton1, boton2, boton3;
    ButtonGroup grupoBotones;
    
    public PestaniaUno() {
        initGUI();
    }
    
    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }
    
    private void instancias() {
        botonNormal = new JButton();
        botonNormal.setIcon(new ImageIcon("src/main/java/resources/button_ok.png"));
        botonNormal.setPressedIcon(new ImageIcon("src/main/java/resources/button_cancel.png"));
        botonNormal1 = new JButton("", new ImageIcon("src/main/java/resources/button_cancel.png"));
        botonTog = new JToggleButton("", true);
        botonTog.setIcon(new ImageIcon("src/main/java/resources/switch_off.png"));
        
        botonTog.setBackground(null);
        botonTog.setBorderPainted(false);
        botonTog.setFocusPainted(false);
        boton1 = new JButton();
        boton2 = new JButton();
        boton3 = new JButton();
        grupoBotones = new ButtonGroup();
        grupoBotones.add(boton1);
        grupoBotones.add(boton2);
        grupoBotones.add(boton3);
    }
    
    private void configurarPanel() {
        this.add(botonNormal);
        this.add(botonNormal1);
        this.add(botonTog);
    }
    
    private void acciones() {
        botonNormal.addActionListener(this);
        botonNormal1.addActionListener(this);
        botonTog.addActionListener(this);
        botonTog.addChangeListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNormal) {
       
            if (botonTog.isSelected()) {
                botonTog.setSelected(false);
            } else {
                botonTog.setSelected(true);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(((JToggleButton)e.getSource()).isSelected()){
            botonTog.setIcon(new ImageIcon("src/main/java/resources/switch_on.png"));
        }
        else{
            botonTog.setIcon(new ImageIcon("src/main/java/resources/switch_off.png"));
        }
    }

    
}
