/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infofso-ws1
 */
@Entity
@Table(name = "bac2014")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bac2014.findAll", query = "SELECT b FROM Bac2014 b"),
    @NamedQuery(name = "Bac2014.findById", query = "SELECT b FROM Bac2014 b WHERE b.id = :id"),
    @NamedQuery(name = "Bac2014.findByCne", query = "SELECT b FROM Bac2014 b WHERE b.cne = :cne"),
    @NamedQuery(name = "Bac2014.findByDateNaisssance", query = "SELECT b FROM Bac2014 b WHERE b.dateNaisssance = :dateNaisssance"),
    @NamedQuery(name = "Bac2014.findByAcad", query = "SELECT b FROM Bac2014 b WHERE b.acad = :acad"),
    @NamedQuery(name = "Bac2014.findBySerie", query = "SELECT b FROM Bac2014 b WHERE b.serie = :serie")})
public class Bac2014 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cne")
    private BigInteger cne;
    @Size(max = 45)
    @Column(name = "date_naisssance")
    private String dateNaisssance;
    @Size(max = 45)
    @Column(name = "acad")
    private String acad;
    @Size(max = 45)
    @Column(name = "serie")
    private String serie;

    public Bac2014() {
    }

    public Bac2014(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getCne() {
        return cne;
    }

    public void setCne(BigInteger cne) {
        this.cne = cne;
    }

    public String getDateNaisssance() {
        return dateNaisssance;
    }

    public void setDateNaisssance(String dateNaisssance) {
        this.dateNaisssance = dateNaisssance;
    }

    public String getAcad() {
        return acad;
    }

    public void setAcad(String acad) {
        this.acad = acad;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bac2014)) {
            return false;
        }
        Bac2014 other = (Bac2014) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.inscription.model.Bac2014[ id=" + id + " ]";
    }
    
}
