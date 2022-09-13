/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.EstadoVo;
import vo.TipoUsuarioVo;
import vo.UsuarioVo;

/**
 *
 * @author Jorge
 */
public class UsuarioDao implements consultasUsuario {

    @Override
    public boolean insertar(UsuarioVo u, EstadoVo evo, TipoUsuarioVo tvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO usuario (nombre_ususario,apellido_usuario, edad_usuario, usr, pass, fk_id_estado, fk_id_tipo_usuario) "
                    + "VALUES('" + u.getNombreUsu() + "', " + "'" + u.getApellidoUsu() + "', " + "'" + u.getEdad() + "', " + "'"
                    + u.getUsr() + "', " + "'" + u.getPass() + "', " + "'" + u.getIdEstado() + "', " + "'" + u.getIdTipoUsu() + "')";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MInsertar]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<UsuarioVo> consultar() {
        Conector c = new Conector();
        ArrayList<UsuarioVo> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "u.id_usuario, "
                    + "u.nombre_ususario, "
                    + "u.apellido_usuario, "
                    + "u.usr, "
                    + "u.pass "
                    + "FROM dbjuegos.usuario u";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                UsuarioVo uVo = new UsuarioVo();
                uVo.setId(rs.getInt(1));
                uVo.setNombreUsu(rs.getString(2));
                uVo.setApellidoUsu(rs.getString(3));
                uVo.setUsr(rs.getString(4));
                uVo.setPass(rs.getString(5));
                info.add(uVo);
            }
        } catch (Exception e) {
            System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean actualizar(UsuarioVo u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE dbjuegos.usuario "
                    +"SET nombre_ususario='"+u.getNombreUsu()+"', "
                    + "apellido_usuario='"+u.getApellidoUsu()+"', "
                    + "usr='"+u.getUsr()+"',"
                    + "pass='"+u.getPass()+"' "
                    + "WHERE id_usuario="+u.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MActualizar]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(UsuarioVo u) {
        Conector c = new Conector();
        try {
          c.conectar();
          String query = "DELETE FROM dbjuegos.usuario "
                  +"WHERE id_usuario = "+u.getId();    
        } catch (Exception e) {
            System.err.println("Error[MEliminar]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public void reporte() {

    }

}
