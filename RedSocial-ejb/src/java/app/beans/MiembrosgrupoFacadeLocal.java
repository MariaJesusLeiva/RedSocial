/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.beans;

import app.entity.Miembrosgrupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inma
 */
@Local
public interface MiembrosgrupoFacadeLocal {

    void create(Miembrosgrupo miembrosgrupo);

    void edit(Miembrosgrupo miembrosgrupo);

    void remove(Miembrosgrupo miembrosgrupo);

    Miembrosgrupo find(Object id);

    List<Miembrosgrupo> findAll();

    List<Miembrosgrupo> findRange(int[] range);

    int count();
    
}
