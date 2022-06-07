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
import modelo.PaisDao;
import modelo.PaisVo;
import vista.FrmEliminar;

/**
 *
 * @author Jorge
 */
public class ControladorEliminar implements ActionListener,MouseListener,WindowListener{
    FrmEliminar vMe = new FrmEliminar();
    PaisDao pDao = new PaisDao();
    PaisVo pVo = new PaisVo();

    public ControladorEliminar(FrmEliminar vMe, PaisDao pDao, PaisVo pVo) {
        this.vMe = vMe;
        this.pDao = pDao;
        this.pVo = pVo;
        this.vMe.btnRegresar.addActionListener(this);
        this.vMe.addWindowListener(this);
        this.vMe.tblDatosEliminar.addMouseListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel(){
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
          m.setColumnCount(0);
        m.addColumn("Id del País");
        m.addColumn("Nombre del País");
        m.addColumn("Capital del País");
        m.addColumn("Población del País");
       
          for(PaisVo pvo: pDao.consultar()){
            m.addRow(new Object[]{pvo.getIdPais(),pvo.getNombrePais(),
            pvo.getCapitalPais(),pvo.getPoblacionPais()});
        }
        
        this.vMe.tblDatosEliminar.setModel(m);
    }
    
    private void setDatoEliminar(){
        int numrow;
        numrow = this.vMe.tblDatosEliminar.getSelectedRow();
        pVo.setIdPais(Integer.parseInt(String.valueOf(vMe.tblDatosEliminar.getValueAt(numrow, 0))));
        int IdPais = vMe.jopEliminar.showConfirmDialog(vMe, 
                "En verdad deseas eliminar el pais de "+vMe.tblDatosEliminar.getValueAt(numrow, 1), "Eliminar", 2);
        if(IdPais == vMe.jopEliminar.OK_OPTION){
            this.eliminar();
            this.vMe.jopEliminar.showMessageDialog(vMe, "Dato eliminado correctamente");
        }
    }
    
    private void eliminar(){
        this.pVo.getIdPais();
        this.pDao.eliminar(pVo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMe.btnRegresar){
            this.vMe.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            this.setDatoEliminar();
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
