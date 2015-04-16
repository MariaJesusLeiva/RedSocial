<%@page import="app.entity.Amigos"%>
<%@page import="app.entity.Post"%>
<%@page import="java.util.List"%>
<%@page import="app.entity.Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//SP"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Red Social</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/typography.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<style type="text/css">
.clearfix {height: 1%;}
img {border: none;}
#resol {position:absolute;} body {overflow-x: hidden;}  #mainnav {top:160px;padding-left:70px;} #logo {left:20px;-top:140px;}

</style>
<![endif]-->
<!--[if gte IE 7.0]>
<style type="text/css">
.clearfix {display: inline-block;}
</style>
<![endif]-->
</head>
<body>
<div id="mainwrap" class="wrap">																																																																																																																																																																																																																																																																																																																				
	<div id="top-tag">
    </div>
	<div id="main" class="pagesize">
    	<div id="header" class="clearfix">
        	<div id="search-wrap">
            	<div id="search" class="clearfix">
                	<a href="?"><img src="images/icon_search.gif" alt="Search" /></a>
                	<input type="text" class="input" />
                    
                </div>
            </div>
<%
            Usuario usu = (Usuario) session.getAttribute("usuarioregistrado");
            Integer rol = (Integer) session.getAttribute("rol");
            
            if(rol == 1)
            {
                List<Post> listaPost = (List<Post>) request.getAttribute("listaPost");
                List<Amigos> listaAmigos = (List<Amigos>) request.getAttribute("listaAmigos");
                
        %>
               

            <h1 id="logo"><%= usu.getNombre() +" "+ usu.getApellidos()%></a></h1>
            <div id="mainnav" class="vernav">
                <ul class="clearfix">
                    <li><a href="?" class="active"><span>Inicio</span></a></li>
                    <li><a href="?"><span>Amigos</span></a></li>
                    <li><a href="?"><span>Invitados</span></a></li>
                    <li><a href="?"><span>Grupos</span></a></li>
                    <li><a href="?"><span>Salir</span></a></li>
                    
                </ul>                	
            </div>
        </div>
        <div id="container" class="clearfix">
        	<div class="box-dot"><div class="inner"><div class="inner"><div class="inner"><div class="inner"><div class="inner"><div class="inner clearfix">`
            	<div id="maincol">
                	<div id="blog">
                    	<h2 class="section-title">Mi muro</h2>
                        <div class="post">
                            <div class="clearfix">
                                <div class="date"><span class="day">02</span><span class="month">Jan</span></div>
                                <div class="left clearfix">
            <%
            if (listaPost != null)
            {
                for(int i=0;i<listaPost.size();i++) //recorro todos los post
                { 
                    
            %>
            
            <h2><a href="?"><%= listaPost.get(i).getTitulo() %></a></h2>
                                    
                                </div>
                            </div>
                            <div class="entry">
                                <p><%= listaPost.get(i).getMensaje() %> </p>
                                <p> <a href="contenidoPost.jsp?codigo=<%=listaPost.get(i).getIdPost() %>">Seguir leyendo...</p>
                            </div>
                        </div>
                      
            <%  }
            }
            
            else
            {
               %>
               <h2>No tienes aún post en tu muro </a></h2>
                    
                                    <%
            }
            if (listaAmigos != null)
            {
                for(int i=0;i<=6;i++) //recorro todos los post
                { 
                    
            %>
            <div id="works">
                    	<h2 class="section-title">Amigos</h2>
                        <div class="box-red"><div class="inner1"><div class="inner1"><div class="inner1 clearfix">
                        	<div class="works-wrap clearfix">
                            	<div class="works">
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(1).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(1).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(2).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(2).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(3).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(3).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(4).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(4).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(5).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(5).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                                <div>
                                    <a href="perfilUsuario.jsp?idUsuario=<%= listaAmigos.get(6).getId2Usuario().getIdUsuario() %>" class="links"><%= listaAmigos.get(i).getId2Usuario().getNombre() %></a>
                                    <a href="?"><img src=<%= listaAmigos.get(6).getId2Usuario().getColumnaimagen() %> alt="Urban Sphere" /></a>
                                </div>
                            </div>
                        </div></div></div></div>
                    </div>
                </div>
                <div id="sidebar">
                	<ul>
                    	<li>
                        	<h2>Mi perfil</h2>
                        	<ul>
                            	<li>
                                	<img src=<%= usu.getColumnaimagen() %> alt="" align="left" class="imgleft" />                                
                                    <p>Este es mi espacio personal. Este soy yo</p>
                                    <
                                    <p><a href="perfilUsuario.jsp?idUsuario=<%= usu.getIdUsuario() %>" class="b black f13">Mi perfil/a></p>
                                </li>
                            </ul>
                        </li>
                        <li>
                        	<h2>Categorias
                                </h2>
                        	<ul class="navicon">
                            	<li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                                <li><a href="?">Category 1</a></li>
                            </ul>
                        </li>
                        <li>
                        	<h2>Simple Block</h2>
                        	<ul>
                            	<li>
                                    <p>Nullam iaculis. Quisque pulvinar orci quis nisl. Sed a nunc nec tellus hendrerit ullamcorper. Suspendisse est quam, laoreet at, cursus ut, luctus viverra, lorem. </p>
                                </li>
                            </ul>
                        </li>
                        <li>
                        	<h2>Syndicate</h2>
                        	<ul>
                            	<li class="text-center">
                                    <a href="?"><img src="images/icon-rss.gif" alt="" /></a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div></div></div></div></div></div></div>
        </div>
    </div>
</div>

<%  }
            }
            }
              

           
                
        %>
		 
</body>
</html>
