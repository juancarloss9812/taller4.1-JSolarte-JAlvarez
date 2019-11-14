/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral.servicio;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author carlangas
 */
public class GestorUsuariosBD {
    private final conectorJDBC conector;
    public GestorUsuariosBD(){
        conector = new conectorJDBC();
    }
    public planTuristico IniciarSesion(String prmUsuario) throws ClassNotFoundException, SQLException{
        conector.conectarse();
        conector.crearConsulta("select * from planturistico where id='"+prmUsuario +"'");
        planTuristico plan = null;
        if (conector.getResultado().next()) {      
            //plan = new planTuristico (conector.getResultado(),conector.getResultado().getString("vignombres"),conector.getResultado().getString("vigapellidos"),conector.getResultado().getString("viggenero"),conector.getResultado().getString("vigfechanac"),conector.getResultado().getString("vigempresa"),conector.getResultado().getString("vigusuario"),conector.getResultado().getString("vigcontrasenia"));
        }
        conector.desconectarse();
        return plan;
    }
   
}
