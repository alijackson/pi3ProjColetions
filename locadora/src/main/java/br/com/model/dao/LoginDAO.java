/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author micro
 */
public class LoginDAO {

    public LoginDAO() {
    }

    public boolean checarLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                result = true;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }

    public String verificarPermissao(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String cargo = "";

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                cargo = rs.getString("CARGO");

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cargo;

    }

}
