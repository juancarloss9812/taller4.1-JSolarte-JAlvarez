 package Negocio;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorCiudadano {
     private ConectorJdbc conector;

    public GestorCiudadano() {
        conector = new ConectorJdbc();
        inicializar();
    }

    public void inicializar() {
        
    }

    public ArrayList<Ciudadano> buscarCiudadanos() throws SQLException, ClassNotFoundException{
        ArrayList<Ciudadano> listaCiudadanosPotenciales = new ArrayList<Ciudadano>();
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM cliente;");
        while (conector.getResultado().next()) {
            Ciudadano ciu = new Ciudadano(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("direccion"), conector.getResultado().getString("celular"), conector.getResultado().getString("email"), conector.getResultado().getString("sexo"),conector.getResultado().getString("fechaNac"));
            listaCiudadanosPotenciales.add(ciu);
        }
        return listaCiudadanosPotenciales;   
    }
    public ArrayList<Ciudadano> buscarCiudadanosPotenciales(int rangoEdadMenor,int rangoEdadMayor) throws SQLException, ClassNotFoundException{
        ArrayList<Ciudadano> listaCiudadanosPotenciales = new ArrayList<Ciudadano>();
        Calendar f_actual = Calendar.getInstance();
        String fechamenor=((f_actual.get(Calendar.YEAR))-rangoEdadMenor)+"-";
        String fechamayor=((f_actual.get(Calendar.YEAR))-rangoEdadMayor)+"-";
        if(f_actual.get(Calendar.MONTH)<10){
            fechamenor=fechamenor+"0"+(f_actual.get(Calendar.MONTH))+"-";
            fechamayor=fechamayor+"0"+(f_actual.get(Calendar.MONTH))+"-";
        }else{
            fechamenor=fechamenor+(f_actual.get(Calendar.MONTH))+"-";
            fechamayor=fechamayor+(f_actual.get(Calendar.MONTH))+"-";            
        }
        if(f_actual.get(Calendar.DATE)<10){
            fechamenor=fechamenor+"0"+f_actual.get(Calendar.DATE);
            fechamayor=fechamayor+"0"+f_actual.get(Calendar.DATE);
        }else{
            fechamenor=fechamenor+f_actual.get(Calendar.DATE);
            fechamayor=fechamayor+f_actual.get(Calendar.DATE);
            
        }
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM cliente WHERE fechanac <= CAST('"+fechamenor+"' AS datetime) and fechanac >=CAST('"+fechamayor+"' AS datetime);");
        while (conector.getResultado().next()) {
            
            Ciudadano ciu = new Ciudadano(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("direccion"), conector.getResultado().getString("celular"), conector.getResultado().getString("email"), conector.getResultado().getString("sexo"),conector.getResultado().getString("fechaNac"));
            listaCiudadanosPotenciales.add(ciu);
        }
        
        return listaCiudadanosPotenciales;
    }

    
}
