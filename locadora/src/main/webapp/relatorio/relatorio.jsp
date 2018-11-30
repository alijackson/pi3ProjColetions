<%-- 
    Document   : relatorio
    Created on : 29/11/2018, 02:10:10
    Author     : Pichau
--%>

<%@page import="br.com.model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/util/topo.jsp"></jsp:include>
    <!doctype html>
    <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv=”content-type” content="text/html;" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
            <title>Relatorio</title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
            <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>

            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                  crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

            <!-- ESTILOS PARA ESTA PÁGINA -->
            <!-- Nesse caso, este estilo é apenas para inserir imagens -->
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" type="text/css" href="style/buttonSeletor.css" <!-- SWEET ALERT -->
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


            <link rel="stylesheet" href="../Morris/css/morris.css">
            <script src="../Morris/js/morris.min.js" charset="utf-8"></script>

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
                    <a class="navbar-brand" href="#"><img src="imagens/logo.png"></a>
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
                                <a class="nav-link " href="#">FILIAL</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="/locadora/relatorio">RELATORIO</a>
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

                        <h1>Relatorio</h1>
                    </div>
                    <!-- AQUI QUE TEM QUE FICAR EM LINHA -->


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

                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Grafico</h2>
                            <hr>
                            <div id="locacoes"></div>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Cliente</th>
                            <th>Veiculo</th>
                            <th>Funcionario</th>
                            <th>Preço Total</th>
                            <th>Dia de Retirada</th>
                            <th>Dia de Entrega</th>
                        </tr>

                    <c:forEach items="${listaLocacoes}" var="locacao">
                        <tr onclick="editarFunc(${locacao.getId()})" id="trTable">
                            <td>
                                <c:out value='${locacao.getId()}' />
                            </td>
                            <td>
                                <c:forEach items="${listaClientes}" var="cliente">
                                    <c:if test="${cliente.getId = locacao.getIdCliente}">
                                        <c:out value="${cliente.getNome}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${listaVeiculos}" var="veiculo">
                                    <c:if test="${veiculo.getId = locacao.getIdVeiculo}">
                                        <c:out value="${veiculo.getModelo}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${listaFuncionarios}" var="funcionario">
                                    <c:if test="${funcionario.getId = locacao.getIdFuncionario}">
                                        <c:out value="${funcionario.getNome}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:out value="${locacao.getPrecoTotal()}" />
                            </td>
                            <td>
                                <c:out value="${locacao.getDiaRetira()}" />
                            </td>
                            <td>
                                <c:out value="${locacao.getDiaEntrega()}" />
                            </td>
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

        <script type="text/javascript">
            new Morris.Line({
                // ID of the element in which to draw the chart.
                element: 'locacoes',
                // Chart data records -- each entry in this array corresponds to a point on
                // the chart.
                data: [
                    <c:forEach items="${listaLocacoes}" var="locacao">
                        {retirada: '<c:out value='${locacao.getDiaRetira()}' />', value: <c:out value='${locacao.getPrecoTotal()}' />},
                    </c:forEach>
                ],
                // The name of the data record attribute that contains x-values.
                xkey: 'retirada',
                // A list of names of data record attributes that contain y-values.
                ykeys: ['a', 'b'],
                // Labels for the ykeys -- will be displayed when you hover over the
                // chart.
                labels: ['Retirada de Veiculo']
            });
        </script>

    </body>

</html>
