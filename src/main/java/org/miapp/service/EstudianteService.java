package org.miapp.service;

import org.miapp.model.Estudiante;
import org.miapp.repository.EstudianteRepository;
import org.miapp.exception.EstudianteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    // Crear un estudiante en base de datos
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Obtener todos los estudiantes de la base de datos
    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    // Actualizar un estudiante por ID
    public Estudiante actualizar(Long id, Estudiante datos) {
        Estudiante existente = repository.findById(id)
                .orElseThrow(() -> new EstudianteNotFoundException(id));
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setEdad(datos.getEdad());
        return repository.save(existente);
    }

    // Eliminar un estudiante por ID
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new EstudianteNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
