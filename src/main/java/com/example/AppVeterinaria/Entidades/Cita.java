package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@IdClass(CitaId.class) // Indica que se está utilizando una clave primaria compuesta
@Table(name = "Cita")
public class Cita {

    @Id
    @Column(name = "CodigoSucursal")
    private int codigoSucursal;

    @Id
    @Column(name = "NumeroCita")
    private int numeroCita;

    @Column(name = "FechaCita")
    private Date fechaCita;

    @Column(name = "Observaciones")
    private String observaciones;

    @Column(name = "CodigoEmpleado")
    private int codigoEmpleado;

    @Column(name = "TipoCita")
    private String tipoCita;

    @Column(name = "CodigoCliente")
    private String codigoCliente;

    public Cita() {
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

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}