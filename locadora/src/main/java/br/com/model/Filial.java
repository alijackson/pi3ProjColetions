/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Kujikeo
 */
public class Filial {

    private int id;
    private String nome;
    private String telefonefixo;
    private String telefonecelular;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String email;
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefonefixo() {
        return telefonefixo;
    }

    public void setTelefonefixo(String telefonefixo) {
        this.telefonefixo = telefonefixo;
    }

    public String getTelefonecelular() {
        return telefonecelular;
    }

    public void setTelefonecelular(String telefonecelular) {
        this.telefonecelular = telefonecelular;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
