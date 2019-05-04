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
public class Pessoa {
    
    private String nome;
    private List<String> pratoPreferido;

    public Pessoa(String nome, List<String> pratoPreferido) {
        this.nome = nome;
        this.pratoPreferido = pratoPreferido;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getPratoPreferido() {
        return pratoPreferido;
    }

    public void setPratoPreferido(List<String> pratoPreferido) {
        this.pratoPreferido = pratoPreferido;
    }
    
    
    
}
