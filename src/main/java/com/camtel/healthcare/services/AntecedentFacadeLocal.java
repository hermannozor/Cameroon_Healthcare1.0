/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Antecedent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface AntecedentFacadeLocal {

    void create(Antecedent antecedent);

    void edit(Antecedent antecedent);

    void remove(Antecedent antecedent);

    Antecedent find(Object id);

    List<Antecedent> findAll();

    List<Antecedent> findRange(int[] range);

    int count();
    
}
