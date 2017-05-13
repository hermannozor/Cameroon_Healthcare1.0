/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.services;

import com.camtel.healthcare.entities.Ordonnance;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author herma
 */
@Stateless
public class OrdonnanceFacade extends AbstractFacade<Ordonnance> implements OrdonnanceFacadeLocal {
    @PersistenceContext(unitName = "com.camtel_healthCare_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdonnanceFacade() {
        super(Ordonnance.class);
    }
    
}
