/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Jorge
 */
public class ModeloLogico {
    
    private String texto; //almacenar el texto del txt area
    private String ruta;//ruta del archivo

    public ModeloLogico() {
    }

    public String getTexto() {
        return texto; //get texto
    }

    public void setTexto(String texto) {
        this.texto = texto; //set texto
    }

    public String getRuta() {
        return ruta; //get ruta
    }

    public void setRuta(String ruta) {
        this.ruta = ruta; //set ruta
    }
    
    public void guardar(){ 
        FileWriter fw;
        PrintWriter pw;
        
        try{
            fw = new FileWriter(ruta+".txt"); //abro y creo el txt con la ruta y la extension del arcivo
            pw = new PrintWriter(fw);
            
            pw.println(this.texto); //el texto que capture del txtarea lo imprimo en alrchivo
            fw.close();//cierro el archivo
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
//    public void abrir(){
//        File f;
//        FileReader fr;
//        BufferedReader br;
//        
//        try{
//            f = new File(this.ruta);
//            fr  = new FileReader(f);
//            br = new BufferedReader(fr);
//            
//            this.texto = "";
//            String lineas;
//            while((lineas = br.readLine())!=null){
//                this.texto+=lineas+"\n";
//            }
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//    }
    
    public String abrir(){
        File f;
        FileReader fr;
        BufferedReader br;
        String t = "";
        
        try{ 
            f = new File(this.ruta); //abro el archivo
            fr  = new FileReader(f);
            br = new BufferedReader(fr);
            
            this.texto = ""; //esto es para ir recorriendo las lineas que se encuentren en el archivo txt
            String lineas;
            while((lineas = br.readLine())!=null){
                t+=lineas+"\n";
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return t;
    }
    
    public Font negrita(){ //para implementar el tipo de fuente negrita tamaño 12
        Font f = new Font("", Font.BOLD, 12); 
        return f;       
    }
}
