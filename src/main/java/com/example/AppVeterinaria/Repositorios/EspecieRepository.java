package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}