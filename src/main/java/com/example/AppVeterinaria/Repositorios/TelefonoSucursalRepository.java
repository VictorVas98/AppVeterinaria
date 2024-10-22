package com.example.AppVeterinaria.Repositorios;

import com.example.AppVeterinaria.Entidades.TelefonoSucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoSucursalRepository extends JpaRepository<TelefonoSucursal, Integer> {
}