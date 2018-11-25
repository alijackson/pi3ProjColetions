/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
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
 * @author micro
 */
@WebServlet(name = "ProcurarVeiculos", urlPatterns = {"/buscarV"})
public class BuscarVeiculos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VeiculoDAO dao = new VeiculoDAO();

        ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();

        String pesquisar = request.getParameter("pesquisar");

        if ("".equalsIgnoreCase(pesquisar) || pesquisar == null) {

            listVeiculos = dao.apresentarVeiculos();

            request.setAttribute("listarVeiculos", listVeiculos);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarVeiculo(pesquisar);

            if (resultado == true) {

                listVeiculos = dao.buscar(pesquisar);
                request.setAttribute("listarVeiculos", listVeiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);

            } else {

                //request.setAttribute("veiculoErro", "Veiculo não localizado");
                listVeiculos = dao.apresentarVeiculos();

                request.setAttribute("listarVeiculos", listVeiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}