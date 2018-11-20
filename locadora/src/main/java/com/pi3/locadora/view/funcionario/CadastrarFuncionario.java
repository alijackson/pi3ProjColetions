/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.funcionario;

import java.io.IOException;
import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;
import java.io.PrintWriter;
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
 * @author david.sdcruz
 */
@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

    public CadastrarFuncionario() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setAttribute("objetivo", "Cadastrar Funcionario");
        ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();

        FuncionarioDAO dao = new FuncionarioDAO();

        listFuncionario = dao.apresentarFuncionarios();

        request.setAttribute("listaFuncionarios", listFuncionario);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/funcionario/funcionario.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String dataNascimento = request.getParameter("dataNascimento");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            String cargo = request.getParameter("cargo");
            String ativo = request.getParameter("ativo");
            String id = request.getParameter("id");

            Funcionario f = new Funcionario();

            f.setNome(nome);
            f.setEmail(email);
            f.setDataNascimento(dataNascimento);
            f.setLogin(login);
            f.setSenha(senha);
            f.setCpf(cpf);
            f.setCargo(cargo);

            if (ativo != null && ativo.trim().equals("on")) {
                f.setAtivo((byte) 1);
            } else {
                f.setAtivo((byte) 0);
            }

            System.out.print("Segue " + dataNascimento);

            FuncionarioDAO dao = new FuncionarioDAO();

//            if (id != null && !id.trim().equals("")) {
//                f.setId(Integer.parseInt(id));
//                dao.atualizar(f);
//            } else {
//                dao.inserir(f);
//            }
            if (id == null) {
                dao.inserir(f);
            } else {
                f.setId(Integer.parseInt(id));
                dao.atualizar(f);
            }

            ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();

            listFuncionario = dao.apresentarFuncionarios();

            request.setAttribute("listaFuncionarios", listFuncionario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/funcionario/funcionario.jsp");

            dispatcher.forward(request, response);

        } catch (Exception e) {

            PrintWriter saida = response.getWriter();
            saida.println(e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("application/json;charset=UTF-8");

        int id = 0;

        Funcionario func = new Funcionario();
        FuncionarioDAO bd = new FuncionarioDAO();


        try {
            id = Integer.parseInt(request.getParameter("id"));
            func = bd.Pesquisa(id);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JSONObject json = new JSONObject();

            json.put("id", func.getId());
            json.put("nome", func.getNome());
            json.put("cpf", func.getCpf());
            json.put("email", func.getEmail());
            json.put("dataNasc", func.getDataNascimento());
            json.put("cargo", func.getCargo().toLowerCase());
            json.put("login", func.getLogin());
            json.put("senha", func.getSenha());
            json.put("ativo", func.getAtivo());

            response.getWriter().write(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id;
        FuncionarioDAO dao = new FuncionarioDAO();
        String resposta;
            
        try {
            
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            
            JSONObject json = new JSONObject();
        
            id = Integer.parseInt(req.getParameter("id"));
                
            dao = new FuncionarioDAO();
            resposta = dao.excluir(id);
            
            if(resposta != null && !resposta.trim().equals(""))
            {
                json.put("resp", "Erro ao excluir.");

                resp.getWriter().write(json.toString());   
                return;
                
            }
            json.put("resp", "Funcionário excluído com sucesso");

            resp.getWriter().write(json.toString());
                   
            
        } catch (Exception e) {
            
            JSONObject json = new JSONObject();
        
            json.put("resp", "Erro ao interpretar dados");

            resp.getWriter().write(json.toString());
        }
        
    }
}
