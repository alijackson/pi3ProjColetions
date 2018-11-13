/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author alijackson.msilva
 */
public class Connect {

    private static Connection conn = null;
    private static String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {

        // Informar caminho de acesso ao banco de dados.
        String ip = "127.0.0.1";
        // Informar porta de acesso ao banco. Padrao 3306
        String portaAcesso = "3306";
        // Nome do Schema do banco
        String nomeSchema = "locadora";
        String usuario = "root";
        String senha = "1234";
        //Informar o login senha de acesso ao banco de dados.
//        String usuario = "root";
//        String senha = "";

        System.setProperty("jdbc.Drivers", driver);
        // Organizando dados para efetuar a conexão
        String dbURL = "jdbc:mysql://"+ip+":"+portaAcesso+"/"+nomeSchema;

        //Propriedades para armazenamento de usuÃ¡rio e senha
        Properties properties = new Properties();
        properties.put("user", usuario);
        properties.put("password", senha);
        // Caso necessario, descomente esse comando para definir o fuso horario no banco.
//        properties.put("serverTimezone", "UTC");

        // Com todos os dados informados. inicia a conexão com o banco.
        conn = DriverManager.getConnection(dbURL, properties);


        return conn;

    }
    public static void closeConnection(java.sql.Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt) {
        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
