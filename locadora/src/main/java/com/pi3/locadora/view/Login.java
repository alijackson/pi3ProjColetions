/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import br.com.model.Cliente;
import br.com.model.dao.ClienteDAO;
import com.pi3.locadora.user.AddUser;
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

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("login.jsp");
        
        dispatcher.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AddUser user = new AddUser("teste", "teste", "teste");
        
        String login = request.getParameter("login");
        
        String senha = request.getParameter("senha");
        
        if(login.equalsIgnoreCase(user.getLogin()))
        {
            HttpSession sessao = request.getSession();
            request.setAttribute("usuario", login);
            
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("index.jsp");
//        
//        dispatcher.forward(request, response);
            response.sendRedirect(request.getContextPath() + "/main");
            return;
        }
        
        request.setAttribute("msgErro", "Login incorreto");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("login.jsp");
        
        dispatcher.forward(request, response);
    }
    
}
