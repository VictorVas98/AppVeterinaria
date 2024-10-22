package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.DetalleTratamiento;
import com.example.AppVeterinaria.Repositorios.DetalleTratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleTratamientoService {

    @Autowired
    private DetalleTratamientoRepository detalleTratamientoRepository;

    public List<DetalleTratamiento> obtenerTodosLosDetalles() {
        return detalleTratamientoRepository.findAll();
    }

    public Optional<DetalleTratamiento> obtenerDetallePorCorrelativo(int correlativo) {
        return detalleTratamientoRepository.findById(correlativo);
    }

    public DetalleTratamiento crearDetalleDeTratamiento(DetalleTratamiento detalleDeTratamiento) {
        return detalleTratamientoRepository.save(detalleDeTratamiento);
    }

    public DetalleTratamiento actualizarDetalleDeTratamiento(DetalleTratamiento detalleDeTratamiento) {
        return detalleTratamientoRepository.save(detalleDeTratamiento);
    }

    public boolean eliminarDetalleDeTratamiento(int correlativo) {
        if (detalleTratamientoRepository.existsById(correlativo)) {
            detalleTratamientoRepository.deleteById(correlativo);
            return true;
        }
        return false;
    }
}
