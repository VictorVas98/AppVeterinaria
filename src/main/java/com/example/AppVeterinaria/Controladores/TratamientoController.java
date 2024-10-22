package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Tratamiento;
import com.example.AppVeterinaria.Servicios.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/{codigoTratamiento}")
    public ResponseEntity<Tratamiento> obtenerTratamientoPorId(@PathVariable int codigoTratamiento) {
        Optional<Tratamiento> tratamiento = tratamientoService.obtenerTratamientoPorId(codigoTratamiento);
        return tratamiento.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Tratamiento>> obtenerTodosLosTratamientos() {
        List<Tratamiento> tratamientos = tratamientoService.obtenerTodosLosTratamientos();
        return new ResponseEntity<>(tratamientos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tratamiento> crearTratamiento(@RequestBody Tratamiento tratamiento) {
        Tratamiento nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento);
        return new ResponseEntity<>(nuevoTratamiento, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoTratamiento}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable int codigoTratamiento, @RequestBody Tratamiento tratamientoDetalles) {
        Optional<Tratamiento> tratamientoExistente = tratamientoService.obtenerTratamientoPorId(codigoTratamiento);
        if (tratamientoExistente.isPresent()) {
            Tratamiento tratamientoActualizado = tratamientoExistente.get();
            tratamientoActualizado.setDescripcion(tratamientoDetalles.getDescripcion());

            Tratamiento tratamientoGuardado = tratamientoService.actualizarTratamiento(tratamientoActualizado);
            return new ResponseEntity<>(tratamientoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoTratamiento}")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable int codigoTratamiento) {
        boolean eliminado = tratamientoService.eliminarTratamiento(codigoTratamiento);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
