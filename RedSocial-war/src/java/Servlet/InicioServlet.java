/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import app.beans.AmigosFacadeLocal;
import app.beans.PostFacadeLocal;
import app.beans.UsuarioFacadeLocal;
import app.entity.Amigos;
import app.entity.Post;

import app.entity.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JoseAntonio
 */
public class InicioServlet extends HttpServlet {
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
     @EJB
    private AmigosFacadeLocal amigosFacade;
    @EJB
    private PostFacadeLocal postFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        
        Usuario usuario;
        HttpSession session;
        
        session = request.getSession(false);
              
        String accion = request.getParameter("valor");
               
        if(accion.equalsIgnoreCase("nuevo")){
          
            String emailNuevo,password,nombre,apellidos,ciudad,pais;
            Date fechaNacimiento;
            
            Short id_usuario,sexo,rol;

            List <Usuario> m;
            m = (List <Usuario>)usuarioFacade.findAll();

                id_usuario = (short) (m.size()+1);//para autoincrementar el id
                emailNuevo = (String) request.getParameter("emailNuevo");
                password = (String) request.getParameter("PasswordNuevo");
                nombre = (String) request.getParameter("nombreNuevo");
                apellidos = (String) request.getParameter("apellidosNuevo");
                ciudad= (String) request.getParameter("ciudadNuevo");
                pais = (String) request.getParameter("paisNuevo");
                fechaNacimiento = Date.valueOf(request.getParameter("fechaNuevo"));
                sexo = Short.parseShort(request.getParameter("sexoNuevo"));
                rol = Short.parseShort("1");

            Usuario usu = new Usuario();

                usu.setIdUsuario(id_usuario);
                usu.setNombre(nombre);
                usu.setApellidos(apellidos);
                usu.setEmail(emailNuevo);
                usu.setPassword(password);
                usu.setCiudad(ciudad);
                usu.setPais(pais);
                usu.setFechaNacimiento(fechaNacimiento);
                usu.setIdRol(rol);
                usu.setSexo (sexo);

            usuarioFacade.create(usu);


            rd = getServletContext().getRequestDispatcher("/Principal.jsp");
            rd.forward(request, response);  
       }
        
       else if(accion.equalsIgnoreCase("registrado"))
      {
           Short idRol;
           
           if(session == null)//compruebo que no esta logueado antes
            {
           
              String email = request.getParameter("email");
              String clave = request.getParameter("clave");
                
              usuario = usuarioFacade.login(email, clave);
                
              session = request.getSession();

               if(usuario != null)
                {
                    idRol = usuario.getIdRol();

                    if (idRol.compareTo(Short.valueOf("1"))==0)
                           
                    {
                        
                        List<Post> listaPost;
                        listaPost = (List<Post>) postFacade.findbyIdUsuario(usuario.getIdUsuario());
                        List<Amigos> listaAmigos;
                        listaAmigos = (List<Amigos>) amigosFacade.findbyIdUsuario(usuario.getIdUsuario());
            
                        request.setAttribute("listaPost", listaPost);
                        request.setAttribute("listaAmigos", listaAmigos);
                        rd = getServletContext().getRequestDispatcher("Principal.jsp");
                        rd.forward(request, response);

                    }
                    if (idRol.compareTo(Short.valueOf("2"))==0)
                    {   
                        session.setAttribute("usuarioregistrado", usuario);
                        session.setAttribute("idRol", idRol);
                        
                        rd = getServletContext().getRequestDispatcher("/CargarPrincipal");
                        rd.forward(request, response);
                    }
                }        
            }
            else  
            {
                 
                
                    rd = getServletContext().getRequestDispatcher("/CargarPrincipal");
                    rd.forward(request, response);
            }
              

        }   

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
