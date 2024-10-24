package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.EmpleadoTrabajaMenos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoTrabajaMenosRepository extends JpaRepository<EmpleadoTrabajaMenos, Integer> {

    @Query(name = "EmpleadoTrabajaMenos.findByFechas", nativeQuery = true)
    List<EmpleadoTrabajaMenos> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}

