/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servico;

import br.com.model.Cliente;
import br.com.model.dao.ClienteDAO;
import br.com.validacao.ValidacaoCliente;

/**
 *
 * @author micro
 */
public class ServicoCliente {

    private ClienteDAO dao = new ClienteDAO();

    public String inserir(Cliente cliente) {

        //Chama o validador para verificar o estado deste cliente
        //e armazena sua resposta na variável de resposta
        String resposta = ValidacaoCliente.validar(cliente);

        try 
        {

            if (resposta == null) 
            {

                dao.inserir(cliente);
            }
        } 
        catch (Exception e) 
        {

            resposta = "Erro na fonte de dados";
        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi atualizado corretamente
        return resposta;

    }

    public String atualizar(Cliente cliente) {

        //Chama o validador para verificar o estado deste cliente
        //e armazena sua resposta na variável de resposta
        String resposta = ValidacaoCliente.validar(cliente);

        try {
            if (resposta == null) {

                dao.atualizar(cliente);
            }

        } catch (Exception e) {

            resposta = "Erro na fonte de dados";
        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi atualizado corretamente
        return resposta;

    }

}
