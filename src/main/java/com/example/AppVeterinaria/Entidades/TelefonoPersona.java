package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "TelefonoPersona")
public class TelefonoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CorrelativoTelefono")
    private int correlativoTelefono;

    @Column(name = "CodigoPersona")
    private int codigoPersona;

    public TelefonoPersona() {
    }

    public int getCorrelativoTelefono() {
        return correlativoTelefono;
    }

    public void setCorrelativoTelefono(int correlativoTelefono) {
        this.correlativoTelefono = correlativoTelefono;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
}