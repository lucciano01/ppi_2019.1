<%-- 
    Document   : index
    Created on : 27/02/2019, 21:00:48
    Author     : Luciano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.edu.fafic.model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/bootbox.min.js"></script>
        <script src="resources/js/bootbox.locales.min.js"></script>
        

        <title>JSP Page</title>
    </head>
    <body>


        <div class="panel panel-primary">
            <div class="panel-heading"> 
                <h3>Seja Bem Vindo, ${usuario.nome}</h3>

                <div class="dropdown" >
                    <button class="btn btn-default pull-right" 
                            type="button" 
                            id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Menu
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="#">Sair</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Alterar Senha</a></li>
                    </ul>
                </div>

            </div>

            <div class="panel-body">
                <div>   
                    <h4>Cadastrar Curso</h4>
                    <form action="curso" method="post">
                        <div class="form-group">
                            curso<input class="form-control" type="text" name="nome_curso" value="${curso.nome}"/><br/><br/>
                            area<input type="text" class="form-control" name="area" value="${curso.area}"/><br/><br/>
                            <input type="hidden" name="param" value="cad_curso"/>
                            <input type="submit" class="btn btn-primary" value="cadastrar curso"/>
                        </div> 
                    </form>
                    <br/><br/>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Lista de Cursos
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <tr>
                                    <td style="width: 100px;"><b>Curso</b></td>
                                    <td style="width: 100px;"><b>Area</b></td>
                                </tr> 
                                <c:forEach  items="${cursos}" var="curso">
                                    <tr>
                                        <td>${curso.nome}</td>
                                        <td>${curso.area}</td>
                                    </tr>
                                </c:forEach>
                            </table> <br/><br/> 
                        </div>
                    </div>     
                </div><br/><br/>
            </div>
        </div>


        <div class="panel panel-primary">
            <div class="panel-body">
                <h4>Cadastrar Disciplina</h4>
                <div class="${color}" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>

                <form action="curso" method="post">
                    <div class="form-group">
                        disciplina<input type="text" class="form-control" name="nome_disciplina" value="${disciplina.nome}"/><br/><br/>
                        <input type="hidden" name="param" value="cad_disciplina"/>
                        <input type="hidden" name="idDisciplina" value="${disciplina.id}"/>
                        <input type="submit" class="btn btn-primary" value="salvar"/>
                    </div>  
                </form>
                <br/><br/>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Lista de Disciplinas
                    </div>
                    <div class="table-responsive">    
                        <table class="table table-striped">
                            <tr>
                                <th style="width: 200px;"><b>Disciplina</b></th>
                                <th class="actions" style="width: 200px;"><b>Ação</b></th>

                            </tr> 
                            <c:forEach  items="${disciplinas}" var="disciplina">
                                <tr>
                                    <td>${disciplina.nome}</td>
                                    <td>

                                        <form action="curso" method="post">
                                            <input class="btn btn-warning" type="submit" value="editar" hidden="editar" name="param">
                                            <input type="hidden" name="idDisciplina" value="${disciplina.id}"/>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirm">excluir</button>
                                            <div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-hidden="true">
                                                <div class="modal-dialog modal-md">

                                                    <div class="modal-content">
                                                        <div class="modal-body">
                                                            <p> QUER REALMENTE FAZER ISSO?? NÂO POR FAVOR, EU TENHO FILHOS</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" data-dismiss="modal" class="btn btn-danger">excluir</button>
                                                            <button type="button" data-dismiss="modal" class="btn btn-default">cancelar</button>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </form>
                                    </td>
                                </tr>

                            </c:forEach>
                        </table> 

                    </div>
                </div>
                <br/>
            </div>    
        </div><br/><br/>
        <div style="border: 5px solid; border-color: cadetblue;">
            <div style="margin-left: 10px;">   
                <h4>Vincular Disciplina/Curso</h4>

                <form action="curso" method="post">
                    <select name="cursoSelecionado">
                        <option label="Selecione">Selecione o Curso</option>
                        <c:forEach items="${cursos}" var="curso">
                            <option value="${curso.id}">${curso.nome}</option>
                        </c:forEach>
                    </select>  
                    <br/> <br/>
                    Disciplinas
                    <br/> <br/>
                    <c:forEach  items="${disciplinas}" var="disciplina">
                        <input name="chekDis" type="checkbox"  value="${disciplina.id}">${disciplina.nome} <br/>
                    </c:forEach>
                    <br/>
                    <input type="submit" value="vincular"/>
                    <input type="hidden" name="param" value="vinc"/>
                </form>
                <br/>
            </div>     
        </div><br/><br/>

        <div style="border: 5px solid; border-color: cadetblue;">
            <div style="margin-left: 10px;">   
                <h4>Lista de Disciplinas por Curso</h4><br/>

                <c:forEach items="${cursoDisciplina}" var="curso">
                    <b>${curso.curso.nome}</b><br/>
                    <c:forEach items="${curso.disciplinas}"    var="disciplina">
                        <i> ${disciplina.nome}</i><br/>

                    </c:forEach>
                    <br/>
                </c:forEach>
                <br/>

            </div>     
        </div><br/><br/>

    </body
</html>
