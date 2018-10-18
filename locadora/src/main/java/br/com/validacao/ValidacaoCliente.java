/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validacao;

import br.com.model.Cliente;

/**
 *
 * @author micro
 */
public class ValidacaoCliente {

    public static String validar(Cliente cliente) {

        //Realização de validações de negócio
        //Verifica se o cliente informou o nome
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            return "É necessário informar um nome de cliente";
        }

        //verificar se o cliente informou o email
        if (cliente.getEmail() == null
                || "".equals(cliente.getEmail())) {
            return "É necessário informar um e-mail";
        }

        //verificar se o cliente informou o cpf
        if (cliente.getCpf() == null
                || "   .   .   -  ".equals(cliente.getCpf())) {

            return "É necessário informar um CPF";
        }

        //Verifica se o cliente informou a data de nascimento
        if (cliente.getDataNascimento() == null
                || "  /  /    ".equals(cliente.getDataNascimento())) {
            return "É necessário informar um valor de data de nascimento"
                    + " válido";
        }

        //verificar se o cliente informou o telefone celular
        if (cliente.getTelefoneCelular() == null
                || "(  ) 9    -    ".equals(cliente.getTelefoneCelular())) {
            return "É necessário informar um celular ";
        }

        //verificar se o cliente informou o número de cnh
        if (cliente.getNumeroCNH() == 0) {
            return "É necessário informar o número de CNH";
        }

        //verificar se o cliente informou o número de cnh
        //Vetorna "null" indicando que todas as validações foram feitas e o
        //cliente é um cliente válido de acordo com as necessidades do negócio
        return null;

    }

}
