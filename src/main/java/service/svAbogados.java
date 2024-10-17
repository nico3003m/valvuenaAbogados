package service;

import controladora.ControladoraClass;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "svAbogados", urlPatterns = {"/svAbogados"})
public class svAbogados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String documento = request.getParameter("documento");
        String celular = request.getParameter("celular");
        String edad = request.getParameter("edad");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");
        String cargo = request.getParameter("cargo");
        String nTarjetaProfesional = request.getParameter("nTarjetaProfesional");

        ControladoraClass controladora = new ControladoraClass();
        controladora.crearAbogado(nombre, apellidos, correo, documento, celular, edad, direccion, especialidad,cargo,nTarjetaProfesional);

        System.out.println("ingreso:" + nombre + "ingreso:" + apellidos + "ingreso:" + correo + "ingreso:" + cargo + "ingreso:" + celular + "ingreso:" + edad + "ingreso:" + direccion + "ingreso:" + especialidad);
        response.sendRedirect("createAbogados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
