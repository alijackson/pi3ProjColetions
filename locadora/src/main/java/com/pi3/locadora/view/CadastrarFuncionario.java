/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import java.io.IOException;
import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david.sdcruz
 */
@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

    public CadastrarFuncionario() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setAttribute("objetivo", "Cadastrar Funcionario");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("funcionario.jsp");

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

        FuncionarioDAO dao = new FuncionarioDAO();

        int resultado = dao.inserir(f);

        if (resultado == 1) {

            //apresentar mensagem de sucesso
            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/funcionario.jsp");

            dispatcher.forward(request, response);

        } else {

            // apresentar mensagem de erro
        }

    }
}
