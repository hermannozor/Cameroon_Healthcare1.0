/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.EmailHealthcare;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface EmailHealthcareFacadeLocal {

    void create(EmailHealthcare emailHealthcare);

    void edit(EmailHealthcare emailHealthcare);

    void remove(EmailHealthcare emailHealthcare);

    EmailHealthcare find(Object id);

    List<EmailHealthcare> findAll();
    
     List<EmailHealthcare> findAllInverse();

    List<EmailHealthcare> findRange(int[] range);

    int count();
    
}
