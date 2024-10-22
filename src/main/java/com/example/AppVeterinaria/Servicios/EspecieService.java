package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Especie;
import com.example.AppVeterinaria.Repositorios.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    public List<Especie> obtenerTodasLasEspecies() {
        return especieRepository.findAll();
    }

    public Optional<Especie> obtenerEspeciePorId(int codigoEspecie) {
        return especieRepository.findById(codigoEspecie);
    }

    public Especie crearEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    public Especie actualizarEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    public boolean eliminarEspecie(int codigoEspecie) {
        if (especieRepository.existsById(codigoEspecie)) {
            especieRepository.deleteById(codigoEspecie);
            return true;
        }
        return false;
    }
}
