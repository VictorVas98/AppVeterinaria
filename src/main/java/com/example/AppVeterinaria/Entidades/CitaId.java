package com.example.AppVeterinaria.Entidades;

import java.io.Serializable;
import java.util.Objects;

public class CitaId implements Serializable {
    private int codigoSucursal;
    private int numeroCita;

    public CitaId() {
    }

    public CitaId(int codigoSucursal, int numeroCita) {
        this.codigoSucursal = codigoSucursal;
        this.numeroCita = numeroCita;
    }

    // Getters y Setters
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitaId)) return false;
        CitaId citaId = (CitaId) o;
        return codigoSucursal == citaId.codigoSucursal && numeroCita == citaId.numeroCita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoSucursal, numeroCita);
    }
}
