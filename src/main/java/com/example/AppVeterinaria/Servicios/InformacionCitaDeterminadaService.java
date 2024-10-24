package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.InformacionCitaDeterminada;
import com.example.AppVeterinaria.Repositorios.InformacionCitaDeterminadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionCitaDeterminadaService {

    @Autowired
    private InformacionCitaDeterminadaRepository informacionCitaDeterminadaRepository;

    public List<InformacionCitaDeterminada> obtenerInformacionCita(int numeroCita) {
        return informacionCitaDeterminadaRepository.findByNumeroCita(numeroCita);
    }
}
