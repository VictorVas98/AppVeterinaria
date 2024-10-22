package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Cita;
import com.example.AppVeterinaria.Entidades.CitaId;
import com.example.AppVeterinaria.Repositorios.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerCitaPorId(CitaId id) {
        return citaRepository.findById(id);
    }

    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public boolean eliminarCita(CitaId id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
