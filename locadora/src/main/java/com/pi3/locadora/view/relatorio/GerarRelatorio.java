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
@WebServlet(name = "GerarRelatorio", urlPatterns = {"/relatorio"})
public class GerarRelatorio extends HttpServlet {

    public GerarRelatorio() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocacaoDAO daoLocacao = new LocacaoDAO();

        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

        locacoes = daoLocacao.ApresentarLocacoes();

        FuncionarioDAO daoFuncionario = new FuncionarioDAO();

        VeiculoDAO daoVeiculo = new VeiculoDAO();

        ClienteDAO daoCliente = new ClienteDAO();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        request.setAttribute("listaLocacoes", locacoes);

        Funcionario funcionario = new Funcionario();

        Cliente cliente = new Cliente();

        Veiculo veiculo = new Veiculo();

        for (int i = 0; i < locacoes.size(); i++) {

            funcionario = daoFuncionario.Pesquisa(Integer.parseInt(locacoes.get(i).getIdFuncionario()));

            if (funcionario != null) {

                funcionarios.add(funcionario);

            }

            cliente = daoCliente.pesquisa(Integer.parseInt(locacoes.get(i).getIdCliente()));

            if (cliente != null) {

                clientes.add(cliente);

            }

            veiculo = daoVeiculo.pesquisa(Integer.parseInt(locacoes.get(i).getIdVeiculo()));

            if (veiculo != null) {

                veiculos.add(veiculo);

            }

        }

        request.setAttribute("listaFuncionarios", funcionarios);

        request.setAttribute("listaClientes", clientes);

        request.setAttribute("listaVeiculos", veiculos);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorio/relatorio.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        LocacaoDAO daoLocacao = new LocacaoDAO();

        FuncionarioDAO daoFuncionario = new FuncionarioDAO();

        VeiculoDAO daoVeiculo = new VeiculoDAO();

        ClienteDAO daoCliente = new ClienteDAO();

        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        String pesquisar = request.getParameter("pesquisar");

        if ("".equalsIgnoreCase(pesquisar)
                || pesquisar == null) {

            locacoes = daoLocacao.ApresentarLocacoes();

            request.setAttribute("listaLocacoes", locacoes);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/relatorio/relatorio.jsp");

            dispatcher.forward(request, response);

        } else {

            if (daoFuncionario.checarFuncionario(pesquisar)) {

                funcionarios = daoFuncionario.buscar(pesquisar);

                //locacoes = daoLocacao.buscarFuncionarios(funcionarios);
                request.setAttribute("listaLocacoes", locacoes);

                Funcionario funcionario = new Funcionario();

                Cliente cliente = new Cliente();

                Veiculo veiculo = new Veiculo();

                for (int i = 0; i < locacoes.size(); i++) {

                    funcionario = daoFuncionario.Pesquisa(Integer.parseInt(locacoes.get(i).getIdFuncionario()));

                    if (funcionario != null) {

                        funcionarios.add(funcionario);

                    }

                    cliente = daoCliente.pesquisa(Integer.parseInt(locacoes.get(i).getIdCliente()));

                    if (cliente != null) {

                        clientes.add(cliente);

                    }

                    veiculo = daoVeiculo.pesquisa(Integer.parseInt(locacoes.get(i).getIdVeiculo()));

                    if (veiculo != null) {

                        veiculos.add(veiculo);

                    }

                }

                request.setAttribute("listaFuncionarios", funcionarios);

                request.setAttribute("listaClientes", clientes);

                request.setAttribute("listaVeiculos", veiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/relatorio/relatorio.jsp");

                dispatcher.forward(request, response);

            } else if (daoVeiculo.checarVeiculo(pesquisar)) {

                veiculos = daoVeiculo.buscar(pesquisar);

                //locacoes = daoLocacao.buscarVeiculos(funcionarios);
                request.setAttribute("listaLocacoes", locacoes);

                Funcionario funcionario = new Funcionario();

                Cliente cliente = new Cliente();

                Veiculo veiculo = new Veiculo();

                for (int i = 0; i < locacoes.size(); i++) {

                    funcionario = daoFuncionario.Pesquisa(Integer.parseInt(locacoes.get(i).getIdFuncionario()));

                    if (funcionario != null) {

                        funcionarios.add(funcionario);

                    }

                    cliente = daoCliente.pesquisa(Integer.parseInt(locacoes.get(i).getIdCliente()));

                    if (cliente != null) {

                        clientes.add(cliente);

                    }

                    veiculo = daoVeiculo.pesquisa(Integer.parseInt(locacoes.get(i).getIdVeiculo()));

                    if (veiculo != null) {

                        veiculos.add(veiculo);

                    }

                }

                request.setAttribute("listaFuncionarios", funcionarios);

                request.setAttribute("listaClientes", clientes);

                request.setAttribute("listaVeiculos", veiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/relatorio/relatorio.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Pesquisa não localizado");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/relatorio/relatorio.jsp");

                dispatcher.forward(request, response);

            }

        }

    }

}
