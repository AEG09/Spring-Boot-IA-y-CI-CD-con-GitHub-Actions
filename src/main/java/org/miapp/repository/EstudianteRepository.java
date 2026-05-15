package org.miapp.repository;

import org.miapp.model.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface EstudianteRepository extends JpaRepository<Estudiante,  Long> {

// Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), deleteById()
}