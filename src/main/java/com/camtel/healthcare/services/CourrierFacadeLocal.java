/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Courrier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface CourrierFacadeLocal {

    void create(Courrier courrier);

    void edit(Courrier courrier);

    void remove(Courrier courrier);

    Courrier find(Object id);

    List<Courrier> findAll();
    
    List<Courrier> findAllInverse();

    List<Courrier> findRange(int[] range);

    int count();
    
}
