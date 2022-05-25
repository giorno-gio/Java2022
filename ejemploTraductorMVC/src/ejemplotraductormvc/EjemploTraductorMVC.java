/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplotraductormvc;

import controlador.Controlador;
import model.Modelo;
import vista.Vista;

/**
 *
 * @author Jorge
 */
public class EjemploTraductorMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista vt = new Vista(); //objetos
        Modelo modelo = new Modelo();
        Controlador ct = new Controlador(vt, modelo); //constructor
        vt.setVisible(true); //llamar a la vista
        vt.setLocationRelativeTo(null); //poner en el centro la ventana
    }
    
}
