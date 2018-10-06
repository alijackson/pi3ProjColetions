<%-- 
    Document   : resultado
    Created on : 06/10/2018, 14:31:27
    Author     : alijackson.msilva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Segue resultado</h1><br>
        <h1><c:out value="${result}" /></h1>
    </body>
</html>
