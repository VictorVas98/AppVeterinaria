package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.GroomistaEficiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroomistaEficienteRepository extends JpaRepository<GroomistaEficiente, Integer> {

    @Query(name = "GroomistaEficiente.findByFechas", nativeQuery = true)
    List<GroomistaEficiente> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}
