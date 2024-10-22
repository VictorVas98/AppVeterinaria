package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.FichaMascota;
import com.example.AppVeterinaria.Servicios.FichaMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fichasmascotas")
public class FichaMascotaController {

    @Autowired
    private FichaMascotaService fichaMascotaService;

    @GetMapping("/{numeroFicha}")
    public ResponseEntity<FichaMascota> obtenerFichaPorId(@PathVariable int numeroFicha) {
        Optional<FichaMascota> fichaMascota = fichaMascotaService.obtenerFichaPorId(numeroFicha);
        return fichaMascota.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<FichaMascota>> obtenerTodasLasFichas() {
        List<FichaMascota> fichas = fichaMascotaService.obtenerTodasLasFichas();
        return new ResponseEntity<>(fichas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FichaMascota> crearFichaMascota(@RequestBody FichaMascota fichaMascota) {
        FichaMascota nuevaFicha = fichaMascotaService.crearFichaMascota(fichaMascota);
        return new ResponseEntity<>(nuevaFicha, HttpStatus.CREATED);
    }

    @PutMapping("/{numeroFicha}")
    public ResponseEntity<FichaMascota> actualizarFichaMascota(@PathVariable int numeroFicha, @RequestBody FichaMascota fichaDetalles) {
        Optional<FichaMascota> fichaExistente = fichaMascotaService.obtenerFichaPorId(numeroFicha);
        if (fichaExistente.isPresent()) {
            FichaMascota fichaActualizada = fichaExistente.get();
            fichaActualizada.setCodigoEspecie(fichaDetalles.getCodigoEspecie());
            fichaActualizada.setCodigoRaza(fichaDetalles.getCodigoRaza());
            fichaActualizada.setNombre(fichaDetalles.getNombre());
            fichaActualizada.setFechaNacimiento(fichaDetalles.getFechaNacimiento());
            fichaActualizada.setTalla(fichaDetalles.getTalla());
            fichaActualizada.setGenero(fichaDetalles.getGenero());

            FichaMascota fichaGuardada = fichaMascotaService.actualizarFichaMascota(fichaActualizada);
            return new ResponseEntity<>(fichaGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{numeroFicha}")
    public ResponseEntity<Void> eliminarFichaMascota(@PathVariable int numeroFicha) {
        boolean eliminado = fichaMascotaService.eliminarFichaMascota(numeroFicha);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
