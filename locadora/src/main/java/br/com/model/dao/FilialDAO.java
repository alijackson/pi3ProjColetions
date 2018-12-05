/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kujikeo
 */
public class FilialDAO {

    public FilialDAO() {
    }

    public void inserir(Filial f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "INSERT INTO FILIAL(CIDADE,TELFIXO,TELCEL,RUA,NUMERO,COMPLEMENTO,CEP,NOME,EMAIL) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, f.getCidade());
            stmt.setString(2, f.getTelefonefixo());
            stmt.setString(3, f.getTelefonecelular());
            stmt.setString(4, f.getRua());
            stmt.setString(5, f.getNumero());
            stmt.setString(6, f.getComplemento());
            stmt.setString(7, f.getCep());
            stmt.setString(8, f.getNome());
            stmt.setString(9, f.getEmail());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Filial> apresentarFiliais() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Filial> filiais = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM FILIAL");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Filial f = new Filial();

                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setRua(rs.getString("RUA"));
                f.setTelefonefixo(rs.getString("TELFIXO"));
                f.setTelefonecelular(rs.getString("TELCEL"));

                filiais.add(f);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return filiais;
    }

    public void atualizar(Filial f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE FILIAL SET CIDADE = ?,TELFIXO = ?,TELCEL = ?,RUA"
                    + ",NUMERO = ?,COMPLEMENTO = ?,CEP = ?,NOME = ?,EMAIL = ? "
                    + "WHERE IDFILIAL = ? ");

            stmt.setString(1, f.getCidade());
            stmt.setString(2, f.getTelefonefixo());
            stmt.setString(3, f.getTelefonecelular());
            stmt.setString(4, f.getRua());
            stmt.setString(5, f.getNumero());
            stmt.setString(6, f.getComplemento());
            stmt.setString(7, f.getCep());
            stmt.setString(8, f.getNome());
            stmt.setString(9, f.getEmail());
            stmt.execute();

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void editar(Filial f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE IDFILIAL = ?");
            stmt.setInt(1, f.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                stmt.setString(1, f.getCidade());
                stmt.setString(2, f.getTelefonefixo());
                stmt.setString(3, f.getTelefonecelular());
                stmt.setString(4, f.getRua());
                stmt.setString(5, f.getNumero());
                stmt.setString(6, f.getComplemento());
                stmt.setString(7, f.getCep());
                stmt.setString(8, f.getNome());
                stmt.setString(9, f.getEmail());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }

    }

    public String excluir(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM FILIAL WHERE IDFILIAL = ?");
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            return ex.toString();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return null;

    }

    public Filial pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Filial f = new Filial();

        try {

            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE IDFILIAL = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setRua(rs.getString("RUA"));
                f.setTelefonefixo("TELFIXO");
                f.setTelefonecelular("TELCEL");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return f;
    }

    public ArrayList<Filial> buscar(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Filial> filiais = new ArrayList<Filial>();

        try {

            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE NOME LIKE ? ");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Filial f = new Filial();

                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setRua(rs.getString("RUA"));
                f.setTelefonefixo("TELFIXO");
                f.setTelefonecelular("TELCEL");

                filiais.add(f);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return filiais;
    }

    public boolean checarFilial(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE NOME LIKE ? ");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
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
