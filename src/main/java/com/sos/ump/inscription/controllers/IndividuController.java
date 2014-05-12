/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.controllers;

import com.sos.fso.cdoc.insc.helpers.Hash;
import com.sos.ump.inscription.model.Activation;
import com.sos.ump.inscription.model.Compte;
import com.sos.ump.inscription.model.Individu;
import com.sos.ump.inscription.services.ActivationFacade;
import com.sos.ump.inscription.services.CompteFacade;
import com.sos.ump.inscription.services.IndividuFacade;
import com.sos.ump.inscription.services.MailerBean;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author infofso-ws1
 */
@Named(value = "individuController")
@SessionScoped
public class IndividuController implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    @Inject
    protected MailerBean mailerBean;
    protected String email;
    protected String status;
    private static final Logger logger = Logger.getLogger(IndividuController.class.getName());
    private Future<String> mailStatus;

    @Inject
    private IndividuFacade individuService;
    private Individu newIndividu = new Individu();
    private Individu current;
    private List<Individu> individus;

    @Inject
    private CompteFacade compteService;
    private Compte newCompte = new Compte();
    private Compte compte;
    private boolean sessionOuverte;

    @Inject
    private ActivationFacade activationService;
    private Activation activation;

    private boolean visibled = false;
    private boolean visible = false;

    // ======================================
    // = Navigation Methods =
    // ======================================
    public String showIndex() {
        return "/index?faces-redirect=true";
    }

    public String showPrint(){
        return "/individu/formCandidature?faces-redirect=true";
        }
    
    public String showEdit() {
        //this.current = item;
        return "/individu/edit?faces-redirect=true";
    }

    public String showDetails() {
        return "/individu/view?faces-redirect=true";
    }

    public String showCreate() {
        this.newIndividu = new Individu();
        this.newCompte = new Compte();
        activation = new Activation();
        return "/individu/new?faces-redirect=true";
    }

    
    public String showLoggedDetails() {
        BigInteger cne = compte.getCne();
        System.out.println("le cne est : " + cne);
        current = individuService.findByCne(cne);
        System.out.println("La personne est : " + current.getNom() + "--> " + current.getCin());
        individuService.clearCache();
        return "/individu/view?faces-redirect=true";
    }

    public String showLogin() {
        return "/secured/logedIndividu?faces-redirect=true";
    }

    // ======================================
    // = Business Methods =
    // ======================================

    @PostConstruct
    public void init() {
        if (current == null) {
            sessionOuverte = false;
        } else {
            sessionOuverte = true;
        }
    }

    public void SendEmail(String email, String key, BigInteger cne, String password) {
        String response = "response?faces-redirect=true";

        try {
            mailStatus = mailerBean.sendVerificationMail(email, key, cne, password);
            this.setStatus("Envoie en cours ...(veuillez rafraishir !!!)");
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
        }

        //return response;
    }

    public void sendConfirmationCandidatureMail(String email, String choix){
        try {
            mailStatus = mailerBean.sendConfirmationCandidatureMail(email, choix);
            this.setStatus("Envoie en cours ...");
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
        }
    }
    
    public List<Individu> getAll() {
        individuService.clearCache();
        return individuService.findAll();
    }

    
    public String doCreate() {
        //creation du compte a partir des infos de l'individu
        newCompte.setCne(newIndividu.getCne());
        newCompte.setEmail(newIndividu.getEmail());
        newCompte.setActif(Boolean.FALSE);
        newCompte.setGroupe("candidat");
        
        System.out.println(newIndividu.getCin());
        
        //Creation Du compte
        String password = newCompte.getPassword();
        String hashedPassword = Hash.hash(password);
        System.out.println("the hashed password is " + hashedPassword);

        newCompte.setPassword(hashedPassword);
        compteService.create(newCompte);
        System.out.println("Compte creer");
        //Creation de l'individu
        System.out.println("creation de l individu");
        
        individuService.create(newIndividu);        
        
        System.out.println("Individu creer !!!!");
        
        
        //Generation de la cle d'identification et envoie de mail d'activation
        final String key = UUID.randomUUID().toString();
        System.out.println("La cle generer est " + key);
        SendEmail(newIndividu.getEmail(), key, newIndividu.getCne(), password);        
        //Definition de l'activation
        activation.setActivationKey(key);
        activation.setCompte(newCompte);
        activationService.create(activation);

        
        return "waitValidation?faces-redirect=true";
    }

    public String doEdit() {
        try {
            individuService.edit(current);

        } catch (Exception e) {
        }
        return showDetails();
    }

    
    // ======================================
    // = Constructors et Helpers=
    // ======================================

    public IndividuController() {
    }

    private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(key, msg);
    }

    
    // ======================================
    // = Getters & setters =
    // ======================================
    public Individu getNewIndividu() {
        return newIndividu;
    }

    public void setNewIndividu(Individu newIndividu) {
        this.newIndividu = newIndividu;
    }

    public Individu getCurrent() {
        if (current == null) {
            current = individuService.findByCne(compte.getCne());
        }
        return current;
    }

    public void setCurrent(Individu current) {
        this.current = current;
    }

    public Compte getNewCompte() {
        return newCompte;
    }

    public void setNewCompte(Compte newCompte) {
        this.newCompte = newCompte;
    }

    public Compte getCompte() {
        if (compte == null) {
            Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
            if (principal != null) {
                long cne = Long.parseLong(principal.getName());
                compte = compteService.findByCne(cne);
            }
        }
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSessionOuverte() {
        return sessionOuverte;
    }

    public void setSessionOuverte(boolean sessionOuverte) {
        this.sessionOuverte = sessionOuverte;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

    public boolean isVisibled() {
        return visibled;
    }

    public void setVisibled(boolean visibled) {
        this.visibled = visibled;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
