package com.scerutti.controladores;

import com.scerutti.repositorio.PersonaRepositorio;
import com.scerutti.repositorio.PersonaRepositorioBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/listar-personas")
public class ListarPersonasController extends HttpServlet {
    private final PersonaRepositorio repositorio = new PersonaRepositorioBD();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("personas", repositorio.listarPersonas());
        req.getRequestDispatcher("/WEB-INF/vistas/listadoPersonas.jsp").forward(req, resp);
    }
}
