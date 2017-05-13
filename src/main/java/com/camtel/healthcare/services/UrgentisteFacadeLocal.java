/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Urgentiste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface UrgentisteFacadeLocal {

    void create(Urgentiste urgentiste);

    void edit(Urgentiste urgentiste);

    void remove(Urgentiste urgentiste);

    Urgentiste find(Object id);

    List<Urgentiste> findAll();
    
     List<Urgentiste> findAllInverse();

    List<Urgentiste> findRange(int[] range);

    int count();
    
}
