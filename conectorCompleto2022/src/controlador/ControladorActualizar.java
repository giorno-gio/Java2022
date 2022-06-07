/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.PaisDao;
import modelo.PaisVo;
import vista.FrmActualizar;

/**
 *
 * @author Jorge
 */
public class ControladorActualizar implements ActionListener, WindowListener, MouseListener {

    FrmActualizar vMa = new FrmActualizar();
    PaisVo pVo = new PaisVo();
    PaisDao pDao = new PaisDao();

    public ControladorActualizar(FrmActualizar vMa, PaisVo pVo, PaisDao pDao) {
        this.vMa = vMa;
        this.pVo = pVo;
        this.pDao = pDao;

        this.vMa.btnActualizar.addActionListener(this);
        this.vMa.btnCancelar.addActionListener(this);
        this.vMa.addWindowListener(this);
        this.vMa.tblRegistrosAc.addMouseListener(this);
    }

    private void mostrar_datos() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }; //objeto para la estructura de mi tabla
        m.setColumnCount(0);//set a 0 para que la tabla este vacia
        m.addColumn("ID_PAIS"); //ENCABEZADOS DE LA TABLA :3
        m.addColumn("NOMBRE_PAIS");
        m.addColumn("CAPITAL_PAIS");
        m.addColumn("POBLACION_PAIS");

        for (PaisVo pvo : pDao.consultar()) {
            m.addRow(new Object[]{pvo.getIdPais(), pvo.getNombrePais(),
                pvo.getCapitalPais(), pvo.getPoblacionPais()});
        }

        this.vMa.tblRegistrosAc.setModel(m);
    }

    private void actualizar() {
        this.pVo.setIdPais(Integer.parseInt(this.vMa.txtIdPais.getText()));
        this.pVo.setNombrePais(this.vMa.txtNombrePais.getText());
        this.pVo.setCapitalPais(this.vMa.txtCapital.getText());
        this.pVo.setPoblacionPais(Long.parseLong(this.vMa.txtPoblacion.getText()));
        this.pVo.setFechaActPais(Extras.FechaHoy());
        if(this.pDao.actualizar(pVo) == true){
            this.vMa.JopPanelActualizar.showMessageDialog(vMa, "Datos Ingresados correctamente");
            this.vMa.txtNombrePais.setText("");
            this.vMa.txtCapital.setText("");
            this.vMa.txtPoblacion.setText("");
        }
        else{
            this.vMa.JopPanelActualizar.showMessageDialog(vMa, "Datos no ingresados");
            this.vMa.txtNombrePais.setText("");
            this.vMa.txtCapital.setText("");
            this.vMa.txtPoblacion.setText("");
        }
    }
    
    public void setDatos(){
        int fila = this.vMa.tblRegistrosAc.getSelectedRow();
        this.vMa.txtIdPais.setText(String.valueOf(this.vMa.tblRegistrosAc.getValueAt(fila, 0)));
        this.vMa.txtNombrePais.setText(String.valueOf(this.vMa.tblRegistrosAc.getValueAt(fila, 1)));
        this.vMa.txtCapital.setText(String.valueOf(this.vMa.tblRegistrosAc.getValueAt(fila, 2)));
        this.vMa.txtPoblacion.setText(String.valueOf(this.vMa.tblRegistrosAc.getValueAt(fila, 3)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMa.btnActualizar){
            if(!this.vMa.txtNombrePais.getText().equals("")
               && !this.vMa.txtCapital.getText().equals("")
               && !this.vMa.txtPoblacion.getText().equals("")){
                this.actualizar();
            }
            else{
                this.vMa.JopPanelActualizar.showMessageDialog(vMa, "Debe llenar todos los campos");
            }
        }
        if (e.getSource() == this.vMa.btnCancelar) {
            this.vMa.dispose();
        }
    }
    

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar_datos();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar_datos();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            this.setDatos();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
