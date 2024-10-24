package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.ReporteVentas;
import com.example.AppVeterinaria.Repositorios.ReporteVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteVentasService {

    @Autowired
    private ReporteVentasRepository reporteVentasRepository;

    public List<ReporteVentas> obtenerReporteVentas(String fechaInicio, String fechaFin) {
        return reporteVentasRepository.findByFechas(fechaInicio, fechaFin);
    }
}
