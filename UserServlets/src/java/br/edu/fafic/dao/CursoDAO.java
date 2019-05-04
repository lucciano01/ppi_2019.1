/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.CursoDisciplinas;
import br.edu.fafic.model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano
 */
public class CursoDAO {

    private Connection con;

    public void cadastraCurso(Curso curso) {
        con = ConnectionFactory.getConnectionFactory().getConnection();
        try {
            String sql = "insert into curso values (default,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getArea());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Curso> getAll() {
        con = ConnectionFactory.getConnectionFactory().getConnection();
        List<Curso> cursos = new ArrayList();
        try {
            String sql = "select * from curso";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getLong("id"), rs.getString("nome"), rs.getString("area")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursos;
    }

    public void cadastraDisciplina(Disciplina disciplina) {
        try {
            con = ConnectionFactory.getConnectionFactory().getConnection();
            if (!validaDisciplina(disciplina)) {
                String sql = "insert into disciplina values(default,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, disciplina.getNome().toUpperCase());
                ps.executeUpdate();
                ps.close();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Disciplina getDisciplinaById(Long id) {
        Disciplina d = new Disciplina();
        try {
            con = ConnectionFactory.getConnectionFactory().getConnection();
            String sql = "select * from disciplina where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getLong("id"));
                d.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public void updateDisciplina(Disciplina disciplina){
        try {
        String sql  = "update disciplina set nome = ? where id = ?";
        con = ConnectionFactory.getConnectionFactory().getConnection();
        PreparedStatement ps;
            ps = con.prepareStatement(sql);
        ps.setString(1, disciplina.getNome());
        ps.setLong(2, disciplina.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean validaDisciplina(Disciplina disciplina) {
        boolean result = false;
        try {
            con = ConnectionFactory.getConnectionFactory().getConnection();
            String sql = "select * from disciplina where nome = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, disciplina.getNome().toUpperCase());
            ResultSet rs = ps.executeQuery();
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean validaDisciplinaCurso(Long idDisciplina, Long idCurso) {
        boolean result = false;
        try {
            String sql = "select * from curso_disciplina where id_disciplina=? and id_curso=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idDisciplina);
            ps.setLong(2, idCurso);
            ResultSet rs = ps.executeQuery();
            result = rs.next();

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void vincularDisciplinaCurso(Long idDisciplina, Long idCurso) {
        try {
            con = ConnectionFactory.getConnectionFactory().getConnection();
            if (!validaDisciplinaCurso(idDisciplina, idCurso)) {
                String sql = "insert into curso_disciplina values(?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, idDisciplina);
                ps.setLong(2, idCurso);
                ps.executeUpdate();
                ps.close();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Disciplina> disciplinasGetAll() {
        con = ConnectionFactory.getConnectionFactory().getConnection();
        List<Disciplina> disciplinas = new ArrayList();
        try {
            String sql = "select * from disciplina";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinas.add(new Disciplina(rs.getLong("id"), rs.getString("nome")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return disciplinas;
    }

    public List<Disciplina> disciplinasPorCurso(Long idCurso) {
        List<Disciplina> disciplinasDoCurso = new ArrayList();
        try {
            con = ConnectionFactory.getConnectionFactory().getConnection();
            String sql = "select d.* from disciplina d\n"
                    + "join curso_disciplina cd on cd.id_disciplina = d.id\n"
                    + "join curso c on c.id=cd.id_curso\n"
                    + "where c.id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinasDoCurso.add(new Disciplina(rs.getLong("id"), rs.getString("nome")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinasDoCurso;
    }

    public List<CursoDisciplinas> disciplinasPorCurso() {
        List<CursoDisciplinas> disciplinasDoCurso = new ArrayList();
        List<Curso> cursos = getAll();
        CursoDisciplinas cursoDisciplina;
        for(Curso c : cursos){
            cursoDisciplina = new CursoDisciplinas();
            cursoDisciplina.setCurso(c);
            cursoDisciplina.setDisciplinas(disciplinasPorCurso(c.getId()));
            disciplinasDoCurso.add(cursoDisciplina);
        }
        return disciplinasDoCurso;
    }
}
