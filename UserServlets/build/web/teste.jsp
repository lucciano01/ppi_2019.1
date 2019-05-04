<%-- 
    Document   : teste
    Created on : 15/03/2019, 17:46:29
    Author     : Luciano
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.fafic.model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>
            Logins
        </h2>
        <%
            List<Login> logs = (List<Login>)request.getAttribute("logins");
        %>
        <%for(Login l : logs){%>
        <br/>
            <%=l.getNome()%>
            <%=l.getEmail()%>
         <%}%>   
    </body>
</html>
