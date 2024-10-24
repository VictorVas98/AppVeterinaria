package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.ServicioMasVendido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioMasVendidoRepository extends JpaRepository<ServicioMasVendido, Integer> {

    @Query(name = "ServicioMasVendido.findByFechas", nativeQuery = true)
    List<ServicioMasVendido> findByFechas(@Param("FechaInicio") String fechaInicio, @Param("FechaFin") String fechaFin);
}
