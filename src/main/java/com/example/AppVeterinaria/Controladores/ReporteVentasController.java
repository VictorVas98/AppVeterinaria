package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.ReporteVentas;
import com.example.AppVeterinaria.Servicios.ReporteVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteVentas")
public class ReporteVentasController {

    @Autowired
    private ReporteVentasService reporteVentasService;

    @GetMapping
    public List<ReporteVentas> obtenerReportVentas(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return reporteVentasService.obtenerReporteVentas(fechaInicio, fechaFin);
    }
}
