package com.pi3.locadora.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.model.Cliente;
import br.com.model.Locacao;
import br.com.model.Veiculo;
import br.com.model.dao.ClienteDAO;
import br.com.model.dao.VeiculoDAO;
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
@WebServlet(name = "FazerLocacao", urlPatterns = {"/locacao"})
public class CadastrarLocacao extends HttpServlet{
    
    public CadastrarLocacao(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        request.setAttribute("objetivo", "Fazer Locacao");
        
        ClienteDAO allClientes = new ClienteDAO();
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = allClientes.apresentarClientes();
        
        request.setAttribute("listaClientes", clientes);
        
        VeiculoDAO allVeiculos = new VeiculoDAO();
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        veiculos = allVeiculos.apresentarVeiculos();
        
        request.setAttribute("listaVeiculos", veiculos);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locacao/locacao.jsp");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String cliente = request.getParameter("cliente");
        String funcionario = request.getParameter("funcionario");
        String veiculo = request.getParameter("veiculo");
        String codigo = request.getParameter("");
        String protecao = request.getParameter("protect");
        String preco = request.getParameter("precoTotal");
        String retira = request.getParameter("diaRetira");
        String entrega = request.getParameter("diaRetira");

        Locacao l = new Locacao();
        
        l.setIdCliente(cliente);
        l.setIdVeiculo(veiculo);
        l.setIdFuncionario(funcionario);
        l.setCodigo(codigo);
        l.setProtecao(protecao);
        l.setPrecoTotal(preco);
        l.setDiaRetira(retira);
        l.setDiaEntrega(entrega);
        
        
//        String log = salvar.inserir(l);
                
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locacoes");
        
        dispatcher.forward(request, response);
    }
    
    
}
