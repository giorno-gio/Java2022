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

/**
 *
 * @author Jorge
 */
public class TipoUsuarioDao implements consultasTipoUsuario {

    @Override
    public ArrayList<TipoUsuarioVo> llenarcmbu() {
        Conector c = new Conector();
        ArrayList<TipoUsuarioVo> datos = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "t.id_tipo_usuario, "
                    + "t.nombre_tipo_usuario "
                    + "FROM dbjuegos.tipo_usuario t";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                TipoUsuarioVo tvo = new TipoUsuarioVo();
                tvo.setIdTipoUsuario(rs.getInt(1));
                tvo.setNombreTipoUsuario(rs.getString(2));
                datos.add(tvo);
            }
        } catch (Exception e) {
            System.err.println("Error[MLLenarCmbTipoU]: " + e.getMessage());
            c.desconectar();
        }
        return datos;
    }
}
