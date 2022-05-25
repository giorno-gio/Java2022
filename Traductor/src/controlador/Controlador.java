/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.jfTraductor;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener{

    jfTraductor vista = new jfTraductor();
    Modelo model = new Modelo();

    public Controlador(jfTraductor vista, Modelo modelo) {
     
        this.vista = vista;
        this.model = modelo;
        this.vista.btnTraducir.addActionListener(this);
        this.vista.cmbPalabras.addActionListener(this);
    }
    
    
    
    public void traduc(){
       this.vista.cmbPalabras.getSelectedIndex();
       JOptionPane.showMessageDialog(this.vista, this.vista.cmbPalabras.getSelectedIndex());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()== vista.btnTraducir) //dependiendo del boton hace unmetodo
            this.traduc();
    }
    
}
