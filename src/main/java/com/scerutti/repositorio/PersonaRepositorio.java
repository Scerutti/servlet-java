package com.scerutti.repositorio;

import com.scerutti.modelos.Persona;

import java.util.List;

public interface  PersonaRepositorio {
    void agregarPersona(Persona persona);
    List<Persona> listarPersonas();
}
