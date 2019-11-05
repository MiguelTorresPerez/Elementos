/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Usuario DAM 2
 */
public class TextFieldNumeros extends JTextField implements KeyListener, FocusListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void focusGained(FocusEvent e) {
       if(this.getText().equals("Aviso")){
       this.setText(""); 
       }
    }

    @Override
    public void focusLost(FocusEvent e) {
      String texto = this.getText();

       if(texto.length()!=0){
       this.setText("Aviso");
       }
    }
}
