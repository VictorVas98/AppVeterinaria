package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Sucursal;
import com.example.AppVeterinaria.Servicios.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerSucursalPorId(@PathVariable int id) {
        Optional<Sucursal> sucursal = sucursalService.obtenerSucursalPorId(id);
        return sucursal.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> obtenerTodasLasSucursales() {
        List<Sucursal> sucursales = sucursalService.obtenerTodasLasSucursales();
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = sucursalService.crearSucursal(sucursal);
        return new ResponseEntity<>(nuevaSucursal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable int id, @RequestBody Sucursal sucursalDetalles) {
        Optional<Sucursal> sucursalExistente = sucursalService.obtenerSucursalPorId(id);
        if (sucursalExistente.isPresent()) {
            Sucursal sucursalActualizada = sucursalExistente.get();
            sucursalActualizada.setNombreSucursal(sucursalDetalles.getNombreSucursal());
            sucursalActualizada.setDireccion(sucursalDetalles.getDireccion());

            Sucursal sucursalGuardada = sucursalService.actualizarSucursal(sucursalActualizada);
            return new ResponseEntity<>(sucursalGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable int id) {
        boolean eliminado = sucursalService.eliminarSucursal(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
