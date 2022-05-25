/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplomvc;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmOperaciones;

/**
 *
 * @author Jorge
 */
public class EjemploMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmOperaciones ope = new FrmOperaciones();
        ModeloLogico ml = new ModeloLogico();
        Controlador c = new Controlador(ope,ml);
        
        ope.setVisible(true);
        ope.setLocationRelativeTo(null);
        ope.setResizable(false); //propiedad para no poder cambiarle de tamaño
    }
    
}
