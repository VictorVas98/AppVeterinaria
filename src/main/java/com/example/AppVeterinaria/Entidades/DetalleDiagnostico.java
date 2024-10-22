package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleDiagnostico")
public class DetalleDiagnostico {

    @Id
    @Column(name = "Correlativo")
    private int correlativo;

    @Column(name = "NumeroCita")
    private int numeroCita;

    @Column(name = "NumeroFicha")
    private int numeroFicha;

    @Column(name = "CodigoDiagnostico")
    private int codigoDiagnostico;

    @Column(name = "CodigoSucursal")
    private int codigoSucursal;

    public DetalleDiagnostico() {
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public int getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(int codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
}
