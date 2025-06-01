package com.scerutti.controladores;

import com.scerutti.modelos.Persona;
import com.scerutti.repositorio.PersonaRepositorio;
import com.scerutti.repositorio.PersonaRepositorioBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;


@WebServlet("/guardar-persona")
public class GuardarPersonaController extends HttpServlet {
    private final PersonaRepositorio repositorio = new PersonaRepositorioBD();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Persona persona = new Persona(
                    req.getParameter("nombre"),
                    req.getParameter("apellido"),
                    req.getParameter("dni"),
                    req.getParameter("fechaNacimiento"),
                    Integer.parseInt(req.getParameter("edad")),
                    req.getParameter("email")
            );
            repositorio.agregarPersona(persona);
            req.setAttribute("mensaje", "Persona cargada exitosamente.");
            req.getRequestDispatcher("/WEB-INF/vistas/confirmacionCarga.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "La edad ingresada no es un número válido.");
            req.getRequestDispatcher("/WEB-INF/vistas/error.jsp").forward(req, resp);
        }
    }

}