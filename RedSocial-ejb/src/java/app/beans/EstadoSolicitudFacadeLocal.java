/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.beans;

import app.entity.EstadoSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inma
 */
@Local
public interface EstadoSolicitudFacadeLocal {

    void create(EstadoSolicitud estadoSolicitud);

    void edit(EstadoSolicitud estadoSolicitud);

    void remove(EstadoSolicitud estadoSolicitud);

    EstadoSolicitud find(Object id);

    List<EstadoSolicitud> findAll();

    List<EstadoSolicitud> findRange(int[] range);

    int count();
    
}
