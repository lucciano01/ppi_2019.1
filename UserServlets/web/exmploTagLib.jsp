<%-- 
    Document   : exmploTagLib
    Created on : 28/03/2019, 19:57:21
    Author     : Luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo forEach</title>
    </head>
    <body>
        <h1>Iterando em Lista Simples</h1>
        <table border="1">
            <tr>
                <td>Numero</td>
                <td>Quadrado</td>
            </tr>
            <c:forEach begin="1" end="10" var="num" step="3">
                <tr>
                    <td>
                        ${num}  
                    </td>
                    <td>${num*num}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>


        <h2>Iterando em Lista do BD</h2>
        <c:forEach items="${logs}" var="login">
            <br/>
            Nome: ${login.nome}<br/>
            Email: ${login.email}<br/>
            Perfil: ${login.perfil}
        </c:forEach>
        <br/>


        <h2>Iterando em Lista Aninhada</h2>  
        <c:forEach items="${pessoa}" var="p">
            <br/>
            Nome: ${p.nome}</br>
            Pratos preferidos:<br/>
            <c:forEach items="${p.pratoPreferido}" var="prato">
                <b>${prato}</b><br/>
            </c:forEach>
        </c:forEach>

        <h2>Tag condicional IF</h2> 
        <c:forEach begin="1" end="10" var="num">
            <c:if test="${num % 2 == 0}">
                Número Par: ${num}
            </c:if>
            <c:if test="${num > 5}">
                Numero maior que 5 ${num}
            </c:if>
        </c:forEach>

        <h2>Tag condicional IF</h2> 
        <table border="1">
            <tr>
                <td>Nota</td>
                <td>Situação</td>
            </tr>   
            <c:forEach begin="1" end="10" var="num">
                <tr>
                    <td>${num}</td>
                    <td>
                        <c:if test="${num >= 7}">
                            <b style="color: blue">Aprovado</b>
                        </c:if>
                        <c:if test="${num < 7}">
                            <b style="color: red">Reprovado</b>
                        </c:if>    
                    </td>
                </tr>
                
            </c:forEach>
                
        </table>
        
        <h2>Exibindo Conteúdo por Perfil</h2>
        
        <c:if test="${perfil eq 'diretor'}">
            <c:import url="diretor/index.jsp" var="page"/>
            ${page}
        </c:if>
        <c:if test="${perfil eq 'professor'}">
            <c:import url="professor/index.jsp" var="page"/>
            ${page}
        </c:if>
        <c:if test="${perfil eq 'coordenador'}">
            <b>Bem vindo Coordenador</b>
        </c:if>
            <br/>
            <c:choose>
                <c:when test="${pais eq 'brasil'}">
                    <b>Feijoada</b>
                </c:when>
                <c:when test="${pais eq 'italia'}">
                    <b>Pizza</b>
                </c:when>
                <c:when test="${pais eq 'japao'}">
                    <b>Sushi</b>
                </c:when>
                <c:otherwise>
                    <b>Então vc é vegetariano</b>
                </c:otherwise>
            </c:choose>  <br/>
            
            
            
            
       

    </body>
</html>
