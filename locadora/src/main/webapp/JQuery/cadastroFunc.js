function editarFunc(func) {
    console.log("funcao")
    let url = "http://localhost:8080/locadora/CadastrarFuncionario?id=" + func;
    console.log(url)
    $.ajax({
        url: url,
        type: 'PUT',
        success: function(data) {
            console.log(data)
            $("#idFuncionario").val(data.id)
            $("#nome").val(data.nome)
            $("#email").val(data.email)
            $("#dataNascimento").val(data.dataNasc)
            $("#login").val(data.login)
            $("#senha").val(data.senha)
            $("#cpf").val(data.cpf)
            $("#cargo").val(data.cargo)
            $("#nome").val(data.senha)
            isTrue(data.ativo);
        },
        error: function(ajaxContext) {
            console.log("error")
        }
    });

    $("#novoFun").modal("show")

}

function isTrue(boolean) {
    let checked = document.getElementById("switch-shadow");
    if(boolean == 1)
        checked.checked = true;
    else
        checked.checked = false;
}
function resetFormEdit(){
    document.formEditCads.reset();
}

