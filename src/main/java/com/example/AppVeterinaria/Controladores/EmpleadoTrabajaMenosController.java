package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.EmpleadoTrabajaMenos;
import com.example.AppVeterinaria.Servicios.EmpleadoTrabajaMenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleadoTrabajaMenos")
public class EmpleadoTrabajaMenosController {

    @Autowired
    private EmpleadoTrabajaMenosService empleadoTrabajaMenosService;

    @GetMapping
    public List<EmpleadoTrabajaMenos> obtenerEmpleadoTrabajaMenos(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return empleadoTrabajaMenosService.obtenerEmpleadoTrabajaMenos(fechaInicio, fechaFin);
    }
}
