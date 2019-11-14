package main;

import Negocio.GestorClientesPotenciales;
import Presentacion.GUIClientesPotenciales;
import Presentacion.GUIClientesPotencialesController;
import java.sql.SQLException;

public class RunMVC {
    public RunMVC() throws ClassNotFoundException, SQLException{
        GestorClientesPotenciales myGestor= new GestorClientesPotenciales();
        GUIClientesPotenciales myViewClientesP=new GUIClientesPotenciales();
        myGestor.addView(myViewClientesP);
        GUIClientesPotencialesController myControllerP = new GUIClientesPotencialesController(myGestor,myViewClientesP);
        
        myViewClientesP.getBtnBuscarClientesP().addActionListener(myControllerP);
        myControllerP.actualizarPlanes();
        myViewClientesP.setVisible(true);
        
        
        
    }
    
}
