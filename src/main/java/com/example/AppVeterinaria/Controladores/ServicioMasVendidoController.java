package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.ServicioMasVendido;
import com.example.AppVeterinaria.Servicios.ServicioMasVendidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviciosMasVendidos")
public class ServicioMasVendidoController {

    @Autowired
    private ServicioMasVendidoService servicioMasVendidoService;

    @GetMapping
    public List<ServicioMasVendido> obtenerServiciosMasVendidos(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return servicioMasVendidoService.obtenerServiciosMasVendidos(fechaInicio, fechaFin);
    }
}
