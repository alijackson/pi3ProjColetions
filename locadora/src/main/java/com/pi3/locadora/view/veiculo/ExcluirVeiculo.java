/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author micro
 */
@WebServlet(name = "ExcluisaoVeiculo", urlPatterns = {"/excluirV"})

public class ExcluirVeiculo extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        VeiculoDAO dao = new VeiculoDAO();
//        
//        String id = req.getParameter("id");
//        
//        dao.excluir(Integer.parseInt(id));
        
        JOptionPane.showMessageDialog(null, "ddada");
        
//        ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();
//
//        listVeiculos = dao.ApresentarVeiculos();
//
//        req.setAttribute("listarVeiculos", listVeiculos);
//
//        RequestDispatcher dispatcher
//                = req.getRequestDispatcher("/veiculo/home-veiculo.jsp");
//
//        dispatcher.forward(req, resp);
    }


}
