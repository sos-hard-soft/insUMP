/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.services;

import com.sos.ump.inscription.model.Bac2014;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author infofso-ws1
 */
@Stateless
public class Bac2014Facade extends AbstractFacade<Bac2014> {
    @PersistenceContext(unitName = "insUMP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Bac2014Facade() {
        super(Bac2014.class);
    }
    
}
