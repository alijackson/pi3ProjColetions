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
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ClienteDAO {

    public ClienteDAO() {

    }

    public String inserir(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String log = "";
        try 
        {

            stmt = con.prepareStatement("INSERT INTO cliente "
                    + "(nome,dtNascimento,telFixo, "
                    + "telCel,email,cnh,cpf,rg,idade,enable) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,1)");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDataNascimento());
            stmt.setString(3, c.getTelefoneFixo());
            stmt.setString(4, c.getTelefoneCelular());
            stmt.setString(5, c.getEmail());
            stmt.setLong(6, c.getNumeroCNH());
            stmt.setString(7, c.getCpf());
            stmt.setString(8, c.getRg());
            stmt.setInt(9, c.getIdade());

            stmt.execute();

        } 
        catch (SQLException ex) 
        {
            log = ex.toString();
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return log;
    }

    /**
     *
     * @return
     */
    public ArrayList<Cliente> ApresentarClientes() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE enable=1");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dtNascimento"));
                c.setTelefoneFixo(rs.getString("telFixo"));
                c.setTelefoneCelular(rs.getString("telCel"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getInt("cnh"));
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

    public String atualizar(Cliente c) {
        
        String retur = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, dtNascimento = ?, "
                    + "idade = ?, cpf = ?, "
                    + "telFixo = ?, telCel = ?,  email = ?, "
                    + "CNH = ?, rg = ?  WHERE idCliente = ? ");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDataNascimento());
            stmt.setInt(3, c.getIdade());
            stmt.setString(4, c.getCpf());
            stmt.setString(5, c.getTelefoneFixo());
            stmt.setString(6, c.getTelefoneCelular());
            stmt.setString(7, c.getEmail());
            stmt.setInt(8, c.getNumeroCNH());
            stmt.setString(9, c.getRg());
            stmt.setInt(10, c.getId());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alteração feita com Sucesso!");

        } catch (SQLException ex) {
            retur = ex.toString();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return retur;     
    }
    /**
     * Função edita o usuario, 
     * Dando um update no banco de dados.
     * @param c
     * Infomação para fazer o update no banco.
     */
    public void editar(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE id = ?");
            stmt.setInt(1, c.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dtNascimento"));
                c.setTelefoneFixo(rs.getString("telFixo"));
                c.setTelefoneCelular(rs.getString("telCel"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getInt("cnh"));
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

            stmt = con.prepareStatement("UPDATE Cliente SET enable=2 WHERE idcliente = ?");
            stmt.setInt(1, id);
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, id);
            JOptionPane.showMessageDialog(null, "Excluído  com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Cliente Pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente c = new Cliente();

        try {
            

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE idcliente = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.first()) {
                c.setId(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dtNascimento"));
                c.setIdade(rs.getInt("idade"));
                c.setTelefoneFixo(rs.getString("telFixo"));
                c.setTelefoneCelular(rs.getString("telCel"));
                c.setEmail(rs.getString("email"));
                c.setNumeroCNH(rs.getInt("cnh"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return c;
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

            if (rs.next()) 
            {    
                result = true;
            }

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "erro ao verificar cadastro do cliente" + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }

}
