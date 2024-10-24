package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.InformacionCitasPorFecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacionCitasPorFechaRepository extends JpaRepository<InformacionCitasPorFecha, Integer> {

    @Query(name = "InformacionCitasPorFecha.findByFechas", nativeQuery = true)
    List<InformacionCitasPorFecha> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}
