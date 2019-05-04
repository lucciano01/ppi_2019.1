<%-- 
    Document   : erro
    Created on : 27/02/2019, 21:31:17
    Author     : Luciano
--%>

<%@page contentType="text/html"  language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=request.getParameter("nome")%> </h1><br/>
        <h1><%=request.getParameter("email")%> </h1><br/>
        <a href="inicio.jsp">voltar</a>
    </body>
</html>
