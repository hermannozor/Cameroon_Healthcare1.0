/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Docteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface DocteurFacadeLocal {

    void create(Docteur docteur);

    void edit(Docteur docteur);

    void remove(Docteur docteur);

    Docteur find(Object id);

    List<Docteur> findAll();
    
     List<Docteur> findAllInverse();

    List<Docteur> findRange(int[] range);

    int count();
    
}
