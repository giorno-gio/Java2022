/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge
 */
public class ModeloLogico {

    private double n1; //loque va almacenar de txtn1
    private double n2; // lo que almacena de txtn2
    private String texto; //texto de los txtfield

    public ModeloLogico() {
        //constructor
    }
    
    //getter y setter
    public double getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int sumar() { //metodo para sumar 
        int res;
        res = (int) (this.n1 + this.n2);
        return res;
    }

    public int res() { //metodo para restar
        int res;
        res = (int) (this.n1 - this.n2);
        return res;
    }

    public int multi() { //metodor multiplicar
        int res;
        res = (int) (this.n1 * this.n2);
        return res;
    }

    public double divi() {//dividir
        double res;
        res = this.n1 / this.n2;
        return res;
    }

    public int modulo() {//modulo
        int res;
        res = (int) (this.n1 % this.n2);
        return res;
    }

    public int potencian1(int val) {//potencia txtfieln1 valor txtfieldn2 potencia
        int res;
        res = (int) Math.pow(n1, val);
        return res;
    }

//    public int potencian2(int val){
//        int res;
//        res = (int) Math.pow(n2, val);
//        return res;
//    }
//    
    public double senn1() { //seno
        double res;
        res = Math.sin(n1);
        return res;
    }
// public double senn2(){
//        double res;
//        res = Math.sin(this.n2);
//        return res;
//    }
// 

    public double cossn1() {//coseno
        double res;
        res = Math.cos(n1);
        return res;
    }

// public double cossn2(){
//     double res;
//     res = Math.cos(n2);
//     return res;
// }
    public String fecha() { //fecha en un txtfield
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

     public void guardar(){ //guardar texto en archivo 
      FileWriter fw;
        PrintWriter pw;
        
        try{
            fw = new FileWriter("C:\\Cursos\\Java\\Intecap\\calculadoraMVC"); //abro y creo el txt con la ruta y la extension del arcivo
            pw = new PrintWriter(fw);
            
            pw.println(this.texto); //el texto que capture del txtarea lo imprimo en alrchivo
            pw.println();
            fw.close();//cierro el archivo
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
