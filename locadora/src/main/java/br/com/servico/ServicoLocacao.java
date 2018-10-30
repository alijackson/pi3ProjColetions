/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servico;

import br.com.model.Locacao;
import br.com.model.dao.LocacaoDAO;
import br.com.validacao.ValidacaoLocacao;

/**
 *
 * @author Pichau
 */
public class ServicoLocacao {
    
    private LocacaoDAO dao = new LocacaoDAO();
    
    public String inserir(Locacao locacao){
        
        String resposta = ValidacaoLocacao.validar(locacao);
        
        try
        {
            
            if (resposta == null)
            {
            
                dao.inserir(locacao);
            }
        }
        catch (Exception e)
        {
        
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
    public String atualizar(Locacao locacao) {
        
        String resposta = ValidacaoLocacao.validar(locacao);
        
        try
        {
            if(resposta == null){
                dao.atualizar(locacao);
            }
        }
        catch(Exception e){
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
}
