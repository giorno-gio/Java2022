/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadfinal;

import Vista.FrmAdministrador;
import Vista.NivelPrincipiante;
import conexion.Conector;
import controlador.ControladorMenuAdministrador;
import controlador.ControladorNivelPrincipiante;
import dao.EstadoDao;
import dao.TipoUsuarioDao;
import dao.UsuarioDao;
import logicaJuegos.LogicaJuegos;
import vo.EstadoVo;
import vo.TipoUsuarioVo;
import vo.UsuarioVo;

/**
 *
 * @author Jorge
 */
public class ActividadFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //prueba de conexion 
//       Conector c = new Conector();
//        c.conectar();

        FrmAdministrador fma = new FrmAdministrador();
        NivelPrincipiante np = new NivelPrincipiante();
        
        EstadoVo evo = new EstadoVo();
        UsuarioVo uVo = new UsuarioVo();
        TipoUsuarioVo tVo = new TipoUsuarioVo();
        
        EstadoDao eDao = new EstadoDao();
        UsuarioDao uDao = new UsuarioDao();
        TipoUsuarioDao tDao = new TipoUsuarioDao();

        //logica juegos
        LogicaJuegos lj = new LogicaJuegos();
        
        ControladorMenuAdministrador cma = new ControladorMenuAdministrador(fma, evo, uVo, eDao, uDao,
                tVo, tDao);
        ControladorNivelPrincipiante cnp = new ControladorNivelPrincipiante(np, lj);

//        fma.setVisible(true);
//        fma.setLocationRelativeTo(null);
//        fma.setResizable(false);
       


        np.setVisible(true);
        np.setLocationRelativeTo(null);
        
    }
    
}
