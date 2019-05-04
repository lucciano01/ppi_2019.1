<%-- 
    Document   : teste
    Created on : 25/03/2019, 19:34:58
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
        <p> Seja bem vindo diretor da sessao ${usuario.nome} </p>      
        <p> Seja bem vindo diretor da requisicao ${login.email} </p><br/>
       
        <form action="${pageContext.request.contextPath}/log" method="post">
            <input type="hidden" name="param" value="logout"/>
            <input type="submit" value="logout"/>
        </form>
    </body>
</html>
