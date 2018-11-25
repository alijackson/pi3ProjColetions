<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/util/verificacao.jsp"></jsp:include>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
    <title>Veiculos</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- ESTILOS PARA ESTA PAGINA -->
    <!-- Nesse caso, este estilo � apenas para inserir imagens -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
            <a class="navbar-brand" href="#">LogoTipo</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/locadora/home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/locadora/venda/locacao">Locação</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/locadora/cadastrarC">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/locadora/cadastrarV">Veículo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/locadora/CadastrarFuncionario">Funcionário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Filial</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- FIM DO MENU SUPERIOR -->

    <!-- INICIO TABLE -->
    <div id="form" class="container">

        <div class="row">

            <div class="col-md-10 d-flex-inline ">

                <h1>Veículos</h1>
            </div>
            <!-- AQUI QUE TEM QUE FICAR EM LINHA -->
            <div class="col-md-2 d-flex-inline ">
                <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novoVeiculo" id="btnd"
                    onclick="resetFormularioVeiculo()"> Novo Veículo</a>
            </div>
        </div>
        <hr>
        <div class="col-md-12 d-flex-inline">
            <form action="cadastrarV" method="head" class="form-inline my-2 my-lg-0 d-flex-inline" id="procura">
                <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="pesquisar"
                    name="pesquisar">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="procurar" name="procurar">Buscar</button>
            </form><br>
        </div>
        <!-- FIM -->


        <div class="col-md-12">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Modelo</th>
                    <th>Ano</th>
                    <th>Número de Documento</th>
                    <th>Marca</th>
                    <th>Placa</th>
                </tr>

                <c:forEach items="${listarVeiculos}" var="veiculo">
                    <tr onclick="editarVeiculo(${veiculo.getId()})" id="trTable">
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
                            <c:out value="${veiculo.getNumeroDocumento()}" />
                        </td>
                        <td>
                            <c:out value="${veiculo.getMarca()}" />
                        </td>
                        <td>
                            <c:out value="${veiculo.getPlaca()}" />
                        </td>
                    </tr>
                    </a>
                </c:forEach>

            </table>
        </div>
        <!-- FIM TABLE -->

        <!-- Inicio Paginação-->
        <div class="container" id="pagination">
            <nav aria-label="Page navigation ">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- FIM Paginação-->

    </div>

    <!-- Modal Cadastrar Veiculos -->
    <div class="modal fade" id="novoVeiculo" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Cadastrar Veiculo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="cadastrarV" method="post" name="formEditVeiculo">
                        <div class="form-group">
                            <!-- hidden omite as infomações -->
                            <input type="text" class="form-control" id="idVeiculo" name="idVeiculo" hidden>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="modelo">Modelo</label>
                                <input type="text" class="form-control" id="modelo" required name="modelo" placeholder="ex: Novo Uno 1.0">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="ano">Ano</label>
                                <input type="text" class="form-control" id="ano" required name="ano" placeholder="ex:2012">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="placa">Placa</label>
                                <input type="text" class="form-control" id="placa" required name="placa" placeholder="ex: XXX-XXXX">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="marca">Marca</label>
                                <input type="text" class="form-control" id="marca" required name="marca" placeholder="ex: Fiat">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="numerodedocumento">Número de Documeto</label>
                                <input type="text" class="form-control" id="numerodedocumento" required name="numerodedocumento"
                                    placeholder="ex: XXXXX-XXXX">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="caracteristica">Caracteristicas</label>
                                <select id="caracteristica" required name="caracteristica" class="form-control">
                                    <option value="2 Portas">2 portas</option>
                                    <option value="4 Portas">4 portas</option>
                                    <option value="Tracao 4x4">Tração 4x4</option>
                                    <option value="Automatico">Automático</option>
                                    <option value="Direcao Eletrica">Direção Elétrica</option>
                                </select>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="categoria">Categoria</label>
                                <select id="categoria" required name="categoria" class="form-control">
                                    <option value="Categoria A">Categoria A</option>
                                    <option value="Categaoria B">Categoria B</option>
                                    <option value="Categoria C">Categoria C</option>
                                    <option value="Categoria D">Categoria D</option>
                                    <option value="Categoria E">Categoria E</option>
                                </select>
                            </div>
                        </div>

                        <button type="reset" class="btn cancel btn-secondary " data-dismiss="modal" floa>Cancelar</button>

                        <div class="modal-foote float-right">
                            <button type="button" class="btn  btn-danger " id="excluir" name="excluir" onclick="confirmeExcluir()">
                                Excluir </button>

                            <button type="submit" class="btn btn-primary " id="butSubmit" name="butSubmit" id="butSubmit">Cadastrar</button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal de confirmação -->
    <div class="modal" tabindex="-1" role="dialog" id="mod-confirmar">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirmação</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p> Deseja realmente excluir o veículo </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="excluirVeiculo()">Sim</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    <script src="JQuery/editar-veiculo.js" type="text/javascript"></script>
    <!-- SWEET ALERT -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script src="JQuery/jquery.mask.js" type="text/javascript"></script>

    <script src="JQuery/validar.js" type="text/javascript"></script>

</body>

</html>