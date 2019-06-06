<%-- 
    Document   : index
    Created on : 01/06/2019, 07:02:58 PM
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line</title>
    </head>
    <body>
        <h1>¡Bienvenido/a a PAR On Line!</h1>

        <a href="${pageContext.request.contextPath}/User">Usuarios</a>
        <a href="${pageContext.request.contextPath}/Product">Productos</a>
        <a href="${pageContext.request.contextPath}/Transaction">Transacciones</a>
    </body>
</html>
