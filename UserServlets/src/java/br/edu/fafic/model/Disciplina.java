/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

/**
 *
 * @author Luciano
 */
public class Disciplina {
    
    private Long id;
    private String nome;
    
    
    public Disciplina(){
        
    }

    public Disciplina(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

   

    public Disciplina(String nome) {
        this.nome = nome;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
    
}
