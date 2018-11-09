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

@WebServlet(name = "editVeiculo", urlPatterns = {"/editar/veiculo"})
public class EditarVeiculo extends HttpServlet {
    
    public EditarVeiculo(){}
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                throws ServletException, IOException
    {
        VeiculoDAO dao = new VeiculoDAO();
        Veiculo v = new Veiculo();
        
        v = dao.Pesquisa(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("objetivo", " Editar");
        request.setAttribute("veiculo", v);
//        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculo/editarveiculo.jsp");
        
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
        veiculo.setPlaca(request.getParameter("placa"));
        veiculo.setNumeroDoc(Integer.parseInt(request.getParameter("numerodoc")));
        veiculo.setCaracter(request.getParameter("caracteristica"));
        veiculo.setMarca(request.getParameter("marca"));
        veiculo.setId(Integer.parseInt(request.getParameter("id").toString()));
//        File file = new File(request.getParameter("imagem"));
//        veiculo.setImagem(file);
//        
        VeiculoDAO dao = new VeiculoDAO();
        
        String log = dao.atualizar(veiculo);

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
