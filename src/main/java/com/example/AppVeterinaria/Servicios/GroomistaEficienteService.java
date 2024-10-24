package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.GroomistaEficiente;
import com.example.AppVeterinaria.Repositorios.GroomistaEficienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroomistaEficienteService {

    @Autowired
    private GroomistaEficienteRepository groomistaEficienteRepository;

    public List<GroomistaEficiente> obtenerGroomistaEficiente(String fechaInicio, String fechaFin) {
        return groomistaEficienteRepository.findByFechas(fechaInicio, fechaFin);
    }
}
