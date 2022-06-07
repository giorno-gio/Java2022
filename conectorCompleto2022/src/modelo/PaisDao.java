/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class PaisDao implements ConsultasPais {

    @Override
    public boolean insertar(PaisVo p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, "
                    + "capital_pais, poblacion_pais, fecha_ingreso_pais) "
                    + "VALUES ('" + p.getNombrePais() + "', '"
                    + p.getCapitalPais() + "', " + p.getPoblacionPais() + ", '"
                    + p.getFechaIngPais() + "')"; //consulta
            c.consultasMultiples(query);
            //recomendacion del inge hacerlo despacio
        } catch (Exception e) {
            System.err.println("Error[MInsert]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PaisVo> consultar() {
        Conector c = new Conector();
        ArrayList<PaisVo> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT p.id_pais,p.nombre_pais,p.capital_pais,p.poblacion_pais "
                    + "FROM bdconector.pais p";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) { //metodo next sirve para saber si rs esta vacio o lleno
                PaisVo pvo = new PaisVo();//la info que voy a llenar es la info delos getter y setter
                pvo.setIdPais(rs.getInt(1)); // envia el valor de la primera columna al rs
                pvo.setNombrePais(rs.getString(2));//.get extrae el valor de la columna definida
                pvo.setCapitalPais(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error[MMostrar]: " + e.getMessage());
        }
        return info;
    }

    @Override
    public boolean actualizar(PaisVo p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE pais "
                    + "SET nombre_pais = '" + p.getNombrePais()
                    + "', capital_pais = '" + p.getCapitalPais()
                    + "', poblacion_pais = " + p.getPoblacionPais()
                    + ", fecha_actualiza_pais = " + p.getFechaActPais()
                    + " WHERE id_pais = " + p.getIdPais();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MUpdate]: " + e.getMessage());
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminar(PaisVo p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM pais WHERE id_pais = "+p.getIdPais();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MDelete]: " + e.getMessage());
            return false;
        }
        c.desconectar();
        return true;
    }

}
