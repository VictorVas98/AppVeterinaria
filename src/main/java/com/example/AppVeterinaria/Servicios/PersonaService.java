package com.example.AppVeterinaria.Servicios;
import com.example.AppVeterinaria.Entidades.Persona;
import com.example.AppVeterinaria.Repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    public Persona actualizarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

@Autowired
private PersonaRepository personaRepository;

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(int id) {
        return personaRepository.findById(id);
    }

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public boolean eliminarPersona(int id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}