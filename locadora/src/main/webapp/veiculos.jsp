<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- ESTILOS PARA ESTA PÁGINA -->
        <!-- Nesse caso, este estilo é apenas para inserir imagens -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        
        <script type="text/JAVASCRIPT">

            function excluir(){
            swal({
            title: "Deseja excluir?",
            text: "Você estará deletendo do sistema!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            })
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
    
        <div id="form" class="container">

            <div class="row">

                <div class="col-md-10 d-flex-inline ">

                    <h1>Veiculos</h1>
                </div>

                <div class="col-md-2 d-flex-inline ">  
                    <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novoVei" id="btnd"> Novo Veiculo</a>  
                </div>
            </div>
            <hr>
            <div class="col-md-12 d-flex-inline">  
                <form class="form-inline my-2 my-lg-0 d-flex-inline" id="procura"> 
                    <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="input2">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="Procurar">Buscar</button>
                </form><br>
            </div>

            <div class="col-md-12">
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Modelo</th>
                        <th>Ano</th>
                        <th>NumeroDoc</th>
                        <th></th>
                        <th></th>
                    </tr>

                    <c:forEach items="${listaVeiculos}" var="veiculo">
                        <tr onclick="location.href = 'edit?id=<c:out value='${veiculo.getId()}' />'" id="trTable" >
                            <td><c:out value='${veiculo.getId()}' /></td>
                            <td><c:out value="${veiculo.getModelo()}" /></td>
                            <td><c:out value="${veiculo.getAno()}" /></td>
                            <td><c:out value="${veiculo.getNumeroDoc()}" /></td>
                            <td><a href="#" class="btn btn-primary" data-toggle="modal" data-target="#novoFun">Atualizar</a></td>
                            <td><a href="#" class="btn btn-danger" onclick="excluir();">Excluir</a></td>  
                        </tr>
                    </c:forEach>
                </table>
            </div>

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
        </div>
        
        <div class="modal fade" id="novoVei" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Cadastrar Veiculo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
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
                                    <select class="form-control" id="categoria" required name="categoria">
                                        <option value="Categoria A">Categoria A</option>
                                        <option value="Categoria B">Categoria B</option>
                                        <option value="Categoria C">Categoria C</option>
                                        <option value="Categoria D">Categoria D</option>
                                    </select>
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
                                    <input type="text" class="form-control" id="marca" name="marca">
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
                </div>
            </div>
        </div>


    </body>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>-->

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>

</html>
