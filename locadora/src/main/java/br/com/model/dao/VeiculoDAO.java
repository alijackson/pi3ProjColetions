/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.conneticon.ConnectionFactory;
import br.com.model.Veiculo;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class VeiculoDAO {
    
    public VeiculoDAO(){
    
    }
    
    public String inserir(Veiculo v){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String log = "";
        try 
        {
            
            stmt = con.prepareStatement("INSERT INTO VEICULO "
                    + "(MODELO, CATEGORIA, ANO, PLACA, MARCA, "
                    + "NUMERODOC, CARACTERISTICAS, IMAGEM) VALUES "
                    + "(?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setDate(3, (Date) v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setInt(6, v.getNumeroDoc());
            stmt.setString(7, v.getCaracter());
            stmt.setObject(8, v.getImagem());

            stmt.execute();
            
        }
        catch(SQLException ex)
        {
            log = ex.toString();
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return log;
    }
    
    public ArrayList<Veiculo> ApresentarVeiculos(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE enable=1");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setId(rs.getInt("IDVEICULO"));
                v.setModelo(rs.getString("MODELO"));
                v.setCategoria(rs.getString("CATEGORIA"));
                v.setAno(rs.getDate("ANO"));
                v.setPlaca(rs.getString("PLACA"));
                v.setMarca(rs.getString("MARCA"));
                v.setNumeroDoc(rs.getInt("NUMERODOC"));
                v.setCaracter(rs.getString("CARACTERISTICAS"));
                v.setImagem((File) rs.getObject("IMAGEM"));

                veiculos.add(v);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        
        return veiculos;
    }
    
    public String atualizar(Veiculo v){
        String retur = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE VEICULO SET MODELO=?, CATEGORIA=?,"
                    + " ANO=?, PLACA=?, MARCA=?, "
                    + "NUMERODOC=?, CARACTERISTICAS=?, IMAGEM=? "
                    + "WHERE (IDVEICULO=?)");

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setDate(3, (Date) v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setInt(6, v.getNumeroDoc());
            stmt.setString(7, v.getCaracter());
            stmt.setObject(8, v.getImagem());
            stmt.setInt(9, v.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alteração feita com Sucesso!");

        } catch (SQLException ex) {
            retur = ex.toString();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return retur;
    }
    
    public void excluir(int id){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE VEICULO SET enable=2 WHERE IDVEICULO = ?");
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
    
    public Veiculo Pesquisa(int id){
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
                v.setAno(rs.getDate("ANO"));
                v.setPlaca(rs.getString("PLACA"));
                v.setMarca(rs.getString("MARCA"));
                v.setNumeroDoc(rs.getInt("NUMERODOC"));
                v.setCaracter(rs.getString("CARACTERISTICAS"));
                v.setImagem((File) rs.getObject("IMAGEM"));
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return v;
    }
    
    public boolean ChecarVeiculo(int numeroDoc){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE NUMERODOC = ?");
            stmt.setInt(1, numeroDoc);
            rs = stmt.executeQuery();

            if (rs.next()) 
            {    
                result = true;
            }

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "erro ao verificar cadastro do veiculo" + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }
    
}
