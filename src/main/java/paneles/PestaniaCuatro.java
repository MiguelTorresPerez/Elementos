/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaCuatro extends JPanel implements ActionListener, FocusListener {

    JTextField textoNormal,textoNormal2;
    JButton bValidar;

    public PestaniaCuatro() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        textoNormal = new JTextField("aviso", 20);
        textoNormal2 = new JTextField("", 20);
    }

    private void configurarPanel() {
        this.add(textoNormal);
        this.add(textoNormal2);
    }

    private void acciones() {
    textoNormal.addFocusListener(this);
    textoNormal.addKeyListener(new ManejoKey());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bValidar) {
            if (textoNormal.getText().length() >= 10) {
                System.out.println("Es distinto de 10.");
            } else {
                System.out.println("");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
       if (e.getSource() == textoNormal){
           if(textoNormal.getText().equals("hint")){
       textoNormal.setText("hint");
           }
       } else if(e.getSource()== textoNormal2){
       if(textoNormal2.getText().equals("hint")){
       textoNormal2.setText("");
       }
    }
    }

    @Override
    public void focusLost(FocusEvent e) {
       if(textoNormal.getText().length()==0){
       textoNormal.setText("hint");
       } else if(textoNormal2.getText().length()==0){
       textoNormal2.setText("hint");
       }
    }

    class ManejoKey extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e){
    super.keyPressed(e);
    char dato = e.getKeyChar();
    if (Character.isDigit(dato)){
       e.consume();
    }
    }
}
}

