package Negocio;

import Servicio.ServidorCentralServer;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorPlan {
        private ConectorJdbc conector;
    public GestorPlan() {
        conector=new ConectorJdbc();
        inicializar();
    }
    public void inicializar(){
         
    }
     public Plan buscarPlan(String id) throws ClassNotFoundException, SQLException{

         conector.conectarse(); 
         conector.crearConsulta("select * from plan where id="+id+";");
         Plan pln=null;
         if (conector.getResultado().next()) {
             pln=new Plan(conector.getResultado().getString("id"), conector.getResultado().getString("nombre"), conector.getResultado().getString("descripcion"), Integer.parseInt(conector.getResultado().getString("rangoedadmenor")), Integer.parseInt(conector.getResultado().getString("rangoedadmayor")),conector.getResultado().getString("sexo"));
         }
        return pln;
     }
     
     public ArrayList<Plan> buscarPlanes() throws ClassNotFoundException, SQLException{
         ArrayList<Plan> planes = new ArrayList<Plan>();
         conector.conectarse();
         conector.crearConsulta("select * from plan;");
         while (conector.getResultado().next()) {   
            Plan pln=new Plan(conector.getResultado().getString("id"), conector.getResultado().getString("nombre"), conector.getResultado().getString("descripcion"), Integer.parseInt(conector.getResultado().getString("rangoedadmenor")), Integer.parseInt(conector.getResultado().getString("rangoedadmayor")),conector.getResultado().getString("sexo"));
            planes.add(pln);
        }
        return planes;
         
     }
         
     
}
