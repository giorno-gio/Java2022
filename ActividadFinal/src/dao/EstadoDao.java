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

/**
 *
 * @author Jorge
 */
public class EstadoDao implements consultaEstado{

    @Override
    public ArrayList<EstadoVo> llenarcmbe() {
        Conector c = new Conector();
        ArrayList<EstadoVo> datos = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "e.id_estado, "
                    + "e.descripcion "
                    + "FROM dbjuegos.estado e";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                EstadoVo evo  = new EstadoVo();
                evo.setIdEstado(rs.getInt(1));
                evo.setDescripcion(rs.getString(2));
                datos.add(evo);
            }
        }catch(Exception e) {
            System.err.println("Error[MLLenarCmbEstado]: " + e.getMessage());
            c.desconectar();
        }
        return datos;
    }
    
}
