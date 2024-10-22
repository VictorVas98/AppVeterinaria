package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Tratamiento")
public class Tratamiento {

    @Id
    @Column(name = "CodigoTratamiento")
    private int codigoTratamiento;

    @Column(name = "Descripcion")
    private String descripcion;

    public Tratamiento() {
    }

    public int getCodigoTratamiento() {
        return codigoTratamiento;
    }

    public void setCodigoTratamiento(int codigoTratamiento) {
        this.codigoTratamiento = codigoTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
