package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {

}