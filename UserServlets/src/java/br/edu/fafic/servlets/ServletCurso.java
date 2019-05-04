/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.CursoDAO;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.CursoDisciplinas;
import br.edu.fafic.model.Disciplina;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Luciano
 */
@WebServlet("/curso")
public class ServletCurso extends HttpServlet {

    private CursoDAO cursoDAO;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private Disciplina d;
    private List<CursoDisciplinas> cursoDisciplinas;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String mensagem = "";
        String color = "";
        cursoDAO = new CursoDAO();
        String param = req.getParameter("param");
        String idDisciplina = req.getParameter("idDisciplina");
        String disciplina = req.getParameter("nome_disciplina");
        if (param.equalsIgnoreCase("cad_curso")) {
            String nome = req.getParameter("nome_curso");
            String area = req.getParameter("area");
            Curso curso = new Curso(nome, area);
            cursoDAO.cadastraCurso(curso);

        } else if (param.equalsIgnoreCase("cad_disciplina")) {
            if (idDisciplina == null || idDisciplina.equals("")) {
                d = new Disciplina();
                d.setNome(disciplina);
                if (!cursoDAO.validaDisciplina(d)) {
                    cursoDAO.cadastraDisciplina(d);
                    color = "alert alert-success";
                    mensagem = "Operação realizada com sucesso!";

                } else {
                    color = "alert alert-warning";
                    mensagem = "Operação não realizada. Já existe uma disciplina " + d.getNome() + " na base de dados";
                }
            } else {
                d = new Disciplina(Long.valueOf(idDisciplina), disciplina);
                if (!cursoDAO.validaDisciplina(d)) {
                    cursoDAO.updateDisciplina(d);
                    color = "alert alert-success";
                    mensagem = "Operação realizada com sucesso!";

                } else {
                    color = "alert alert-warning";
                    mensagem = "Operação não realizada. Já existe uma disciplina " + d.getNome() + " na base de dados";
                }

            }
        }else if(param.equalsIgnoreCase ( "vinc")){
           String idCurso = req.getParameter("cursoSelecionado");
        String[] idsDisciplinasSelecionadas = req.getParameterValues("chekDis");
        for (String s : idsDisciplinasSelecionadas) {
            cursoDAO.vincularDisciplinaCurso(Long.valueOf(s), Long.valueOf(idCurso));
        }

    }else if(param.equalsIgnoreCase ("editar")&&(idDisciplina != null)){
            req.setAttribute("disciplina", cursoDAO.getDisciplinaById(Long.valueOf(idDisciplina)));
    }
    cursos  = cursoDAO.getAll();
    disciplinas  = cursoDAO.disciplinasGetAll();
    cursoDisciplinas =  new ArrayList();
    for(Curso c : cursos){
        cursoDisciplinas.add(new CursoDisciplinas(c, cursoDAO.disciplinasPorCurso(c.getId())));
    }
    req.setAttribute("cursoDisciplina", cursoDisciplinas);
    req.setAttribute ("cursos", cursos);
    req.setAttribute ("disciplinas", disciplinas);
    req.setAttribute ("color", color);
    req.setAttribute ("mensagem", mensagem);
    req.getRequestDispatcher ("diretor/index.jsp").forward(req, res);

    }

}
