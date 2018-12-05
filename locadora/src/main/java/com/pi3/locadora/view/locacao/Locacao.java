/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.locacao;

import br.com.model.Cliente;
import br.com.model.dao.ClienteDAO;
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
 * @author jackson
 */
@WebServlet(name = "locacao", urlPatterns = {"/new/locacao"})
public class Locacao extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/locacao/home-locacao.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("");

            dispatcher.forward(request, response);

    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        try {
            
            
        } catch (Exception e) {
            
        }
        
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        try {

            ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

            ClienteDAO dao = new ClienteDAO();

            listClientes = dao.apresentarClientes();

            JSONArray array = new JSONArray();

            PrintWriter out = resp.getWriter();
            
            for(Cliente c : listClientes)
            {
                JSONObject json = new JSONObject();

                json.put("idCliente", c.getId());
                json.put("nome", c.getNome());
                json.put("numerocnh", c.getNumeroCNH());
                json.put("cpf", c.getCpf());
                json.put("rg", c.getRg());
                json.put("email", c.getEmail());
                json.put("telefonefixo", c.getTelefoneFixo());
                json.put("telefonecelular", c.getTelefoneCelular());
                json.put("datanascimento", c.getDataNascimento());
                
                array.put(json);
                
            }
            out.print(array);
//            resp.getWriter().write(array.toString());
            
        } catch (Exception e) {
            
            JSONObject json = new JSONObject();
        
            json.put("resp", "Erro ao interpretar dados "+ e);

            resp.getWriter().write(json.toString());
        }
        
    }
}
