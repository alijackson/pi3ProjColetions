function editarFunc(func) {
    let id = $("#trTable").children().eq(0).html();
    let nome = $("#trTable").children().eq(1).html();
    let area = $("#trTable").children().eq(2).html();
    let email = $("#trTable").children().eq(3).html();
    let cpf = $("#trTable").children().eq(4).html();
    let nasc = $("#trTable").children().eq(5).html();
    
    let checked = document.getElementById("switch-shadow");

    $("#nome").val(nome);
    checked.checked = true;

    $("#novoFun").modal("show")
    
}
var checked = true;

function isTrue() {
    let checked = document.getElementById("switch-shadow");
    console.log(checked);
    checked.checked = true;
    
}

