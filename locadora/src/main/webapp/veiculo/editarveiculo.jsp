<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <title>Atualizar Veiculo</title>
    <style>
        .center{
            text-align: center;
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
                        <a class="nav-link" href="locacoes">Locação</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="cadastrar">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="/locadora/veiculos">Veículo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="CadastrarFuncionario">Funcionário</a>
                    </li>
                </ul>
            </div>

        </div>

    </nav>

    <br>
    <br>
    <br>
    <br>
    
    <div class="container">
        <div class="row">

            <div class="col-2" style="background: write">
                <!-- Primeira lateral-->
            </div>

            <div class="col-8" style="background: write">
                <form id="form" action="/locadora/editar/veiculo" method="post" items="${Veiculo}" var="veiculo">
                    <div class="form-row">
                        <div class="col">
                            <div class="center">
                                <h1>
                                    <c:out value="${objetivo}" />
                                </h1>
                            </div>
                        </div>
                        <div class="w-100">

                        </div>
                        <div class="form-group col-md-1">
                            <label for="modelo">ID</label>
                            <input type="text" value="${veiculo.getId()}" class="form-control" id="id" name="id">
                        </div>

                        <div class="form-group col-md-10">

                            <label for="modelo">Modelo</label>
                            <input type="text" value="${veiculo.getModelo()}" class="form-control" id="modelo" name="modelo"
                                placeholder="Modelo do Veiculo">
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="categoria">Categoria</label>
                            <input type="text" value="${veiculo.getCategoria()}" class="form-control" id="categoria"
                                name="categoria" placeholder="Categoria A">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="ano">Ano</label>
                            <input type="text" value="${veiculo.getAno()}" class="form-control" id="ano" name="ano"
                                placeholder="2018">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="caracter">Caracteristicas</label>
                            <input type="text" value="${veiculo.getCaracter()}" class="form-control" id="caracteristica"
                                name="caracteristica">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="placa">Placa</label>
                            <input type="text" value="${veiculo.getPlaca()}" class="form-control" id="placa" name="placa"
                                placeholder="AAA-1234">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="marca">Marca</label>
                            <input type="text" value="${veiculo.getMarca()}" class="form-control" id="marca" name="marca">
                        </div>

                        <div class="form-group col-md-4">
                            <label for="numerodoc">Numero Documento</label>
                            <input type="text" value="${veiculo.getNumeroDoc()}" class="form-control" id="numerodoc"
                                name="numerodoc">
                            <!--                           <input value = "${veiculo.getId()}" class="form-control" id="id" name="id"> -->
                        </div>
                    </div>
                    <!--
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="imagem">Imagem</label>
                            <input type="file" value="${veiculo.getImagem()}" class="form-control" id="imagem" name="imagem" accept="image/*">
                        </div>
                    </div>
-->
                    <button type="submit" class="btn btn-primary">Salvar</button>

                    <a href="/locadora/remover/veiculo?id=${veiculo.getId()}" class="btn btn-danger" role="button">
                        Excluir
                    </a>

                </form>

            </div>
            <div class="col-2" style="background: write">


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
        <script src="jquery.mask.js"></script>
        <script src="javascript.js"></script>
</body>

</html>