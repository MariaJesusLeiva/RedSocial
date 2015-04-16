/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.beans;

import app.entity.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JoseAntonio
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> implements PostFacadeLocal {
    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List<Post> findbyIdUsuario(Short id) {
        
        
         List<Post> pst;
        Query buscarPost;
        
        try
        {
            
        buscarPost= em.createQuery("SELECT u FROM Post u WHERE u.idUsuario = :idand ") //t.idGrupo is NULL")
                 .setParameter("id", id);
        
      
            pst = (List<Post>) buscarPost.getResultList();
        }
        catch(NoResultException e)
        {
            return null;
        }
        return pst;
    }

}
