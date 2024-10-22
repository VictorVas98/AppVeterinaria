package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Cita;
import com.example.AppVeterinaria.Entidades.CitaId;
import com.example.AppVeterinaria.Servicios.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/{codigoSucursal}/{numeroCita}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable int codigoSucursal, @PathVariable int numeroCita) {
        CitaId id = new CitaId(codigoSucursal, numeroCita);
        Optional<Cita> cita = citaService.obtenerCitaPorId(id);
        return cita.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Cita>> obtenerTodasLasCitas() {
        List<Cita> citas = citaService.obtenerTodasLasCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.crearCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoSucursal}/{numeroCita}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable int codigoSucursal, @PathVariable int numeroCita, @RequestBody Cita citaDetalles) {
        CitaId id = new CitaId(codigoSucursal, numeroCita);
        Optional<Cita> citaExistente = citaService.obtenerCitaPorId(id);
        if (citaExistente.isPresent()) {
            Cita citaActualizada = citaExistente.get();
            citaActualizada.setFechaCita(citaDetalles.getFechaCita());
            citaActualizada.setObservaciones(citaDetalles.getObservaciones());
            citaActualizada.setCodigoEmpleado(citaDetalles.getCodigoEmpleado());
            citaActualizada.setTipoCita(citaDetalles.getTipoCita());
            citaActualizada.setCodigoCliente(citaDetalles.getCodigoCliente());

            Cita citaGuardada = citaService.actualizarCita(citaActualizada);
            return new ResponseEntity<>(citaGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoSucursal}/{numeroCita}")
    public ResponseEntity<Void> eliminarCita(@PathVariable int codigoSucursal, @PathVariable int numeroCita) {
        CitaId id = new CitaId(codigoSucursal, numeroCita);
        boolean eliminado = citaService.eliminarCita(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
