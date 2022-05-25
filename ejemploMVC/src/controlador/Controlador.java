/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmOperaciones;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener{
    //cracion de objetos a los cuales tiene acceso el contraldor
    FrmOperaciones vista = new FrmOperaciones();
    ModeloLogico modelo = new ModeloLogico();
    
    //constructor
    public Controlador(FrmOperaciones vista, ModeloLogico modelo){ //reserva espacio en memoria para que los objetos btns etc tengan un papel funcional en el proyecto
        this.vista = vista;   
        this.modelo = modelo;
        
        this.vista.btnSumar.addActionListener(this); //agrega al boton una accion guarda en memoria lo que se va a hacer con el boton
        this.vista.btnRestar.addActionListener(this);
        this.vista.btnMultiplicacion.addActionListener(this);
        this.vista.btnDividir.addActionListener(this);
    }
    
    
    //Funcionamiento del controlador
    private void sum(){
        //proceso del controlador de trasladar datos al modelo 
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        //el txt manda String entonces hay que parcearlo
     //.getText()obtiene el texto del txtField
     
     //proceso del controlador de recibir y traladar respuesta a la vista
     vista.jopResultado.showMessageDialog(this.vista, modelo.suma());
    }
    
    private void res(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        vista.jopResultado.showMessageDialog(this.vista, modelo.resta());
    }
    
    private void multi(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        vista.jopResultado.showMessageDialog(this.vista, modelo.multiplicacion());
    }
    private void divi(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        this.vista.jopResultado.showMessageDialog(this.vista, modelo.division());
        //1ubicacion medio de la pantallita, (null) cualquiera2)resultado
    }
    //metodo abstracto de la implementacion del actionlisntener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnSumar) //dependiendo del boton hace unmetodo
            this.sum();
        if(e.getSource()== vista.btnRestar)
            this.res();
        if(e.getSource()== vista.btnMultiplicacion)
            this.multi();
        if(e.getSource()== vista.btnDividir)
            this.divi();
    }
    
    
}
