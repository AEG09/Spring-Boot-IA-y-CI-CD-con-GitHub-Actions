package org.miapp.model;
import jakarta.persistence.*;

import lombok.Data; // Si usas Lombok, te ahorras escribir getters y setters



@Entity
@Data
@Table(name = "estudiantes")

public class Estudiante {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;

    private String email;

    private int edad;


}
