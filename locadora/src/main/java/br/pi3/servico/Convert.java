/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.servico;

/**
 *
 * @author jacks
 */
public class Convert {
    /**
     * Função recebe uma data no formato aaaa-mm-dd
     * e converte para o formato dd/mm/aaaa
     * @param date
     * @return 
     */
    public String convertDate(String date)
    {
        String data = date.replaceAll("-", "/");
        String[] s = data.split("/");
        return s[2]+"/"+s[1]+"/"+s[0];
    }
    
}
