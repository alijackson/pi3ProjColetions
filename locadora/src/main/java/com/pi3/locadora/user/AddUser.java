/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.user;

/**
 *
 * @author alijackson.msilva
 */
public class AddUser extends User{
    public AddUser(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }
}
