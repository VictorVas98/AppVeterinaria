package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
}

