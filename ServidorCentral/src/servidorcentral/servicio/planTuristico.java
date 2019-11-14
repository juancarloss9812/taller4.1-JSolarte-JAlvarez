package servidorcentral.servicio;

/**
 *
 * @author JUAN
 */
public class planTuristico {
        private String id;
    private String nombre;
    private String descripcion;
    private String rangoEdad1;
    private String rangoEdad2;
    private String genero;

    /**
     * Constructor parametrizado
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param rangoEdad1
     * @param rangoEdad2
     * @param genero
     */
    public planTuristico(String id, String nombre, String descripcion, String rangoEdad1, String rangoEdad2, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rangoEdad1 = rangoEdad1;
        this.rangoEdad2 = rangoEdad2;
        this.genero = genero;
        
    }

    public planTuristico() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRangoEdad1() {
        return rangoEdad1;
    }

    public void setRangoEdad1(String rangoEdad1) {
        this.rangoEdad1 = rangoEdad1;
    }

    public String getRangoEdad2() {
        return rangoEdad2;
    }

    public void setRangoEdad2(String rangoEdad2) {
        this.rangoEdad2 = rangoEdad2;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
  
    
    
    
}
