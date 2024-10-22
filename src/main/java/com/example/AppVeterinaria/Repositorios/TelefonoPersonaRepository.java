package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.TelefonoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoPersonaRepository extends JpaRepository<TelefonoPersona, Integer> {
}