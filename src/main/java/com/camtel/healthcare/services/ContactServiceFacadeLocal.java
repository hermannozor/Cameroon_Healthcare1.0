/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.ContactService;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface ContactServiceFacadeLocal {

    void create(ContactService contactService);

    void edit(ContactService contactService);

    void remove(ContactService contactService);

    ContactService find(Object id);

    List<ContactService> findAll();
    
    List<ContactService> findAllInverse();

    List<ContactService> findRange(int[] range);

    int count();
    
}
