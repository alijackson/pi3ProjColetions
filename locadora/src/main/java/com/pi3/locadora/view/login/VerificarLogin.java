/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view.login;

import br.com.model.dao.LoginDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author micro
 */
@WebServlet(name = "VerificarUsuario", urlPatterns = {"/verificarL"})
public class VerificarLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        LoginDAO dao = new LoginDAO();

        if (login.equals("") && senha.equals("")) {

            request.setAttribute("mensagem", "Informar login e senha");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } else if (login.equals("")) {
            request.setAttribute("mensagem", "Informar login");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } else if (senha.equals("")) {

            request.setAttribute("mensagem", "Informar senha");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } else {

            boolean resposta = dao.checarLogin(login, senha);

            if (dao.getAtivo() == 0) {

                request.setAttribute("mensagem", "Usuário não permitido");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/index.jsp");

                dispatcher.forward(request, response);

                return;
            }

            if (resposta == true) {

                String filial = dao.retornarFilial(login, senha);

                HttpSession session = request.getSession(true);

                session.setAttribute("login", "true");

                session.setAttribute("filialLocalizada", filial);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/tela-principal/tela-principal.jsp");

                dispatcher.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Usuário não cadastrado");

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/index.jsp");

                dispatcher.forward(request, response);

            }

        }

    }

}
