/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaDos extends JPanel implements ActionListener, ChangeListener{

    JCheckBox cNormal;
    JRadioButton rNormal, rUno, rDos, rTres;
    ButtonGroup grupoRadios;

    public PestaniaDos() {
        initGUI();
    }

    
    public void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void instancias() {
      cNormal = new JCheckBox("", false);
      cNormal.setIcon(new ImageIcon("src/main/java/resources/switch_off.png"));
      cNormal.setSelectedIcon(new ImageIcon("src/main/java/resources/switch_on.png"));
      rNormal = new JRadioButton("Opcion 1", false);
      rUno = new JRadioButton("Opcion 1", false);
      rDos = new JRadioButton("Opcion 2", false);
      rTres = new JRadioButton("Opcion 3", true);
      grupoRadios = new ButtonGroup();
      grupoRadios.add(rUno);
      grupoRadios.add(rDos);
      grupoRadios.add(rTres);
    }

    private void configurarPanel() {
        this.add(cNormal);
        this.add(rNormal);
        this.add(rUno);
        this.add(rDos);
        this.add(rTres);
    }
    private void acciones() {
        cNormal.addChangeListener(this);
        rUno.addChangeListener(this);
        rDos.addChangeListener(this);
        rTres.addChangeListener(this);
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
         
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()== rUno){
        
        }
        
        else if(e.getSource() == cNormal){
            cNormal.setText("a");
        }
        else{
           cNormal.setText("d");
        }
    }

    
}
