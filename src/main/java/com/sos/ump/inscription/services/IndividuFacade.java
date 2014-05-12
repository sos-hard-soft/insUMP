/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.services;

import com.sos.ump.inscription.model.Individu;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author infofso-ws1
 */
@Stateless
public class IndividuFacade extends AbstractFacade<Individu> {
    @PersistenceContext(unitName = "insUMP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndividuFacade() {
        super(Individu.class);
    }
    public Individu findByCne(BigInteger cne) {
        Individu individu;
        try {
            individu = em.createNamedQuery("Individu.findByCne", Individu.class).setParameter("cne", cne).getSingleResult();
            return individu;
        } catch (NoResultException ex) {
            return null;
        }
        
    }
    
    public Individu findByCin(String cin) {
        Individu individu;
        try {
            individu = em.createNamedQuery("Individu.findByCin", Individu.class).setParameter("cin", cin).getSingleResult();
            return individu;
        } catch (NoResultException ex) {
            return null;
        }
        
    }
}
