/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.relatorio;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.model.Locacao;
import br.com.model.Veiculo;
import br.com.model.dao.ClienteDAO;
import br.com.model.dao.FuncionarioDAO;
import br.com.model.dao.LocacaoDAO;
import br.com.model.dao.VeiculoDAO;
import java.io.IOException;
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

/**
 *
 * @author Pichau
 */
@WebServlet(name = "GerarRelatorio", urlPatterns = {"/GerarRelatorio"})
public class GerarRelatorio extends HttpServlet {

    public GerarRelatorio() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        LocacaoDAO daoLocacao = new LocacaoDAO();

        FuncionarioDAO daoFuncionario = new FuncionarioDAO();

        VeiculoDAO daoVeiculo = new VeiculoDAO();

        ClienteDAO daoCliente = new ClienteDAO();

        locacoes = daoLocacao.relatorioSemanal();
        
        HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        funcionarios = daoFuncionario.apresentarFuncionarios();

        veiculos = daoVeiculo.apresentarVeiculos(filialConvertida);

        clientes = daoCliente.apresentarClientes(filialConvertida);

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        String max = fmt.format(cal.getTime());

        cal.add(Calendar.DAY_OF_YEAR, -7);

        String min = fmt.format(cal.getTime());

        request.setAttribute("max", max);

        request.setAttribute("min", min);

        request.setAttribute("listaClientes", clientes);

        request.setAttribute("listaVeiculos", veiculos);

        request.setAttribute("listaFuncionarios", funcionarios);

        request.setAttribute("listaLocacoes", locacoes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorio/relatorio.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("rel");

        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        LocacaoDAO daoLocacao = new LocacaoDAO();

        FuncionarioDAO daoFuncionario = new FuncionarioDAO();

        VeiculoDAO daoVeiculo = new VeiculoDAO();

        ClienteDAO daoCliente = new ClienteDAO();

        HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        if (opcao.equalsIgnoreCase("semanal")) {

            locacoes = daoLocacao.relatorioSemanal();

            funcionarios = daoFuncionario.apresentarFuncionarios();

            veiculos = daoVeiculo.apresentarVeiculos(filialConvertida);

            clientes = daoCliente.apresentarClientes(filialConvertida);

            Calendar cal = Calendar.getInstance();

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

            String max = fmt.format(cal.getTime());

            cal.add(Calendar.DAY_OF_YEAR, -7);

            String min = fmt.format(cal.getTime());

            request.setAttribute("max", max);

            request.setAttribute("min", min);

            request.setAttribute("listaClientes", clientes);

            request.setAttribute("listaVeiculos", veiculos);

            request.setAttribute("listaFuncionarios", funcionarios);

            request.setAttribute("listaLocacoes", locacoes);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/relatorio/relatorio.jsp");

            dispatcher.forward(request, response);

        } else if (opcao.equalsIgnoreCase("mensal")) {

            locacoes = daoLocacao.relatorioMensal();

            funcionarios = daoFuncionario.apresentarFuncionarios();

            veiculos = daoVeiculo.apresentarVeiculos(filialConvertida);

            clientes = daoCliente.apresentarClientes(filialConvertida);

            Calendar cal = Calendar.getInstance();

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

            String max = fmt.format(cal.getTime());

            cal.add(Calendar.DAY_OF_YEAR, -30);

            String min = fmt.format(cal.getTime());

            request.setAttribute("max", max);

            request.setAttribute("min", min);

            request.setAttribute("listaClientes", clientes);

            request.setAttribute("listaVeiculos", veiculos);

            request.setAttribute("listaFuncionarios", funcionarios);

            request.setAttribute("listaLocacoes", locacoes);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/relatorio/relatorio.jsp");

            dispatcher.forward(request, response);

        } else {

            locacoes = daoLocacao.relatorioQuinzenal();

            funcionarios = daoFuncionario.apresentarFuncionarios();

            veiculos = daoVeiculo.apresentarVeiculos(filialConvertida);

            clientes = daoCliente.apresentarClientes(filialConvertida);

            Calendar cal = Calendar.getInstance();

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

            String max = fmt.format(cal.getTime());

            cal.add(Calendar.DAY_OF_YEAR, -15);

            String min = fmt.format(cal.getTime());

            request.setAttribute("max", max);

            request.setAttribute("min", min);

            request.setAttribute("listaClientes", clientes);

            request.setAttribute("listaVeiculos", veiculos);

            request.setAttribute("listaFuncionarios", funcionarios);

            request.setAttribute("listaLocacoes", locacoes);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/relatorio/relatorio.jsp");

            dispatcher.forward(request, response);

        }

    }

}
