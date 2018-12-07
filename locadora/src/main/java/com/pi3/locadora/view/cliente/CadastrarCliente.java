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
import javax.servlet.http.HttpSession;
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
        
         HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        listClientes = dao.apresentarClientes(filialConvertida);

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
        String nomefilial = request.getParameter("nomefilial");

        Cliente c = new Cliente();

        c.setNome(nome);
        c.setNumeroCNH(numerocnh);
        c.setCpf(cpf);
        c.setRg(rg);
        c.setEmail(email);
        c.setTelefoneFixo(telefonefixo);
        c.setTelefoneCelular(telefonecelular);
        c.setDataNascimento(datanascimento);
        c.setNomeFilial(nomefilial);

        ClienteDAO dao = new ClienteDAO();

        if (id == null || id.trim().equals("")) {
            dao.inserir(c);
        } else {
            c.setId(Integer.parseInt(id));
            dao.atualizar(c);
        }

        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();
        
         HttpSession session = request.getSession(true);

        Object filial = session.getAttribute("filialLocalizada");

        String filialConvertida = String.valueOf(filial);

        listClientes = dao.apresentarClientes(filialConvertida);

        request.setAttribute("listarCliente", listClientes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cliente/home-cliente.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id;

        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        id = Integer.parseInt(req.getParameter("id"));
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        ClienteDAO dao = new ClienteDAO();
        String resposta;

        try {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            JSONObject json = new JSONObject();

            id = Integer.parseInt(req.getParameter("cod"));

            dao = new ClienteDAO();
            resposta = dao.excluir(id);

            if (resposta != null && !resposta.trim().equals("")) {
                json.put("resp", "Erro ao excluir.");

                resp.getWriter().write(json.toString());
                return;

            }
            json.put("resp", "Cliente excluído com sucesso");

            resp.getWriter().write(json.toString());

        } catch (Exception e) {

            JSONObject json = new JSONObject();

            json.put("resp", "Erro ao interpretar dados");

            resp.getWriter().write(json.toString());
        }

    }
}
