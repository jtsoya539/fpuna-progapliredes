<%-- 
    Document   : index
    Created on : 01/06/2019, 07:01:55 PM
    Author     : javie
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="py.com.paronline.paronline.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line - Usuarios</title>
        <% ArrayList<User> usuarios = (ArrayList<User>) request.getAttribute("users");%>
    </head>
    <body>
        <h1>Usuarios</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Alias</th>
                    <th>Tipo</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (usuarios != null) {
                        for (User usuario : usuarios) {
                %>
                <tr>
                    <td><%= usuario.getId()%></td>
                    <td><%= usuario.getNombre()%></td>
                    <td><%= usuario.getApellido()%></td>
                    <td><%= usuario.getEmail()%></td>
                    <td><%= usuario.getLoginName()%></td>
                    <td><%= usuario.getTipoCliente()%></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/User" method="get">
                            <input type="hidden" name="id" value="<%= usuario.getId()%>"/>
                            <button>Detalles</button>
                        </form>
                    </td>
                    <td>
                        <button type="button" onclick="removeUser(<%= usuario.getId()%>)">Eliminar</button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <script src="js/site.js"></script>
    </body>
</html>
