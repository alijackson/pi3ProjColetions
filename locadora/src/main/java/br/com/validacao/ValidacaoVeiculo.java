/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validacao;

import br.com.model.Veiculo;

/**
 *
 * @author Pichau
 */
public class ValidacaoVeiculo {
    
    public static String validar(Veiculo v){
    
        if (v.getModelo()== null || "".equals(v.getModelo())) {
            return "É necessário informar o modelo do veiculo";
        }
        
        if (v.getCategoria()== null
                || "".equals(v.getCategoria())) {
            return "É necessário informar a categoria do veiculo";
        }
        
        if (v.getAno() == null
                || "".equals(v.getAno())) {
            return "É necessário informar o ano do veiculo";
        }
        
        if (v.getPlaca()== null
                || "  -    ".equals(v.getPlaca())) {
            return "É necessário informar a placa do veiculo";
        }
        
        if (v.getMarca()== null
                || "".equals(v.getMarca())) {
            return "É necessário informar a marca do veiculo";
        }
        
        if (v.getNumeroDoc()== 0
                || "".equals(v.getNumeroDoc())) {
            return "É necessário informar o número de documento do veiculo";
        }
        
        if (v.getCaracter() == null
                || v.getCaracter().equals("")) {
            return "É necessário informar as caracteristicas do veiculo";
        }
        
        return null;
    
    }
    
}
