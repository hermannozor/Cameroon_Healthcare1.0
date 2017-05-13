/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.DossierMedical;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herma
 */
@Local
public interface DossierMedicalFacadeLocal {

    void create(DossierMedical dossierMedical);

    void edit(DossierMedical dossierMedical);

    void remove(DossierMedical dossierMedical);

    DossierMedical find(Object id);

    List<DossierMedical> findAll();
    
    List<DossierMedical> findAllInverse();

    List<DossierMedical> findRange(int[] range);

    int count();
    
}
