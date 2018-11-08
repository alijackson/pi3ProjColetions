<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv=?content-type? content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
    <title>Cadastrar Veiculo</title>
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

            </div>

        </nav>

    <br>
    <div id="form" class="container">

            <div class="row">

                <div class="col-md-10 d-flex-inline ">

                    <h1>Cadastrar Veiculo</h1>
                </div>
            </div>
            <hr>
                <form id="form" action="CadastrarVeiculo" method="post">
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

                    </div>
                     
                    <div class="form-row">
                        <div class="form-group col-md-10">
                            <label for="modelo">Modelo</label>
                            <input type="text" class="form-control" id="modelo" name="modelo" placeholder="Modelo do Veiculo">
                        </div>
                    </div>
                                
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="categoria">Categoria</label>
                            <input type="text" class="form-control" id="categoria" name="categoria" placeholder="Categoria A">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="ano">Ano</label>
                            <input type="text" class="form-control" id="ano" name="ano" placeholder="2018">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="caracter">Caracteristicas</label>
                            <input type="text" class="form-control" id="caracteristica" name="caracteristica">
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="placa">Placal</label>
                            <input type="text" class="form-control" id="placa" name="placa" placeholder="AAA-1234">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="marca">Marca</label>
                            <input type="text" class="form-control" id="placa" name="placa">
                        </div>
                        
                        <div class="form-group col-md-4">
                            <label for="numerodoc">Numero Documento</label>
                            <input type="text" class="form-control" id="numerodoc" name="numerodoc">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="imagem">Imagem</label>
                            <input type="file" class="form-control" id="imagem" name="imagem" accept="image/*">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Salvar</button>

                </form>

            </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>-->
        <script src="jquery.mask.js"></script>
        <script src="javascript.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>

</html>
