/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import java.io.File;
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

@WebServlet(name = "removeCar", urlPatterns = {"/remover/veiculo"})
public class RemoverVeiculo extends HttpServlet {
    
    public RemoverVeiculo(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        VeiculoDAO dao = new VeiculoDAO();
        
        dao.excluir(Integer.parseInt(request.getParameter("id")));
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/main");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {   
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setCategoria(request.getParameter("categoria"));
            veiculo.setAno(request.getParameter("ano"));
        veiculo.setPlaca(request.getParameter("marca"));
        veiculo.setNumeroDoc(Integer.parseInt(request.getParameter("numerodoc")));
        veiculo.setCaracter(request.getParameter("caracteristica"));
        File file = new File(request.getParameter("imagem"));
        veiculo.setImagem(file);
        
        VeiculoDAO dao = new VeiculoDAO();
        
        String log = dao.inserir(veiculo);

        request.setAttribute("result", "Ocorreu tudo bem\n" + "<br>" + log);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculos");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
