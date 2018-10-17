/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ClienteDAO {

    public ClienteDAO() {

    }

    public void inserir(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO Cliente(nome,dataNascimento,telefoneFixo,telefoneCelular,email,numeroCNH, cpf) "
                    + "VALUES(?,?,?,?,?,?,?)");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDataNascimento());
            stmt.setString(3, c.getTelefoneFixo());
            stmt.setString(4, c.getTelefoneCelular());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNumeroCNH());
            stmt.setString(7, c.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    /**
     *
     * @return
     */
    public List<Cliente> ApresentarClientes() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setTelefoneFixo(rs.getString("telefoneFixo"));
                c.setTelefoneCelular(rs.getString("telefoneCelular"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getString("numeroCNH"));
                c.setCpf(rs.getString("cpf"));
                clientes.add(c);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return clientes;
    }

    public void atualizar(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE Cliente SET nome = ?,dataNascimento = ?,telefoneFixo = ?,"
                    + " telefoneCelular = ?,email = ? , numeroCNH = ?, cpf = ? WHERE id = ?");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getTelefoneFixo());
            stmt.setString(4, c.getTelefoneCelular());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNumeroCNH());
            stmt.setString(7, c.getCpf());
            stmt.setInt(8, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void editar(Cliente c, int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setTelefoneFixo(rs.getString("telefoneFixo"));
                c.setTelefoneCelular(rs.getString("telefoneCelular"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getString("numeroCNH"));
                c.setCpf(rs.getString("cpf"));

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

            stmt = con.prepareStatement("DELETE FROM Cliente WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> Pesquisa(String cpf) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setTelefoneFixo(rs.getString("telefoneFixo"));
                c.setTelefoneCelular(rs.getString("telefoneCelular"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getString("numeroCNH"));
                c.setCpf(rs.getString("cpf"));

                clientes.add(c);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return clientes;
    }

    public boolean ChecarCliente(String cpf) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if (rs.next()) {

                result = true;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return result;
    }

}
