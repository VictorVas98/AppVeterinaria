package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefono")
public class Telefono {

    @Id
    @Column(name = "CorrelativoTelefono")
    private int correlativoTelefono;

    @Column(name = "NumeroTelefono")
    private String numeroTelefono;

    public Telefono() {
    }

    public int getCorrelativoTelefono() {
        return correlativoTelefono;
    }

    public void setCorrelativoTelefono(int correlativoTelefono) {
        this.correlativoTelefono = correlativoTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}