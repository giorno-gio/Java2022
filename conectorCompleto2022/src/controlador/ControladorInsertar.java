/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import modelo.PaisDao;
import modelo.PaisVo;
import modelo.Extras;
import vista.FrmInsertar;

/**
 *
 * @author Jorge
 */
public class ControladorInsertar implements ActionListener {

    FrmInsertar vIn = new FrmInsertar();
    PaisVo pvo = new PaisVo();
    PaisDao pDao = new PaisDao();

    public ControladorInsertar(FrmInsertar vIn, PaisVo pvo, PaisDao pDao) {
        this.vIn = vIn;
        this.pvo = pvo;
        this.pDao = pDao;

        this.vIn.btnRegistrarPais.addActionListener(this);
        this.vIn.btnCancelarInsertar.addActionListener(this);
    }

    private void RegistrarPais() {
        pvo.setNombrePais(this.vIn.txtNombrePais.getText());
        this.pvo.setCapitalPais(this.vIn.txtCapital.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vIn.txtPoblacion.getText()));
        this.pvo.setFechaIngPais(Extras.FechaHoy());
        //this.pDao.insertar(pvo);
        if (pDao.insertar(pvo) == true) {
            this.vIn.jopPanelR.showMessageDialog(vIn, "Datos registrados correctamente");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapital.setText("");
            this.vIn.txtPoblacion.setText("");
        } else {
            this.vIn.jopPanelR.showMessageDialog(vIn, "Datos no registrados");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapital.setText("");
            this.vIn.txtPoblacion.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vIn.btnRegistrarPais) {
            if (!this.vIn.txtNombrePais.getText().equals("")
                    && !this.vIn.txtCapital.getText().equals("")
                    && !this.vIn.txtPoblacion.getText().equals("")) {
                this.RegistrarPais();
            } else {
                this.vIn.jopPanelR.showMessageDialog(vIn, "Debe llenar todos los campos");
            }

        }
        if (e.getSource() == this.vIn.btnCancelarInsertar) {
            this.vIn.dispose(); //cierra la ventana
        }
    }

}
