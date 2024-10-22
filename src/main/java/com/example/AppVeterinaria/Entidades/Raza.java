package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Raza")
public class Raza {

    @Id
    @Column(name = "CodigoRaza")
    private int codigoRaza;

    @Column(name = "Descripcion")
    private String descripcion;

    public Raza() {
    }

    public int getCodigoRaza() {
        return codigoRaza;
    }

    public void setCodigoRaza(int codigoRaza) {
        this.codigoRaza = codigoRaza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}