/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.locacao;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.model.Locacao;
import br.com.model.Veiculo;
import br.com.model.dao.ClienteDAO;
import br.com.model.dao.FuncionarioDAO;
import br.com.model.dao.LocacaoDAO;
import br.com.model.dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jackson
 */
@WebServlet(name = "viewNewLocacao", urlPatterns = {"/new/locacao"})
public class viewNewLocacao extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
//
//        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
//
//        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
//
//        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//
//        LocacaoDAO daoLocacao = new LocacaoDAO();
//
//        FuncionarioDAO daoFuncionario = new FuncionarioDAO();
//
//        VeiculoDAO daoVeiculo = new VeiculoDAO();
//
//        ClienteDAO daoCliente = new ClienteDAO();
//
//        locacoes = daoLocacao.relatorioSemanal();
//        
//        HttpSession session = request.getSession(true);
//
//        Object filial = session.getAttribute("filialLocalizada");
//
//        String filialConvertida = String.valueOf(filial);
//
//        funcionarios = daoFuncionario.apresentarFuncionarios();
//
//        veiculos = daoVeiculo.apresentarVeiculos(filialConvertida);
//
//        clientes = daoCliente.apresentarClientes(filialConvertida);
//
//        request.setAttribute("listaClientes", clientes);
//
//        request.setAttribute("listaVeiculos", veiculos);
//
//        request.setAttribute("listaFuncionarios", funcionarios);
//
//        request.setAttribute("listaLocacoes", locacoes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locacao/oneLocacao.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
        LocacaoDAO loc = new LocacaoDAO();
        
        Locacao newLoc = new Locacao();

        newLoc.setIdCliente(request.getParameter("idClient"));
        newLoc.setIdVeiculo(request.getParameter("idCar"));
        newLoc.setDiaRetira(request.getParameter("dataSaida"));
        newLoc.setDiaEntrega(request.getParameter("dataReturn"));
        newLoc.setProtecao(request.getParameter("protect"));
        newLoc.setServicos(request.getParameter("service"));
//        newLoc.setTotalDias(request.getParameter("allDias"));
        newLoc.setPrecoTotal(request.getParameter("valorTotal"));
        
        loc.inserir(newLoc);
       
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/locacao/listlocacao.jsp");
        
        dispatcher.forward(request, response);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Segue erro \n"+e);
        }

    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        HttpSession session = req.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);
        try {

            ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

            ClienteDAO dao = new ClienteDAO();

            listClientes = dao.apresentarClientes(filialConvertida);

            JSONArray array = new JSONArray();

            PrintWriter out = resp.getWriter();
            
            for(Cliente c : listClientes)
            {
                JSONObject json = new JSONObject();

                json.put("idCliente", c.getId());
                json.put("nome", c.getNome());
                json.put("numerocnh", c.getNumeroCNH());
                json.put("cpf", c.getCpf());
                json.put("rg", c.getRg());
                json.put("email", c.getEmail());
                json.put("telefonefixo", c.getTelefoneFixo());
                json.put("telefonecelular", c.getTelefoneCelular());
                json.put("datanascimento", c.getDataNascimento());
                
                array.put(json);
                
            }
            out.print(array);
            
        } catch (Exception e) {
            
            JSONObject json = new JSONObject();
        
            json.put("resp", "Erro ao interpretar dados "+ e);

            resp.getWriter().write(json.toString());
        }
        
    }
}
