/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class Conector {

    private String driver = "com.mysql.jdbc.Driver";
    private String host = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String db = "bdlibreria";
    private String cadena;

    Connection connection;
    Statement statement;

    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.db;
        try {
            Class.forName(this.driver).newInstance(); //investigar esto xD
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MCon]: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes]: " + e.getMessage());
        }
    }

    public int consultasMultiples(String query) {
       int resultado;
        try {
            this.conectar();
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.err.println("Error[MCM]: " + e.getMessage());
            return 0;
        }
        return resultado;
    }

    public ResultSet consultaDatos(String query) {
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(query);
            return resultado;
        } catch (Exception e) {
             System.err.println("Error[MCD]: " + e.getMessage());
        }
        return null;
    }

}
