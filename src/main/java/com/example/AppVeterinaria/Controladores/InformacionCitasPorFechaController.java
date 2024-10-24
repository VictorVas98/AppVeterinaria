package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.InformacionCitasPorFecha;
import com.example.AppVeterinaria.Servicios.InformacionCitasPorFechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citasPorFecha")
public class InformacionCitasPorFechaController {

    @Autowired
    private InformacionCitasPorFechaService informacionCitasPorFechaService;

    @GetMapping
    public List<InformacionCitasPorFecha> obtenerInformacionCitasPorFecha(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return informacionCitasPorFechaService.obtenerInformacionCitasPorFecha(fechaInicio, fechaFin);
    }
}
