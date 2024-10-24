package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.ReporteVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteVentasRepository extends JpaRepository<ReporteVentas, String> {

    @Query(name = "ReporteVentas.findByFechas", nativeQuery = true)
    List<ReporteVentas> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}
