<%@page import="br.com.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/util/topo.jsp"></jsp:include>
    <!DOCTYPE html>
    <html lang="pt-br">

        <head>
            <title>Home</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                  crossorigin="anonymous">

            <style>
                #trTable.a.hover{

                    background-color: red;
                }
                .center{
                    text-align: center;
                }      

            </style>


        </head>

        <body>
            <div class="container">
                <div class="row">
                    <div class="col-2">

                    </div>
                    <div class="col-8">
                        <div class="row">
                            <div class="col">
                                <nav class="navbar navbar-expand-lg navbar-light bg-light scrolling-navbar fixed-top">

                                    <div class="container">
                                        <a class="navbar-brand" href="#"><img src="imagens/logotipo.png"></a>
                                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                            <span class="navbar-toggler-icon"></span>
                                        </button>
                                        <div class="collapse navbar-collapse" id="navbarNav">
                                            <ul class="navbar-nav">
                                                <li class="nav-item active">
                                                    <a class="nav-link" href="/locadora/home">HOME <span class="sr-only">(current)</span></a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="/locadora/new/locacao">LOCAÇÃO</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link " href="/locadora/cadastrarC">CLIENTE</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link " href="/locadora/cadastrarV">VEÍCULO</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link " href="/locadora/CadastrarFuncionario">FUNCIONÁRIO</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link " href="/locadora/filial">FILIAL</a>
                                                </li>
                                                <li class="nav-item pulç">
                                                    <a style="margin-left: 500px"href="logout"  class="nav-link active">LOGOUT</a>
                                                </li> 
                                            </ul>
                                        </div>

                                    </div>

                                </nav>

                                <p>${login}</p>

                            </body>



                            </html>