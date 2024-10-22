package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {
}