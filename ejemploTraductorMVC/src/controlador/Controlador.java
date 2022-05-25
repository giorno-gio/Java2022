/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Modelo;
import vista.Vista;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener {  
    Vista vista = new Vista(); //objetovs
    Modelo modelo = new Modelo();

    public Controlador(Vista vista, Modelo modelo) { //constructor
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnTraducir.addActionListener(this);
    }
    
    public void traducir(){
        this.modelo.setIndexPalabra(this.vista.cmbPEspanish.getSelectedIndex());//metodo para traducir
        this.vista.txtPalabraTraducida.setText(this.modelo.traducirPalabra()); // ya habia llenado antes el cmb box en las propiedades
        //solo lo traduje ing
    }
    @Override
    public void actionPerformed(ActionEvent e) { //metodo para los eventos (click) de la interface
        if(e.getSource() == this.vista.btnTraducir)
            this.traducir();
    }
    
    
}
