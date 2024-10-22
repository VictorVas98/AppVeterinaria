package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.DetalleTratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTratamientoRepository extends JpaRepository<DetalleTratamiento, Integer> {
}
