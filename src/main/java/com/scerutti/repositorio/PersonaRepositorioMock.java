package com.scerutti.repositorio;

import com.scerutti.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorioMock implements PersonaRepositorio{
    private static PersonaRepositorioMock instance;
    private final List<Persona> personas = new ArrayList<>();

    private PersonaRepositorioMock() {}
    public static PersonaRepositorioMock getInstance() {
        if (instance == null) {
            instance = new PersonaRepositorioMock();
        }
        return instance;
    }

    @Override
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }
    @Override
    public List<Persona> listarPersonas() {
        return personas;
    }
}
