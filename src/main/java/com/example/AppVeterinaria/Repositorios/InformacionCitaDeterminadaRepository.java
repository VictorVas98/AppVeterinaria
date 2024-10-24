package com.example.AppVeterinaria.Repositorios;
import com.example.AppVeterinaria.Entidades.InformacionCitaDeterminada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacionCitaDeterminadaRepository extends JpaRepository<InformacionCitaDeterminada, Integer> {

    @Query(name = "InformacionCitaDeterminada.findByNumeroCita", nativeQuery = true)
    List<InformacionCitaDeterminada> findByNumeroCita(@Param("NumeroCita") int numeroCita);

}
