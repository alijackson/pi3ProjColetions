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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author micro
 */
public class FuncionarioDAO {

    public FuncionarioDAO() {
    }

    private final SimpleDateFormat dataEntrada = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat dataBanco = new SimpleDateFormat("yyyy-MM-dd");

    public void inserir(Funcionario f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "INSERT INTO FUNCIONARIO(NOME,CPF,EMAIL,CARGO,SENHA,LOGIN,DTNASCIMENTO) VALUES (?,?,?,?,?,?,?)");

            String dataConvertida = dataEntrada.format(dataBanco.parse(f.getDataNascimento()));

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getCargo());
            stmt.setString(5, f.getSenha());
            stmt.setString(6, f.getLogin());
            stmt.setString(7, dataConvertida);

            stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro");

        } catch (ParseException ex) {

            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Funcionario> ApresentarFuncionarios() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> Funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("IDFUNCIONARIO"));
                f.setNome(rs.getString("NOME"));
                f.setCargo(rs.getString("CARGO"));
                f.setDataNascimento(rs.getString("DTNASCIMENTO"));
                f.setCpf(rs.getString("CPF"));
                f.setEmail(rs.getString("EMAIL"));

                Funcionarios.add(f);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return Funcionarios;
    }

    public void atualizar(Funcionario f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE FUNCIONARIO SET NOME = ?, DTNASCIMENTO = ?, CPF = ? "
                    + "EMAIL = ?, CARGO = ?,  SENHA = ?  WHERE IDFUNCIONARIO = ? ");

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDataNascimento());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getCargo());
            stmt.setString(6, f.getSenha());
            stmt.setInt(7, f.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void excluir(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Funcionario pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario f = new Funcionario();

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                f.setNome(rs.getString("NOME"));
                f.setCpf(rs.getString("CPF"));
                f.setEmail(rs.getString("EMAIL"));
                f.setCargo(rs.getString("CARGO"));
                f.setSenha(rs.getString("SENHA"));
                f.setLogin(rs.getString("LOGIN"));
                f.setId(rs.getInt("IDFUNCIONARIO"));

                String dataConvertida = dataBanco.format(dataEntrada.parse(rs.getString("DTNASCIMENTO")));

                f.setDataNascimento(dataConvertida);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return f;
    }

    public boolean checarFuncionario(String rg) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE RG = ?");
            stmt.setString(1, rg);
            rs = stmt.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao verificar cadastro do cliente" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }

}
