package Negocio;
public class Plan {
    private String id;
    private String nombre; 
    private String descripcion;
    private int rangoEdadMenor;
    private int rangoEdadMayor; 
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Plan(){
        
    }
    public Plan(String id,String nombre,String descripcion,int rangoEdadMenor,int rangoEdadMayor,String sexo){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.rangoEdadMenor=rangoEdadMenor;
        this.rangoEdadMayor=rangoEdadMayor;
        this.sexo=sexo;
    }    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdPlan() {
        return id;
    }

    public void setIdPlan(String idPlan) {
        this.id = idPlan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRangoEdadMenor() {
        return rangoEdadMenor;
    }

    public void setRangoEdadMenor(int rangoEdadMenor) {
        this.rangoEdadMenor = rangoEdadMenor;
    }

    public int getRangoEdadMayor() {
        return rangoEdadMayor;
    }

    public void setRangoEdadMayor(int rangoEdadMayor) {
        this.rangoEdadMayor = rangoEdadMayor;
    }
}
