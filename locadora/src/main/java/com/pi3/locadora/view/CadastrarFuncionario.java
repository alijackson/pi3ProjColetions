/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import java.io.IOException;
import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
            throws ServletException, IOException 
    {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("funcionario.jsp");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

//        JOptionPane.showMessageDialog(null, "DADASDSADASD");
        
        String nome = request.getParameter("name");
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

        dao.inserir(f);
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("");
//        
//        dispatcher.forward(request, response);
    }
}
