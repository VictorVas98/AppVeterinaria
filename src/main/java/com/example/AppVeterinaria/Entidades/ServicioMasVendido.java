package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "ServicioMasVendidoMapping",
        classes = @ConstructorResult(
                targetClass = ServicioMasVendido.class,
                columns = {
                        @ColumnResult(name = "Consumo", type = String.class),
                        @ColumnResult(name = "VecesVendido", type = Integer.class),
                        @ColumnResult(name = "TotalVenta", type = Float.class)
                }
        )
)
@NamedNativeQuery(
        name = "ServicioMasVendido.findByFechas",
        query = "EXEC ServicioMasVendido :FechaInicio, :FechaFin",
        resultSetMapping = "ServicioMasVendidoMapping"
)
public class ServicioMasVendido {

    @Id
    private String consumo;
    private int vecesVendido;
    private float totalVenta;

    public ServicioMasVendido(String consumo, int vecesVendido, float totalVenta) {
        this.consumo = consumo;
        this.vecesVendido = vecesVendido;
        this.totalVenta = totalVenta;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public int getVecesVendido() {
        return vecesVendido;
    }

    public void setVecesVendido(int vecesVendido) {
        this.vecesVendido = vecesVendido;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ServicioMasVendido() {
    }
}
