<%-- 
    Document   : CrearPost
    Created on : 18-abr-2015, 13:15:24
    Author     : MJ
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Crear Post</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    

  </head>
  <body>
	<form name="edit" action="CrearPost" method="post">
		<table border="1">
			<tbody>
				<%--<tr>
					<td><b>Título:</b></td>
					<td><input type="text" name="titulo" size ="60" value=""/></td>		
					</tr><tr>		
					<td><b>Mensaje:</b></td>	
					<td><input type="text" name="mensaje" size ="60" value=""/></td>
					</tr><tr>
					<td colspan="2"><input type="submit" name="btnSave" value="Publicar"/></td>--%>
                                </tr>
                                	<tr>
					<td><b>Título:</b></td>
					<td><input type="text" name="titulo" size ="60" value=""/></td>		
					</tr><tr>		
                        		<td><b>Mensaje:</b></td>
					<td><textarea name="mensaje" rows="10" cols="45"> ¿Qué estás pensando?</textarea></td>
					</tr><tr>
                                        <td colspan="2"><input type="submit" name="btnSave" value="Publicar"/></td>
                                        </tr>
                                        <tr></tr>
			</tbody>
		</table>
	</form>
  </body>
</html>