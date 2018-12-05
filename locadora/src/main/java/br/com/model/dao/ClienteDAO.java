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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class ClienteDAO {

    public ClienteDAO() {

    }

    private final SimpleDateFormat dataEntrada = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat dataBanco = new SimpleDateFormat("yyyy-MM-dd");

    public void inserir(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO CLIENTE "
                    + "(NOME,DTNASCIMENTO,TELFIXO, "
                    + "TELCEL,EMAIL,CNH,CPF,RG,ENABLE) "
                    + "VALUES(?,?,?,?,?,?,?,?,1)");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDataNascimento());
            stmt.setString(3, c.getTelefoneFixo());
            stmt.setString(4, c.getTelefoneCelular());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNumeroCNH());
            stmt.setString(7, c.getCpf());
            stmt.setString(8, c.getRg());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Cliente> apresentarClientes() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE ENABLE = 1");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("IDCLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setDataNascimento(c.convertDate(rs.getString("DTNASCIMENTO")));
                c.setTelefoneFixo(rs.getString("TELFIXO"));
                c.setTelefoneCelular(rs.getString("TELCEL"));
                c.setEmail(rs.getString("EMAIL"));
                c.setNumeroCNH(rs.getString("CNH"));
                c.setCpf(rs.getString("CPF"));
                
                clientes.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return clientes;
    }

    public void atualizar(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE CLIENTE SET NOME = ?, DTNASCIMENTO = ?, "
                    + "TELFIXO = ?, TELCEL = ?, "
                    + "EMAIL = ?, CNH = ?,  RG = ?, "
                    + "CPF = ? WHERE IDCLIENTE = ? ");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDataNascimento());
            stmt.setString(3, c.getTelefoneFixo());
            stmt.setString(4, c.getTelefoneCelular());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNumeroCNH());
            stmt.setString(7, c.getRg());
            stmt.setString(8, c.getCpf());
            stmt.setInt(9, c.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public String excluir(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE CLIENTE SET ENABLE = 0 WHERE IDCLIENTE = ?");
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            return ex.toString();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }

    public Cliente pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente c = new Cliente();

        try {

            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE IDCLIENTE = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.first()) {
                c.setId(rs.getInt("IDCLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setDataNascimento(rs.getString("DTNASCIMENTO"));
                c.setTelefoneFixo(rs.getString("TELFIXO"));
                c.setTelefoneCelular(rs.getString("TELCEL"));
                c.setEmail(rs.getString("EMAIL"));
                c.setNumeroCNH(rs.getString("CNH"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return c;
    }

    public ArrayList<Cliente> buscar(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE ENABLE = 1 AND NOME LIKE ? ");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Cliente c = new Cliente();
                
                     
                String dataConvertida = dataEntrada.format(dataBanco.parse(rs.getString("DTNASCIMENTO")));

                c.setId(rs.getInt("IDCLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setDataNascimento(dataConvertida);
                c.setTelefoneFixo(rs.getString("TELFIXO"));
                c.setTelefoneCelular(rs.getString("TELCEL"));
                c.setEmail(rs.getString("EMAIL"));
                c.setNumeroCNH(rs.getString("CNH"));
                c.setCpf(rs.getString("CPF"));

                clientes.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
           ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return clientes;
    }

    public boolean checarCliente(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE ENABLE = 1 AND NOME LIKE ? ");
            stmt.setString(1, "%" + nome + "%");
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

}
