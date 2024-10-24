package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "InformacionCitasPorFechaMapping",
        classes = @ConstructorResult(
                targetClass = InformacionCitasPorFecha.class,
                columns = {
                        @ColumnResult(name = "NumeroCita", type = Integer.class),
                        @ColumnResult(name = "FechaCita", type = String.class),
                        @ColumnResult(name = "Observaciones", type = String.class),
                        @ColumnResult(name = "TipoCita", type = String.class),
                        @ColumnResult(name = "CodigoEmpleado", type = Integer.class),
                        @ColumnResult(name = "Nombre_Empleado", type = String.class),
                        @ColumnResult(name = "CodigoCliente", type = String.class),
                        @ColumnResult(name = "Nombre_Cliente", type = String.class),
                        @ColumnResult(name = "Nombre_Mascota", type = String.class),
                        @ColumnResult(name = "FechaNacimiento", type = String.class),
                        @ColumnResult(name = "Servicio", type = String.class)
                }
        )
)
@NamedNativeQuery(
        name = "InformacionCitasPorFecha.findByFechas",
        query = "EXEC InformacionCitasPorFecha :FechaInicio, :FechaFin",
        resultSetMapping = "InformacionCitasPorFechaMapping"
)
public class InformacionCitasPorFecha {

    @Id
    private int numeroCita;
    private String fechaCita;
    private String observaciones;
    private String tipoCita;
    private int codigoEmpleado;
    private String nombreEmpleado;
    private String codigoCliente;
    private String nombreCliente;
    private String nombreMascota;
    private String fechaNacimiento;
    private String servicio;

    public InformacionCitasPorFecha(int numeroCita, String fechaCita, String observaciones, String tipoCita, int codigoEmpleado, String nombreEmpleado, String codigoCliente, String nombreCliente, String nombreMascota, String fechaNacimiento, String servicio) {
        this.numeroCita = numeroCita;
        this.fechaCita = fechaCita;
        this.observaciones = observaciones;
        this.tipoCita = tipoCita;
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreMascota = nombreMascota;
        this.fechaNacimiento = fechaNacimiento;
        this.servicio = servicio;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public InformacionCitasPorFecha() {
    }
}
