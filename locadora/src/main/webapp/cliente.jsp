<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <title>Cadastro Cliente</title>
    <style>
        .center{
            text-align: center;
        }
    </style>
</head>

<body>

    <br>
    <div class="container">
        <div class="row">

            <div class="col-2" style="background: write">
                <!-- Primeira lateral-->
            </div>

            <div class="col-8" style="background: write">
                <form id="form" action="cadastrar" method="post">
                    <div class="form-row">
                        <div class="col">
                            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                                <a class="navbar-brand" href="#">Locadora</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarNav">
                                    <ul class="navbar-nav">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="main">Home<span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="cadastrar">Cadastrar</a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                            <div class="center">
                                <h1>
                                    <c:out value="${objetivo}" />
                                </h1>
                            </div>
                        </div>
                        <div class="w-100">

                        </div>
                        <!-- Inicio de First Nome -->
                        <div class="form-group col-md-10">
                            <span id="erroNome">Insira o nome</span>
                            <label for="inputNome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome Completo">
                        </div>
                        <!-- Inicio de SobreNome -->
                        <!--            <div class="form-group col-md-8">
              <label for="inputSobreNome">Sobre Nome</label>
              <input type="text" class="form-control" id="SobreNome" placeholder="Sobre Nome">
            </div> -->
                    </div>
                    <!-- Inicio de CPF -->
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" id="cpf" name="cpf" placeholder="123.123.123-12">
                        </div>
                        <div class="form-group col-md-5">
                            <label for="cpf">RG</label>
                            <input type="text" class="form-control" id="rg" name="rg" placeholder="12.123.123-12">
                        </div>
                    </div>
                    <!-- Inicio de E-mail -->
                    <div class="form-row">
                        <div class="form-group col-md-10">
                            <label for="email">E-mail</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="exemplo@exemplo.com.br">
                        </div>
                    </div>

                    <div class="form-row">
                        <!-- Inicio de telefone fixo -->
                        <div class="form-group col-md-5">
                            <label for="tel">N� Tel</label>
                            <input type="text" class="form-control" id="tel" name="tel">
                        </div>
                        <!-- Inicio de telefone Celular -->
                        <div class="form-group col-md-5">
                            <label for="cel">N� Cel</label>
                            <input type="text" class="form-control" id="cel" name="cel">
                        </div>
                    </div>
                    <!-- Inicio de Data de Nascimento -->
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="dataNasc">Data de nascimento</label>
                            <input type="date" class="form-control" id="dataNasc" name="dataNasc">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dataNasc">Idade</label>
                            <input type="number" class="form-control" id="idade" name="idade">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="cnh">N� CNH</label>
                            <input type="number" class="form-control" id="cnh" name="cnh" maxlength="9">
                        </div>
                    </div>
                    <!--          <div class="form-group col-md-2">
            <label for="inputZip">Estado</label>
            <input type="text" class="form-control" id="estado">
            </div> -->

                    <button type="submit" class="btn btn-primary">Salvar</button>

                </form>

            </div>
            <div class="col-2" style="background: write">
                <!-- Terceira latera-->

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