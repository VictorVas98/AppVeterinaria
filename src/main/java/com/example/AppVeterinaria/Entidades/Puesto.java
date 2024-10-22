package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Puesto")
public class Puesto {

    @Id
    @Column(name = "CodigoPuesto")
    private int codigoPuesto;

    @Column(name = "Descripcion")
    private String descripcion;

    public Puesto() {
    }

    public int getCodigoPuesto() {
        return codigoPuesto;
    }

    public void setCodigoPuesto(int codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}