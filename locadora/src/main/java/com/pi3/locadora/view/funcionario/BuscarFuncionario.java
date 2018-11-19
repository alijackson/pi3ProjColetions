/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.funcionario;

import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "BuscarFuncionario", urlPatterns = {"/buscarF"})
public class BuscarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioDAO dao = new FuncionarioDAO();

        ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();

        String pesquisar = request.getParameter("pesquisar");

        if ("".equalsIgnoreCase(pesquisar)
                || pesquisar == null) {

            listFuncionarios = dao.apresentarFuncionarios();

            request.setAttribute("listaFuncionarios", listFuncionarios);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/funcionario/funcionario.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarFuncionario(pesquisar);

            if (resultado == true) {

                listFuncionarios = dao.buscar(pesquisar);

                request.setAttribute("listaFuncionarios", listFuncionarios);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/funcionario/funcionario.jsp");

                dispatcher.forward(request, response);

            } else {

                //request.setAttribute("veiculoErro", "Veiculo não localizado");
                listFuncionarios = dao.buscar(pesquisar);

                request.setAttribute("listaFuncionarios", listFuncionarios);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/funcionario/funcionario.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}
