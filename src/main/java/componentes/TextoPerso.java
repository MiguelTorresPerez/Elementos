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
public class TextoPerso extends JTextField implements FocusListener {

    String hint;

    public TextoPerso(String text, int columns) {
        super(text, columns);
        hint = text;
        this.addFocusListener(this);
        this.addKeyListener(new ManejoKey());
    }

    @Override
    public void focusGained(FocusEvent e) {

        if (this.getText().equals(hint)) {
            this.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().length() == 0) {
            setText(hint);
        }
    }

    class ManejoKey extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            char dato = e.getKeyChar();
            if (Character.isDigit(dato)) {
                e.consume();
            } else if (getText().length() == 10) {
                e.consume();
            }

        }

    }
}
