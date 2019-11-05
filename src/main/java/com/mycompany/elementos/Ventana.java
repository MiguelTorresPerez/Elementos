/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elementos;

import paneles.PestaniaDos;
import paneles.PestaniaUno;
import paneles.PestaniaTres;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import paneles.PestaniaCinco;
import paneles.PestaniaCuatro;
import paneles.PestaniaSeis;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame {

    Container container;
    PestaniaUno pestaniaUno;
    PestaniaDos pestaniaDos;
    PestaniaTres pestaniaTres;
    PestaniaCuatro pestaniaCuatro;
    PestaniaCinco pestaniaCinco;
    PestaniaSeis pestaniaSeis;
    JTabbedPane panelPestanias;

    public void initGUI() {
        instancias();
        configurarContainer();
       
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaUno = new PestaniaUno();
        pestaniaDos = new PestaniaDos();
        pestaniaTres = new PestaniaTres();
        pestaniaCuatro = new PestaniaCuatro();
        pestaniaCinco = new PestaniaCinco();
        pestaniaSeis = new PestaniaSeis();
    }

    private void configurarContainer() {
        container.add(new JLabel(), BorderLayout.CENTER);
        container.add(panelPestanias);
        panelPestanias.addTab("botones", pestaniaUno);
        panelPestanias.addTab("botones1", pestaniaDos);
        panelPestanias.addTab("Textos", pestaniaTres);
        panelPestanias.addTab("4", pestaniaCuatro);
        panelPestanias.addTab("5", pestaniaCinco);
        panelPestanias.addTab("6", pestaniaSeis);
    }
}
