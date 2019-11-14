package servidorcentral.servicio;
import com.google.gson.Gson;
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
//import servidorcentral.negocio.Cliente;
import servidorcentral.negocio.GestorClientes;
import servidorcentral.servicio.planTuristico;


public class CentralServer implements Runnable {
    private static ServerSocket ssock;
    private static Socket socket;
    private final GestorClientes gestor;
    
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5001;

    /**
     * Constructor
     */
    public CentralServer() {
        gestor = new GestorClientes();
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
        new Thread(new CentralServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(CentralServer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CentralServer.class.getName()).log(Level.SEVERE, null, ex);
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
    private void leerFlujos() {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            //decodificarPeticion(peticion);
        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
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
     * Decodifica la petición, extrayendo la acción y los parámetros
     * @param peticion petición completa al estilo
     * "accion, informacion"
     */
/*
    private void decodificarPeticion(String peticion) throws ClassNotFoundException, SQLException
    {
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[15];
        
        int i=0;
        while(tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);
    }
*/  
private planTuristico[] deserializarPlanes(String arrayJsonSerializado) {
        planTuristico[] planes = new Gson().fromJson(arrayJsonSerializado, planTuristico[].class
    );
        return planes;
    }
    private String serializarPlanes(ArrayList<planTuristico> listado) {
 JsonArray array = new JsonArray();
 JsonObject gsonObj;
 for (planTuristico plan : listado) {
    gsonObj = new JsonObject();
    gsonObj.addProperty("id", plan.getId());
    gsonObj.addProperty("nombre", plan.getNombre());
    gsonObj.addProperty("descripcion", plan.getDescripcion());
    gsonObj.addProperty("rangoEdad1", "" + plan.getRangoEdad1());
    gsonObj.addProperty("rangoEdad2", "" + plan.getRangoEdad2());
    gsonObj.addProperty("genero", "" + plan.getGenero());
    array.add(gsonObj);
 }
 //System.out.println("Planes json serializado: " + array.toString());
 return array.toString();
 }
}







