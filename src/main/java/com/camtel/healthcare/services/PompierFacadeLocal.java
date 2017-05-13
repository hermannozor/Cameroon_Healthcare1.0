/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Pompier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface PompierFacadeLocal {

    void create(Pompier pompier);

    void edit(Pompier pompier);

    void remove(Pompier pompier);

    Pompier find(Object id);

    List<Pompier> findAll();
    
    List<Pompier> findAllInverse();

    List<Pompier> findRange(int[] range);

    int count();
    
}
