package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "CantidadCitasVeterinarioMapping",
        classes = @ConstructorResult(
                targetClass = CantidadCitasVeterinario.class,
                columns = {
                        @ColumnResult(name = "CantidadCitas", type = Integer.class),
                        @ColumnResult(name = "CodigoEmpleado", type = Integer.class),
                        @ColumnResult(name = "CodigoPersona", type = Integer.class),
                        @ColumnResult(name = "Nombre", type = String.class)
                }
        )
)
@NamedNativeQuery(
        name = "CantidadCitasVeterinario.findByFechas",
        query = "EXEC CantidadCitasVeterinario :FechaInicio, :FechaFin",
        resultSetMapping = "CantidadCitasVeterinarioMapping"
)
public class CantidadCitasVeterinario {

    @Id
    private int codigoEmpleado;  // Este puede ser un campo único o puede ser un ID adicional.
    private int cantidadCitas;
    private int codigoPersona;
    private String nombre;

    public CantidadCitasVeterinario(int cantidadCitas, int codigoEmpleado, int codigoPersona, String nombre) {
        this.cantidadCitas = cantidadCitas;
        this.codigoEmpleado = codigoEmpleado;
        this.codigoPersona = codigoPersona;
        this.nombre = nombre;
    }

    public int getCantidadCitas() {
        return cantidadCitas;
    }

    public void setCantidadCitas(int cantidadCitas) {
        this.cantidadCitas = cantidadCitas;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CantidadCitasVeterinario() {
    }
}
