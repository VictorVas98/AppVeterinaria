package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.DetalleDiagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDiagnosticoRepository extends JpaRepository<DetalleDiagnostico, Integer> {
}
