package org.miapp.controller;

import org.miapp.model.Estudiante;
import org.miapp.service.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import  static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(EstudianteController.class)
public  class  EstudianteControllerTest {

    @Autowired
    private  MockMvc  mockMvc;

    @MockitoBean
    private  EstudianteService  service;

    @Test
    void  testListarTodosEndpoint() throws  Exception {
        Estudiante  e = new  Estudiante();
        e.setNombre("Ana");

        when(service.obtenerTodos()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/estudiantes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Ana"));
    }
}
