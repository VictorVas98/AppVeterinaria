package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.TelefonoPersona;
import com.example.AppVeterinaria.Repositorios.TelefonoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TelefonoPersonaService {

    @Autowired
    private TelefonoPersonaRepository telefonoPersonaRepository;

    public List<TelefonoPersona> obtenerTodosLosTelefonosPersona() {
        return telefonoPersonaRepository.findAll();
    }

    public Optional<TelefonoPersona> obtenerTelefonoPersonaPorId(int id) {
        return telefonoPersonaRepository.findById(id);
    }

    public TelefonoPersona crearTelefonoPersona(TelefonoPersona telefonoPersona) {
        return telefonoPersonaRepository.save(telefonoPersona);
    }

    public TelefonoPersona actualizarTelefonoPersona(TelefonoPersona telefonoPersona) {
        return telefonoPersonaRepository.save(telefonoPersona);
    }

    public boolean eliminarTelefonoPersona(int id) {
        if (telefonoPersonaRepository.existsById(id)) {
            telefonoPersonaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
