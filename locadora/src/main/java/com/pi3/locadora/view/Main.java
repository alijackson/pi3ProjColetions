/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

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

/**
 *
 * @author alijackson.msilva
 */

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/main"})

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
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        
        dispatcher.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
//        AddUser criarUser = new AddUser("Administrador", "admin", "admin");
//        
//        String login = request.getParameter("login");
//        String senha = request.getParameter("senha");
//        String temp = "Acesso negado!";
        
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
        
        if(request.getParameter("tel") != null &&
                !request.getParameter("tel").equals(""))
            cliente.setTelefoneFixo(request.getParameter("tel"));
                
//        if(criarUser.getLogin().equalsIgnoreCase(login) &&
//                criarUser.getSenha().equalsIgnoreCase(senha))
//        {
//            temp = "Acesso permitido!";
//        }
//        
        ClienteDAO clienteDao = new ClienteDAO();
        String log = clienteDao.inserir(cliente);
                
        request.setAttribute("result", "Ocorreu tudo bem\n"+"<br>"+log);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("resultado.jsp");
        
        dispatcher.forward(request, response);
    }
}
