package Servicio;
import Negocio.Ciudadano;
import Negocio.GestorCiudadano;
import Negocio.GestorPlan;
import Negocio.Plan;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorCentralServer implements Runnable{
    private  final GestorCiudadano gestorC;
    private final GestorPlan gestorP;
    private static ServerSocket ssock;
    private static Socket socket;

    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5000;

    /**
     * Constructor
     */
    public ServidorCentralServer() {
        gestorC = new GestorCiudadano();
        gestorP= new GestorPlan();
    }
    /**
     * Logica completa del servidor
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() {
        new Thread(new ServidorCentralServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() throws SQLException, ClassNotFoundException {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa al estilo
     * "consultarCiudadano,983932814"
     */
    private void decodificarPeticion(String peticion) throws SQLException, ClassNotFoundException {
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Segun el protocolo decide qué accion invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) throws SQLException, ClassNotFoundException {
        switch (accion) {
            case "consultarClientesServicio":
                String id = parametros[1];
                Plan pln = gestorP.buscarPlan(id);
                if(pln==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }
                int rangoEdadMenor=pln.getRangoEdadMenor();
                int rangoEdadMayor=pln.getRangoEdadMayor();
                ArrayList<Ciudadano> listaCiudadanosPotenciales = new ArrayList<Ciudadano>();
                listaCiudadanosPotenciales=gestorC.buscarCiudadanosPotenciales(rangoEdadMenor,rangoEdadMayor);
                if (listaCiudadanosPotenciales == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSONCiudadanos(listaCiudadanosPotenciales));
                }
                break;
            
            case "consultarClientes":
                ArrayList<Ciudadano> clientes;
                clientes=gestorC.buscarCiudadanos();
                if(clientes==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }else{
                    salidaDecorada.println(parseToJSONCiudadanos(clientes));                   
                }
                break;
                
            case "consultarPlanes":
                ArrayList<Plan> planes;
                planes=gestorP.buscarPlanes();
                if(planes==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }else{
                    salidaDecorada.println(parseToJSONplanes(planes));                   
                }
             
                break;
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    /**
     * Convierte el objeto Ciudadano a json
     *
     * @param ciu Objeto ciudadano
     * @return cadena json
     */
    private String parseToJSON(Ciudadano ciu) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("id", ciu.getCedula());
        jsonobj.addProperty("nombres", ciu.getNombres());
        jsonobj.addProperty("apellidos", ciu.getApellidos());
        jsonobj.addProperty("direccion", ciu.getDireccion());
        jsonobj.addProperty("celular", ciu.getCelular());
        jsonobj.addProperty("email", ciu.getEmail());
        jsonobj.addProperty("sexo", ciu.getSexo());
        jsonobj.addProperty("fechaNac", ciu.getFechaNac());
        return jsonobj.toString();
    }
    private String parseToJSON(Plan pln) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("id", pln.getIdPlan());
        jsonobj.addProperty("nombre", pln.getNombre());
        jsonobj.addProperty("descripcion", pln.getDescripcion());
        jsonobj.addProperty("rangoEdadMenor:", pln.getRangoEdadMenor());
        jsonobj.addProperty("rangoEdadMayor", pln.getRangoEdadMayor());
        jsonobj.addProperty("sexo", pln.getSexo());
        return jsonobj.toString();
    }
    
    private String parseToJSONCiudadanos(ArrayList<Ciudadano> ciudadanos) {
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        for(int i=0;i<ciudadanos.size();i++){
            gsonObj = new JsonObject();
            gsonObj.addProperty("id", ciudadanos.get(i).getCedula());
            gsonObj.addProperty("nombres", ciudadanos.get(i).getNombres());
            gsonObj.addProperty("apellidos", ciudadanos.get(i).getApellidos());
            gsonObj.addProperty("direccion", ciudadanos.get(i).getDireccion());
            gsonObj.addProperty("celular", ciudadanos.get(i).getCelular());
            gsonObj.addProperty("email", ciudadanos.get(i).getEmail());
            gsonObj.addProperty("sexo", ciudadanos.get(i).getSexo());
            gsonObj.addProperty("fechaNac", ciudadanos.get(i).getFechaNac());
            array.add(gsonObj);
        }    
        return array.toString();
    }
    
    
    private String parseToJSONplanes(ArrayList<Plan> planes) {
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        for(int i=0;i<planes.size();i++){
            gsonObj = new JsonObject();
            gsonObj.addProperty("id", planes.get(i).getIdPlan());
            gsonObj.addProperty("nombre", planes.get(i).getNombre());
            gsonObj.addProperty("descripcion", planes.get(i).getDescripcion());
            gsonObj.addProperty("rangoEdadMenor", planes.get(i).getRangoEdadMenor());
            gsonObj.addProperty("rangoEdadMayor", planes.get(i).getRangoEdadMayor());   
            gsonObj.addProperty("sexo", planes.get(i).getSexo());  
            array.add(gsonObj);
        }    
        return array.toString();
    }
    
    
}
