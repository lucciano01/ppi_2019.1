<%-- 
    Document   : pageInit
    Created on : 28/03/2019, 19:56:27
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
        <h1>Iniciando Tag lib</h1>
        <form action="exmploTagLib.jsp">
            <input type="submit" value="enviar"/>
        </form>
        <br/>
        <h1>Iniciando Tag lib</h1>
        <form action="tag">
            <input type="submit" value="exibir lista do BD"/>
        </form>
        <h1>Selecione o perfil</h1>
        <form action="tag" method="post">
            <select name="perfil">
                <option value="diretor">Diretor</option>
                <option value="coordenador">Coordenador</option>
                <option value="professor">Professor</option>
            </select>
            <input type="submit" value="acessar"/>
        </form>
        <h1>Selecione o país</h1>
         <form action="tag" method="post">
            <select name="pais">
                <option value=""></option>
                <option value="brasil">Brasil</option>
                <option value="italia">Italia</option>
                <option value="japao">Japao</option>
            </select>
            <input type="submit" value="enviar"/>
        </form>
        
    </body>
</html>
