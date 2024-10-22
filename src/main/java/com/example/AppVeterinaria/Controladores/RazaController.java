package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Raza;
import com.example.AppVeterinaria.Servicios.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/razas")
public class RazaController {

    @Autowired
    private RazaService razaService;

    @GetMapping("/{codigoRaza}")
    public ResponseEntity<Raza> obtenerRazaPorId(@PathVariable int codigoRaza) {
        Optional<Raza> raza = razaService.obtenerRazaPorId(codigoRaza);
        return raza.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Raza>> obtenerTodasLasRazas() {
        List<Raza> razas = razaService.obtenerTodasLasRazas();
        return new ResponseEntity<>(razas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Raza> crearRaza(@RequestBody Raza raza) {
        Raza nuevaRaza = razaService.crearRaza(raza);
        return new ResponseEntity<>(nuevaRaza, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoRaza}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable int codigoRaza, @RequestBody Raza razaDetalles) {
        Optional<Raza> razaExistente = razaService.obtenerRazaPorId(codigoRaza);
        if (razaExistente.isPresent()) {
            Raza razaActualizada = razaExistente.get();
            razaActualizada.setDescripcion(razaDetalles.getDescripcion());

            Raza razaGuardada = razaService.actualizarRaza(razaActualizada);
            return new ResponseEntity<>(razaGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoRaza}")
    public ResponseEntity<Void> eliminarRaza(@PathVariable int codigoRaza) {
        boolean eliminado = razaService.eliminarRaza(codigoRaza);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
