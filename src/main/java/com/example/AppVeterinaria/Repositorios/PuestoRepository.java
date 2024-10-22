package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Integer> {
}