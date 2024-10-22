package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "TelefonoSucursal")
public class TelefonoSucursal {

    @Id
    @Column(name = "CorrelativoTelefono")
    private int correlativoTelefono;

    @Column(name = "CodigoSucursal")
    private int codigoSucursal;

    public TelefonoSucursal() {
    }

    public int getCorrelativoTelefono() {
        return correlativoTelefono;
    }

    public void setCorrelativoTelefono(int correlativoTelefono) {
        this.correlativoTelefono = correlativoTelefono;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
}