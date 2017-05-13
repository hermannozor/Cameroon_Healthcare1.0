/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Planification;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface PlanificationFacadeLocal {

    void create(Planification planification);

    void edit(Planification planification);

    void remove(Planification planification);

    Planification find(Object id);

    List<Planification> findAll();
    
     List<Planification> findAllInverse();

    List<Planification> findRange(int[] range);

    int count();
    
}
