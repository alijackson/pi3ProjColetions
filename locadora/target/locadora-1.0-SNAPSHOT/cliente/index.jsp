<%@page import="br.com.model.Cliente"%>
<%@page import="com.pi3.locadora.view.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

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
                        
                        <div class="center">
                                <h1>
                                    Clientes
                                </h1>
                        </div>
                    </div>
                    <div class="w-100">

                    </div>
                    <div class="col">
                        <table class="table table-striped" id="table">
                            <tbody>
                                <thead>
                                    <tr>

                                        <th scope="col">#</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">CPF</th>
                                        <th scope="col">E-mail</th>
                                    </tr>
                                </thead>

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
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>

</html>