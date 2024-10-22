package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.DetalleCita;
import com.example.AppVeterinaria.Repositorios.DetalleCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleCitaService {

    @Autowired
    private DetalleCitaRepository detalleCitaRepository;

    public List<DetalleCita> obtenerTodosLosDetallesCita() {
        return detalleCitaRepository.findAll();
    }

    public Optional<DetalleCita> obtenerDetalleCitaPorId(int correlativo) {
        return detalleCitaRepository.findById(correlativo);
    }

    public DetalleCita crearDetalleCita(DetalleCita detalleCita) {
        return detalleCitaRepository.save(detalleCita);
    }

    public DetalleCita actualizarDetalleCita(DetalleCita detalleCita) {
        return detalleCitaRepository.save(detalleCita);
    }

    public boolean eliminarDetalleCita(int correlativo) {
        if (detalleCitaRepository.existsById(correlativo)) {
            detalleCitaRepository.deleteById(correlativo);
            return true;
        }
        return false;
    }
}
