/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Date;

public class Ciudadano {
    
    private String cedula;
    private String nom;
    private String ape;
    private String direccion;
    private String celular;
    private String email;
    private String sexo;
    private String fechaNac;

    public Ciudadano(String cedula, String nombres, String apellidos, String direccion, String celular, String email, String sexo, String fecNac) {
        this.cedula = cedula;
        this.nom = nombres;
        this.ape = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.fechaNac = fecNac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String id) {
        this.cedula = id;
    }

    public String getNombres() {
        return nom;
    }

    public void setNombres(String nombres) {
        this.nom = nombres;
    }

    public String getApellidos() {
        return ape;
    }

    public void setApellidos(String apellidos) {
        this.ape = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String edad) {
        this.fechaNac = edad;
    }

}
