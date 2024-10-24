package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.InformacionCitaDeterminada;
import com.example.AppVeterinaria.Servicios.InformacionCitaDeterminadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citaDeterminada")
public class InformacionCitaDeterminadaController {

    @Autowired
    private InformacionCitaDeterminadaService informacionCitaDeterminadaService;

    @GetMapping("/{numeroCita}")
    public List<InformacionCitaDeterminada> obtenerInformacionCita(@PathVariable int numeroCita) {
        return informacionCitaDeterminadaService.obtenerInformacionCita(numeroCita);
    }
}
