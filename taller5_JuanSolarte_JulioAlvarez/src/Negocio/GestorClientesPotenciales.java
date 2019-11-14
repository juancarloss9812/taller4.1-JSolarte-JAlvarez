package Negocio;

import Acceso.IServidorCentral;
import Acceso.ServicioServidorCentralSocket;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import mvcf.AModel;

public class GestorClientesPotenciales extends AModel{
    private Cliente[] clientes;
    private Plan[] planes;
    private final IServidorCentral sc;
    private ConectorJdbc conector;
    public GestorClientesPotenciales() throws ClassNotFoundException, SQLException{
        sc= new ServicioServidorCentralSocket();
        conector= new ConectorJdbc();
        inicializar();
    }
    public Cliente[] ConsultarClientesServicio(String id) throws ClassNotFoundException, SQLException{
        Cliente[] myclientes= new Gson().fromJson(sc.consultarClientesServicio(id), Cliente[].class);
        return myclientes;
    }
    public Plan[] ConsultarPlanesServicio(){
        Plan[] myplanes= new Gson().fromJson(sc.consultarPlanesServicio(), Plan[].class);
        return myplanes;
    }
    
    public void actualizarClientesPotenciales(String id) throws ClassNotFoundException, SQLException{
        clientes=ConsultarClientesServicio(id);
        this.notificar();
    }
    
    public void actualizarPlanes() throws ClassNotFoundException, SQLException{
        planes=ConsultarPlanesServicio();
    }
    
    public String buscarPlanPorNombre(String nombre){
    //Esta funcion retorna el id de un plan, ingresando el nombre
        String id=null;
            for(int i=0;i<planes.length;i++){
                if(nombre.equals(planes[i].getNombre())){            
                    return (planes[i].getIdPlan());
                }
            }
        System.out.println("        Nombre del plan no existe");
        return id;
    }
    public ArrayList<String> listaNombrePlanes(){
        ArrayList<String> listaNombre= new ArrayList<>();
        for(int i=0;i<planes.length;i++){
           listaNombre.add(planes[i].getNombre());
        }
        
        return listaNombre;      
        
    }

    private void inicializar() throws ClassNotFoundException, SQLException {
        //planes=ConsultarPlanesServicio();
        //clientes=ConsultarClientesServicio();
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Plan[] getPlanes() {
        return planes;
    }

    public void setPlanes(Plan[] planes) {
        this.planes = planes;
    }
    
    
}
