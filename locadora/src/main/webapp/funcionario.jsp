<%-- 
    Document   : funcionario
    Created on : 05/11/2018, 19:36:16
    Author     : david.sdcruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
        <head>
                <meta charset="utf-8">
                <meta http-equiv=”content-type” content="text/html;" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
                <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
                <title>TakeYourCar</title>
                <meta name="description" content="">
                <meta name="viewport" content="width=device-width, initial-scale=1">
            
                <!-- BOOTSTRAP -->
                
                <link type="text/css" rel="stylesheet" href="Boostrap/css/bootstrap.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                
                <!-- ESTILOS PARA ESTA PÁGINA -->
                <!-- Nesse caso, este estilo é apenas para inserir imagens -->
                <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        
                
                <!-- SWEET ALERT -->
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
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Locação</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" href="#">Cliente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Veículo</a>
                  </li>
                <li class="nav-item">
                  <a class="nav-link disabled" href="#">Funcionário</a>
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
          <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novoFun" id="btnd"> Novo Funcionário</a>  
        </div>
 </div>
    <hr>
    <div class="col-md-12 d-flex-inline">  
            <form class="form-inline my-2 my-lg-0 d-flex-inline" id="procura"> 
                    <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Search" id="input2">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="Procurar">Buscar</button>
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
                <th>RG</th>
                <th>Endereço</th>
                <th></th>
                <th></th>
             </tr>
             <tr>
                <td>1</td>
                <td>João Carlos</td>
                <td>Vendedor</td>
                <td>joaozinho@hotmail.com</td>
                <td>50.658.475-8</td>
                <td>Rua carrão</td>
                <td><a href="#" class="btn btn-primary" data-toggle="modal" data-target="#novoFun">Atualizar</a></td>
                <td><a href="#" class="btn btn-danger" onclick="excluir();">Excluir</a></td>       
            </tr>
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
      <div class="modal fade" id="novoFun" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle">Cadastrar Funcionário</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
                    <form>
                         <div class="form-group">
                              <label for="inputAddress">Nome</label>
                              <input type="text" class="form-control" id="inputAddress" placeholder="ex: Jose Silva">
                            </div>
                            <div class="form-row">
                              <div class="form-group col-md-6">
                                <label for="inputEmail4">Email</label>
                                <input type="email" class="form-control" id="inputEmail4" placeholder="ex: Augusto@gmail.com">
                              </div>
                              <div class="form-group col-md-6">
                                <label for="inputPassword4">Senha</label>
                                <input type="password" class="form-control" id="inputPassword4" placeholder="Senha">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="inputAddress">Endereço</label>
                              <input type="text" class="form-control" id="inputAddress" placeholder="ex: Rua Jão Carlos">
                            </div>
                            <div class="form-row">
                              <div class="form-group col-md-6">
                                    <label for="cpf">RG</label>
                                    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="123.123.123-12">
                              </div>
                              <div class="form-group col-md-6">
                                <label for="inputState">Área</label>
                                <select id="inputState" class="form-control">
                                  <option selected>Vendedor</option>
                                  <option>Gerente TI</option>
                                  <option>Gerente</option>
                                  <option>Administrador</option>
                                </select>
                              </div>
                            </div>
                        
                          </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary" onclick="sucesso();">Cadastrar</button>
            </div>
          </div>
        </div>
      </div>



</body>

   <!-- JAVASCRIPT E JQUERY -->
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
               
            
</html>