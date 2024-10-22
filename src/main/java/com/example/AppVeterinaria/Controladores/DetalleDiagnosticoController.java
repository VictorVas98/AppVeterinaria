package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.DetalleDiagnostico;
import com.example.AppVeterinaria.Servicios.DetalleDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalleDiagnosticos")
public class DetalleDiagnosticoController {

    @Autowired
    private DetalleDiagnosticoService detalleDiagnosticoService;

    @GetMapping("/{correlativo}")
    public ResponseEntity<DetalleDiagnostico> obtenerDetallePorCorrelativo(@PathVariable int correlativo) {
        Optional<DetalleDiagnostico> detalleDiagnostico = detalleDiagnosticoService.obtenerDetallePorCorrelativo(correlativo);
        return detalleDiagnostico.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<DetalleDiagnostico>> obtenerTodosLosDetalles() {
        List<DetalleDiagnostico> detalles = detalleDiagnosticoService.obtenerTodosLosDetalles();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleDiagnostico> crearDetalleDiagnostico(@RequestBody DetalleDiagnostico detalleDiagnostico) {
        DetalleDiagnostico nuevoDetalle = detalleDiagnosticoService.crearDetalleDiagnostico(detalleDiagnostico);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{correlativo}")
    public ResponseEntity<DetalleDiagnostico> actualizarDetalleDiagnostico(@PathVariable int correlativo, @RequestBody DetalleDiagnostico detalleDetalles) {
        Optional<DetalleDiagnostico> detalleExistente = detalleDiagnosticoService.obtenerDetallePorCorrelativo(correlativo);
        if (detalleExistente.isPresent()) {
            DetalleDiagnostico detalleActualizado = detalleExistente.get();
            detalleActualizado.setNumeroCita(detalleDetalles.getNumeroCita());
            detalleActualizado.setNumeroFicha(detalleDetalles.getNumeroFicha());
            detalleActualizado.setCodigoDiagnostico(detalleDetalles.getCodigoDiagnostico());
            detalleActualizado.setCodigoSucursal(detalleDetalles.getCodigoSucursal());

            DetalleDiagnostico detalleGuardado = detalleDiagnosticoService.actualizarDetalleDiagnostico(detalleActualizado);
            return new ResponseEntity<>(detalleGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{correlativo}")
    public ResponseEntity<Void> eliminarDetalleDiagnostico(@PathVariable int correlativo) {
        boolean eliminado = detalleDiagnosticoService.eliminarDetalleDiagnostico(correlativo);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
