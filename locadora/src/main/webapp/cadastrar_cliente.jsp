<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
  <title>Cadastro Cliente</title>
</head>

<body>
  <center>
    <h1>
      Cadastrar cliente
    </h1>
  </center>
  <br>
  <div class="container">
    <div class="row">

      <div class="col-2" style="background: write">
        <!-- Primeira lateral-->
      </div>
      <div class="col-8" style="background: write">
        <form id="form">
          <div class="form-row">
            <!-- Inicio de First Nome -->
            <div class="form-group col-md-4">
              <span id="erroNome">Insira o nome</span>
              <label for="inputNome">Nome</label>
              <input type="text" class="form-control" id="Nome" placeholder="Nome">
            </div>
            <!-- Inicio de SobreNome -->
            <div class="form-group col-md-8">
              <label for="inputSobreNome">Sobre Nome</label>
              <input type="text" class="form-control" id="SobreNome" placeholder="Sobre Nome">
            </div>
          </div>
          <!-- Inicio de CPF -->
          <div class="form-group">
            <label for="cpf">CPF</label>
            <input type="text" class="form-control" id="cpf" placeholder="123.123.123-75">
          </div>
          <!-- Inicio de E-mail -->
          <div class="form-group">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" id="email" placeholder="exemplo@exemplo.com.br">
          </div>
          <div class="form-row">
            <!-- Inicio de telefone fixo -->
            <div class="form-group col-md-6">
              <label for="tel">Nº Tel</label>
              <input type="text" class="form-control" id="tel">
            </div>
            <!-- Inicio de telefone Celular -->
            <div class="form-group col-md-6">
              <label for="cel">Nº Cel</label>
              <input type="text" class="form-control" id="cel">
            </div>

            <!-- Inicio de Data de Nascimento -->
            <div class="form-group col-md-6">
              <label for="dataNasc">Data de nascimento</label>
              <input type="text" class="form-control" id="dataNasc">
            </div>
            <div class="form-group col-md-6">
              <label for="cnh">Nº CNH</label>
              <input type="text" class="form-control" id="cnh">
            </div>
          </div>
          <div class="form-group col-md-2">
            <label for="inputZip">Estado</label>
            <input type="text" class="form-control" id="inputZip">
          </div>

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