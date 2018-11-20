/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Filial;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    "INSERT INTO FILIAL(NOME,ENDERECO,DESCRICAO) "
                    + "VALUES (?,?,?)");

            //    Date dataConvertida = converterData(dataEntrada, dataBanco, f);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getDescricao());
            //stmt.setInt(8, f.getAtivo());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
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
                f.setEndereco(rs.getString("ENDERECO"));
                f.setDescricao(rs.getString("DESCRICAO"));

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

        String retur = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE FILIAL SET NOME = ?, ENDERECO = ?, "
                    + "DESCRICAO = ?, EMAIL = ?, ENABLE = 1 "
                    + "WHERE IDFUNCIONARIO = ? ");

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getDescricao());
            //stmt.setInt(4, f.getAtivo());
            stmt.setInt(5, f.getId());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("ERROOOO =======");
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

            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE ID = ?");
            stmt.setInt(1, f.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getEndereco());
                stmt.setString(3, f.getDescricao());
            }

        } catch (SQLException ex) {
            System.out.println("ERROOOO =======");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }

    }

    public void excluir(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM FILIAL WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluído  com sucesso");
        } catch (SQLException ex) {
            System.out.println("ERROOOO =======");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Filial Pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Filial f = new Filial();

        try {

            stmt = con.prepareStatement("SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setEndereco(rs.getString("ENDERECO"));
                f.setDescricao(rs.getString("DESCRICAO"));
                //f.setAtivo(rs.getByte("ATIVO"));

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

        Filial f = new Filial();

        ArrayList<Filial> filiais = new ArrayList<Filial>();

        try {

            stmt = con.prepareStatement("SELECT * FROM FILIAL WHERE NOME LIKE ? ");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setEndereco(rs.getString("ENDERECO"));
                f.setDescricao(rs.getString("DESCRICAO"));
                //f.setAtivo(rs.getByte("ATIVO"));

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
