/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.AutorDao;
import VO.AutorVo;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import vista.FrmMenuAutor;

/**
 *
 * @author Jorge
 */
public class ControladorMostrar implements WindowListener{

    FrmMenuAutor vMa = new FrmMenuAutor();
    AutorVo avo = new AutorVo();
    AutorDao adao = new AutorDao();

    public ControladorMostrar(FrmMenuAutor vMa, AutorVo avo, AutorDao adao) {
        this.vMa = vMa;
        this.avo = avo;
        this.adao = adao;
        
        this.vMa.addWindowListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel(){
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        m.setColumnCount(0);
        m.addColumn("ID");
        m.addColumn("NOMBRE");
        m.addColumn("APELLIDO");
        m.addColumn("NACIALIDAD");
        m.addColumn("FECHA DE REGISTRO");
        
        for(AutorVo avo : adao.consulta()){
            m.addRow(new Object[]{avo.getIdAutor(), avo.getNombreAutor(),
            avo.getApellidoAutor(), avo.getNacionalidadAutor(), avo.getFechaIngAutor()});
        }
        this.vMa.tblDatosAutor.setModel(m);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
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
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    
}
