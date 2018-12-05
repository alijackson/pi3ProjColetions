function buscarCliente(){
    console.log("funcao")
    let url = "/locadora/new/locacao";
    let clientes;

    console.log(url)
    $.ajax({
        url: url,
        type: 'HEAD',
        success: function(data) {
            console.log(data)
        },
        error: function(ajaxContext) {
            console.log("error")
        }
    });
}