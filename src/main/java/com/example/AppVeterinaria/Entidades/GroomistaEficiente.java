package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "GroomistaEficienteMapping",
        classes = @ConstructorResult(
                targetClass = GroomistaEficiente.class,
                columns = {
                        @ColumnResult(name = "CodigoEmpleado", type = Integer.class),
                        @ColumnResult(name = "Descripcion", type = String.class),
                        @ColumnResult(name = "Nombre", type = String.class),
                        @ColumnResult(name = "TiempoTotalEnMinutos", type = Integer.class)
                }
        )
)
@NamedNativeQuery(
        name = "GroomistaEficiente.findByFechas",
        query = "EXEC GroomistaEficiente :FechaInicio, :FechaFin",
        resultSetMapping = "GroomistaEficienteMapping"
)
public class GroomistaEficiente {

    @Id
    private int codigoEmpleado;  // Este puede ser un campo único o puede ser un ID adicional.
    private String descripcion;
    private String nombre;
    private int tiempoTotalEnMinutos;

    public GroomistaEficiente(int codigoEmpleado, String descripcion, String nombre, int tiempoTotalEnMinutos) {
        this.codigoEmpleado = codigoEmpleado;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tiempoTotalEnMinutos = tiempoTotalEnMinutos;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoTotalEnMinutos() {
        return tiempoTotalEnMinutos;
    }

    public void setTiempoTotalEnMinutos(int tiempoTotalEnMinutos) {
        this.tiempoTotalEnMinutos = tiempoTotalEnMinutos;
    }

    public GroomistaEficiente() {
    }
}