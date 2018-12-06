/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author micro
 */
@WebServlet(name = "ProcurarVeiculos", urlPatterns = {"/buscarV"})
public class BuscarVeiculos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VeiculoDAO dao = new VeiculoDAO();

        ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();

        String pesquisar = request.getParameter("pesquisar");

        if ("".equalsIgnoreCase(pesquisar) || pesquisar == null) {

            listVeiculos = dao.apresentarVeiculos();

            request.setAttribute("listarVeiculos", listVeiculos);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

            dispatcher.forward(request, response);

        } else {

            boolean resultado = dao.checarVeiculo(pesquisar);

            if (resultado == true) {

                listVeiculos = dao.buscar(pesquisar);
                request.setAttribute("listarVeiculos", listVeiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Veiculos não localizado");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);
            }

        }

    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("application/json;charset=UTF-8");

        ArrayList<Veiculo> cars = new ArrayList<Veiculo>();

        VeiculoDAO dao = new VeiculoDAO();
        
        cars = dao.apresentarVeiculos();

        JSONArray array = new JSONArray();

        PrintWriter out = resp.getWriter();
        
        for(Veiculo v : cars)
        {
            JSONObject json = new JSONObject();

            json.put("idVeiculo", v.getId());
            json.put("modelo", v.getModelo());
            json.put("ano", v.getAno());
            json.put("placa", v.getPlaca());
            json.put("marca", v.getMarca());
            json.put("numerodedocumento", v.getNumeroDocumento());
            json.put("caracteristica", v.getCaracteristica());
            json.put("categoria", v.getCategoria());
            
            array.put(json);
        }
        
        out.print(array);
    }
    

}
