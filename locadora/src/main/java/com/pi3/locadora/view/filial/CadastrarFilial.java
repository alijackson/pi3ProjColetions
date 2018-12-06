/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.filial;

import br.com.model.Filial;
import br.com.model.dao.FilialDAO;
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
 * @author david
 */
@WebServlet(name = "telaInicialFilial", urlPatterns = {"/filial"})
public class CadastrarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Filial> listFilial = new ArrayList<Filial>();

        FilialDAO dao = new FilialDAO();

        listFilial = dao.apresentarFiliais();

        request.setAttribute("listarFilial", listFilial);

        RequestDispatcher dispatcher = request.getRequestDispatcher("filial/home-filial.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomefilial = request.getParameter("nomefilial");
        String cidade = request.getParameter("cidade");
        String telefonefixo = request.getParameter("telefonefixo");
        String telefonecelular = request.getParameter("telefonecelular");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String complemento = request.getParameter("complemento");
        String id = request.getParameter("id");

        Filial f = new Filial();

        f.setNome(nomefilial);
        f.setCidade(cidade);
        f.setTelefonefixo(telefonefixo);
        f.setTelefonecelular(telefonecelular);
        f.setRua(endereco);
        f.setNumero(numero);
        f.setCep(cep);
        f.setEmail(email);
        f.setComplemento(complemento);

        FilialDAO dao = new FilialDAO();

        if (id == null || id.trim().equals("")) {
            dao.inserir(f);
        } else {
            f.setId(Integer.parseInt(id));
            dao.atualizar(f);
        }

        ArrayList<Filial> listFilial = new ArrayList<Filial>();

        listFilial = dao.apresentarFiliais();

        request.setAttribute("listarFilial", listFilial);

        RequestDispatcher dispatcher = request.getRequestDispatcher("filial/home-filial.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id;

        Filial f = new Filial();
        FilialDAO dao = new FilialDAO();

        id = Integer.parseInt(req.getParameter("id"));
        f = dao.pesquisa(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        json.put("id", f.getId());
        json.put("nomefilial", f.getNome());
        json.put("cidade", f.getCidade());
        json.put("telefonefixo", f.getTelefonefixo());
        json.put("telefonecelular", f.getTelefonefixo());
        json.put("endereco", f.getRua());
        json.put("numero", f.getNumero());
        json.put("cep", f.getCep());
        json.put("email", f.getEmail());
        json.put("complemento", f.getComplemento());

        resp.getWriter().write(json.toString());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;

        String resposta;

        try {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            FilialDAO dao = new FilialDAO();

            JSONObject json = new JSONObject();

            id = Integer.parseInt(req.getParameter("cod"));

            resposta = dao.excluir(id);

            if (resposta != null && !resposta.trim().equals("")) {
                json.put("resp", "Erro ao excluir.");

                resp.getWriter().write(json.toString());
                return;

            }
            json.put("resp", "Filial excluida com sucesso");

            resp.getWriter().write(json.toString());

        } catch (Exception e) {

            JSONObject json = new JSONObject();

            json.put("resp", "Erro ao interpretar dados");

            resp.getWriter().write(json.toString());
        }

    }

}
