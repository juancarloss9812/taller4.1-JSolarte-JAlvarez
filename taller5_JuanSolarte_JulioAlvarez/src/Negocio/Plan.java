/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author JUAN
 */
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
    public Plan(String idPlan,String nombre,String descripcion,int rangoEdadMenor,int rangoEdadMayor,String sexocliente){
        this.sexo=sexocliente;
        this.id=idPlan;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.rangoEdadMenor=rangoEdadMenor;
        this.rangoEdadMayor=rangoEdadMayor;
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
