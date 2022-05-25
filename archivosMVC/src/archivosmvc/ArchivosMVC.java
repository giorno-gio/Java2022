/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivosmvc;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.Vistajf;

/**
 *
 * @author Jorge
 */
public class ArchivosMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vistajf vista = new Vistajf();//objetos
        ModeloLogico modelo = new ModeloLogico();
        Controlador controla = new Controlador(vista, modelo);//constructor
        
        vista.setVisible(true);//invocar ventana
        vista.setLocationRelativeTo(null);//invocar al centro
       
    }
    
}
