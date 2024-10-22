package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Tratamiento;
import com.example.AppVeterinaria.Repositorios.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> obtenerTodosLosTratamientos() {
        return tratamientoRepository.findAll();
    }

    public Optional<Tratamiento> obtenerTratamientoPorId(int codigoTratamiento) {
        return tratamientoRepository.findById(codigoTratamiento);
    }

    public Tratamiento crearTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Tratamiento actualizarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public boolean eliminarTratamiento(int codigoTratamiento) {
        if (tratamientoRepository.existsById(codigoTratamiento)) {
            tratamientoRepository.deleteById(codigoTratamiento);
            return true;
        }
        return false;
    }
}
