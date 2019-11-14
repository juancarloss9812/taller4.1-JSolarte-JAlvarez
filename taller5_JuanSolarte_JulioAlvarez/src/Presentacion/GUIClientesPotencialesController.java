
package Presentacion;

import Negocio.Cliente;
import Negocio.GestorClientesPotenciales;
import Negocio.Plan;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

public class GUIClientesPotencialesController extends AActionController {
    private final GestorClientesPotenciales gestor; // Modelo
    private final GUIClientesPotenciales vista; //Vista
    public GUIClientesPotencialesController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorClientesPotenciales) myModel;
        this.vista = (GUIClientesPotenciales) myView;
    }

    public void actualizarPlanes() throws ClassNotFoundException, SQLException{
        gestor.actualizarPlanes();
        vista.llenarCbx( gestor.listaNombrePlanes());
                
    }

    @Override
    public void actualizar(ActionEvent e) {
     
        vista.limpiarTabla();
        String id=gestor.buscarPlanPorNombre(vista.getPlanEscogido());
        if(id==null){
            System.out.println("    No se puede realizar la consulta, idPlan es nulo");
        }
        try { 
            gestor.actualizarClientesPotenciales(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIClientesPotencialesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUIClientesPotencialesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
