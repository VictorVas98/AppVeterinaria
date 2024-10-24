package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.CantidadCitasVeterinario;
import com.example.AppVeterinaria.Repositorios.CantidadCitasVeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantidadCitasVeterinarioService {

    @Autowired
    private CantidadCitasVeterinarioRepository cantidadCitasVeterinarioRepository;

    public List<CantidadCitasVeterinario> obtenerCantidadCitasVeterinario(String fechaInicio, String fechaFin) {
        return cantidadCitasVeterinarioRepository.findByFechas(fechaInicio, fechaFin);
    }
}
