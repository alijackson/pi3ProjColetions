/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.cliente;

import br.com.model.Cliente;
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
 * @author alijackson.msilva
 */

@WebServlet(name = "CadastroClient", urlPatterns = {"/main"})

public class Main extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();

        ClienteDAO getAllCliente = new ClienteDAO();

        listCliente = getAllCliente.ApresentarClientes();

        request.setAttribute("listaCliente", listCliente);
//
//        HttpSession sessao = request.getSession();
//
//        if(sessao.getAttribute("usuario") == null)
//        {
//            response.sendRedirect(request.getContextPath() + "/cliente/index.jsp");
//            return;
//        }
//        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cliente/index.jsp");

        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();

        ClienteDAO getAllCliente = new ClienteDAO();

        listCliente = getAllCliente.ApresentarClientes();

        request.setAttribute("listaCliente", listCliente);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cliente/index.jsp");

        dispatcher.forward(request, response);
    }
}
