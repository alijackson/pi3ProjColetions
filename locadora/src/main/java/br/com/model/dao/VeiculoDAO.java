/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class VeiculoDAO {

    public VeiculoDAO() {

    }

    private final SimpleDateFormat dataEntrada = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat dataBanco = new SimpleDateFormat("yyyy-MM-dd");

    public void inserir(Veiculo v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO VEICULO "
                    + "(MODELO, CATEGORIA, ANO, PLACA, "
                    + "MARCA, NUMERODOC, CARACTERISTICAS,FILIALVEICULO, ENABLE) VALUES "
                    + "(?,?,?,?,?,?,?,?,1)");

//            String dataConvertida = dataEntrada.format(dataBanco.parse(v.getAno()));
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setString(3, v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setString(6, v.getNumeroDocumento());
            stmt.setString(7, v.getCaracteristica());
            stmt.setString(8, v.getNomeFilial());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Veiculo> apresentarVeiculos(String filial) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        try {

            if ("MATRIZ-SP".equals(filial)) {

                stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE ENABLE = 1");
                rs = stmt.executeQuery();

            } else {

                stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE ENABLE = 1 AND FILIALVEICULO = ?");
                stmt.setString(1, filial);
                rs = stmt.executeQuery();

            }

            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setId(rs.getInt("IDVEICULO"));
                v.setModelo(rs.getString("MODELO"));
                v.setCategoria(rs.getString("CATEGORIA"));
                v.setAno(rs.getString("ANO"));
                v.setPlaca(rs.getString("PLACA"));
                v.setMarca(rs.getString("MARCA"));
                v.setNumeroDocumento(rs.getString("NUMERODOC"));
                v.setCaracteristica(rs.getString("CARACTERISTICAS"));
//                v.setImagem((File) rs.getObject("IMAGEM"));

                veiculos.add(v);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return veiculos;
    }

    public void atualizar(Veiculo v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE VEICULO SET MODELO=?, CATEGORIA=?,"
                    + " ANO=?, PLACA=?, MARCA=?, "
                    + "NUMERODOC=?, CARACTERISTICAS=? "
                    + "WHERE IDVEICULO=?");

            //String dataConvertida = dataEntrada.format(dataBanco.parse(v.getAno()));
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setString(3, v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setString(6, v.getNumeroDocumento());
            stmt.setString(7, v.getCaracteristica());
//            stmt.setObject(8, v.getImagem());
            stmt.setInt(8, v.getId());

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

            stmt = con.prepareStatement("UPDATE VEICULO SET ENABLE = 0 WHERE IDVEICULO = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {

            return ex.toString();

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }

    public Veiculo pesquisa(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Veiculo v = new Veiculo();

        try {

            stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE IDVEICULO = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.first()) {
                v.setId(rs.getInt("IDVEICULO"));
                v.setModelo(rs.getString("MODELO"));
                v.setCategoria(rs.getString("CATEGORIA"));
                v.setPlaca(rs.getString("PLACA"));
                v.setMarca(rs.getString("MARCA"));
                v.setNumeroDocumento(rs.getString("NUMERODOC"));
                v.setCaracteristica(rs.getString("CARACTERISTICAS"));
                v.setAno(rs.getString("ANO"));
//                v.setImagem((File) rs.getObject("IMAGEM"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return v;
    }

    public ArrayList<Veiculo> buscar(String modelo, String filial) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try {

            if ("MATRIZ-SP".equals(filial)) {

                stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE ENABLE = 1 AND MODELO LIKE ?");
                stmt.setString(1, "%" + modelo + "%");
                rs = stmt.executeQuery();

            } else {

                stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE ENABLE = 1 AND MODELO LIKE ? AND FILIALVEICULO = ?");
                stmt.setString(1, "%" + modelo + "%");
                stmt.setString(2, filial);

                rs = stmt.executeQuery();

            }

//            stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE ENABLE = 1 AND MODELO LIKE ? AND FILIALVEICULO = ?");
//            stmt.setString(1, "%" + modelo + "%");
//            stmt.setString(2, filial);
//            rs = stmt.executeQuery();
            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setId(rs.getInt("IDVEICULO"));
                v.setModelo(rs.getString("MODELO"));
                v.setCategoria(rs.getString("CATEGORIA"));
                v.setAno(rs.getString("ANO"));
                v.setPlaca(rs.getString("PLACA"));
                v.setMarca(rs.getString("MARCA"));
                v.setNumeroDocumento(rs.getString("NUMERODOC"));
                v.setCaracteristica(rs.getString("CARACTERISTICAS"));
//              v.setImagem((File) rs.getObject("IMAGEM"));

                veiculos.add(v);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return veiculos;
    }

    public boolean checarVeiculo(String modelo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE MODELO LIKE ?");
            stmt.setString(1, "%" + modelo + "%");
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
