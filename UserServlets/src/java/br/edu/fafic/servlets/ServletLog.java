/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.CursoDAO;
import br.edu.fafic.dao.LoginDAO;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/log")
public class ServletLog extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDAO loginDAO = new LoginDAO();
        CursoDAO cursoDAO = new CursoDAO();
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        Login l = loginDAO.autenticacao(nome, email);
        String param = req.getParameter("param");
        if (param != null && param.equals("logout")) {
            req.getSession().invalidate();
//            req.getRequestDispatcher(l.getPerfil()+"/teste.jsp").forward(req, resp);
            resp.sendRedirect("diretor/teste.jsp");
        } else {
            if (l != null) {
                String perfil = l.getPerfil();
//            resp.sendRedirect(perfil+"/index.jsp");
                req.setAttribute("login", l);
                req.setAttribute("cursos", cursoDAO.getAll());
                req.setAttribute("disciplinas", cursoDAO.disciplinasGetAll());
                req.setAttribute("cursoDisciplina", cursoDAO.disciplinasPorCurso());
                req.setAttribute("size", cursoDAO.disciplinasPorCurso().size());
                req.getSession().setAttribute("usuario", l);
                req.getRequestDispatcher(perfil + "/index.jsp").forward(req, resp);

            } else {
                PrintWriter out = resp.getWriter();

                out.println("<script type=\"text/javascript\">");
                out.println("location='inicio.jsp';");
                out.println("alert('Usuário ou senha inválidos!');");
                out.println("</script>");
            }

        }

    }

}
