/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.ForumHealthcare;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface ForumHealthcareFacadeLocal {

    void create(ForumHealthcare forumHealthcare);

    void edit(ForumHealthcare forumHealthcare);

    void remove(ForumHealthcare forumHealthcare);

    ForumHealthcare find(Object id);

    List<ForumHealthcare> findAll();
    
     List<ForumHealthcare> findAllInverse();

    List<ForumHealthcare> findRange(int[] range);

    int count();
    
}
