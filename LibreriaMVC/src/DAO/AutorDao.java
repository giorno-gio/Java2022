/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.AutorVo;
import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class AutorDao implements ConsultasAutor {

    @Override
    public boolean insertarAutor(AutorVo a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO autor (nombre_autor, apellido_autor, nacionalidad, fecha_ingreso) "
                    + "VALUES ('" + a.getNombreAutor() + "', '" + a.getApellidoAutor() + "', '"
                    + a.getNacionalidadAutor() + "', '" + a.getFechaIngAutor() + "')";
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
    public ArrayList<AutorVo> consulta() {
        Conector c = new Conector();
        ArrayList<AutorVo> infoa = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "a.id_autor, "
                    + "a.nombre_autor, "
                    + "a.apellido_autor, "
                    + "a.nacionalidad, "
                    + "a.fecha_ingreso "
                    + "FROM bdlibreria.autor a";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                AutorVo aVo = new AutorVo();
                aVo.setIdAutor(rs.getInt(1));
                aVo.setNombreAutor(rs.getString(1));
                aVo.setApellidoAutor(rs.getString(2));
                aVo.setNacionalidadAutor(rs.getString(3));
                aVo.setFechaIngAutor(rs.getString(5));
                infoa.add(aVo);
            }
            c.desconectar();

        } catch (Exception e) {
            System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
        return infoa;
    }

}
