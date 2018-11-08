<%@page import="br.com.model.Cliente"%>
<%@page import="com.pi3.locadora.view.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv=”content-type” content="text/html;" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
        <title>Home</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- ESTILOS PARA ESTA PÁGINA -->
        <!-- Nesse caso, este estilo é apenas para inserir imagens -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


        <!-- SWEET ALERT -->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

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
        <div class="container">
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <div class="row">
                        <div class="col">
                            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                                <a class="navbar-brand" href="#"><c:out value='${usuario}' /></a>
                                <a class="navbar-brand" href="#">LogoTipo</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarNav">
                                    <ul class="navbar-nav">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
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
                            </nav>
                            <div class="center">
                                <h1>
                                    Clientes
                                </h1>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <table class="table table-striped" id="table">
                                <tbody>
                                    <tr>
                                        <th >ID</th>
                                        <th >Nome</th>
                                        <th >CPF</th>
                                        <th>E-mail</th>
                                    </tr>

                                    <c:forEach items="${listaCliente}" var="cliente">
                                        <tr onclick="location.href = 'edit?id=<c:out value='${cliente.getId()}' />'"  id="trTable"  >
                                            <td>
                                                <c:out value='${cliente.getId()}' />
                                            </td>
                                            <td>
                                                <c:out value="${cliente.getNome()}" />
                                            </td>
                                            <td>
                                                <c:out value="${cliente.getCpf()}" />
                                            </td>
                                            <td>
                                                <c:out value="${cliente.getEmail()}" />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-2">

                </div>
            </div>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    </body>

</html>