/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import br.com.servico.ServicoVeiculo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pichau
 */

@WebServlet(name = "CadastrarVeiculo", urlPatterns = {"/veiculos"})
public class Veiculos extends HttpServlet {
    
    public Veiculos(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        VeiculoDAO dao = new VeiculoDAO();
        
        veiculos = dao.ApresentarVeiculos();
        
        request.setAttribute("listaVeiculos", veiculos);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("veiculos.jsp");
        
        dispatcher.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setCategoria(request.getParameter("categoria"));
        veiculo.setAno(request.getParameter("ano"));
        veiculo.setPlaca(request.getParameter("marca"));
        veiculo.setNumeroDoc(request.getParameter("numerodoc"));
        veiculo.setCaracter(request.getParameter("caracteristica"));
        
        ServicoVeiculo cadastrar = new ServicoVeiculo();
        
        cadastrar.inserir(veiculo);
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        VeiculoDAO dao = new VeiculoDAO();
        
        veiculos = dao.ApresentarVeiculos();
        
        request.setAttribute("listaVeiculos", veiculos);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("veiculos.jsp");
        
        dispatcher.forward(request, response);
    }
    
}
