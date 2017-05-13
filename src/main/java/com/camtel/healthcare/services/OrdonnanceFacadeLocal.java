/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Ordonnance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface OrdonnanceFacadeLocal {

    void create(Ordonnance ordonnance);

    void edit(Ordonnance ordonnance);

    void remove(Ordonnance ordonnance);

    Ordonnance find(Object id);

    List<Ordonnance> findAll();
    
     List<Ordonnance> findAllInverse();

    List<Ordonnance> findRange(int[] range);

    int count();
    
}
