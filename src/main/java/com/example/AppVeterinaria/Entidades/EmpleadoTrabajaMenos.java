package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "EmpleadoTrabajaMenosMapping",
        classes = @ConstructorResult(
                targetClass = EmpleadoTrabajaMenos.class,
                columns = {
                        @ColumnResult(name = "CodigoEmpleado", type = Integer.class),
                        @ColumnResult(name = "Empleado", type = String.class),
                        @ColumnResult(name = "CitasAtendidas", type = Integer.class)
                }
        )
)
@NamedNativeQuery(
        name = "EmpleadoTrabajaMenos.findByFechas",
        query = "EXEC EmpleadoTrabajaMenos :FechaInicio, :FechaFin",
        resultSetMapping = "EmpleadoTrabajaMenosMapping"
)
public class EmpleadoTrabajaMenos {

    @Id
    private int codigoEmpleado;
    private String empleado;
    private int citasAtendidas;

    public EmpleadoTrabajaMenos(int codigoEmpleado, String empleado, int citasAtendidas) {
        this.codigoEmpleado = codigoEmpleado;
        this.empleado = empleado;
        this.citasAtendidas = citasAtendidas;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getCitasAtendidas() {
        return citasAtendidas;
    }

    public void setCitasAtendidas(int citasAtendidas) {
        this.citasAtendidas = citasAtendidas;
    }

    public EmpleadoTrabajaMenos() {
    }
}
