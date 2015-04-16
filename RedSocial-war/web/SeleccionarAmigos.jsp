<%-- 
    Document   : SeleccionarAmigos
    Created on : 14-abr-2015, 10:17:46
    Author     : Inma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear grupo de amigos</title>
    </head>
    <body>
        <h1>Selecciona los amigos para crear el grupo </h1>
        
        
        <form name="edit" action="ConsultarAmigos" method="get">
            
           <fieldset>   
                
               <table>
                   <td>
                       Nombre
                   </td>
                   <td>
                       Seleccionar
                   </td>
                       <tr>
                           
                       </tr>

               </table>     
                    <%-- Botón buscar --%>
                    <input type="submit" name="btnCrear" value="Crear grupo">
            </fieldset>

            </form>
        
        
        
        
        
    </body>
</html>
