/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Biometrie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface BiometrieFacadeLocal {

    void create(Biometrie biometrie);

    void edit(Biometrie biometrie);

    void remove(Biometrie biometrie);

    Biometrie find(Object id);

    List<Biometrie> findAll();
    
     List<Biometrie> findAllInverse();

    List<Biometrie> findRange(int[] range);

    int count();
    
}
