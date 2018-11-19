/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.pi3.servico.Convert;

/**
 *
 * @author micro
 */
public class Funcionario extends Convert{

    private int id;
    private String nome;
    private String dataNascimento;
    private String login;
    private String cpf;
    private String email;
    private String cargo;
    private String senha;
    private byte ativo;
    private byte enable;

    public Funcionario() {
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte getAtivo() {
        return ativo;
    }

    public void setAtivo(byte ativo) {
        this.ativo = ativo;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }
    
    
}
