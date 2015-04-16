/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.beans;

import app.entity.Amigos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Inma
 */
@Stateless
public class AmigosFacade extends AbstractFacade<Amigos> implements AmigosFacadeLocal {
    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmigosFacade() {
        super(Amigos.class);
    }
    
}
