/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.ConseilHealth;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface ConseilHealthFacadeLocal {

    void create(ConseilHealth conseilHealth);

    void edit(ConseilHealth conseilHealth);

    void remove(ConseilHealth conseilHealth);

    ConseilHealth find(Object id);

    List<ConseilHealth> findAll();
    
     List<ConseilHealth> findAllInverse();

    List<ConseilHealth> findRange(int[] range);

    int count();
    
}
