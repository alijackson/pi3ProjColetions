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
import java.util.ArrayList;

/**
 *
 * @author micro
 */
public class LoginDAO {

    private byte ativo;

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
                setAtivo((byte) rs.getInt("ATIVO"));
                result = true;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }

    public String retornarFilial(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String filial = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario f = new Funcionario();

                filial = rs.getString("FILIALFUNCIONARIO");

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return filial;
    }

    public byte getAtivo() {
        return ativo;
    }

    public void setAtivo(byte ativo) {
        this.ativo = ativo;
    }

}
