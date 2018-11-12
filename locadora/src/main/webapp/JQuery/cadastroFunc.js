function editarFunc(func) {
    let id = $("#trTable").children().eq(0).html();
    let nome = $("#trTable").children().eq(1).html();
    let area = $("#trTable").children().eq(2).html();
    let email = $("#trTable").children().eq(3).html();
    let cpf = $("#trTable").children().eq(4).html();
    let nasc = $("#trTable").children().eq(5).html();
    
    $("#nome").val(nome);
    

    $("#novoFun").modal("show")
}


