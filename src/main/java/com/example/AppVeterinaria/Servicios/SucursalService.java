package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Sucursal;
import com.example.AppVeterinaria.Repositorios.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> obtenerTodasLasSucursales() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> obtenerSucursalPorId(int id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal actualizarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public boolean eliminarSucursal(int id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}