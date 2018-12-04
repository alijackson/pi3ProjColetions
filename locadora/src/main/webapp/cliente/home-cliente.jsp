<%@page import="br.com.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/util/topo.jsp"></jsp:include>
    <!DOCTYPE html>
    <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv=”content-type” content="text/html;" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
            <title>Clientes</title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                  crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

            <!-- ESTILOS PARA ESTA PAGINA -->
            <!-- Nesse caso, este estilo � apenas para inserir imagens -->
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

            <!-- SWEET ALERT -->
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


            <style>
                #Body{

                    margin-top: 10%;
                    margin-left: 8%;

                }

                #mensagem{

                    text-align: center;


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
                    <a class="navbar-brand" href="#"><img src="imagens/logotipo.png"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="/locadora/home">HOME <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">LOCAÇÃO</a>
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
                            <li class="nav-item">
                                <a class="nav-link " href="/locadora/GerarRelatorio">RELATORIO</a>
                            </li>
                            <li class="nav-item pulç">
                                <a style="margin-left: 500px"href="logout"  class="nav-link active">LOGOUT</a>
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

                        <h1>Clientes</h1>
                    </div>
                    <!-- AQUI QUE TEM QUE FICAR EM LINHA -->


                    <div class="col-md-2 d-flex-inline ">  
                        <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novoCliente" id="btnd" onclick="resetFormularioCliente()"> Novo Cliente</a>  
                    </div>
                </div>
                <hr>
                <div class="col-md-12 d-flex-inline">  
                    <form action="buscarC" method="post" class="form-inline my-2 my-lg-0 d-flex-inline" id="procura"> 
                        <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="pesquisar" name="pesquisar">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="procurar" name = "procurar">Buscar</button>
                    </form><br>
                </div>
                <!-- FIM -->


                <div class="col-md-12">
                    <table class="table table-striped">
                        <tr>  
                            <th>Nome</th>
                            <th>Data Nascimento</th>
                            <th>Email</th>
                            <th>Número CNH</th>
                            <th>CPF</th>
                        </tr>

                    <c:forEach items="${listarCliente}" var="cliente">
                        <tr onclick="editarCliente(${cliente.getId()})"  id="trTable"  >
                            <td hidden><c:out value='${cliente.getId()}' /></td>
                            <td><c:out value="${cliente.getNome()}" /> </td>
                            <td> <c:out value="${cliente.getDataNascimento()}" /></td>
                            <td><c:out value="${cliente.getEmail()}" /> </td>
                            <td><c:out value="${cliente.getNumeroCNH()}" /> </td>
                            <td><c:out value="${cliente.getCpf()}" /> </td>
                        </tr>
                        </a>
                    </c:forEach>
                </table>
            </div>

            <p id="mensagem">${mensagem}</p>
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
        <div class="modal fade" id="novoCliente" tabindex="-1" role="dialog" aria-labelledby="modalCliente" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalCliente">Cadastrar Cliente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="cadastrarC" method="post" name="formEditCliente">
                            <div class="form-group">
                                <!-- hidden omite as infomações -->
                                <input type="text" class="form-control" id="idCliente" name="idCliente" hidden>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="nome">Nome</label>
                                    <input type="text" class="form-control" id="nome" required name="nome" placeholder="ex: Jose Santos">
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="numerocnh">Número CNH</label>
                                    <input type="text" class="form-control" id="numerocnh"  required name="numerocnh"placeholder="ex: xxxx-xxxx">
                                </div>

                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="cpf">CPF</label>
                                    <input type="text" class="form-control" id="cpf" required name="cpf" placeholder="ex: xxx-xxx-xxx-xx">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="rg">RG</label>
                                    <input type="text" class="form-control" id="rg" required name="rg" placeholder="ex: xxx-xxx-xx-xx">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email"  required name="email"placeholder="ex: david@bol.com.br">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="telefonefixo">Telefone Fixo</label>
                                    <input type="tel" class="form-control" id="telefonefixo"  required name="telefonefixo"placeholder="ex: (xx) xxxx-xxxx">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="telefonecelular">Telefone Celular</label>
                                    <input type="tel" class="form-control" id="telefonecelular"  required name="telefonecelular"placeholder="ex: (xx) 9xxxx-xxxx">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="datanascimento">Data Nascimento</label>
                                    <input type="date" class="form-control" id="datanascimento"  required name="datanascimento"placeholder="ex: 25/06/1998">
                                </div>

                            </div>

                            <button type="reset"  class="btn cancel btn-secondary " data-dismiss="modal" >Cancelar</button>

                            <div class="modal-foote float-right" >
                                <button type="button" class="btn btn-danger " id="excluir" name="excluir" onclick="confirmarExcluir()"> Excluir </button>

                                <button type="submit" class="btn btn-primary" id="butSubmit" name="butSubmit" >Cadastrar</button>

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
                        <p> Deseja realmente excluir o cliente </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onclick="excluirCliente()">Sim</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script src="JQuery/editar-cliente.js" type="text/javascript"></script>

        <script src="JQuery/jquery.mask.js" type="text/javascript"></script>

        <script src="JQuery/validar.js" type="text/javascript"></script>


    </body>


</html>