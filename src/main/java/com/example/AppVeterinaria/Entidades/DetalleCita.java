package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleCita")
public class DetalleCita {

    @Id
    @Column(name = "Correlativo")
    private int correlativo;

    @Column(name = "NumeroCita")
    private int numeroCita;

    @Column(name = "NumeroFicha")
    private int numeroFicha;

    @Column(name = "CodigoServicio")
    private int codigoServicio;

    @Column(name = "Inicio")
    private String inicio; // Puedes cambiar a LocalDateTime si prefieres

    @Column(name = "Fin")
    private String fin; // También puedes cambiar a LocalDateTime si prefieres

    @Column(name = "CodigoEmpleado")
    private int codigoEmpleado;

    @Column(name = "CodigoSucursal")
    private int codigoSucursal;

    public DetalleCita() {
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

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
}
