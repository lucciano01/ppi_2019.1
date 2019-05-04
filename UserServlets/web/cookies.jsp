<%-- 
    Document   : cookies
    Created on : 28/03/2019, 19:10:28
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
        <%
            String nome = request.getParameter("nome");
          if(nome != null)  {
              Cookie cookie = new Cookie("nomeUsuario", nome);
              cookie.setMaxAge(60*60*24);
              response.addCookie(cookie);
          }else{
              Cookie [] cookies = request.getCookies();
              for(Cookie c : cookies){
                  if(c.getName().equalsIgnoreCase("nomeUsuario")){
                      nome = c.getValue();
                  }
              }
          }

        %>
        <h3>Seja bem vindo <%=nome%></h3>
        <img src="imagens/ferrari.jpg"/>
    </body>
</html>
