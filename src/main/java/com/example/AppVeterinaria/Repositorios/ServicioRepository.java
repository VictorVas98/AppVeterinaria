package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> { }
