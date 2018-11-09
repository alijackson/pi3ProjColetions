/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servico;

import br.com.model.Veiculo;
import br.com.model.dao.VeiculoDAO;
import br.com.validacao.ValidacaoVeiculo;

/**
 *
 * @author Pichau
 */
public class ServicoVeiculo {
    
    private VeiculoDAO dao = new VeiculoDAO();
    
    public String inserir(Veiculo veiculo){
        
        String resposta = ValidacaoVeiculo.validar(veiculo);
        
        try{
            
            if (resposta == null)
            {
                
                dao.inserir(veiculo);
            }
            
        }catch (Exception e)
        {
        
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
        
    }
    
    public String atualizar(Veiculo veiculo){
        
        String resposta = ValidacaoVeiculo.validar(veiculo);
        try{
            
            if (resposta == null)
            {
                dao.atualizar(veiculo);
            }
        
        } catch (Exception e){
            
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
}
