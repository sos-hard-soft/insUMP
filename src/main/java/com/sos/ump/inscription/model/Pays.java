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
    @NamedQuery(name = "Pays.findByLicPay", query = "SELECT p FROM Pays p WHERE p.licPay = :licPay"),
    @NamedQuery(name = "Pays.findByLibNat", query = "SELECT p FROM Pays p WHERE p.libNat = :libNat")})
public class Pays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "COD_PAY")
    private String codPay;
    @Size(max = 75)
    @Column(name = "LIB_PAY")
    private String libPay;
    @Size(max = 100)
    @Column(name = "LIC_PAY")
    private String licPay;
    @Size(max = 45)
    @Column(name = "LIB_NAT")
    private String libNat;

    public Pays() {
    }

    public Pays(String codPay) {
        this.codPay = codPay;
    }

    public String getCodPay() {
        return codPay;
    }

    public void setCodPay(String codPay) {
        this.codPay = codPay;
    }

    public String getLibPay() {
        return libPay;
    }

    public void setLibPay(String libPay) {
        this.libPay = libPay;
    }

    public String getLicPay() {
        return licPay;
    }

    public void setLicPay(String licPay) {
        this.licPay = licPay;
    }

    public String getLibNat() {
        return libNat;
    }

    public void setLibNat(String libNat) {
        this.libNat = libNat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPay != null ? codPay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.codPay == null && other.codPay != null) || (this.codPay != null && !this.codPay.equals(other.codPay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.inscription.model.Pays[ codPay=" + codPay + " ]";
    }
    
}
