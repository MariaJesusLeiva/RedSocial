/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import app.beans.PostFacade;
import app.entity.Post;
import app.entity.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;


/**
 *
 * @author MJ
 */
@WebServlet(name="MostrarPost", urlPatterns={"/MostrarPost"})
public class MostrarPostServlet extends HttpServlet {
    
    @EJB
    private PostFacade postFacade;
    
    

    /**
     * Constructor of the object.
     */
    public MostrarPostServlet() {
            super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
            super.destroy();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        List<Post> listapost;
        listapost = this.postFacade.findbyIdUsuario(usuario.getIdUsuario());
        request.setAttribute("listapost", listapost);



        //get the request dispatcher
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarPost.jsp");
        //forward to the jsp file to display the book list
        dispatcher.forward(request, response);		
    }
    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

            //call the doGet method
            this.processRequest(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

            //call the doGet method
            this.processRequest(request, response);
    }
    
    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occure
     */
    @Override
    public void init() throws ServletException {
            // Put your code here
    }

}
