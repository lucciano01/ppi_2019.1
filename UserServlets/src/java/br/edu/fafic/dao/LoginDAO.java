/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Contato;
import br.edu.fafic.model.Login;
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
public class LoginDAO {

    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();

    public void cadastraLogin(Login login) {
        String sql = "insert into login values(default,?,?)";
        int idLogin = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login.getNome());
            ps.setString(2, login.getEmail());
            ps.executeQuery();
            
            sql = "select max(id) from login";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
               idLogin = rs.getInt(1);
            }
           
            
            sql = "insert into contato values(default,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getContato().getTelefoneResidencial());
            ps.setString(2, login.getContato().getTelefoneComercial());
            ps.setString(3, login.getContato().getTelefoneCelular());
            ps.setInt(4, idLogin);
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Login> getAll() {
        List<Login> logins = new ArrayList();
        String sql = "select * from login";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                logins.add(new Login(rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("perfil")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logins;
    }

    public Login getLoginById(Long id) {
        Login login = new Login();
        String sql = "select * from login where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                login.setId(rs.getLong("id"));
                login.setNome(rs.getString("nome"));
                login.setEmail(rs.getString("email"));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return login;
    }

    public void updateLogin(Login login) {
        String sql = "update login set nome = ?, email = ? where id = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getNome());
            ps.setString(2, login.getEmail());
            ps.setLong(3, login.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Long id){
        String sql = "delete from login where id=?";
        PreparedStatement ps;
        try {
        ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
        con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Login autenticacao(String nome, String email){
        Login login = null;
        String sql = "select * from login where nome = ? and email = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
       
        ps.setString(1, nome);
        ps.setString(2, email);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            login = new Login(rs.getLong("id"),rs.getString("nome"), rs.getString("email"), rs.getString("perfil"));
        }
        
        ps.close();
        con.close();
        
         } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
}
