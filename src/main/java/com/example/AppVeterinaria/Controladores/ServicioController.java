package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Servicio;
import com.example.AppVeterinaria.Servicios.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/{codigoServicio}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable int codigoServicio) {
        Optional<Servicio> servicio = servicioService.obtenerServicioPorId(codigoServicio);
        return servicio.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> obtenerTodosLosServicios() {
        List<Servicio> servicios = servicioService.obtenerTodosLosServicios();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio nuevoServicio = servicioService.crearServicio(servicio);
        return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoServicio}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable int codigoServicio, @RequestBody Servicio servicioDetalles) {
        Optional<Servicio> servicioExistente = servicioService.obtenerServicioPorId(codigoServicio);
        if (servicioExistente.isPresent()) {
            Servicio servicioActualizado = servicioExistente.get();
            servicioActualizado.setDescripcion(servicioDetalles.getDescripcion());
            servicioActualizado.setTipo(servicioDetalles.getTipo());
            servicioActualizado.setPrecio(servicioDetalles.getPrecio());

            Servicio servicioGuardado = servicioService.actualizarServicio(servicioActualizado);
            return new ResponseEntity<>(servicioGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigoServicio}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable int codigoServicio) {
        boolean eliminado = servicioService.eliminarServicio(codigoServicio);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}