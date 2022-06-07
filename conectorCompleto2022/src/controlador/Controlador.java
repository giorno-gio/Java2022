/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener{
 //diferentes controladores porque van a diferentes pantallas
    
    FrmMenu vMenu = new FrmMenu();
    FrmInsertar vIn = new FrmInsertar();
    FrmMostrar vMo = new FrmMostrar(); //cada que cree pantallas agregar objetos
    FrmActualizar vMa = new FrmActualizar();
    FrmEliminar vMe = new FrmEliminar();

    public Controlador(FrmMenu vMenu, FrmInsertar vIN, FrmMostrar vMo, 
            FrmActualizar vMa, FrmEliminar vMe) { //agregar obj al contrlador tmb
        this.vMenu = vMenu;
        this.vIn = vIN;
        this.vMo = vMo;
        this.vMa = vMa;
        this.vMe = vMe;
        this.vMenu.btnInsertar.addActionListener(this);
        this.vMenu.btnMostrar.addActionListener(this);
        this.vMenu.btnActualizar.addActionListener(this);
        this.vMenu.btnEliminar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMenu.btnInsertar){
            this.vIn.setVisible(true);
            this.vIn.setLocationRelativeTo(this.vMenu);
            this.vIn.setResizable(false);
        }
        if(e.getSource() == this.vMenu.btnMostrar){
            this.vMo.setVisible(true);
            this.vMo.setLocationRelativeTo(this.vMenu);
            this.vMo.setResizable(false);
        }
        if(e.getSource() == this.vMenu.btnActualizar){
            this.vMa.setVisible(true);
            this.vMa.setLocationRelativeTo(this.vMenu);
            this.vMa.setResizable(false);
        }
        if(e.getSource() == this.vMenu.btnEliminar){
            this.vMe.setVisible(true);
            this.vMe.setLocationRelativeTo(this.vMenu);
            this.vMe.setResizable(false);
        }
        
    }
   
    
}
