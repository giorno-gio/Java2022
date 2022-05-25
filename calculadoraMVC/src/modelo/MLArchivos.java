/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Jorge
 */
public class MLArchivos {
    
    private String texto;
    public MLArchivos() {
        
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    public void guardar(){ 
        FileWriter fw;
        PrintWriter pw;
        
        try{
            fw = new FileWriter("C:\\Users\\Jorge\\Desktop\\Java y android\\archivos.txt"); //abro y creo el txt con la ruta y la extension del arcivo
            pw = new PrintWriter(fw);
            
            pw.println(this.texto); //el texto que capture del txtarea lo imprimo en alrchivo
            fw.close();//cierro el archivo
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
}
