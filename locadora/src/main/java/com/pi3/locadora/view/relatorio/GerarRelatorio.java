/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.relatorio;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.model.Locacao;
import br.com.model.Veiculo;
import br.com.model.dao.ClienteDAO;
import br.com.model.dao.FuncionarioDAO;
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

/**
 *
 * @author Pichau
 */
@WebServlet(name = "GerarRelatorio", urlPatterns = {"/GerarRelatorio"})
public class GerarRelatorio extends HttpServlet {

    public GerarRelatorio() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       

        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        
        LocacaoDAO daoLocacao = new LocacaoDAO();

        locacoes = daoLocacao.ApresentarLocacoes();
                
        request.setAttribute("listaLocacoes", locacoes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorio/relatorio.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        

    }

}
