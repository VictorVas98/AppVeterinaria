package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.TelefonoSucursal;
import com.example.AppVeterinaria.Servicios.TelefonoSucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/telefonossucursales")
public class TelefonoSucursalController {

    @Autowired
    private TelefonoSucursalService telefonoSucursalService;

    @GetMapping("/{id}")
    public ResponseEntity<TelefonoSucursal> obtenerTelefonoSucursalPorId(@PathVariable int id) {
        Optional<TelefonoSucursal> telefonoSucursal = telefonoSucursalService.obtenerTelefonoSucursalPorId(id);
        return telefonoSucursal.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TelefonoSucursal>> obtenerTodosLosTelefonosSucursal() {
        List<TelefonoSucursal> telefonosSucursal = telefonoSucursalService.obtenerTodosLosTelefonosSucursal();
        return new ResponseEntity<>(telefonosSucursal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TelefonoSucursal> crearTelefonoSucursal(@RequestBody TelefonoSucursal telefonoSucursal) {
        TelefonoSucursal nuevoTelefonoSucursal = telefonoSucursalService.crearTelefonoSucursal(telefonoSucursal);
        return new ResponseEntity<>(nuevoTelefonoSucursal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefonoSucursal> actualizarTelefonoSucursal(@PathVariable int id, @RequestBody TelefonoSucursal telefonoSucursalDetalles) {
        Optional<TelefonoSucursal> telefonoSucursalExistente = telefonoSucursalService.obtenerTelefonoSucursalPorId(id);
        if (telefonoSucursalExistente.isPresent()) {
            TelefonoSucursal telefonoSucursalActualizado = telefonoSucursalExistente.get();
            telefonoSucursalActualizado.setCodigoSucursal(telefonoSucursalDetalles.getCodigoSucursal());

            TelefonoSucursal telefonoSucursalGuardado = telefonoSucursalService.actualizarTelefonoSucursal(telefonoSucursalActualizado);
            return new ResponseEntity<>(telefonoSucursalGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTelefonoSucursal(@PathVariable int id) {
        boolean eliminado = telefonoSucursalService.eliminarTelefonoSucursal(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}