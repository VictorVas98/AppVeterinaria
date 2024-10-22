package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Especie")
public class Especie {

    @Id
    @Column(name = "CodigoEspecie")
    private int codigoEspecie;

    @Column(name = "Descripcion")
    private String descripcion;

    public Especie() {
    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
