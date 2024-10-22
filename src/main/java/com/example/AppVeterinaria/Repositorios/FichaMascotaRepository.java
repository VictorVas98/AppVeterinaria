package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.FichaMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaMascotaRepository extends JpaRepository<FichaMascota, Integer> { }