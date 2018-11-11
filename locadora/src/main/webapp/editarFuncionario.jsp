<%-- 
    Document   : editarFuncionario
    Created on : 09/11/2018, 00:02:28
    Author     : David Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=”content-type” content="text/html;" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
        <title>TakeYourCar</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- BOOTSTRAP -->

        <link type="text/css" rel="stylesheet" href="Boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- ESTILOS PARA ESTA PÁGINA -->
        <!-- Nesse caso, este estilo é apenas para inserir imagens -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


        <!-- SWEET ALERT -->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script type="text/JAVASCRIPT">

            function excluir(){
            swal({
            title: "Deseja excluir?",
            text: "Você estará deletendo do sistema!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            })
            .then((willDelete) => {
            if (willDelete) {
            swal("Poof! Funcionário deletado com sucesso!", {
            icon: "success",
            });
            } else {
            swal("Seu funcionário ainda está salvo!");
            }
            });

            }
            function sucesso(){

            swal({
            title: "Sucesso!",
            text: "Funcionário cadastrado com sucesso!",
            icon: "success",
            button: "Ok",
            });

            $('.abrir').on('click', function(){

            $('.modal').modal('show');  

            });

            $('.modal').on('click', function(){

            $('.modal').modal('hide'); 

            });

            $('form').on('submit', function(){

            $('.modal').modal('hide'); 

            });
            }
        </script>

        <!-- STYLES --> 
        <style>
            #Body{

                margin-top: 10%;
                margin-left: 8%;

            }

            #menu{

                margin-left: 5%;
            }
            #logout{

                margin-right: 1%;
            }


            #lol{

                display: inline-block;
            }
            #form{

                margin-top: 5%;
            }
            #pagination{

                margin-left: 40%;
                margin-right: 40%;
            }


        </style>

    </head>

    <body>
        <!-- INÍCIO DO MENU SUPERIOR -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light scrolling-navbar fixed-top">

            <div class="container">
                <a class="navbar-brand" href="#">LogoTipo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="locacoes">Locação</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="cadastrar">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="veiculos.jsp">Veículo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="CadastrarFuncionario">Funcionário</a>
                        </li>
                    </ul>
                </div>

            </div>

        </nav>

        <!-- FIM DO MENU SUPERIOR -->

        <!-- INICIO TABLE -->
        <div id="form" class="container">
            <div class="modal-body">
                <form action="EditarFuncionario" method="post">
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" value = "${funcionario.getNome()}" class="form-control" id="nome" required name="nome">
                        <input  type="text" value = "${funcionario.getId()}" class="form-control" id="id" name="id">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="email">Email</label>
                            <input type="email" value = "${funcionario.getEmail()}" class="form-control" id="email" required name="email" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="dataNascimento">Data de Nascimento</label>
                            
                            <input type="date" class="form-control" value = "${funcionario.getDataNascimento()}" id="dataNascimento" required name="dataNascimento" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="login">Login</label>
                            <input type="text" class="form-control" value = "${funcionario.getLogin()}"  id="login"  required name="login" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" value = "${funcionario.getSenha()}" id="senha"  required name="senha">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cpf">CPF</label>
                            <input type="text" value = "${funcionario.getCpf()}" class="form-control" id="cpf" required name="cpf" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="cargo">Área</label>
                            <select id="cargo" value = "${funcionario.getCargo()}" required name="cargo"class="form-control">
                                <option selected>Vendedor</option>
                                <option>Gerente TI</option>
                                <option>Gerente</option>
                                <option>Administrador</option>
                            </select>
                        </div>
                    </div>

                    <div class="modal-footer" >
                        <button type="submit" class="btn btn-primary">Atualizar</button> 
                        <a href="RemoverFuncionario?id=${funcionario.getId()}" class="btn btn-danger" role="button">
                            Excluir 
                        </a>
                    </div>
                </form>
            </div> 
        </div>

    </body>

    <!-- BOOTSTRAP CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>