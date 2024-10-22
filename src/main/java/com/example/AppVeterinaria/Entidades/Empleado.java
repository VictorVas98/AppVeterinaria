package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @Column(name = "CodigoEmpleado")
    private int codigoEmpleado;

    @Column(name = "CodigoPersona")
    private int codigoPersona;

    @Column(name = "CodigoPuesto")
    private int codigoPuesto;

    public Empleado() {
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public int getCodigoPuesto() {
        return codigoPuesto;
    }

    public void setCodigoPuesto(int codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }
}