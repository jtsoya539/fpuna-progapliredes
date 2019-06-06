<%-- 
    Document   : details
    Created on : 03/06/2019, 07:31:01 PM
    Author     : javie
--%>

<%@page import="py.com.paronline.paronline.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line - Productos</title>
        <% Product producto = (Product) request.getAttribute("product");%>
    </head>
    <body>
        <h1>Detalles</h1>
        <h2>Producto</h2>

        <dl>
            <dt>ID</dt>
            <dd><%= producto.getId()%></dd>
            <dt>Descripción</dt>
            <dd><%= producto.getDescripcion()%></dd>
            <dt>Categoría</dt>
            <dd><%= producto.getCategoria().getDescripcion()%></dd>
            <dt>Precio Unitario</dt>
            <dd><%= producto.getPrecioUnit()%></dd>
            <dt>Cantidad</dt>
            <dd><%= producto.getCantidad()%></dd>
        </dl>

        <a href="${pageContext.request.contextPath}/Product">Volver</a>
    </body>
</html>
