package com.example.AppVeterinaria.Controladores;

import com.example.AppVeterinaria.Entidades.Empleado;
import com.example.AppVeterinaria.Servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable int id) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorId(id);
        return empleado.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.crearEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoDetalles) {
        Optional<Empleado> empleadoExistente = empleadoService.obtenerEmpleadoPorId(id);
        if (empleadoExistente.isPresent()) {
            Empleado empleadoActualizado = empleadoExistente.get();
            empleadoActualizado.setCodigoPersona(empleadoDetalles.getCodigoPersona());
            empleadoActualizado.setCodigoPuesto(empleadoDetalles.getCodigoPuesto());

            Empleado empleadoGuardado = empleadoService.actualizarEmpleado(empleadoActualizado);
            return new ResponseEntity<>(empleadoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable int id) {
        boolean eliminado = empleadoService.eliminarEmpleado(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
