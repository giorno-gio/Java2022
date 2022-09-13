/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.AutorDao;
import DAO.Extras;
import VO.AutorVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmMenuAutor;

/**
 *
 * @author Jorge
 */
public class ControladorInsertar implements ActionListener{
    
    FrmMenuAutor via = new FrmMenuAutor();
    AutorDao aDao = new AutorDao();
    AutorVo aVo = new AutorVo();

    public ControladorInsertar(FrmMenuAutor via, AutorDao aDao, AutorVo aVo) {
        this.via = via;
        this.aDao = aDao;
        this.aVo = aVo;
        
        via.btnIngresar.addActionListener(this);
        via.btnCancelar.addActionListener(this);
    }
    
    
    private void registrarAutor(){
        this.aVo.setNombreAutor(this.via.txtNombreAutor.getText());
        this.aVo.setApellidoAutor(this.via.txtApellidoAutor.getText());
        this.aVo.setNacionalidadAutor(this.via.txtNacionalidad.getText());
        this.aVo.setFechaIngAutor(Extras.fechaHoy());
        
        if(aDao.insertarAutor(aVo)== true){
            this.via.jopIngresoAutores.showMessageDialog(via, "Datos ingresados correctamente");
            this.via.txtNombreAutor.setText("");
            this.via.txtApellidoAutor.setText("");
            this.via.txtNacionalidad.setText("");
        }
        else{
             this.via.jopIngresoAutores.showMessageDialog(via, "Error, Datos no Registrados");
            this.via.txtNombreAutor.setText("");
            this.via.txtApellidoAutor.setText("");
            this.via.txtNacionalidad.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==via.btnIngresar){
            if(!this.via.txtNombreAutor.getText().equals("")
              && !this.via.txtApellidoAutor.getText().equals("")
              && !this.via.txtNacionalidad.getText().equals("")){
                this.registrarAutor();
            }
            else{
                this.via.jopIngresoAutores.showMessageDialog(via, "Debe llenar todos los campos");
            }
        }
        
        if(e.getSource() == via.btnCancelar){
            via.dispose();
        }
    }
    
}
