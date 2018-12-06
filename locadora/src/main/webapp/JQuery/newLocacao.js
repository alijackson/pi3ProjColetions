/**
 * Função busca todos os dados dos clientes cadastrado no banco de dados
 * E preenche uma tabela.
 */
function buscarCliente() {
  let url = "/locadora/new/locacao";

  let clientes;

  console.log(url);
  $.ajax({
    url: url,
    type: "PUT",
    success: function(data) {
      clientes = JSON.parse(data);

      $("#listaCliente").html(
        "<tr>" +
          "<th>ID</th>" +
          "<th>Nome</th>" +
          "<th>CPF</th>" +
          "<th>Email</th>" +
          "</tr>"
      );

      clientes.forEach(element => {
        let row =
          "<tr class='oneRowClient'>" +
          "<td>" +
          element.idCliente +
          "</td>" +
          "<td>" +
          element.nome +
          "</td>" +
          "<td>" +
          element.cpf +
          "</td>" +
          "<td>" +
          element.email +
          "</td>" +
          "</tr>";

        $("#listaCliente").append(row);
      });
    },
    error: function(ajaxContext) {
      console.log("error");
    }
  });
}
/**
 * Função é chamada quando o usuario clica em alguma linha da tabela.
 * pegando o ID dos dados do cliente, chama uma função que coleta
 *  os dados do cliente no banco de dados.
 */
$(document).on("click", ".oneRowClient", function() {
  let aux = $(this).html();
  selCliente(aux.charAt(4));
});
/**
 * Função chama uma função do Servlets para efetuar a busca do cliente selecionado
 * Preeche a label com o nome do cliente.
 * @param  id ID do cliente para efetuar a busca.
 */
function selCliente(id) {
  let url = "/locadora/cadastrarC?id=" + id;

  $.ajax({
    url: url,
    type: "PUT",

    success: function(data) {
      document.getElementById("labelIdClient").innerHTML =
        "<label>" + data.idCliente + "</label> ";

      document.getElementById("labelClient").innerHTML =
        "<label>" + "Cliente: " + data.nome + "</label> ";
    },
    error: function(ajaxContext) {
      console.log("error");
    }
  });
}
// ============================ DADOS VEICULOS =================================

/**
 * Função busca todos os dados dos veiculos cadastrado no banco de dados
 * E preenche uma tabela.
 */
function buscarCar() {
  let url = "/locadora/buscarV";
  let carros;
  console.log(url);
  $.ajax({
    url: url,
    type: "PUT",
    success: function(data) {
      carros = JSON.parse(JSON.stringify(data));
      console.log(carros);
      $("#listVeiculos").html(
        "<tr>" +
          "<th>ID</th>" +
          "<th>Marca</th>" +
          "<th>Modelo</th>" +
          "<th>Ano</th>" +
          "<th>Categoria</th>" +
          "<th>Preço</th>" +
          "</tr>"
      );

      carros.forEach(element => {
        let row =
          "<tr class='oneRowCar'>" +
          "<td>" +
          element.idVeiculo +
          "</td>" +
          "<td  id=selClient>" +
          element.marca +
          "</td>" +
          "<td>" +
          element.modelo +
          "</td>" +
          "<td>" +
          element.ano +
          "</td>" +
          "<td>" +
          element.categoria +
          "</td>" +
          "<td>" +
          element.idVeiculo +
          "</td>" +
          "</tr>";

        $("#listVeiculos").append(row);
      });
    },
    error: function(ajaxContext) {
      console.log("error");
    }
  });
}
/**
 * Função é chamada quando o usuario clica em alguma linha da tabela.
 * pegando o ID dos dados do cliente, chama uma função que coleta
 *  os dados do cliente no banco de dados.
 */
$(document).on("click", ".oneRowCar", function() {
  let aux = $(this).html();
  selCliente(aux.charAt(4));
});
/**
 * Função chama uma função do Servlets para efetuar a busca do cliente selecionado
 * Preeche a label com o nome do cliente.
 * @param  id ID do cliente para efetuar a busca.
 */
function selCliente(id) {
  let url = "/locadora/cadastrarV?id=" + id;

  $.ajax({
    url: url,
    type: "PUT",

    success: function(data) {
      document.getElementById("labelIdCar").innerHTML =
        "<label>" + data.idVeiculo + "</label> ";

      document.getElementById("labelNomeCar").innerHTML =
        "<label>" + "Cliente: " + data.modelo + "</label> ";
    },
    error: function(ajaxContext) {
      console.log("error");
    }
  });
}
