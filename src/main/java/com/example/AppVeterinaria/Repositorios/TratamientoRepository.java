package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer> {
}
