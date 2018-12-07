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
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        if ("".equalsIgnoreCase(pesquisar) || pesquisar == null) {

            listVeiculos = dao.apresentarVeiculos(filialConvertida);

            request.setAttribute("listarVeiculos", listVeiculos);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarVeiculo(pesquisar);

            if (resultado == true) {

                listVeiculos = dao.buscar(pesquisar, filialConvertida);

                request.setAttribute("listarVeiculos", listVeiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Veiculos não localizado");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}
