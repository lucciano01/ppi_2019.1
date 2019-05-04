/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciano
 */
@WebServlet("/show")
public class ServletEL extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String veiculo = req.getParameter("veiculos");
        String sexo = req.getParameter("sexo");
        List<String> idiomas = Arrays.asList(req.getParameterValues("idioma"));
        req.setAttribute("idiomas", idiomas);
        req.setAttribute("veiculos", veiculo);
        req.setAttribute("sexo", sexo);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
    
    
}
