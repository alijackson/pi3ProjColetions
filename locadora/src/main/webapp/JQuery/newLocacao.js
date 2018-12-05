function buscarCliente(){
    console.log("funcao")
    let url = "/locadora/new/locacao";
    
    let clientes;

    console.log(url)
    $.ajax({
        url: url,
        type: 'PUT',
        success: function(data) {
            clientes = JSON.parse(data);

            console.log(clientes)  
        },
        error: function(ajaxContext) {
            console.log("error" )
        }
    });
    for(var i = 0; i < clientes.length; i++){
    }

}