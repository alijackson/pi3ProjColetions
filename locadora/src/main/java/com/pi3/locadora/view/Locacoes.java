package com.pi3.locadora.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.model.Locacao;
import br.com.model.dao.ClienteDAO;
import br.com.model.dao.LocacaoDAO;
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
 * @author Pichau
 */

@WebServlet(name = "ExibirLocacoes", urlPatterns = {"/locacoes"})
public class Locacoes extends HttpServlet{
    
    public Locacoes(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        
        LocacaoDAO dao = new LocacaoDAO();
        
        locacoes = dao.ApresentarLocacoes();
        
        request.setAttribute("listaLocacoes", locacoes);
        
        HttpSession sessao = request.getSession();
        
        /*if(sessao.getAttribute("usuario") == null)
        {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
        }*/

        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("locacoes.jsp");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
