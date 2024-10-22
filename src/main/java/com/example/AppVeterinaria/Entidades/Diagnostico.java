package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico {

    @Id
    @Column(name = "CodigoDiagnostico")
    private int codigoDiagnostico;

    @Column(name = "Descripcion")
    private String descripcion;

    public Diagnostico() {
    }

    public int getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(int codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
