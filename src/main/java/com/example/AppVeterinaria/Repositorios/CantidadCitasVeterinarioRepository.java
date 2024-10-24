package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.CantidadCitasVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantidadCitasVeterinarioRepository extends JpaRepository<CantidadCitasVeterinario, Integer> {

    @Query(name = "CantidadCitasVeterinario.findByFechas", nativeQuery = true)
    List<CantidadCitasVeterinario> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}
