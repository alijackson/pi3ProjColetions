<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    
<head>
    <meta charset="utf-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
    <title>Veiculos</title>
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
    <nav class="navbar navbar-expand-lg navbar-light bg-light scrolling-navbar fixed-top">

        <div class="container">
            <a class="navbar-brand" href="#">LogoTipo</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/locadora/main">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/locadora/venda/locacao">Locação</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="/locadora/main">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="/locadora/veiculos">Veículo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="/locadora/CadastrarFuncionario">Funcionário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Filial</a>
                    </li>
                </ul>
            </div>

        </div>

    </nav>
    
    <div id="form" class="container">
        
        <div class="row">

                <div class="col-md-10 d-flex-inline ">

                    <h1>Veiculos</h1>
                </div>
                <!-- AQUI QUE TEM QUE FICAR EM LINHA -->


                <div class="col-md-2 d-flex-inline ">  
                    <a class="btn btn-primary btn-block" href="cadastro/veiculo" id="btnd"> Novo Veiculo</a>  
                </div>
            </div>
            <hr>
            <div class="col-md-12 d-flex-inline"> 
                <form class="form-inline my-2 my-lg-0 d-flex-inline" id="procura"> 
                    <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="input2">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="Procurar">Buscar</button>
                </form><br>
            </div>
        
        <div class="col-md-12">
            <table class="table table-striped" id="table">
                <tbody>
                    <thead>
                        <tr>

                            <th scope="col">#</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Ano</th>
                            <th scope="col">NumeroDoc</th>
                        </tr>
                    </thead>

                    <c:forEach items="${listaVeiculos}" var="veiculo">
                       <tr onclick="location.href = '/locadora/editar/veiculo?id=<c:out value='${veiculo.getId()}' />'"  id="trTable"  >
                            <td>
                                <c:out value='${veiculo.getId()}' />
                            </td>
                            <td>
                                <c:out value="${veiculo.getModelo()}" />
                            </td>
                            <td>
                                <c:out value="${veiculo.getAno()}" />
                            </td>
                            <td>
                                <c:out value="${veiculo.getNumeroDoc()}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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
