/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.cliente;

import br.com.model.Cliente;
import br.com.model.dao.ClienteDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author micro
 */
@WebServlet(name = "CadastroCliente", urlPatterns = {"/cadastrarC"})
public class CadastrarCliente extends HttpServlet {

    public CadastrarCliente() {
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

        ClienteDAO dao = new ClienteDAO();

        listClientes = dao.apresentarClientes();

        request.setAttribute("listarCliente", listClientes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cliente/home-cliente.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String numerocnh = request.getParameter("numerocnh");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String email = request.getParameter("email");
        String telefonefixo = request.getParameter("telefonefixo");
        String telefonecelular = request.getParameter("telefonecelular");
        String datanascimento = request.getParameter("datanascimento");
        String id = request.getParameter("idCliente");

        Cliente c = new Cliente();

        c.setNome(nome);
        c.setNumeroCNH(numerocnh);
        c.setCpf(cpf);
        c.setRg(rg);
        c.setEmail(email);
        c.setTelefoneFixo(telefonefixo);
        c.setTelefoneCelular(telefonecelular);
        c.setDataNascimento(datanascimento);

        ClienteDAO dao = new ClienteDAO();

        if (id == null) {
            dao.inserir(c);
        } else {
            c.setId(Integer.parseInt(id));
            dao.atualizar(c);
        }

        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

        listClientes = dao.apresentarClientes();

        request.setAttribute("listarCliente", listClientes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cliente/home-cliente.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=UTF-8");

        int id;

        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        id = Integer.parseInt(req.getParameter("idCliente"));
        c = dao.pesquisa(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
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

        resp.getWriter().write(json.toString());

    }

}
