package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.DetalleTratamiento;
import com.example.AppVeterinaria.Servicios.DetalleTratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalleTratamientos")
public class DetalleTratamientoController {

    @Autowired
    private DetalleTratamientoService detalleTratamientoService;

    @GetMapping("/{correlativo}")
    public ResponseEntity<DetalleTratamiento> obtenerDetallePorCorrelativo(@PathVariable int correlativo) {
        Optional<DetalleTratamiento> detalleDeTratamiento = detalleTratamientoService.obtenerDetallePorCorrelativo(correlativo);
        return detalleDeTratamiento.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<DetalleTratamiento>> obtenerTodosLosDetalles() {
        List<DetalleTratamiento> detalles = detalleTratamientoService.obtenerTodosLosDetalles();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleTratamiento> crearDetalleDeTratamiento(@RequestBody DetalleTratamiento detalleDeTratamiento) {
        DetalleTratamiento nuevoDetalle = detalleTratamientoService.crearDetalleDeTratamiento(detalleDeTratamiento);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{correlativo}")
    public ResponseEntity<DetalleTratamiento> actualizarDetalleDeTratamiento(@PathVariable int correlativo, @RequestBody DetalleTratamiento detalleDetalles) {
        Optional<DetalleTratamiento> detalleExistente = detalleTratamientoService.obtenerDetallePorCorrelativo(correlativo);
        if (detalleExistente.isPresent()) {
            DetalleTratamiento detalleActualizado = detalleExistente.get();
            detalleActualizado.setNumeroCita(detalleDetalles.getNumeroCita());
            detalleActualizado.setNumeroFicha(detalleDetalles.getNumeroFicha());
            detalleActualizado.setCodigoDiagnostico(detalleDetalles.getCodigoDiagnostico());
            detalleActualizado.setCodigoTratamiento(detalleDetalles.getCodigoTratamiento());
            detalleActualizado.setCodigoSucursal(detalleDetalles.getCodigoSucursal());

            DetalleTratamiento detalleGuardado = detalleTratamientoService.actualizarDetalleDeTratamiento(detalleActualizado);
            return new ResponseEntity<>(detalleGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{correlativo}")
    public ResponseEntity<Void> eliminarDetalleDeTratamiento(@PathVariable int correlativo) {
        boolean eliminado = detalleTratamientoService.eliminarDetalleDeTratamiento(correlativo);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
