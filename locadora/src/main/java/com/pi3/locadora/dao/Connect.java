/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alijackson.msilva
 */
public class Connect {
    public static Connection getConnection() {
        
        String caminho = "127.0.0.1";
        String schema = "locadora";
        String user = "root";
        String senha = "1234";

        Connection conn = null;
        try 
        {            
            String url = "jdbc:mysql://"+caminho+"/"+schema;

            conn = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        catch (Exception e) {
                e.printStackTrace();
        }

        return conn;

    }
}
