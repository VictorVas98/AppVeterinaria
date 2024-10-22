package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Diagnostico;
import com.example.AppVeterinaria.Servicios.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping("/{codigoDiagnostico}")
    public ResponseEntity<Diagnostico> obtenerDiagnosticoPorId(@PathVariable int codigoDiagnostico) {
        Optional<Diagnostico> diagnostico = diagnosticoService.obtenerDiagnosticoPorId(codigoDiagnostico);
        return diagnostico.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Diagnostico>> obtenerTodosLosDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoService.obtenerTodosLosDiagnosticos();
        return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Diagnostico> crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        Diagnostico nuevoDiagnostico = diagnosticoService.crearDiagnostico(diagnostico);
        return new ResponseEntity<>(nuevoDiagnostico, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoDiagnostico}")
    public ResponseEntity<Diagnostico> actualizarDiagnostico(@PathVariable int codigoDiagnostico, @RequestBody Diagnostico diagnosticoDetalles) {
        Optional<Diagnostico> diagnosticoExistente = diagnosticoService.obtenerDiagnosticoPorId(codigoDiagnostico);
        if (diagnosticoExistente.isPresent()) {
            Diagnostico diagnosticoActualizado = diagnosticoExistente.get();
            diagnosticoActualizado.setDescripcion(diagnosticoDetalles.getDescripcion());

            Diagnostico diagnosticoGuardado = diagnosticoService.actualizarDiagnostico(diagnosticoActualizado);
            return new ResponseEntity<>(diagnosticoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoDiagnostico}")
    public ResponseEntity<Void> eliminarDiagnostico(@PathVariable int codigoDiagnostico) {
        boolean eliminado = diagnosticoService.eliminarDiagnostico(codigoDiagnostico);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}