/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Cliente;
import br.com.model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        ResultSet rs = null;

        try {

            stmt = con.prepareCall("INSERT INTO FUNCIONARIO(NOME,DTNASCIMENTO,RG,CPF,EMAIL,CARGO,SENHA) VALUES (?,?,?,?,?,?,?)");

            Date dataConvertida = converterData(dataEntrada, dataBanco, f);

            stmt.setString(1, f.getNome());
            stmt.setDate(2, dataConvertida);
            stmt.setString(3, String.valueOf(f.getRg()));
            stmt.setString(4, String.valueOf(f.getCpf()));
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getCargo());
            stmt.setInt(7, f.getSenha());

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar" + e);

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
            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("IDFUNCIONARIO"));
                f.setNome(rs.getString("NOME"));
                f.setDataNascimento(rs.getString("DTNASCIMENTO"));
                f.setRg(rs.getString("RG").charAt(0));
                f.setCpf(rs.getString("CPF").charAt(0));
                f.setEmail(rs.getString("EMAIL"));
                f.setCargo(rs.getString("EMAIL"));
                f.setSenha(rs.getInt("SENHA"));

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

        String retur = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE FUNCIONARIO SET NOME = ?, DTNASCIMENTO = ? RG = ?, CPF = ? "
                    + "EMAIL = ?, EMAIL = ?,  SENHA = ?  WHERE IDFUNCIONARIO = ? ");

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDataNascimento());
            stmt.setString(3, String.valueOf(f.getRg()));
            stmt.setString(4, String.valueOf(f.getCpf()));
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getCargo());
            stmt.setInt(7, f.getSenha());
            stmt.setInt(8, f.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alteração feita com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void editar(Funcionario f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, f.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getDataNascimento());
                stmt.setString(3, String.valueOf(f.getRg()));
                stmt.setString(4, String.valueOf(f.getCpf()));
                stmt.setString(5, f.getEmail());
                stmt.setString(6, f.getCargo());
                stmt.setInt(7, f.getSenha());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }

    }

    public void excluir(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, id);
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluído  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Funcionario Pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario f = new Funcionario();

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getDataNascimento());
                stmt.setString(3, String.valueOf(f.getRg()));
                stmt.setString(4, String.valueOf(f.getCpf()));
                stmt.setString(5, f.getEmail());
                stmt.setString(6, f.getCargo());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
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

    public Date converterData(SimpleDateFormat dataEntrada, SimpleDateFormat dataBanco, Funcionario f) {

        String data;
        Date dataConvertida = null;

        try {
            data = dataBanco.format(dataEntrada.parse(f.getDataNascimento()));
            dataConvertida = java.sql.Date.valueOf(data);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataConvertida;

    }
}
