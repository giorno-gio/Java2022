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
import modelo.MLArchivos;
import modelo.ModeloLogico;
import vista.JFVista;

/**
 *
 * @author Jorge
 */
public class Controlador implements ActionListener, WindowListener{

    JFVista vista = new JFVista(); //objetos a los cuales tiene acceso el controlado
    ModeloLogico modelo = new ModeloLogico();
    MLArchivos mlarchivos = new MLArchivos();//esta clase ya no la use inge xd

    public Controlador(JFVista vista, ModeloLogico modelo) { //constructor
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnSumar.addActionListener(this);
        this.vista.btnRestar.addActionListener(this);
        this.vista.btnMulti.addActionListener(this);
        this.vista.btnDivi.addActionListener(this);
        this.vista.btnModulo.addActionListener(this);
        this.vista.btnPow.addActionListener(this);
        this.vista.btnSen.addActionListener(this);
        this.vista.btnCos.addActionListener(this);
        //this.vista.jftxtFecha.setText(this.modelo.fecha());
        this.vista.addWindowListener(this);
        this.vista.btnDatos.addActionListener(this);
    }

    private void sumar() { //
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText()));//setn1 cuando obtengo el texto del textfield y lo parceo a int
        this.modelo.setN2(Integer.parseInt(this.vista.txtN2.getText()));//lo mismo
        this.vista.txtResultado.setText(String.valueOf(this.modelo.sumar()));//y aqui seteo el metodo sumar del modelo logico pero lo paso a string
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void restar() {
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText()));//aqui igual para ambos los seteo en setn1 pero antes los obtengo con un get y luego los paso a entero
        this.modelo.setN2(Integer.parseInt(this.vista.txtN2.getText()));
        this.vista.txtResultado.setText(String.valueOf(this.modelo.res()));
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void setambosnumeros() {
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText())); //aqui hice este metodo para solo tener que llamarlo y hacer la misma operacion de setn1 y setn2
        this.modelo.setN2(Integer.parseInt(this.vista.txtN2.getText()));
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void multi() {
        try{
        this.setambosnumeros();
        this.vista.txtResultado.setText(String.valueOf(this.modelo.multi()));
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void divi() {
        try{
        this.setambosnumeros();
        this.vista.txtResultado.setText(String.valueOf(this.modelo.divi()));
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void modulo() {
        try{
        this.setambosnumeros();
        this.vista.txtResultado.setText(String.valueOf(this.modelo.modulo()));
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void pown1() {
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText()));
        this.vista.txtResultado.setText(String.valueOf(this.modelo.potencian1(Integer.parseInt(this.vista.txtN2.getText()))));//obtengo el texto de txtfieldn2 lo paso a int para mandarlo al metodo potencia y luego lo paso a string con settext
        }catch(Exception e){ //basicamente para mandar el parametro a mi metodo 
            e.getMessage();
        }
    }

    private void senn1() {
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText()));
        this.vista.txtResultado.setText(String.valueOf(this.modelo.senn1()));
        }catch(Exception e){
            e.getMessage();
        }
    }
    private void cosn1(){
        try{
        this.modelo.setN1(Integer.parseInt(this.vista.txtN1.getText()));
        this.vista.txtResultado.setText(String.valueOf(this.modelo.cossn1()));
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    private void fecha(){
        this.vista.jftxtFecha.setText(this.modelo.fecha());
    }
      private void datosSuma(){
        this.modelo.setTexto(this.vista.txtN1.getText()+"+"+this.vista.txtN2.getText()
        +"="+this.vista.txtResultado.getText());
        this.modelo.guardar();
    }
       private void datosResta(){
        this.modelo.setTexto(this.vista.txtN1.getText()+"-"+this.vista.txtN2.getText()
        +"="+this.vista.txtResultado.getText());
        this.modelo.guardar(); // :( esta parte no me salio inge solo guarda una vez los datos y los borra 
    }
  
    @Override
    public void actionPerformed(ActionEvent e) { //metodo que implementa la interfaz action listener
        if (e.getSource() == vista.btnSumar) {
            this.sumar();
            this.datosSuma();
        }
        if (e.getSource() == vista.btnRestar) {
            this.restar();
            this.datosResta();
        }
        if (e.getSource() == vista.btnMulti) {
            this.multi();
        }
        if (e.getSource() == vista.btnDivi) {
            this.divi();
        }
        if (e.getSource() == vista.btnModulo) {
            this.modulo();
        }
        if (e.getSource() == vista.btnPow) {
            this.pown1();
        }
        if (e.getSource() == vista.btnSen) {
            this.senn1();
        }
        if (e.getSource() == vista.btnCos) {
            this.cosn1();
        }
        if (e.getSource() == vista.btnDatos) {
            //this.datosSuma();
        }
    }
    

    @Override
    public void windowOpened(WindowEvent e) {//metodos que implementa la intefaz windowslistener
        this.fecha();
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
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}
