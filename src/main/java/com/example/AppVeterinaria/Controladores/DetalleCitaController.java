package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.DetalleCita;
import com.example.AppVeterinaria.Servicios.DetalleCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalleCita")
public class DetalleCitaController {

    @Autowired
    private DetalleCitaService detalleCitaService;

    @GetMapping("/{correlativo}")
    public ResponseEntity<DetalleCita> obtenerDetalleCitaPorId(@PathVariable int correlativo) {
        Optional<DetalleCita> detalleCita = detalleCitaService.obtenerDetalleCitaPorId(correlativo);
        return detalleCita.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<DetalleCita>> obtenerTodosLosDetallesCita() {
        List<DetalleCita> detallesCita = detalleCitaService.obtenerTodosLosDetallesCita();
        return new ResponseEntity<>(detallesCita, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleCita> crearDetalleCita(@RequestBody DetalleCita detalleCita) {
        DetalleCita nuevoDetalleCita = detalleCitaService.crearDetalleCita(detalleCita);
        return new ResponseEntity<>(nuevoDetalleCita, HttpStatus.CREATED);
    }

    @PutMapping("/{correlativo}")
    public ResponseEntity<DetalleCita> actualizarDetalleCita(@PathVariable int correlativo, @RequestBody DetalleCita detalleCitaDetalles) {
        Optional<DetalleCita> detalleCitaExistente = detalleCitaService.obtenerDetalleCitaPorId(correlativo);
        if (detalleCitaExistente.isPresent()) {
            DetalleCita detalleCitaActualizado = detalleCitaExistente.get();
            detalleCitaActualizado.setNumeroCita(detalleCitaDetalles.getNumeroCita());
            detalleCitaActualizado.setNumeroFicha(detalleCitaDetalles.getNumeroFicha());
            detalleCitaActualizado.setCodigoServicio(detalleCitaDetalles.getCodigoServicio());
            detalleCitaActualizado.setInicio(detalleCitaDetalles.getInicio());
            detalleCitaActualizado.setFin(detalleCitaDetalles.getFin());
            detalleCitaActualizado.setCodigoEmpleado(detalleCitaDetalles.getCodigoEmpleado());
            detalleCitaActualizado.setCodigoSucursal(detalleCitaDetalles.getCodigoSucursal());

            DetalleCita detalleCitaGuardado = detalleCitaService.actualizarDetalleCita(detalleCitaActualizado);
            return new ResponseEntity<>(detalleCitaGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{correlativo}")
    public ResponseEntity<Void> eliminarDetalleCita(@PathVariable int correlativo) {
        boolean eliminado = detalleCitaService.eliminarDetalleCita(correlativo);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}