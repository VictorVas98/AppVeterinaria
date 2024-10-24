package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.GroomistaEficiente;
import com.example.AppVeterinaria.Servicios.GroomistaEficienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groomistaEficiente")
public class GroomistaEficienteController {

    @Autowired
    private GroomistaEficienteService groomistaEficienteService;

    @GetMapping
    public List<GroomistaEficiente> obtenerGroomistaEficiente(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return groomistaEficienteService.obtenerGroomistaEficiente(fechaInicio, fechaFin);
    }
}
