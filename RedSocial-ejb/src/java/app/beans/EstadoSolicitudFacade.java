/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.beans;

import app.entity.EstadoSolicitud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JoseAntonio
 */
@Stateless
public class EstadoSolicitudFacade extends AbstractFacade<EstadoSolicitud> implements EstadoSolicitudFacadeLocal {
    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoSolicitudFacade() {
        super(EstadoSolicitud.class);
    }
    
}
