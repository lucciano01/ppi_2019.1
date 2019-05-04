/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import java.util.Objects;

/**
 *
 * @author Luciano
 */
public class Curso {
    
    private Long id;
    private String nome;
    private String area;

    public Curso(Long id, String nome, String area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
    }
    
    public Curso(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }
    
    public Curso(){
        
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {   
      this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.area);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;

      
    }
   

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", area=" + area + '}';
    }

       
    
    
}
