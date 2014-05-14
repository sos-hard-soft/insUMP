/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.controllers;

import com.sos.ump.inscription.model.Pays;
import com.sos.ump.inscription.services.PaysFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author infofso-ws1
 */

@Named(value = "paysController")
@SessionScoped
public class PaysController implements Serializable {

    @Inject
    private PaysFacade paysService;
    private List<Pays> lesPays;
    private Pays pays;
    /**
     * Creates a new instance of PaysController
     */
    public PaysController() {
    }
    
    public List<Pays> getAll(){
        return paysService.findAll();
    }
    

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    
    
    
    
public Pays getPays(java.lang.Integer id) {
        return paysService.find(id);
    }
    
     @FacesConverter(forClass = Pays.class)
    public static class PaysControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PaysController controller = (PaysController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "paysController");
            return controller.getPays(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pays) {
                Pays o = (Pays) object;
                return getStringKey(o.getCodPay());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Pays.class.getName());
            }
        }
    
}
}