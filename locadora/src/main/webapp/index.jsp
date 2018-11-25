<%-- 
    Document   : login
    Created on : 06/10/2018, 14:05:06
    Author     : alijackson.msilva
--%>
<%@page import="br.com.model.Funcionario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
    </head>


    <!-- ESTILOS PARA ESTA PAGINA -->
    <!-- Nesse caso, este estilo apenas para inserir imagens -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


    <style>

        #mensagem{

            text-align: center;
            font-family: Verdana;
            font-style: normal;


        }


    </style>




    <body>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light scrolling-navbar fixed-top">

                        <div class="container">
                            <a class="navbar-brand" href="#">LogoTipo</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <div class="collapse navbar-collapse" id="navbarNav">
                                    <ul class="navbar-nav">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="/locadora/inicio">HOME <span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="/locadora/venda/locacao">LOCAÇÃO</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link disabled" href="/locadora/cadastrarC">CLIENTE</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link disabled" href="/locadora/cadastrarV">VEÍCULO</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link disabled" href="/locadora/CadastrarFuncionario">FUNCIONÁRIO</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link disabled" href="#">FILIAL</a>
                                        </li>

                                    </ul>
                                </div>
                            </div>

                        </div>

                    </nav>
                </div>

                <div class="col-6">
                    <br><br><br><br>
                    <h1 style="text-align: center">LOCADORA FIVE</h1>



                    <form   class="px-4 py-3" action="verificarL" method="post">
                        <div class="form-group">
                            <label for="exampleDropdownFormEmail1">Login</label>
                            <input type="text" class="form-control" name="login" id="login" placeholder="Usuario">
                        </div>
                        <div class="form-group">
                            <label for="exampleDropdownFormPassword1">Senha</label>
                            <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
                        </div>

                        <button type="submit" class="btn btn-primary">Entrar</button>

                    </form>



                    <p id="mensagem"> ${mensagem}</p>

                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    </body>
</html>
