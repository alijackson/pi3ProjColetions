package com.pi3.locadora.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.model.Locacao;
import br.com.servico.ServicoLocacao;
import java.io.IOException;
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
@WebServlet(name = "FazerLocacao", urlPatterns = {"/locacao"})
public class CadastrarLocacao extends HttpServlet{
    
    public CadastrarLocacao(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        request.setAttribute("objetivo", "Fazer Locacao");
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("locacao.jsp");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String cliente = request.getParameter("cliente");
        String funcionario = request.getParameter("funcionario");
        String veiculo = request.getParameter("veiculo");
        String codigo = request.getParameter("");
        String protecao = request.getParameter("protect");
        String preco = request.getParameter("precoTotal");
        String retira = request.getParameter("diaRetira");
        String entrega = request.getParameter("diaRetira");

        Locacao l = new Locacao();
        
        l.setIdCliente(cliente);
        l.setIdVeiculo(veiculo);
        l.setIdFuncionario(funcionario);
        l.setCodigo(codigo);
        l.setProtecao(protecao);
        l.setPrecoTotal(preco);
        l.setDiaRetira(retira);
        l.setDiaEntrega(entrega);
        
        ServicoLocacao salvar = new ServicoLocacao();
        
        String log = salvar.inserir(l);
                
        request.setAttribute("result", "Ocorreu tudo bem\n"+"<br>"+log);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("locacoes");
        
        dispatcher.forward(request, response);
    }
    
    
}
