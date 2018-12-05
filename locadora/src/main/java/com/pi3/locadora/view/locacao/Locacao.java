/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.locacao;

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
import org.json.JSONObject;

/**
 *
 * @author jackson
 */
@WebServlet(name = "locacao", urlPatterns = {"/new/locacao"})
public class Locacao extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

        ClienteDAO dao = new ClienteDAO();

        listClientes = dao.apresentarClientes();

        request.setAttribute("listClient", listClientes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locacao/home-locacao.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("");

            dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("application/json;charset=UTF-8");

    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        try {
            
            
        } catch (Exception e) {
            
        }
        
    }
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

        ClienteDAO dao = new ClienteDAO();

        listClientes = dao.apresentarClientes();

        req.setAttribute("listClient", listClientes);
        try {
            
            
        } catch (Exception e) {
            
        }
        
    }
}
