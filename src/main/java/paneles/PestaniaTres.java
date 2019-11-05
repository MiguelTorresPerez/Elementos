package paneles;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaTres extends JPanel implements ActionListener, FocusListener {

    JTextField textoNormal,textoNormalSw;
    JButton bValidar;

    public PestaniaTres() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        textoNormal = new JTextField("aviso", 20);
        textoNormalSw = new JTextField("", 20);
        bValidar = new JButton("Validar");
    }

    private void configurarPanel() {
        this.add(textoNormal);
        this.add(textoNormalSw);
        this.add(bValidar);
    }

    private void acciones() {
    bValidar.addActionListener(this);
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
       if(textoNormal.getText().equals("Aviso")){
       textoNormal.setText(""); 
       }
    }

    @Override
    public void focusLost(FocusEvent e) {
      String texto = textoNormal.getText();

       if(texto.length()!=0){
       textoNormal.setText("Aviso");
       }
    }

    class ManejoKey extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e){
    super.keyPressed(e);
    char dato = e.getKeyChar();
    if (Character.isDigit(dato)){
        System.out.println("Es digito");
    }
    
    }
}
}
