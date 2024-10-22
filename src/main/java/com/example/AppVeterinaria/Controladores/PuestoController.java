package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Puesto;
import com.example.AppVeterinaria.Servicios.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> obtenerPuestoPorId(@PathVariable int id) {
        Optional<Puesto> puesto = puestoService.obtenerPuestoPorId(id);
        return puesto.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Puesto>> obtenerTodosLosPuestos() {
        List<Puesto> puestos = puestoService.obtenerTodosLosPuestos();
        return new ResponseEntity<>(puestos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Puesto> crearPuesto(@RequestBody Puesto puesto) {
        Puesto nuevoPuesto = puestoService.crearPuesto(puesto);
        return new ResponseEntity<>(nuevoPuesto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puesto> actualizarPuesto(@PathVariable int id, @RequestBody Puesto puestoDetalles) {
        Optional<Puesto> puestoExistente = puestoService.obtenerPuestoPorId(id);
        if (puestoExistente.isPresent()) {
            Puesto puestoActualizado = puestoExistente.get();
            puestoActualizado.setDescripcion(puestoDetalles.getDescripcion());

            Puesto puestoGuardado = puestoService.actualizarPuesto(puestoActualizado);
            return new ResponseEntity<>(puestoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPuesto(@PathVariable int id) {
        boolean eliminado = puestoService.eliminarPuesto(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
