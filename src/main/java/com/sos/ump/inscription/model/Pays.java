/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infofso-ws1
 */
@Entity
@Table(name = "pays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.findByCodPay", query = "SELECT p FROM Pays p WHERE p.codPay = :codPay"),
    @NamedQuery(name = "Pays.findByLibPay", query = "SELECT p FROM Pays p WHERE p.libPay = :libPay"),
    @NamedQuery(name = "Pays.findByLibNat", query = "SELECT p FROM Pays p WHERE p.libNat = :libNat")})
public class Pays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_PAY")
    private int codPay;
    @Size(max = 175)
    @Column(name = "LIB_PAY")
    private String libPay;
    @Size(max = 175)
    @Column(name = "LIB_NAT")
    private String libNat;
    public Pays() {
    }

    public Pays(int codPay) {
        this.codPay = codPay;
    }

    public int getCodPay() {
        return codPay;
    }

    public void setCodPay(int codPay) {
        this.codPay = codPay;
    }

    public String getLibPay() {
        return libPay;
    }

    public void setLibPay(String libPay) {
        this.libPay = libPay;
    }

   

    public String getLibNat() {
        return libNat;
    }

    public void setLibNat(String libNat) {
        this.libNat = libNat;
    }

    

    

    @Override
    public String toString() {
        return libPay;
    }
    
}
