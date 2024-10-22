package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio")
public class Servicio {

    @Id
    @Column(name = "CodigoServicio")
    private int codigoServicio;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Precio")
    private double precio;

    public Servicio() {
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}