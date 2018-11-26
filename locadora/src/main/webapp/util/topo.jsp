<%

    if (session.getAttribute("login") != "true") {

        request.setAttribute("mensagem", "Acesso Proibido! Favor se autenticar.");

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request, response);

    }%>



