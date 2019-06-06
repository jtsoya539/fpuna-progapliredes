<%-- 
    Document   : details
    Created on : 03/06/2019, 07:37:33 PM
    Author     : javie
--%>

<%@page import="py.com.paronline.paronline.model.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% Transaction transaccion = (Transaction) request.getAttribute("transaction");%>
    </head>
    <body>
        <h1>Detalles</h1>
        <h2>Transacción</h2>

        <dl>
            <dt>ID</dt>
            <dd><%= transaccion.getId()%></dd>
            <dt>Fecha</dt>
            <dd><%= transaccion.getFecha()%></dd>
            <dt>Cliente</dt>
            <dd><%= transaccion.getCliente().getNombre() + " " + transaccion.getCliente().getApellido()%></dd>
            <dt>Total</dt>
            <dd><%= transaccion.getTotal()%></dd>
            <dt>Dirección de Envío</dt>
            <dd><%= transaccion.getDireccionEnvio()%></dd>
            <dt>Medio de Pago</dt>
            <dd><%= transaccion.getIdMedioPago()%></dd>
            <dt>Número de Tarjeta</dt>
            <dd><%= transaccion.getNroTarjeta()%></dd>
            <dt>Estado</dt>
            <dd><%= transaccion.getEstado()%></dd>
        </dl>

        <a href="${pageContext.request.contextPath}/Transaction">Volver</a>
    </body>
</html>
