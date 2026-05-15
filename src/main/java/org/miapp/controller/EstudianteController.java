package org.miapp.controller;

import org.miapp.model.Estudiante;
import org.miapp.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    // POST: http://localhost:8080/api/estudiantes
    @PostMapping
    public Estudiante crear(@Valid @RequestBody Estudiante estudiante) {
        return service.guardarEstudiante(estudiante);
    }

    // GET: http://localhost:8080/api/estudiantes
    @GetMapping
    public List<Estudiante> listarTodos() {
        return service.obtenerTodos();
    }

    // PUT: http://localhost:8080/api/estudiantes/1
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id,
                                                 @Valid @RequestBody Estudiante estudiante) {
        Estudiante actualizado = service.actualizar(id, estudiante);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE: http://localhost:8080/api/estudiantes/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}