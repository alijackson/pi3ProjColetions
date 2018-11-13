/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import br.com.servico.ServicoVeiculo;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "car", urlPatterns = {"/cadastro/veiculo"})
public class CadastrarVeiculo extends HttpServlet{

    public CadastrarVeiculo() {
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("objetivo", "Cadastrar Veiculo");

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculo/veiculo.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {      

        Veiculo veiculo = new Veiculo();
        
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setCategoria(request.getParameter("categoria"));
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
//        try {
            veiculo.setAno(request.getParameter("ano"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CadastrarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        veiculo.setPlaca(request.getParameter("marca"));
        veiculo.setMarca(request.getParameter("placa"));
        veiculo.setNumeroDoc(Integer.parseInt(request.getParameter("numerodoc")));
        veiculo.setCaracter(request.getParameter("caracter"));
//        File file = new File(request.getParameter("imagem"));
//        veiculo.setImagem(file);
        
        ServicoVeiculo cadastrar = new ServicoVeiculo();
        
        String log = cadastrar.inserir(veiculo);

        request.setAttribute("result", "Ocorreu tudo bem\n" + "<br>" + log);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculos");

        dispatcher.forward(request, response);
    }
}
