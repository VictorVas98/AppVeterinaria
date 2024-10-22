package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Puesto;
import com.example.AppVeterinaria.Repositorios.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;

    public List<Puesto> obtenerTodosLosPuestos() {
        return puestoRepository.findAll();
    }

    public Optional<Puesto> obtenerPuestoPorId(int id) {
        return puestoRepository.findById(id);
    }

    public Puesto crearPuesto(Puesto puesto) {
        return puestoRepository.save(puesto);
    }

    public Puesto actualizarPuesto(Puesto puesto) {
        return puestoRepository.save(puesto);
    }

    public boolean eliminarPuesto(int id) {
        if (puestoRepository.existsById(id)) {
            puestoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}