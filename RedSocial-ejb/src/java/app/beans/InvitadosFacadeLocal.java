/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.beans;

import app.entity.Invitados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inma
 */
@Local
public interface InvitadosFacadeLocal {

    void create(Invitados invitados);

    void edit(Invitados invitados);

    void remove(Invitados invitados);

    Invitados find(Object id);

    List<Invitados> findAll();

    List<Invitados> findRange(int[] range);

    int count();
    
}
