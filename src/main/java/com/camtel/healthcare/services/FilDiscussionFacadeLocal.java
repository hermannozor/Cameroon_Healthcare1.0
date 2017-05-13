/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.FilDiscussion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface FilDiscussionFacadeLocal {

    void create(FilDiscussion filDiscussion);

    void edit(FilDiscussion filDiscussion);

    void remove(FilDiscussion filDiscussion);

    FilDiscussion find(Object id);

    List<FilDiscussion> findAll();
    
        List<FilDiscussion> findAllInverse();

    List<FilDiscussion> findRange(int[] range);

    int count();
    
}
