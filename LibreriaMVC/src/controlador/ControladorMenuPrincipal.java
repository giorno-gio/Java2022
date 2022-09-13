/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmMenuAutor;
import vista.FrmMenuPrincipal;

/**
 *
 * @author Jorge
 */
public class ControladorMenuPrincipal implements ActionListener{
    FrmMenuPrincipal vMp = new FrmMenuPrincipal();
    FrmMenuAutor vMa = new FrmMenuAutor();

    public ControladorMenuPrincipal(FrmMenuPrincipal vMp, FrmMenuAutor vMa) {
        this.vMp = vMp;
        this.vMa = vMa;
        
        
        this.vMp.btnAutores.addActionListener(this);
        this.vMp.btnLibros.addActionListener(this);
        this.vMp.btnJoin.addActionListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.vMp.btnAutores){
           vMa.setVisible(true);
           vMa.setLocationRelativeTo(vMp);
           vMa.setResizable(false);
       }
       
    }
    
}
