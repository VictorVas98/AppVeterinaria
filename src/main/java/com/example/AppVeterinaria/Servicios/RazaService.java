package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Raza;
import com.example.AppVeterinaria.Repositorios.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazaService {

    @Autowired
    private RazaRepository razaRepository;

    public List<Raza> obtenerTodasLasRazas() {
        return razaRepository.findAll();
    }

    public Optional<Raza> obtenerRazaPorId(int codigoRaza) {
        return razaRepository.findById(codigoRaza);
    }

    public Raza crearRaza(Raza raza) {
        return razaRepository.save(raza);
    }

    public Raza actualizarRaza(Raza raza) {
        return razaRepository.save(raza);
    }

    public boolean eliminarRaza(int codigoRaza) {
        if (razaRepository.existsById(codigoRaza)) {
            razaRepository.deleteById(codigoRaza);
            return true;
        }
        return false;
    }
}
