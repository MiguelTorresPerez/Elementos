/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaSeis extends JPanel implements ActionListener, ChangeListener, ItemListener {
    JList listaNormal;
    JButton botonAgregar, botonRellenar;
    DefaultListModel modeloLista;
    ArrayList<Persona> listaPersonas;


    public PestaniaSeis() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void instancias() {
        listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("dd", "fd",5345, true));
        modeloLista = new DefaultListModel();
        listaNormal = new JList(modeloLista);
        listaNormal.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        botonAgregar = new JButton("agregar elemento");
        botonRellenar = new JButton("Rellenar");
    }
    private void acciones() {
    botonAgregar.addActionListener(this);
    botonRellenar.addActionListener(this);
    listaNormal.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(listaNormal.getValueIsAdjusting()){
            Persona p = (Persona)modeloLista.getElementAt(listaNormal.getSelectedIndex());
            System.out.println(p.getNombre());
            }
        }
    });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonAgregar) {
        Object seleccionado = modeloLista.getElementAt(listaNormal.getSelectedIndex());
        if(seleccionado.getClass()== Persona.class){
        Persona seleccionada = (Persona)listaNormal.getSelectedValue();//Devuelve el objeto completo
        Persona pEncontrada = (Persona)modeloLista.getElementAt(listaNormal.getSelectedIndex());
        }
        
        };
        if (e.getSource()== botonRellenar){
        for(Persona p : listaPersonas){
        modeloLista.addElement(p);
        }
        }
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(listaNormal), BorderLayout.NORTH);
        this.add(botonRellenar, BorderLayout.SOUTH);
        this.add(botonAgregar, BorderLayout.CENTER);
    }

    class ManejoKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
           
        }
    }
}
