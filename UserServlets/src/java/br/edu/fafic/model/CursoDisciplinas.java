/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import java.util.List;

/**
 *
 * @author Luciano
 */
public class CursoDisciplinas implements Comparable<Curso> {
    
    private Curso curso;
    
    private List<Disciplina> disciplinas;
    
    public CursoDisciplinas(){
        
    }

    public CursoDisciplinas(Curso curso, List<Disciplina> disciplinas) {
        this.curso = curso;
        this.disciplinas = disciplinas;
    }
    
    

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int compareTo(Curso o) {
        return this.compareTo(o);
    }

   
    
    
    
    
}
