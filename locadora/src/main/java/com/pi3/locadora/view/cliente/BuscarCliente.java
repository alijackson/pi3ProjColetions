/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.cliente;

import br.com.model.Cliente;
import com.pi3.locadora.view.veiculo.*;
import br.com.model.Veiculo;
import br.com.model.dao.ClienteDAO;
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
@WebServlet(name = "ProcurarClientes", urlPatterns = {"/buscarC"})
public class BuscarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDAO dao = new ClienteDAO();

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        String pesquisar = request.getParameter("pesquisar");

        HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        if ("".equalsIgnoreCase(pesquisar) || pesquisar == null) {

            listaCliente = dao.apresentarClientes(filialConvertida);

            request.setAttribute("listarCliente", listaCliente);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cliente/home-cliente.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarCliente(pesquisar);

            if (resultado == true) {

                listaCliente = dao.buscar(pesquisar, filialConvertida);
                request.setAttribute("listarCliente", listaCliente);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/cliente/home-cliente.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Cliente não localizado");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/cliente/home-cliente.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}
