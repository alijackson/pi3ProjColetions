function editarFunc(func) {
    console.log("funcao")
    let url = "http://localhost:8080/locadora/CadastrarFuncionario?id=" + func;
    console.log(url)
    $.ajax({
        url: url,
        type: 'PUT',
        success: function(data) {
            console.log(data)
            $("#id").val(data.id)
            $("#nome").val(data.nome)
            $("#email").val(data.email)
            $("#dataNascimento").val(data.dataNasc)
            $("#login").val(data.login)
            $("#senha").val(data.senha)
            $("#cpf").val(data.cpf)
            $("#cargo").val(data.cargo)
            $("#butSubmit").text("Salvar")
            $("#exampleModalCenterTitle").text("Editar Funcionário")
            isTrue(data.ativo);
        },
        error: function(ajaxContext) {
            console.log("error")
        }
    });

    document.getElementById('excluir').style.visibility = 'visible';

    $("#novoFun").modal("show")

}

function addFunc(){
    var func = {nome: document.getElementById("nome"),
            cpf: document.getElementById("cpf"),
            email: document.getElementById("email"),
            dtnasc: document.getElementById("dataNascimento"),
            login: document.getElementById("login"),
            senha: document.getElementById("senha"),
            cargo: document.getElementById("area"),
            ativo: document.getElementById("ativo")}

    console.log(func);

}

function isTrue(boolean) {
    let checked = document.getElementById("switch-shadow");
    if(boolean == 1)
        checked.checked = true;
    else
        checked.checked = false;
}
function resetFormEdit(){
    document.formEditCad.reset();

    document.getElementById('excluir').style.visibility = 'hidden';
    
    $("#butSubmit").text("Cadastrar");
    
    $("#exampleModalCenterTitle").text("Cadastrar Funcionário");
}
function confirmarExcluir() {
    
    $("#mod-confirmar").modal("show");

}

function excluirFunc(){
    $("#mod-confirmar").modal("hide");
    let id = document.getElementById('id').value;
    let  url = "http://localhost:8080/locadora/CadastrarFuncionario?id="+id;

    $.ajax({
        url: url,
        type: 'DELETE',

        success: function(data) {
            
            alert(data.resp);
            location.reload()
            $("#novoFun").modal("hide");

         },
         error: function(ajaxContext) {
            alert("Erro no servidor");
            $("#novoFun").modal("hide");
         }
    });
    
}
