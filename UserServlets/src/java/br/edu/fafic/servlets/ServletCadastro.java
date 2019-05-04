/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciano
 */
@WebServlet("/cad")
public class ServletCadastro extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>");
        out.print("</title>");
        out.print("</head>");
        out.print("<body>");
        out.println("Seja Bem-Vindo: " +nome+"<br/><br/>");
        out.print("Email: " +email);
        out.print("</body>");
        out.print("</html>");
    }
    
    
    
    
    
}
