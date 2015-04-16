/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.beans;

import app.entity.Amigos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JoseAntonio
 */
@Local
public interface AmigosFacadeLocal {

    void create(Amigos amigos);

    void edit(Amigos amigos);

    void remove(Amigos amigos);

    Amigos find(Object id);

    List<Amigos> findAll();

    List<Amigos> findRange(int[] range);

    int count();
    
}
