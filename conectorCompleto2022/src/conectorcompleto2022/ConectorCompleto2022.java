/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectorcompleto2022;

import conexion.Conector;
import controlador.Controlador;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMostrar;
import modelo.PaisDao;
import modelo.PaisVo;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

/**
 *
 * @author Jorge
 */
public class ConectorCompleto2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //prueba de conexion 
//        Conector c = new Conector();
//        c.conectar();
//vistar
        FrmMenu fm = new FrmMenu();
        FrmInsertar fi = new FrmInsertar();
        FrmMostrar fmo = new FrmMostrar();
        FrmActualizar fa = new FrmActualizar();
        FrmEliminar fe = new FrmEliminar();
        //mofdelo
        PaisDao pDao = new PaisDao();
        PaisVo pVo = new PaisVo();
        
        
        //controlador
        Controlador cm = new Controlador(fm, fi,fmo,fa,fe);
        ControladorInsertar ci = new ControladorInsertar(fi, pVo, pDao);
        ControladorMostrar cmo = new ControladorMostrar(fmo, pVo, pDao);
        ControladorActualizar cma = new ControladorActualizar(fa, pVo, pDao);
        ControladorEliminar cme = new ControladorEliminar(fe, pDao, pVo);

        //configuracion pantalla menu
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);
    }

}
