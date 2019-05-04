/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano
 */
public class ConnectionFactory {
    
    private static ConnectionFactory connectionFactory;
    
    private ConnectionFactory(){
        
    }
    
    public static ConnectionFactory getConnectionFactory(){
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        
        return connectionFactory;
    }
    
    public Connection getConnection(){
       Connection con = null; 
        try {
            Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuario", "postgres", "123456");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
