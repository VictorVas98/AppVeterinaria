package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.CantidadCitasVeterinario;
import com.example.AppVeterinaria.Servicios.CantidadCitasVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cantidadCitasVeterinario")
public class CantidadCitasVeterinarioController {

    @Autowired
    private CantidadCitasVeterinarioService cantidadCitasVeterinarioService;

    @GetMapping
    public List<CantidadCitasVeterinario> obtenerCantidadCitasVeterinario(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return cantidadCitasVeterinarioService.obtenerCantidadCitasVeterinario(fechaInicio, fechaFin);
    }
}
