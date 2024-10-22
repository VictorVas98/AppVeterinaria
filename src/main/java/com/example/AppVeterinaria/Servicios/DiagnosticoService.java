package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.Diagnostico;
import com.example.AppVeterinaria.Repositorios.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public List<Diagnostico> obtenerTodosLosDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    public Optional<Diagnostico> obtenerDiagnosticoPorId(int codigoDiagnostico) {
        return diagnosticoRepository.findById(codigoDiagnostico);
    }

    public Diagnostico crearDiagnostico(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    public Diagnostico actualizarDiagnostico(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    public boolean eliminarDiagnostico(int codigoDiagnostico) {
        if (diagnosticoRepository.existsById(codigoDiagnostico)) {
            diagnosticoRepository.deleteById(codigoDiagnostico);
            return true;
        }
        return false;
    }
}
