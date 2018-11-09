/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import br.com.model.dao.FuncionarioDAO;
import java.io.IOException;
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
@WebServlet(name = "RemoverFuncionario", urlPatterns = {"/RemoverFuncionario"})
public class RemoverFuncionario extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FuncionarioDAO dao =  new FuncionarioDAO();
        
        dao.excluir(Integer.parseInt(request.getParameter("id")));
        
         RequestDispatcher dispatcher
                = request.getRequestDispatcher("funcionario.jsp");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    
    
    


}
