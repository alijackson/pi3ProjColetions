<%-- 
    Document   : login
    Created on : 06/10/2018, 14:05:06
    Author     : alijackson.msilva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
    </head>
    
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    
                </div>
                
                <div class="col-6">
                    <br><br><br><br>
                    <h1>&nbsp;&nbsp;Locadora Five</h1>
                    <c:if test="${msgErro != null}">
                        <p style="background-color: plum">
                            <c:out value="${msgErro}" />
                        </p>
                    </c:if>
                    <form class="px-4 py-3" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group">
                            <label for="exampleDropdownFormEmail1">Login</label>
                            <input type="text" class="form-control" name="login" id="exampleDropdownFormEmail1" placeholder="Usuario">
                        </div>
                        <div class="form-group">
                            <label for="exampleDropdownFormPassword1">Senha</label>
                            <input type="password" class="form-control" name="senha" id="exampleDropdownFormPassword1" placeholder="Senha">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Entrar</button>
                    </form>
                    
                </div>
                <div class="col-3">
                    
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        
    </body>
</html>
