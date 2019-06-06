<%-- 
    Document   : details
    Created on : 01/06/2019, 08:11:37 PM
    Author     : javie
--%>

<%@page import="py.com.paronline.paronline.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line - Usuarios</title>
        <% User usuario = (User) request.getAttribute("user");%>
    </head>
    <body>
        <h1>Detalles</h1>
        <h2>Usuario</h2>

        <dl>
            <dt>ID</dt>
            <dd><%= usuario.getId()%></dd>
            <dt>Nombre</dt>
            <dd><%= usuario.getNombre()%></dd>
            <dt>Apellido</dt>
            <dd><%= usuario.getApellido()%></dd>
            <dt>Email</dt>
            <dd><%= usuario.getEmail()%></dd>
            <dt>Alias</dt>
            <dd><%= usuario.getLoginName()%></dd>
            <dt>Tipo</dt>
            <dd><%= usuario.getTipoCliente()%></dd>
        </dl>

        <a href="${pageContext.request.contextPath}/User">Volver</a>
    </body>
</html>
