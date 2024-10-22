package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Telefono;
import com.example.AppVeterinaria.Servicios.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/telefonos")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;

    @GetMapping("/{id}")
    public ResponseEntity<Telefono> obtenerTelefonoPorId(@PathVariable int id) {
        Optional<Telefono> telefono = telefonoService.obtenerTelefonoPorId(id);
        return telefono.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Telefono>> obtenerTodosLosTelefonos() {
        List<Telefono> telefonos = telefonoService.obtenerTodosLosTelefonos();
        return new ResponseEntity<>(telefonos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Telefono> crearTelefono(@RequestBody Telefono telefono) {
        Telefono nuevoTelefono = telefonoService.crearTelefono(telefono);
        return new ResponseEntity<>(nuevoTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telefono> actualizarTelefono(@PathVariable int id, @RequestBody Telefono telefonoDetalles) {
        Optional<Telefono> telefonoExistente = telefonoService.obtenerTelefonoPorId(id);
        if (telefonoExistente.isPresent()) {
            Telefono telefonoActualizado = telefonoExistente.get();
            telefonoActualizado.setNumeroTelefono(telefonoDetalles.getNumeroTelefono());

            Telefono telefonoGuardado = telefonoService.actualizarTelefono(telefonoActualizado);
            return new ResponseEntity<>(telefonoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTelefono(@PathVariable int id) {
        boolean eliminado = telefonoService.eliminarTelefono(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}