/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral.c;

/**
 *
 * @author JUAN
 */
public class Cliente {
    private String id;
    private String nombres;
    private String apellidos;
    private String fechanac;
    private String genero;
    private String gmail;
    
    public Cliente() {
    }

    public Cliente(String id, String nombres, String apellidos, String fechanac, String genero, String gmail) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanac = fechanac;
        this.genero = genero;
        this.gmail = gmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    
    
}
