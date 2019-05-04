/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.LoginDAO;
import br.edu.fafic.model.Login;
import br.edu.fafic.model.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/tag")
public class ServletTagLib extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              
        LoginDAO dao = new LoginDAO();
        List<Login> logins = dao.getAll();
        req.setAttribute("logs", logins);
//        req.getRequestDispatcher("exemploTagLib.jsp").forward(req, resp);
        
        List<String> comida = new ArrayList();
        comida.add("Feijoada");
        comida.add("Churrasco");
        Pessoa p1 = new Pessoa("Jose", comida);
        List<String> comida2 = new ArrayList();
        comida2.add("Pizza");
        comida2.add("Lasanha");
        Pessoa p2 = new Pessoa("Antonio", comida2);
        List<Pessoa> pessoas = new ArrayList();
        pessoas.add(p1);
        pessoas.add(p2);
        req.setAttribute("pessoa", pessoas);
        String perfil = req.getParameter("perfil");
        req.setAttribute("perfil", perfil);
        String pais = req.getParameter("pais");
        req.setAttribute("pais", pais);
        req.getRequestDispatcher("exmploTagLib.jsp").forward(req, resp);
        
        
    }
    
    
    
}
