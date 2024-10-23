package com.example.AppVeterinaria.Controladores;
import com.example.AppVeterinaria.Entidades.Persona;
import com.example.AppVeterinaria.Servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable int id) {
        try {
            Optional<Persona> persona = personaService.obtenerPersonaPorId(id);
            return persona.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.obtenerTodasLasPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        Persona nuevaPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable int id, @RequestBody Persona personaDetalles) {
        Optional<Persona> personaExistente = personaService.obtenerPersonaPorId(id);
        if (personaExistente.isPresent()) {
            Persona personaActualizada = personaExistente.get();
            // Actualizar los campos de la persona
            personaActualizada.setPrimerNombre(personaDetalles.getPrimerNombre());
            personaActualizada.setSegundoNombre(personaDetalles.getSegundoNombre());
            personaActualizada.setTercerNombre(personaDetalles.getTercerNombre());
            personaActualizada.setPrimerApellido(personaDetalles.getPrimerApellido());
            personaActualizada.setSegundoApellido(personaDetalles.getSegundoApellido());
            personaActualizada.setTercerApellido(personaDetalles.getTercerApellido());
            personaActualizada.setTipoPersona(personaDetalles.getTipoPersona());
            personaActualizada.setRazonSocial(personaDetalles.getRazonSocial());
            personaActualizada.setFechaNacimiento(personaDetalles.getFechaNacimiento());
            personaActualizada.setGenero(personaDetalles.getGenero());

            Persona personaGuardada = personaService.actualizarPersona(personaActualizada);
            return new ResponseEntity<>(personaGuardada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable int id) {
        Optional<Persona> persona = personaService.obtenerPersonaPorId(id);
        if (persona.isPresent()) {
            personaService.eliminarPersona(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}