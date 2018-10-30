/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Pichau
 */
public class Locacao {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProtecao() {
        return protecao;
    }

    public void setProtecao(String protecao) {
        this.protecao = protecao;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getDiaRetira() {
        return diaRetira;
    }

    public void setDiaRetira(String diaRetira) {
        this.diaRetira = diaRetira;
    }

    public String getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(String diaEntrega) {
        this.diaEntrega = diaEntrega;
    }
    
    private String id;
    private String idCliente;
    private String idFuncionario;
    private String idVeiculo;
    private String codigo;
    private String protecao;
    private String precoTotal;
    private String diaRetira;
    private String diaEntrega;
    
    public Locacao(){}
    
}
