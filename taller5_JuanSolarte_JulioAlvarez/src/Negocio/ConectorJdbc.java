/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JUAN
 */
public class ConectorJdbc {
    private Connection cn;
    private ResultSet rs;
    private Statement st;
    private final String URL = "jdbc:hsqldb:file:D:\\Ingenieria de Sistemas\\VI SEMESTRE\\Laboratorio Ingenieria de Softeare II\\taller 4.1\\ServidorCentral\\db\\bd;hsqldb.lock_file=false";
    String USER="sa";
    String PASSWORD= "1234";
    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver"); 
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Base de datos conectada");
    }

}
