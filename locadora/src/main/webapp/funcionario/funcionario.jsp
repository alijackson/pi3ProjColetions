<%-- 
    Document   : funcionario
    Created on : 05/11/2018, 19:36:16
    Author     : david.sdcruz
--%>

<%@page import="br.com.model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/util/verificacao.jsp"></jsp:include>
<!doctype html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
    <title>Funcionarios</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- ESTILOS PARA ESTA PÁGINA -->
    <!-- Nesse caso, este estilo é apenas para inserir imagens -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" type="text/css" href="style/buttonSeletor.css" <!-- SWEET ALERT -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script type="text/JAVASCRIPT">

            function excluir() {
            swal({
            title: "Deseja excluir?",
            text: "Você estará deletendo do sistema!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            } )
            .then((willDelete) => {
            if (willDelete) {
            swal("Poof! Funcionário deletado com sucesso!", {
            icon: "success",
            });
            } else {
            swal("Seu funcionário ainda está salvo!");
            }
            });

            }
            function sucesso(){

            swal({
            title: "Sucesso!",
            text: "Funcionário cadastrado com sucesso!",
            icon: "success",
            button: "Ok",
            });

            $('.abrir').on('click', function(){

            $('.modal').modal('show');  

            });

            $('.modal').on('click', function(){

            $('.modal').modal('hide'); 

            });

            $('form').on('submit', function(){

            $('.modal').modal('hide'); 

            });
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

                <h1>Funcionários</h1>
            </div>
            <!-- AQUI QUE TEM QUE FICAR EM LINHA -->


            <div class="col-md-2 d-flex-inline ">
                <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novoFun" id="btnd"
                    onclick="resetFormEdit()"> Novo Funcionário</a>
            </div>
        </div>
        <hr>
        <div class="col-md-12 d-flex-inline">
            <form action="buscarF" method="post" class="form-inline my-2 my-lg-0 d-flex-inline" id="procura">
                <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="pesquisar"
                    name="pesquisar">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"> Buscar</button>
            </form><br>
        </div>
        <!-- FIM -->


        <div class="col-md-12">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Área</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
                </tr>

                <c:forEach items="${listaFuncionarios}" var="funcionario">
                    <tr onclick="editarFunc(${funcionario.getId()}) " id="trTable">
                        <td>
                            <c:out value='${funcionario.getId()}' />
                        </td>
                        <td>
                            <c:out value="${funcionario.getNome()}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.getCargo()}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.getEmail()}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.getCpf()}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.getDataNascimento()}" />
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

    <!-- Modal Cadastrar usuário -->
    <div class="modal fade" id="novoFun" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Cadastrar Funcionário</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="CadastrarFuncionario" method="post" name="formEditCad">
                        <div class="form-group">
                            <!-- hidden omite as infomações -->
                            <input type="text" class="form-control" id="id" name="id" placeholder="ID" hidden>
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" required name="nome" placeholder="ex: Jose Silva">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="email" required name="email" placeholder="ex: Augusto@gmail.com">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="dataNascimento">Data de Nascimento</label>
                                <input type="date" class="form-control" id="dataNascimento" required name="dataNascimento"
                                    placeholder="ex: 12/12/2012">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" id="login" required name="login" placeholder="ex: Login">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" required name="senha"
                                    placeholder="Senha">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="cpf">CPF</label>
                                <input type="text" class="form-control" id="cpf" required name="cpf" placeholder="123.123.123-12">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="cargo">Área</label>
                                <select id="cargo" required name="cargo" class="form-control">
                                    <option value="vendedor">Vendedor</option>
                                    <option value="gerente ti">Gerente TI</option>
                                    <option value="gerente">Gerente</option>
                                    <option value="administrador">Administrador</option>
                                </select>
                            </div>

                            <!--<div class="switch__container float-left">
                                <small>Ativo
                                    <input id="switch-shadow" class="switch switch--shadow" type="checkbox" checked="true"
                                        name="ativo" id="ativo">
                                    <label for="switch-shadow"></label>
                                </small>
                            </div>-->
                        </div>

                        <button type="reset" class="btn cancel btn-secondary float-right" data-dismiss="modal">Cancelar</button>

                        <button class="btn btn-primary float-right" id="butSubmit" name="butSubmit" id="butSubmit">Cadastrar</button>
                        <button type="button" class="btn btn-danger " id="excluir" name="excluir" onclick="confirmarExcluir()">
                            Excluir </button>

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
                    <p> Deseja realmente excluir o Funcionário </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="excluirFunc()">Sim</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                </div>
            </div>
        </div>
    </div>
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

    <script src="JQuery/cadastroFunc.js" type="text/javascript"></script>

    <script src="JQuery/jquery.mask.js" type="text/javascript"></script>

    <script src="JQuery/validar.js" type="text/javascript"></script>

</body>

</html>