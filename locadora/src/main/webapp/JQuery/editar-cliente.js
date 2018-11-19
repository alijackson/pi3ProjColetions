function editarCliente(id) {

    let  url = "http://localhost:8080/locadora/cadastrarC?id=" + id;

    console.log(url)

    $.ajax({
        url: url,
        type: 'PUT',

        success: function (data) {
            console.log(data),
            $("#idCliente").val(data.idCliente);
            $("#nome").val(data.nome);
            $("#numerocnh").val(data.numerocnh);
            $("#cpf").val(data.cpf);
            $("#rg").val(data.rg);
            $("#email").val(data.email);
            $("#telefonefixo").val(data.telefonefixo);
            $("#telefonecelular").val(data.telefonecelular);
            $("#datanascimento").val(data.datanascimento);
            $("#butSubmit").text("Salvar");



            $("#modalCliente").text("Editar Cliente");
        },
        error: function (ajaxContext) {
            console.log("error");
        }
    });

    $("#novoCliente").modal("show");



}


function resetFormularioCliente() {
    document.formEditCliente.reset();

    $("#butSubmit").text("Cadastrar");

    $("#modalCliente").text("Cadastrar Cliente");
}










