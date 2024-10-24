package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.InformacionCitasPorFecha;
import com.example.AppVeterinaria.Repositorios.InformacionCitasPorFechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionCitasPorFechaService {

    @Autowired
    private InformacionCitasPorFechaRepository informacionCitasPorFechaRepository;

    public List<InformacionCitasPorFecha> obtenerInformacionCitasPorFecha(String fechaInicio, String fechaFin) {
        return informacionCitasPorFechaRepository.findByFechas(fechaInicio, fechaFin);
    }
}
