package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Cita;
import com.example.AppVeterinaria.Entidades.CitaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, CitaId> {

}
