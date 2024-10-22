package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.FichaMascota;
import com.example.AppVeterinaria.Repositorios.FichaMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaMascotaService {

    @Autowired
    private FichaMascotaRepository fichaMascotaRepository;

    public List<FichaMascota> obtenerTodasLasFichas() {
        return fichaMascotaRepository.findAll();
    }

    public Optional<FichaMascota> obtenerFichaPorId(int numeroFicha) {
        return fichaMascotaRepository.findById(numeroFicha);
    }

    public FichaMascota crearFichaMascota(FichaMascota fichaMascota) {
        return fichaMascotaRepository.save(fichaMascota);
    }

    public FichaMascota actualizarFichaMascota(FichaMascota fichaMascota) {
        return fichaMascotaRepository.save(fichaMascota);
    }

    public boolean eliminarFichaMascota(int numeroFicha) {
        if (fichaMascotaRepository.existsById(numeroFicha)) {
            fichaMascotaRepository.deleteById(numeroFicha);
            return true;
        }
        return false;
    }
}
