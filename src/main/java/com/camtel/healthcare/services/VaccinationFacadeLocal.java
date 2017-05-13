/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Vaccination;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface VaccinationFacadeLocal {

    void create(Vaccination vaccination);

    void edit(Vaccination vaccination);

    void remove(Vaccination vaccination);

    Vaccination find(Object id);

    List<Vaccination> findAll();
    
     List<Vaccination> findAllInverse();

    List<Vaccination> findRange(int[] range);

    int count();
    
}
