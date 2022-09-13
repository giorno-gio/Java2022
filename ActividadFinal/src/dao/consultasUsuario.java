/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import vo.EstadoVo;
import vo.TipoUsuarioVo;
import vo.UsuarioVo;

/**
 *
 * @author Jorge
 */
public interface consultasUsuario {
    public boolean insertar(UsuarioVo u, EstadoVo evo,TipoUsuarioVo tvo);
    public ArrayList<UsuarioVo> consultar();
    public boolean actualizar(UsuarioVo u);
    public boolean eliminar(UsuarioVo u);
    public void reporte();
}
