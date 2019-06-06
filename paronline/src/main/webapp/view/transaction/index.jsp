<%-- 
    Document   : index
    Created on : 03/06/2019, 07:18:45 PM
    Author     : javie
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="py.com.paronline.paronline.model.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line - Transacciones</title>
        <% ArrayList<Transaction> transacciones = (ArrayList<Transaction>) request.getAttribute("transactions");%>
    </head>
    <body>
        <h1>Transacciones</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Cliente</th>
                    <th>Total</th>
                    <th>Dirección de Envío</th>
                    <th>Medio de Pago</th>
                    <th>Número de Tarjeta</th>
                    <th>Estado</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (transacciones != null) {
                        for (Transaction transaccion : transacciones) {
                %>
                <tr>
                    <td><%= transaccion.getId()%></td>
                    <td><%= transaccion.getFecha()%></td>
                    <td><%= transaccion.getCliente().getNombre() + " " + transaccion.getCliente().getApellido()%></td>
                    <td><%= transaccion.getTotal()%></td>
                    <td><%= transaccion.getDireccionEnvio()%></td>
                    <td><%= transaccion.getIdMedioPago()%></td>
                    <td><%= transaccion.getNroTarjeta()%></td>
                    <td><%= transaccion.getEstado()%></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/Transaction" method="get">
                            <input type="hidden" name="id" value="<%= transaccion.getId()%>"/>
                            <button>Detalles</button>
                        </form>
                    </td>
                    <td>
                        <button type="button" onclick="removeTransaction(<%= transaccion.getId()%>)">Eliminar</button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/Home">Inicio</a>

        <script src="js/site.js"></script>
    </body>
</html>
