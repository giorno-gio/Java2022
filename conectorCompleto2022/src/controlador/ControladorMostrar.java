/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDao;
import modelo.PaisVo;
import vista.FrmMostrar;

/**
 *
 * @author Jorge
 */
public class ControladorMostrar implements ActionListener,WindowListener{
    FrmMostrar vMo = new FrmMostrar();
    PaisVo pVo = new PaisVo();
    PaisDao pDao = new PaisDao();
    
    
    public ControladorMostrar(FrmMostrar vMo, PaisVo pVo, PaisDao pDao){
        this.vMo = vMo;
        this.pVo = pVo;
        this.pDao = pDao;
        
        this.vMo.btnCancelarMos.addActionListener(this);
        this.vMo.addWindowListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel(){
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
        
        for(PaisVo pvo: pDao.consultar()){
            m.addRow(new Object[]{pvo.getIdPais(),pvo.getNombrePais(),
            pvo.getCapitalPais(),pvo.getPoblacionPais()});
        }
        
        this.vMo.tblMostrar.setModel(m);
//        TableColumn cCero = this.vMo.tblMostrar.getColumnModel().getColumn(0);
//        cCero.setMinWidth(75);
//        cCero.setMaxWidth(75);
//        TableColumn cUno = this.vMo.tblMostrar.getColumnModel().getColumn(1);
//        cUno.setMaxWidth(150);
//        cUno.setMinWidth(150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMo.btnCancelarMos){
            this.vMo.dispose();
        }
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
