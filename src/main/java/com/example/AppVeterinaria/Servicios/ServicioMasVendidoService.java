package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.ServicioMasVendido;
import com.example.AppVeterinaria.Repositorios.ServicioMasVendidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMasVendidoService {

    @Autowired
    private ServicioMasVendidoRepository servicioMasVendidoRepository;

    public List<ServicioMasVendido> obtenerServiciosMasVendidos(String fechaInicio, String fechaFin) {
        return servicioMasVendidoRepository.findByFechas(fechaInicio, fechaFin);
    }
}