/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validacao;

import br.com.model.Locacao;

/**
 *
 * @author Pichau
 */
public class ValidacaoLocacao {
    
    public static String validar(Locacao l){
    
        if (l.getIdCliente()== null || "".equals(l.getIdCliente())) {
            return "É necessário informar o id do Cliente";
        }

        if (l.getIdFuncionario()== null
                || "".equals(l.getIdFuncionario())) {
            return "É necessário informar o id do funcionario";
        }

        if (l.getIdVeiculo()== null
                || "".equals(l.getIdVeiculo())) {
            return "É necessário informar o id do veiculo";
        }

        if (l.getCodigo()== null
                || "  -    ".equals(l.getCodigo())) {
            return "É necessário informar o codigo ???";
        }

        if (l.getProtecao()== null
                || "".equals(l.getProtecao())) {
            return "É necessário informar a proteção da locação";
        }

        if (l.getPrecoTotal()==null
                || "".equals(l.getPrecoTotal())) {
            return "É necessário informar o preço total da locação";
        }

        if (l.getDiaRetira()== null
                || "".equals(l.getDiaRetira())) {
            return "É necessário informar o dia de retirada do veiculo";
        }
        
        if (l.getDiaEntrega()== null
                || "".equals(l.getDiaEntrega())) {
            return "É necessário informar o dia de entrega do veiculo";
        }

        return null;
        
    }
    
}
