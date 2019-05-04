<%-- 
    Document   : index
    Created on : 21/03/2019, 19:33:47
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
        <form action="show" method="post">
        <h1>Lista de Veiculos</h1><br><br>
        <select name="veiculos">
            <option value="Ferrari">Ferrari</option>
            <option value="BMW">BMW</option>
            <option value="Fusca">Fusca</option>
        </select><br/><br/>
        Sexo:
        <input type="radio" name="sexo" value="Masculino">Masculino
        <input type="radio" name="sexo" value="Feminino">Feminino
        <br/>
        Idiomas:
        <input type="checkbox" name="idioma" value="Italiano">Italiano
        <input type="checkbox" name="idioma" value="Espanhol">Espanhol
        <input type="checkbox" name="idioma" value="Ingles">Ingles
        <br/>
        <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
