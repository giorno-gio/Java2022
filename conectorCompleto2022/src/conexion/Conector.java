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

    //declaracion de variables que se utilizaran en la conexion
    private String driver = "com.mysql.jdbc.Driver"; // hace referencia a la clase driver ayuda a hacer conexiones
    private String host = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String db = "bdconector";
    private String cadena;

    //Declaracion de objetos pa la conexion
    Connection conection;
    Statement statement;

    //Declaracion de metodos para la conexion 
    //metodo conectar
    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.db;

        try {
            Class.forName(this.driver).newInstance(); //hace que se active el paquete mysql para usar la clase driver
            this.conection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MCon]: " + e.getMessage());
        }

    }

    public void desconectar() {
        try {
            this.conection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes]: " + e.getMessage());
        }
    }

    //metodo para realizar los querys INSERT,UPDATE, DELETE 
    public int consultasMultiples(String query) {
        int resultado;
        try {
            this.conectar();
            this.statement = this.conection.createStatement();//permite crear un query insert update delete
            resultado = this.statement.executeUpdate(query);
            
        } catch (Exception e) {
            System.err.println("Error[MCM]: " + e.getMessage());
            return 0;
        }
        return resultado;
    }
    //metodo para realizar consultas select
    public ResultSet consultaDatos(String consulta){
    //Resulset encargado de capturar todos los datos de la bd y permite manipular
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.conection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error[CD]: " + e.getMessage());
        }
         return null;
    }
}
