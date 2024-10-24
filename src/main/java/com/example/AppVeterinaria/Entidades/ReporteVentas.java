package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "ReporteVentasMapping",
        classes = @ConstructorResult(
                targetClass = ReporteVentas.class,
                columns = {
                        @ColumnResult(name = "Consumo", type = String.class),
                        @ColumnResult(name = "NumeroCita", type = Integer.class),
                        @ColumnResult(name = "FechaCita", type = String.class),
                        @ColumnResult(name = "CodigoCliente", type = String.class),
                        @ColumnResult(name = "Cliente", type = String.class),
                        @ColumnResult(name = "TotalVenta", type = Double.class)
                }
        )
)
@NamedNativeQuery(
        name = "ReporteVentas.findByFechas",
        query = "EXEC ReporteVentas :FechaInicio, :FechaFin",
        resultSetMapping = "ReporteVentasMapping"
)
public class ReporteVentas {

    @Id
    private String consumo;
    private int numeroCita;
    private String fechaCita;
    private String codigoCliente;
    private String cliente;
    private double totalVenta;

    public ReporteVentas(String consumo, int numeroCita, String fechaCita, String codigoCliente, String cliente, double totalVenta) {
        this.consumo = consumo;
        this.numeroCita = numeroCita;
        this.fechaCita = fechaCita;
        this.codigoCliente = codigoCliente;
        this.cliente = cliente;
        this.totalVenta = totalVenta;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
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

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ReporteVentas() {
    }
}
