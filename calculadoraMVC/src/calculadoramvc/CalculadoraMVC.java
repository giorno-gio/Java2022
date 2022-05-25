/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramvc;

import controlador.Controlador;
import modelo.MLArchivos;
import modelo.ModeloLogico;
import vista.JFVista;

/**
 *
 * @author Jorge
 */
public class CalculadoraMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //aqui en el main instancio los objetos
        JFVista v = new JFVista();
        ModeloLogico m = new ModeloLogico();
        Controlador c = new Controlador(v, m);//le paso los parametros al controlador
        
        v.setVisible(true);//invocar ventana
        v.setLocationRelativeTo(null);//invocar al centro
    }
    //gracias inge
}
