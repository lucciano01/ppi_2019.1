/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.LoginDAO;
import br.edu.fafic.model.Contato;
import br.edu.fafic.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/cadLogin")
public class ServletLogin extends HttpServlet {
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    try{    
        Login login = null;
        LoginDAO dao = new LoginDAO();
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String perfil = req.getParameter("perfil");
        String type = req.getParameter("param");
        String telResidencial = req.getParameter("telefone_res");
        String telComercial = req.getParameter("telefone_com");
        String telCelular = req.getParameter("telefone_cel");
        Contato contato = new Contato(telResidencial, telComercial, telCelular);
        if(type.equalsIgnoreCase("cadastrar")){
            login = new Login(nome, email, perfil);
//            login.setContato(contato);
            
            dao.cadastraLogin(login);
        }else if(type.equalsIgnoreCase("editar")){
         Long id = Long.valueOf(req.getParameter("id"));
            login = new Login(id, nome, email);
            dao.updateLogin(login);
            
        }else if(type.equalsIgnoreCase("excluir")){
            Long id = Long.valueOf(req.getParameter("id"));
            dao.excluir(id);
        }
    }catch(Exception ex){
//        System.out.println("Erro: " +ex.getMessage());
    }
        
                PrintWriter out = resp.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("location='inicio.jsp';");
                out.println("alert('Operação realizada com sucesso!');");
                out.println("</script>");
        
    }
    
    
}
