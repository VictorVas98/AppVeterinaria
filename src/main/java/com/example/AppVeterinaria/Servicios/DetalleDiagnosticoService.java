package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.DetalleDiagnostico;
import com.example.AppVeterinaria.Repositorios.DetalleDiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleDiagnosticoService {

    @Autowired
    private DetalleDiagnosticoRepository detalleDiagnosticoRepository;

    public List<DetalleDiagnostico> obtenerTodosLosDetalles() {
        return detalleDiagnosticoRepository.findAll();
    }

    public Optional<DetalleDiagnostico> obtenerDetallePorCorrelativo(int correlativo) {
        return detalleDiagnosticoRepository.findById(correlativo);
    }

    public DetalleDiagnostico crearDetalleDiagnostico(DetalleDiagnostico detalleDiagnostico) {
        return detalleDiagnosticoRepository.save(detalleDiagnostico);
    }

    public DetalleDiagnostico actualizarDetalleDiagnostico(DetalleDiagnostico detalleDiagnostico) {
        return detalleDiagnosticoRepository.save(detalleDiagnostico);
    }

    public boolean eliminarDetalleDiagnostico(int correlativo) {
        if (detalleDiagnosticoRepository.existsById(correlativo)) {
            detalleDiagnosticoRepository.deleteById(correlativo);
            return true;
        }
        return false;
    }
}