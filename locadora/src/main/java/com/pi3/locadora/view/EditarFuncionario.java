/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

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

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario f = new Funcionario();

        f = dao.Pesquisa(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("objetivo", " Editar");
        request.setAttribute("funcionario", f);
//        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/funcionario/editarFuncionario.jsp");

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
        f.setId(Integer.parseInt(request.getParameter("id")));

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.atualizar(f);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/main");

        dispatcher.forward(request, response);
    }

}
