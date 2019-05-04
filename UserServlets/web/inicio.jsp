<%-- 
    Document   : inicio
    Created on : 19/02/2019, 19:44:32
    Author     : Luciano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="br.edu.fafic.model.Login"%>
<%@page import="br.edu.fafic.dao.LoginDAO"%>
<%@page contentType="text/html; UTF-8" language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"  charset="UTF-8"  content="text/html">
        <title>JSP Page</title>
        <script type="text/javascript">
            function excluir(id, nome) {
                if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
                    location.href = "cadLogin?id=" + id + "&param=excluir";
                }
            }
            function teste(login) {
                console.log(login.value);
                location.href = "cadLogin?email=" + login + "&param=teste";
            }
            function validaform() {
                if (document.cad.nome.value === "") {
                    alert("O campo nome é obrigatório!");
                }
                if (document.cad.email.value === "") {
                    alert("O campo email é obrigatório!");
                }
            }
        </script>
    </head>
    <body>
        <p id="msg"></p>
        <h2>Logar</h2>
         <form name="formLogar" action="log" method="post" accept-charset="utf8">
            nome<input type="text" name="nome"/> <br/><br/>
            email<input type="text" name="email"/> <br/><br/>
            <br/>
            <input type="submit" value="logar" />
        </form>
       
       
        <form name="cadLogin" action="cadLogin" method="post" accept-charset="utf8">
            nome<input type="text" name="nome"/> <br/><br/>
            email<input type="text" name="email"/> <br/><br/>
            telefone1<input type="text" name="telefone_res"/> <br/>
            telefone2<input type="text" name="telefone_com"/> <br/>
            telefone3<input type="text" name="telefone_cel"/> <br/>
           
        <br/>
            <input type="hidden" value="cadastrar" name="param"/>
            <input type="submit" value="logar" />
        </form>
        <br/>
       
        
        <%
            LoginDAO dao = new LoginDAO();
            List<Login> logins = dao.getAll();
        %>
        <b>Lista de Logins</b><br/><br/>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Email</td>

                <td colspan="2" style="text-align: center;">Ação</td>
            </tr>
            <%for (Login login : logins) {%>
            <tr>
                <td><%=login.getId()%></td>
                <td><%=login.getNome()%></td>
                <td><%=login.getEmail()%></td>
                <td><a  href="edit.jsp?id=<%=login.getId()%>"><img src="imagens/edit.png"/></a></td>
                <td><a  href="javascript://" onclick="excluir(<%=login.getId()%>, '<%=login.getNome()%>')"><img src="imagens/lixo.png"/></a></td>

            </tr>
            <%}%>
        </table>
        <br/>
       
    </body>
</html>
