package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.DetalleCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCitaRepository extends JpaRepository<DetalleCita, Integer> { }
