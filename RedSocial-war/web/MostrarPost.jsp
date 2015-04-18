<%-- 
    Document   : MostrarPost
    Created on : 12-abr-2015, 11:16:45
    Author     : MJ
--%>

<%@page import="app.entity.Usuario"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="app.entity.Post"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Post</title>
<%            
            List<Post> listapost = (List<Post>) request.getAttribute("post");
            Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
    </head>
    <body>
        <table border="1">
            <tbody>

<%
        for (Post p:listapost) {
          
%>
        <tr>
            <td><b>Título: </b><%= p.getTitulo() %> </td>
            </tr>
            <tr>
	    <td><b>Mensaje: </b><%= p.getMensaje() %> </td>
            </tr>
            <tr>
	    <td><b>Fecha de publicación: </b><%= p.getFechaPublicacion() %> </td>
            </tr>
            <tr>
            <td><b>Publicado por: </b><%=p.getIdUsuario().getNombre()+ " " + p.getIdUsuario().getApellidos() %> </td>
            </tr>
            <tr>
            <td height = "20"></td>
            </tr>
<%              
        }
%>
            </tbody>
        </table>        
    </td></tr>
</html>
