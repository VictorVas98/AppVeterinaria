package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Telefono;
import com.example.AppVeterinaria.Repositorios.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    public List<Telefono> obtenerTodosLosTelefonos() {
        return telefonoRepository.findAll();
    }

    public Optional<Telefono> obtenerTelefonoPorId(int id) {
        return telefonoRepository.findById(id);
    }

    public Telefono crearTelefono(Telefono telefono) {
        return telefonoRepository.save(telefono);
    }

    public Telefono actualizarTelefono(Telefono telefono) {
        return telefonoRepository.save(telefono);
    }

    public boolean eliminarTelefono(int id) {
        if (telefonoRepository.existsById(id)) {
            telefonoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}