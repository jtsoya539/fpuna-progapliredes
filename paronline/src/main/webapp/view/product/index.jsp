<%-- 
    Document   : index
    Created on : 03/06/2019, 07:18:08 PM
    Author     : javie
--%>

<%@page import="py.com.paronline.paronline.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAR On Line - Productos</title>
        <% ArrayList<Product> productos = (ArrayList<Product>) request.getAttribute("products");%>
    </head>
    <body>
        <h1>Productos</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descripción</th>
                    <th>Categoría</th>
                    <th>Precio Unitario</th>
                    <th>Cantidad</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (productos != null) {
                        for (Product producto : productos) {
                %>
                <tr>
                    <td><%= producto.getId()%></td>
                    <td><%= producto.getDescripcion()%></td>
                    <td><%= producto.getCategoria().getDescripcion()%></td>
                    <td><%= producto.getPrecioUnit()%></td>
                    <td><%= producto.getCantidad()%></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/Product" method="get">
                            <input type="hidden" name="id" value="<%= producto.getId()%>"/>
                            <button>Detalles</button>
                        </form>
                    </td>
                    <td>
                        <button type="button" onclick="removeProduct(<%=  producto.getId()%>)">Eliminar</button>
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
