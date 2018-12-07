<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=”content-type” content="text/html;" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
        <title>Efetuar Locação</title>
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

        <script type="text/JAVASCRIPT">
            function Cliente(){
                
            }
            function Veiculo(){
                
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
                    <a class="navbar-brand" href="#"><img src="../imagens/logotipo.png"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
                            aria-expanded="false" aria-label="Toggle navigation">
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

        <div id="form" class="container">

            <div class="row">

                <div class="col-md-10 d-flex-inline ">

                    <h1>Efetuar Locação</h1>
                </div>
             

            </div>
            <hr>
            <form id="form" action="locacao" method="post">
                <!-- AQUI TEM UM BOTÃO QUE APRESENTA UMA TABELA DE CLIENTES -->
                <div class="form-row">  
                    <div class="col-md-2 d-flex-inline "> 
                        <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#clientes" id="btnd" onclick="buscarCliente()">Selecionar Cliente</a>
                    </div>
                </div>
                <br>
                <div class="form-row">
                    <!-- APRESENTAR O CLIENTE SELECIONADO -->
                    <div>
                        <label for="cliente" id="labelClient"> Cliente: </label>
                        <input type="text" id="labelIdClient" name="idClient" hidden>
                    </div>
                </div>
                <br>
                <!-- AQUI TEM UM BOTÃO QUE APRESENTA UMA TABELA DE VEICULOS -->
                <div class="form-row">
                    <div class="col-md-2 d-flex-inline "> 
                        <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#veiculos" id="btnd" onclick="buscarCar()">Selecionar Veiculo</a>
                    </div>
                </div>
                <br>
                <div class="form-row">
                        <!-- APRESENTAR O VEICULO SELECIONADO -->
                    <div>
                        <label for="veiculo" id="labelNomeCar">Veiculo: </label>
                        <input type="text" id="labelIdCar" name="idCar" hidden>
                    </div>
                </div>
                <br>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="dataNasc">Data de Retirada</label>
                        <input type="date" class="form-control" id="dateSaida" name="dataSaida">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="dataNasc" class="dataEntrega">Data de Entrega</label>
                        <input type="date" class="form-control" id="dateReturn" name="dataReturn">
                    </div>
                    <div class="form-group col-md-4">
                        <input type="text" id="totalDias" name="allDias" hidden>
                    </div>
                </div>
                <div>
                    <h2>Proteções</h2>
                </div>
                <div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="protect" value="basico">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="basico">Proteção Básica</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorBas">R$25,00 por dia</label>
                        </div>
                    </div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="protect" value="completo">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="comp">Proteção Completa</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorComp">R$35,00 por dia</label>
                        </div>
                    </div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="protect" value="super">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="super">Superproteção</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorSuper">R$45,00 por dia</label>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>Serviços</h2>
                </div>
                <div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="service" value="bebe">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="bebe">Bebê Conforto</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorBebe">R$25,00 por dia</label>
                        </div>
                    </div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="service" value="cadeira">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="cad">Cadeira de Bebê</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorCad">R$30,00 por dia</label>
                        </div>
                    </div>
                    <div class="form-row">
                        <div>
                            <input type="radio" name="service" value="gps">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="nav">Navegador GPS</label>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="valorNav">R$12,00 por dia</label>
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="totalLoc">Valor Total: </label>
                            <input type="text" id="valorTotal" name="valorTotal" class="valorTotal" placeholder="R$: ">
                        </div>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary" onclick="enviarBd()">Salvar</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="modal fade" id="clientes" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Veiculos</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="form-row">
                                <input class="form-control col-md-6" type="search" placeholder="Pesquisar Cliente" aria-label="Search" id="bcliente">
                                <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="Procurar" onclick="">Buscar</button>
                            </div>
                            <form>
                                <table class="table table-striped" id="listaCliente">
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>Email</th>
                                    </tr>
                                </table>
                                <button type="button" class="btn btn-primary" onclick="">Selecionar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="veiculos" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Veiculos</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="form-row">
                                <input class="form-control col-md-6" type="search" placeholder="Pesquisar Veiculo" aria-label="Search" id="bveiculo">
                                <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="Procurar" onclick="">Buscar</button>
                            </div>
                            <form>
                                <table class="table table-striped" id="listVeiculos">
                                    <tr>
                                        <th>ID</th>
                                        <th>Marca</th>
                                        <th>Modelo</th>
                                        <th>Ano</th>
                                        <th>Categoria</th>
                                        <th>Preço</th>
                                    </tr>
                                    <!-- RECORTEI O CODIGO DAQUI E COLEI NO NOTEPAD ++ PARA PESQUISA FUTURA>-->
                                </table>
                                <button type="button" class="btn btn-primary" onclick="">Selecionar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>

    <!-- JAVASCRIPT E JQUERY 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
    <script src="../JQuery/jquery.mask.js"></script>
    <script src="../JQuery/validar.js"></script>
    <script src="../JQuery/newLocacao.js" type="text/javascript"></script>

</html>