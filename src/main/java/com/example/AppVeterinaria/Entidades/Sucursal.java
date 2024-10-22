package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Sucursal")
public class Sucursal {

    @Id
    @Column(name = "CodigoSucursal")
    private int codigoSucursal;

    @Column(name = "NombreSucursal")
    private String nombreSucursal;

    @Column(name = "Direccion")
    private String direccion;

    public Sucursal() {
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
