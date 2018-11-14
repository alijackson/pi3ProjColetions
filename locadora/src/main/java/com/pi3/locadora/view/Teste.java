/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import br.com.model.Funcionario;
import br.com.model.dao.FuncionarioDAO;

/**
 *
 * @author jackson
 */
public class Teste {
    public static void main (String[]args)
    {
         String nome = "nome";
        String email = "email";
        String dataNascimento = "09/03/2019";
        String login = "login";
        String senha = "senha";
        String cpf = "cpf";
        String cargo = "cargo";
        String ativo = "ativo";
        String id = null;

        Funcionario f = new Funcionario();

        f.setNome(nome);
        f.setEmail(email);
        f.setDataNascimento(dataNascimento);
        f.setLogin(login);
        f.setSenha(senha);
        f.setCpf(cpf);
        f.setCargo(cargo);

        if(ativo.trim().equals("on"))
            f.setAtivo((byte) 1);
        else
            f.setAtivo((byte) 0);

        System.out.print("Segue "+dataNascimento);

        FuncionarioDAO dao = new FuncionarioDAO();

        if(id != null)
        {
            f.setId(Integer.parseInt(id));
            dao.atualizar(f);
        }
        else
            dao.inserir(f);

    }
           
}
