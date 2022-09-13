/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.FrmAdministrador;
import dao.EstadoDao;
import dao.TipoUsuarioDao;
import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import vo.EstadoVo;
import vo.TipoUsuarioVo;
import vo.UsuarioVo;

/**
 *
 * @author Jorge
 */
public class ControladorMenuAdministrador implements ActionListener, WindowListener, MouseListener{

    FrmAdministrador va = new FrmAdministrador();
    EstadoVo eVo = new EstadoVo();
    UsuarioVo uVo = new UsuarioVo();
    EstadoDao eDao = new EstadoDao();
    UsuarioDao uDao = new UsuarioDao();
    TipoUsuarioVo tVo = new TipoUsuarioVo();
    TipoUsuarioDao tDao = new TipoUsuarioDao();

    public ControladorMenuAdministrador(FrmAdministrador va, EstadoVo eVo, UsuarioVo uVo, EstadoDao eDao, UsuarioDao uDao,
            TipoUsuarioVo tVo, TipoUsuarioDao tDao) {
        this.va = va;
        this.eVo = eVo;
        this.uVo = uVo;
        this.eDao = eDao;
        this.uDao = uDao;
        this.tVo = tVo;
        this.tDao = tDao;

        this.va.btnIngresar.addActionListener(this);
        this.va.btnModificar.addActionListener(this);
        this.va.btnBorrar.addActionListener(this);
        this.va.cmbEstado.addActionListener(this);
        this.va.cmbTipoUsuario.addActionListener(this);
        this.va.addWindowListener(this);
        this.va.tblUsuarios.addMouseListener(this);
    }

//    private void llenar() { //metodo para llenar cmbbox estado usuario
//        DefaultComboBoxModel dcb2 = new DefaultComboBoxModel();
//        for (EstadoVo evo : eDao.llenarcmbe()) {
//            //va.cmbEstado.addItem(evo.getDescripcion());
//            dcb2.addElement(evo.getDescripcion());
//        }
//        
//        va.cmbEstado.setModel(dcb2);
//    }
//    private void llenartipocmb() {
//        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
//        for (TipoUsuarioVo tvo : tDao.llenarcmbu()) {
//            //va.cmbEstado.addItem(evo.getDescripcion());
//            dcb.addElement(tvo.getNombreTipoUsuario());
//            
//        }
//        
//        va.cmbTipoUsuario.setModel(dcb);
//    }
//    private void llenarIndexEstado() {
//         DefaultComboBoxModel dcb = new DefaultComboBoxModel();
//        //this.eVo.setIndexop(this.va.cmbEstado.getSelectedIndex());
//        
//    }
//    
//    private void llenarIndexTipo(){
//        this.tVo.setIndesUs(this.va.cmbTipoUsuario.getSelectedIndex());
//    }
//    
    private void registarUsuario() {
        this.uVo.setNombreUsu(this.va.txtNombre.getText());
        this.uVo.setApellidoUsu(this.va.txtApellido.getText());
        this.uVo.setEdad(Integer.parseInt(this.va.txtEdad.getText()));
        this.uVo.setUsr(this.va.txtUsr.getText());
        this.uVo.setPass(this.va.txtPass.getText());
        this.uVo.setIdEstado(this.va.cmbEstado.getSelectedIndex());
        this.uVo.setIdTipoUsu(va.cmbTipoUsuario.getSelectedIndex());
        if (uDao.insertar(uVo, eVo, tVo) == true) {
            va.jopIngresar.showMessageDialog(va, "Usuario creado exitosamente");
            this.va.txtNombre.setText("");
            this.va.txtApellido.setText("");
            this.va.txtEdad.setText("");
            this.va.txtUsr.setText("");
            this.va.txtPass.setText("");
        } else {
            va.jopIngresar.showMessageDialog(va, "Error, No se puede crear usuario");
            this.va.txtNombre.setText("");
            this.va.txtApellido.setText("");
            this.va.txtEdad.setText("");
            this.va.txtUsr.setText("");
            this.va.txtPass.setText("");
        }
    }

    public void mostrar() {
        DefaultTableModel t = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        t.setColumnCount(0);
        t.addColumn("ID");
        t.addColumn("Nombre Usuario");
        t.addColumn("Apellido Usuario");
        t.addColumn("Usuario");
        t.addColumn("contraseña");

        for (UsuarioVo uVo : uDao.consultar()) {
            t.addRow(new Object[]{uVo.getId(),uVo.getNombreUsu(), uVo.getApellidoUsu(),
                uVo.getUsr(), uVo.getPass()});
        }

        this.va.tblUsuarios.setModel(t);
    }
    
    public void setDatosUsuario(){
        int numrow;
        numrow = va.tblUsuarios.getSelectedRow();
        va.txtId.setText(String.valueOf(va.tblUsuarios.getValueAt(numrow, 0)));
        va.txtNombre.setText(String.valueOf(va.tblUsuarios.getValueAt(numrow, 1)));
        va.txtApellido.setText(String.valueOf(va.tblUsuarios.getValueAt(numrow, 2)));
        va.txtUsr.setText(String.valueOf(va.tblUsuarios.getValueAt(numrow, 3)));
        va.txtPass.setText(String.valueOf(va.tblUsuarios.getValueAt(numrow, 4)));
    }
    
    
    private void actualizar(){
        this.uVo.setId(Integer.parseInt(va.txtId.getText()));
        this.uVo.setNombreUsu(va.txtNombre.getText());
        uVo.setApellidoUsu(va.txtApellido.getText());
        uVo.setUsr(va.txtUsr.getText());
        uVo.setPass(va.txtPass.getText());
        if(this.uDao.actualizar(uVo) == true){
            va.jopActualizar.showMessageDialog(va, "Datos actualizados correctamente");
            va.txtId.setText("");
            va.txtNombre.setText("");
//            va.txtNombre.requestFocus();
            va.txtApellido.setText("");
            va.txtUsr.setText("");
            va.txtUsr.setText("");
        }
        else{
            va.jopActualizar.showMessageDialog(va, "Error, datos no actualizados ");
            va.txtId.setText("");
            va.txtNombre.setText("");
//            va.txtNombre.requestFocus();
            va.txtApellido.setText("");
            va.txtUsr.setText("");
            va.txtUsr.setText("");
        }
    }
    
     private void setDatoEliminar(){
        int numRow;
        numRow = va.tblUsuarios.getSelectedRow();
        uVo.setId(Integer.parseInt(String.valueOf(va.tblUsuarios.getValueAt(numRow, 0))));
        int idPais = va.jopEliminar.showConfirmDialog(va, "En verdad desea eliminar el usuario "
           +va.tblUsuarios.getValueAt(numRow, 1),"Eliminar",2);
        if (idPais == va.jopEliminar.OK_OPTION){
            this.eliminar();
            va.jopEliminar.showMessageDialog(va, "Dato eliminado Correctamente");
        }
    }
    
    private void eliminar(){
        uVo.getId();
        uDao.eliminar(uVo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == va.btnIngresar) {
            if (!va.txtId.getText().equals("")&&!va.txtNombre.getText().equals("") && !this.va.txtApellido.getText().equals("")
                    && !this.va.txtEdad.getText().equals("") && !this.va.txtUsr.getText().equals("")
                    && !this.va.txtPass.getText().equals("")) {
                this.registarUsuario();
            } else {
                va.jopIngresar.showMessageDialog(va, "Debes llenar todos los campos");
            }
        }
        
        if(e.getSource() == va.btnModificar){
            if(!va.txtId.getText().equals("")&&!va.txtNombre.getText().equals("") && !this.va.txtApellido.getText().equals("")
               && !this.va.txtUsr.getText().equals("")&& !this.va.txtPass.getText().equals("")){
                this.actualizar();
            }
            else{
                va.jopActualizar.showMessageDialog(va, "Debes elegir un usuario");
            }
        }
        if(e.getSource() == va.btnBorrar){
            if(!va.txtId.getText().equals("")&&!va.txtNombre.getText().equals("") && !this.va.txtApellido.getText().equals("")
               && !this.va.txtUsr.getText().equals("")&& !this.va.txtPass.getText().equals("")){
                
            }
        }
    }
    
   

    @Override
    public void windowOpened(WindowEvent e) {
        //this.llenar();
//        this.llenartipocmb();
//        this.llenarIndexEstado();
//        this.llenarIndexTipo();
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
        //this.llenar();
//        this.llenartipocmb();
//        this.llenarIndexEstado();
//        this.llenarIndexTipo();
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            this.setDatosUsuario();
            this.va.txtEdad.setEditable(false);
        }
        
        if (e.getClickCount() == 3){
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

}
