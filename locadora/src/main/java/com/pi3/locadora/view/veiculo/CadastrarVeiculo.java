/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.veiculo;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Pichau
 */
@WebServlet(name = "InicioVeiculos", urlPatterns = {"/cadastrarV"})
public class CadastrarVeiculo extends HttpServlet {

    public CadastrarVeiculo() {
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();

        VeiculoDAO dao = new VeiculoDAO();

        listVeiculos = dao.apresentarVeiculos();

        request.setAttribute("listarVeiculos", listVeiculos);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
//        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String modelo = request.getParameter("modelo");
        String ano = request.getParameter("ano");
        String placa = request.getParameter("placa");
        String marca = request.getParameter("marca");
        String numerodedocumento = request.getParameter("numerodedocumento");
        String caracteristica = request.getParameter("caracteristica");
        String categoria = request.getParameter("categoria");
        String id = request.getParameter("idVeiculo");

        Veiculo v = new Veiculo();

        v.setModelo(modelo);
        v.setAno(ano);
        v.setPlaca(placa);
        v.setMarca(marca);
        v.setNumeroDocumento(numerodedocumento);
        v.setCaracteristica(caracteristica);
        v.setCategoria(categoria);

        VeiculoDAO dao = new VeiculoDAO();
        if (id == null || id.trim().equals("")) {
            dao.inserir(v);
        } else {
            v.setId(Integer.parseInt(id));
            dao.atualizar(v);
        }

        ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();

        listVeiculos = dao.apresentarVeiculos();

        request.setAttribute("listarVeiculos", listVeiculos);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=UTF-8");

        int id;

        Veiculo v = new Veiculo();
        VeiculoDAO dao = new VeiculoDAO();
        
        id = Integer.parseInt(req.getParameter("id"));
        v = dao.pesquisa(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        json.put("idVeiculo", v.getId());
        json.put("modelo", v.getModelo());
        json.put("ano", v.getAno());
        json.put("placa", v.getPlaca());
        json.put("marca", v.getMarca());
        json.put("numerodedocumento", v.getNumeroDocumento());
        json.put("caracteristica", v.getCaracteristica());
        json.put("categoria", v.getCategoria());

        resp.getWriter().write(json.toString());

    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id;
        VeiculoDAO dao = new VeiculoDAO();
        String resposta;
            
        try {
            
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            
            JSONObject json = new JSONObject();
        
            id = Integer.parseInt(req.getParameter("cod"));
                
            dao = new VeiculoDAO();
            resposta = dao.excluir(id);
            
            if(resposta != null && !resposta.trim().equals(""))
            {
                json.put("resp", "Erro ao excluir.");

                resp.getWriter().write(json.toString());   
                return;
                
            }
            json.put("resp", "Veículo excluído com sucesso");

            resp.getWriter().write(json.toString());
                   
            
        } catch (Exception e) {
            
            JSONObject json = new JSONObject();
        
            json.put("resp", "Erro ao interpretar dados");

            resp.getWriter().write(json.toString());
        }
        
    }
    
    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response)
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

                //request.setAttribute("veiculoErro", "Veiculo não localizado");
                listVeiculos = dao.apresentarVeiculos();

                request.setAttribute("listarVeiculos", listVeiculos);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/veiculo/home-veiculo.jsp");

                dispatcher.forward(request, response);
            }

        }

    }

}
