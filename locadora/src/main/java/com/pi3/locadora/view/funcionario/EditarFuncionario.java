/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.funcionario;

import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author micro
 */
@WebServlet(name = "EditarFuncionario", urlPatterns = {"/EditarFuncionario"})
public class EditarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();

        FuncionarioDAO dao = new FuncionarioDAO();

        int id = Integer.parseInt(request.getParameter("id"));

        funcionario = dao.pesquisa(id);

        request.setAttribute("funcionario", funcionario);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/editarFuncionario.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String dataNascimento = request.getParameter("dataNascimento");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String cargo = request.getParameter("cargo");

        Funcionario f = new Funcionario();

        f.setNome(nome);
        f.setEmail(email);
        f.setDataNascimento(dataNascimento);
        f.setLogin(login);
        f.setSenha(senha);
        f.setCpf(cpf);
        f.setCargo(cargo);
        int id = Integer.parseInt(request.getParameter("id"));
        f.setId(id);

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.atualizar(f);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/funcionario.jsp");

        dispatcher.forward(request, response);
    }

}
