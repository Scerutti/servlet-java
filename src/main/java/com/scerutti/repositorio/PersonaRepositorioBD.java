package com.scerutti.repositorio;

import com.scerutti.conexion.Conexion;
import com.scerutti.modelos.Persona;
import com.scerutti.shared.CustomLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaRepositorioBD implements PersonaRepositorio {
    private static final Logger LOGGER = CustomLogger.getLogger();

    @Override
    public void agregarPersona(Persona persona) {
        String sql = "INSERT INTO persona (nombre, apellido, dni, fechaNacimiento, edad, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getDni());
            stmt.setString(4, persona.getFechaNacimiento());
            stmt.setInt(5, persona.getEdad());
            stmt.setString(6, persona.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al interactuar con la base de datos.", e);
        }
    }

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT nombre, apellido, dni, fechaNacimiento, edad, email FROM persona";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Persona p = new Persona(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("fechaNacimiento"),
                        rs.getInt("edad"),
                        rs.getString("email")
                );
                personas.add(p);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al interactuar con la base de datos.", e);
        }
        return personas;
    }
}
