/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriamvc;

import DAO.AutorDao;
import VO.AutorVo;
import conexion.Conector;
import controlador.ControladorInsertar;
import controlador.ControladorMenuPrincipal;
import controlador.ControladorMostrar;
import vista.FrmMenuAutor;
import vista.FrmMenuPrincipal;

/**
 *
 * @author Jorge
 */
public class LibreriaMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //     Conector c = new Conector();
        //      c.conectar();
        
        
        FrmMenuPrincipal mp = new FrmMenuPrincipal();
        FrmMenuAutor ma = new FrmMenuAutor();
        
        //DAO
        AutorDao aDa = new AutorDao();
        //VO
        AutorVo aVo = new AutorVo();
        
        ControladorMenuPrincipal cMp = new ControladorMenuPrincipal(mp,ma);
        ControladorInsertar cIn = new ControladorInsertar(ma, aDa, aVo);
        ControladorMostrar cMo = new ControladorMostrar(ma, aVo, aDa);
        
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        mp.setResizable(false);

    }

}
