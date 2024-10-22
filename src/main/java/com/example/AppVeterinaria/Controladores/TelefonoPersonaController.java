package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.TelefonoPersona;
import com.example.AppVeterinaria.Servicios.TelefonoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/telefonospersonas")
public class TelefonoPersonaController {

    @Autowired
    private TelefonoPersonaService telefonoPersonaService;

    @GetMapping("/{id}")
    public ResponseEntity<TelefonoPersona> obtenerTelefonoPersonaPorId(@PathVariable int id) {
        Optional<TelefonoPersona> telefonoPersona = telefonoPersonaService.obtenerTelefonoPersonaPorId(id);
        return telefonoPersona.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TelefonoPersona>> obtenerTodosLosTelefonosPersona() {
        List<TelefonoPersona> telefonosPersona = telefonoPersonaService.obtenerTodosLosTelefonosPersona();
        return new ResponseEntity<>(telefonosPersona, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TelefonoPersona> crearTelefonoPersona(@RequestBody TelefonoPersona telefonoPersona) {
        TelefonoPersona nuevoTelefonoPersona = telefonoPersonaService.crearTelefonoPersona(telefonoPersona);
        return new ResponseEntity<>(nuevoTelefonoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefonoPersona> actualizarTelefonoPersona(@PathVariable int id, @RequestBody TelefonoPersona telefonoPersonaDetalles) {
        Optional<TelefonoPersona> telefonoPersonaExistente = telefonoPersonaService.obtenerTelefonoPersonaPorId(id);
        if (telefonoPersonaExistente.isPresent()) {
            TelefonoPersona telefonoPersonaActualizado = telefonoPersonaExistente.get();
            telefonoPersonaActualizado.setCodigoPersona(telefonoPersonaDetalles.getCodigoPersona());

            TelefonoPersona telefonoPersonaGuardado = telefonoPersonaService.actualizarTelefonoPersona(telefonoPersonaActualizado);
            return new ResponseEntity<>(telefonoPersonaGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTelefonoPersona(@PathVariable int id) {
        boolean eliminado = telefonoPersonaService.eliminarTelefonoPersona(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}