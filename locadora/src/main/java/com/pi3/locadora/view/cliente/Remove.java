/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.cliente;

import br.com.model.Cliente;
import br.com.model.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author jackson
 */

@WebServlet(name = "RemovClient", urlPatterns = {"/remov"})
public class Remove extends HttpServlet{
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        ClienteDAO cliente = new ClienteDAO();
        
        cliente.excluir(Integer.parseInt(request.getParameter("id")));
//        request.setAttribute("objetivo", " Editar");
//        request.setAttribute("cliente", c);
////        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locadora/main");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {   
        Cliente cliente = new Cliente(
                request.getParameter("nome"), 
                request.getParameter("cel"), 
                request.getParameter("cpf"), request.getParameter("rg"),
                Integer.parseInt(request.getParameter("cnh")), 
                request.getParameter("dataNasc"),
                Integer.parseInt(request.getParameter("idade")));
        
        if(request.getParameter("email") != null &&
                !request.getParameter("email").equals(""))
            cliente.setEmail(request.getParameter("email"));
        else
            cliente.setEmail("");
        
        if(request.getParameter("tel") != null &&
                !request.getParameter("tel").equals(""))
            cliente.setTelefoneFixo(request.getParameter("tel"));
        else
            cliente.setTelefoneFixo("");
        
        cliente.setId(Integer.parseInt(request.getParameter("id")));
        
        ClienteDAO clienteDao = new ClienteDAO();
        
        String retur = clienteDao.atualizar(cliente);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/main");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
