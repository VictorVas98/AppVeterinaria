package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Servicio;
import com.example.AppVeterinaria.Repositorios.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> obtenerServicioPorId(int codigoServicio) {
        return servicioRepository.findById(codigoServicio);
    }

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public boolean eliminarServicio(int codigoServicio) {
        if (servicioRepository.existsById(codigoServicio)) {
            servicioRepository.deleteById(codigoServicio);
            return true;
        }
        return false;
    }
}
