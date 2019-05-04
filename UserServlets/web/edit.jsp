<%-- 
    Document   : edit
    Created on : 22/02/2019, 21:37:25
    Author     : Luciano
--%>

<%@page import="br.edu.fafic.model.Login"%>
<%@page import="br.edu.fafic.dao.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Long id = Long.valueOf(request.getParameter("id"));
            LoginDAO dao = new LoginDAO();
            Login login = dao.getLoginById(id);
        %>
        <b>Atulizar Cadastro</b>
        <form name="cad" action="cadLogin" method="post">
            nome<input type="text" name="nome" value="<%=login.getNome()%>"><br/><br/>
            email<input type="text" name="email" value="<%=login.getEmail()%>"><br/><br/>
            <input type="hidden" value="editar" name="param"/>
            <input type="hidden" value="<%=login.getId()%>" name="id"/>
            <input type="submit" value="atualizar"/>
        </form>
    </body>
</html>
