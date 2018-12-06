/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.filial;

import br.com.model.Filial;
import br.com.model.dao.FilialDAO;
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
 * @author david.sdcruz
 */
@WebServlet(name = "buscarPorFilial", urlPatterns = {"/buscarFi"})
public class BuscarFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FilialDAO dao = new FilialDAO();

        ArrayList<Filial> listFilial = new ArrayList<Filial>();

        String pesquisar = request.getParameter("pesquisar");

        if ("".equalsIgnoreCase(pesquisar)
                || pesquisar == null) {

            listFilial = dao.apresentarFiliais();

            request.setAttribute("listarFilial", listFilial);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("filial/home-filial.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarFilial(pesquisar);

            if (resultado == true) {

                listFilial = dao.buscar(pesquisar);

                request.setAttribute("listarFilial", listFilial);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("filial/home-filial.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Filial não localizada");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("filial/home-filial.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}
