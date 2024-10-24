package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.EmpleadoTrabajaMenos;
import com.example.AppVeterinaria.Repositorios.EmpleadoTrabajaMenosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoTrabajaMenosService {

    @Autowired
    private EmpleadoTrabajaMenosRepository empleadoTrabajaMenosRepository;

    public List<EmpleadoTrabajaMenos> obtenerEmpleadoTrabajaMenos(String fechaInicio, String fechaFin) {
        return empleadoTrabajaMenosRepository.findByFechas(fechaInicio, fechaFin);
    }
}
