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

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaCinco extends JPanel implements ActionListener, ChangeListener, ItemListener {

    JSpinner spinnerEdad, spinnerLista;
    JTextField tNombre, tApellido,tNum;
    JCheckBox ch1;
    JButton botonAgregar;
    SpinnerListModel spinnerListModel;
    SpinnerNumberModel spinnerNumModel;
    ArrayList datosSpinner;
    JPanel panelCentro, panelSup;
    JComboBox wombo;
    DefaultComboBoxModel modeloWombo;

    public PestaniaCinco() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarSpinner();
        configurarModeloWombo();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        tNombre = new JTextField();
        tApellido = new JTextField();
        tNum = new JTextField();
        ch1 = new JCheckBox();
        modeloWombo = new DefaultComboBoxModel();
        wombo = new JComboBox(modeloWombo);
        botonAgregar = new JButton("Agregar");
        panelSup = new JPanel();
        panelCentro = new JPanel();
        datosSpinner = new ArrayList();
        spinnerEdad = new JSpinner();
        spinnerListModel = new SpinnerListModel();
        spinnerLista = new JSpinner(spinnerListModel);
    }
    private void acciones() {
    tNum.addKeyListener(new ManejoKey());
    botonAgregar.addActionListener(this);
    spinnerLista.addChangeListener(this);
    wombo.addItemListener(this);
    }
    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarPanelSup(),BorderLayout.NORTH);
        this.add(configurarPanelCent(), BorderLayout.CENTER);
    }

    private void configurarSpinner() {
        datosSpinner.add("nombre1");
        datosSpinner.add("nombre2");
        datosSpinner.add("nombre3");
        spinnerListModel.setList(datosSpinner);
    }
    private void configurarModeloWombo() {
        modeloWombo.addElement(new Persona("hdl", "bjhf", 5, true));
    }

   

    private JPanel configurarPanelSup() {
       panelSup.add(spinnerLista);
       panelSup.add(spinnerEdad);
       panelSup.add(wombo);
       return panelSup;
    }
    private JPanel configurarPanelCent() {
        panelCentro.setLayout(new GridBagLayout());
        confuigurarConstraints(1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, tNombre);
        confuigurarConstraints(0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0.2, new JLabel("Nombre"));
        confuigurarConstraints(1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, tApellido);
        confuigurarConstraints(0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0.2, new JLabel("Apellido"));
        confuigurarConstraints(1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, spinnerEdad);
        confuigurarConstraints(0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0.2, new JLabel("Edad"));
        confuigurarConstraints(1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, tNum);
        confuigurarConstraints(0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0.2, new JLabel("Numero"));
        confuigurarConstraints(1, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, ch1);
        confuigurarConstraints(0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0.2, new JLabel("Disponibilidad"));
        confuigurarConstraints(0, 5, 2, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0.2, botonAgregar);
        return panelCentro;
    }
    
    
    private void confuigurarConstraints(int posx,int posy, int tx, int ty, int ali, int fill, double pesx, double pesy, Component component){
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridwidth=tx;
    constraints.gridheight=ty;
    constraints.gridx=posx;
    constraints.gridy=posy;
    constraints.anchor=ali;
    constraints.fill=fill;
    constraints.weightx=pesx;
    constraints.weighty=pesy;
    panelCentro.add(component, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonAgregar){
        if(tNum.getText().isEmpty() || tNombre.getText().isEmpty() || tApellido.getText().isEmpty()){
            System.out.println("Faltan datos");
            
            //Persona p = (Persona)wombo.getItemAt(wombo.getSelectedIndex());
            //System.out.println(p.getNombre());
            Persona p = (Persona)modeloWombo.getSelectedItem();
            System.out.println(p.getNombre());
        } else {
        String nombre = tNombre.getText();
        String apellido = tApellido.getText();
        int tlf = Integer.valueOf(tNum.getText());
        boolean disponibilidad = ch1.isSelected();
        Persona persona = new Persona(nombre,apellido,tlf,disponibilidad);
        datosSpinner.add(persona);
        }
        
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       // System.out.println("Cambiado");
       if(spinnerLista.getModel().getValue().getClass() == Persona.class){
       Persona pSelected = (Persona)spinnerLista.getModel().getValue();
           System.out.println(pSelected.isDisponibilidad());
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Persona p = (Persona) wombo.getModel().getSelectedItem();
        System.out.println(p.getApellido());
    }

    class ManejoKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            char dato = e.getKeyChar();
            if (!Character.isDigit(dato)) {
                e.consume();
            }else if(tNum.getText().length() > 9){
            e.consume();
            }
        }
    }
}
