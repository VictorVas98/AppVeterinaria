package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Especie;
import com.example.AppVeterinaria.Servicios.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping("/{codigoEspecie}")
    public ResponseEntity<Especie> obtenerEspeciePorId(@PathVariable int codigoEspecie) {
        Optional<Especie> especie = especieService.obtenerEspeciePorId(codigoEspecie);
        return especie.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Especie>> obtenerTodasLasEspecies() {
        List<Especie> especies = especieService.obtenerTodasLasEspecies();
        return new ResponseEntity<>(especies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Especie> crearEspecie(@RequestBody Especie especie) {
        Especie nuevaEspecie = especieService.crearEspecie(especie);
        return new ResponseEntity<>(nuevaEspecie, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoEspecie}")
    public ResponseEntity<Especie> actualizarEspecie(@PathVariable int codigoEspecie, @RequestBody Especie especieDetalles) {
        Optional<Especie> especieExistente = especieService.obtenerEspeciePorId(codigoEspecie);
        if (especieExistente.isPresent()) {
            Especie especieActualizada = especieExistente.get();
            especieActualizada.setDescripcion(especieDetalles.getDescripcion());

            Especie especieGuardada = especieService.actualizarEspecie(especieActualizada);
            return new ResponseEntity<>(especieGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoEspecie}")
    public ResponseEntity<Void> eliminarEspecie(@PathVariable int codigoEspecie) {
        boolean eliminado = especieService.eliminarEspecie(codigoEspecie);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
