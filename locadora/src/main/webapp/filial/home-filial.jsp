<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=”content-type” content="text/html;" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="keywords" content="tags, que, eu, quiser, usar, para, os, robos, do, google" />
        <title>Filiais</title>
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
                <a class="navbar-brand" href="#"><img src="imagens/logotipo.png"></a>
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
                            <a class="nav-link " href="#">FILIAL</a>
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

                    <h1>Filiais</h1>
                </div>
                <!-- AQUI QUE TEM QUE FICAR EM LINHA -->


                <div class="col-md-2 d-flex-inline ">  
                    <a class="btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#novaFilial" id="btnNovaFilial"> Nova Filial</a>  
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
                        <th>Email</th>
                        <th>Endereço</th>
                        <th>Cidade</th>
                        <th>Telefone Fixo</th>
                         <th>Telefone Celular</th>
                    </tr>
                    <c:forEach items="${listaFilial}" var="filial">
                        <tr onclick="location.href = 'edit?id=<c:out value='${filial.getId()}' />'"  id="trTable"  >
                            <td>
                        <c:out value='${filial.getId()}' />
                        </td>
                        <td>
                        <c:out value="${filial.getEmail()}" />
                        </td>
                        <td>
                        <c:out value="${locacao.getEndereco()}" />
                        </td>
                        <td>
                        <c:out value="${filial.getCidade()}" />
                        </td>
                        <td>
                        <c:out value="${locacao.getTelefoneFixo()}" />
                        </td>
                         <td>
                        <c:out value="${locacao.getTelefoneCelular()}" />
                        </td>
                        </tr>
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

        <!-- Modal Cadastrar filial -->
        <div class="modal fade" id="novaFilial" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle">
            aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Cadastrar Filial</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="filial" method="post" name="formEditCad">
                            <div class="form-group">
                                <!-- hidden omite as infomações -->
                                <input type="text" class="form-control" id="id" name="id" placeholder="ID" hidden>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" required name="email" placeholder="ex: filial@filial.com.br">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="telefonefixo">Telefone Fixo</label>
                                    <input type="text" class="form-control" id="telefonefixo" required name="telefonefixo" placeholder="ex: (11) 5894-3241">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="telefonecelular">Telefone Celular</label>
                                    <input type="text" class="form-control" id="telefonecelular" required name="telefonecelular"
                                           placeholder="ex: 96276-8066">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="endereco">Endereço </label>
                                    <input type="text" class="form-control" id="endereco" required name="endereco" placeholder="ex: rua nações unidas">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="numero">Número</label>
                                    <input type="text" class="form-control" id="numero" required name="numero"
                                           placeholder="250-B">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="complemento">Complemento </label>
                                    <input type="text" class="form-control" id="complemento" required name="complemento" placeholder="ex: próximo ao bar do zé">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="cep">CEP</label>
                                    <input type="text" class="form-control" id="cep" required name="cep"
                                           placeholder="05831-200">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="estado">Estado</label>
                                    <select id="estado" required name="estado" class="form-control">
                                        <option value="SP">SP</option>
                                        <option value="AL">AL</option>
                                        <option value="AP">AP</option>
                                        <option value="AM">AM</option>
                                        <option value="BA">BA</option>
                                        <option value="CE">CE</option>
                                        <option value="DF">DF</option>
                                        <option value="ES">ES</option>
                                        <option value="GO">GO</option>
                                        <option value="MA">MA</option>
                                        <option value="MT">MT</option>
                                        <option value="MS">MS</option>
                                        <option value="MG">MG</option>
                                        <option value="PA">PA</option>
                                        <option value="PB">PB</option>
                                        <option value="PR">PR</option>
                                        <option value="PE">PE</option>
                                        <option value="PI">PI</option>
                                        <option value="RJ">RJ</option>
                                        <option value="RN">RN</option>
                                        <option value="RS">RS</option>
                                        <option value="RO">RO</option>
                                        <option value="RR">RR</option>
                                        <option value="SC">SC</option>
                                        <option value="SE">SE</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="cidade">Cidade</label>
                                    <select id="cidade" required name="cidade" class="form-control">
                                        <option value="Sao Paulo">São Paulo</option>
                                        <option value="Alagoas">Amapá</option>
                                        <option value="Amapa">Amapá</option>
                                        <option value="Amazonas">Amazonas</option>
                                        <option value="Bahia">Bahia</option>
                                        <option value="Ceara">Ceará</option>
                                        <option value="Distrito Federal">Distrito Federal</option>
                                        <option value="Espirito Santo">Espírito Santo</option>
                                        <option value="Goias">Goiás</option>
                                        <option value="Maranhão">Maranhão</option>
                                        <option value="Mato Grosso">Mato Grosso</option>
                                        <option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
                                        <option value="Minas Gerais">Minas Gerais</option>
                                        <option value="Para">Pará</option>
                                        <option value="Paraiba">Paraíba</option>
                                        <option value="Parana">Paraná</option>
                                        <option value="Pernambuco">Pernambuco</option>
                                        <option value="Piaui">Piauí</option>
                                        <option value="Rio de Janeiro">Rio de Janeiro</option>
                                        <option value="Rio Grande do Norte">Rio Grande do Norte</option>
                                        <option value="Rio Grande do Sul">Rio Grande do Sul</option>
                                        <option value="Rondonia">Rondônia</option>
                                        <option value="Roraima">Roraima</option>
                                        <option value="Santa Catarina">Santa Catarina</option>
                                        <option value="Sergipe">Sergipe</option>
                                        <option value="Tocantins">Tocantins</option>
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



    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>

</html>