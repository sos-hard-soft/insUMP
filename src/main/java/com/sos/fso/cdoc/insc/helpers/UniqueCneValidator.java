/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.fso.cdoc.insc.helpers;

import com.sos.ump.inscription.services.IndividuFacade;
import java.math.BigInteger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */
@FacesValidator("uniqueCneValidator")
public class UniqueCneValidator implements Validator{

    @Inject
    private IndividuFacade individuService;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if (value == null) {
            return; // Let required="true" handle, if any.
        }

        long cne = (long) value;

        if (individuService.findByCne(cne) != null) {
            throw new ValidatorException(new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Ce Code national est deja enregistrer !!", null));
        }
    }
    
}
