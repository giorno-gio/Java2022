/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.Vistajf;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener{
    Vistajf vista = new Vistajf();
    ModeloLogico model = new ModeloLogico(); //objetos

    public Controlador(Vistajf vista, ModeloLogico modelo) { //constructor
        this.vista = vista;
        this.model = modelo;
        
        this.vista.jmiAbrir.addActionListener(this); //espacio para los elementos a interactuar 
        this.vista.jmiGuardar.addActionListener(this);
        this.vista.jmiNegrita.addActionListener(this);
    }
    
    private void guardar(){
        int cierre = vista.emergente.showSaveDialog(vista); //metodo guardar de la ventanita
         if(cierre != vista.emergente.CANCEL_OPTION){ //condicion para que no salga error al darle cancelar
        model.setTexto(this.vista.txtDatos.getText()); //obtener los datos del txtarea
        model.setRuta(this.vista.emergente.getSelectedFile().toString());//setear la ruta del archivo con la ventanita
        model.guardar(); //guardar el archivo
         }
    }
    
    
    private void abrir(){
        int cierre = vista.emergente.showOpenDialog(vista);//metodo para abrir con la ventanita
        if(cierre != vista.emergente.CANCEL_OPTION){////condicion para que no salga error al darle cancelar
        model.setRuta(vista.emergente.getSelectedFile().toString());//seleccionar la ruta a abrir del archivo
        vista.txtDatos.setText(model.abrir());//abrir el archivo
        
        //modelo.abrir();
        //vista.txtArea.setText(modelo.getTexto());
        }
    }
    
    private void negrita(){
        this.vista.txtDatos.setFont(this.model.negrita()); //
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //metodo para reconocer clicks implementado por el actionlistener
        if(e.getSource() == vista.jmiGuardar){
            this.guardar();
        }
          if(e.getSource() == vista.jmiAbrir){
            this.abrir();
        }
            if(e.getSource() == vista.jmiNegrita){
           this.negrita();
        }
    }
    
    
}
