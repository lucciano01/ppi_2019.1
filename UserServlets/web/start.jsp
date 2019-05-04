<%-- 
    Document   : start
    Created on : 28/03/2019, 19:06:55
    Author     : Luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Trabalhando com Cookies</h1>
        <form action="cookies.jsp">
            <input type="text" name="nome"/>
            <input type="submit" value="enviar"/>
        </form>
        <%
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                if(c.getName().equalsIgnoreCase("nomeUsuario")){
                    response.sendRedirect("cookies.jsp");
                }
            }
        
        %>
    </body>
</html>
