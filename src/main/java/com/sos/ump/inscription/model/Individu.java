/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.inscription.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infofso-ws1
 */
@Entity
@Table(name = "individu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Individu.findAll", query = "SELECT i FROM Individu i"),
    @NamedQuery(name = "Individu.findById", query = "SELECT i FROM Individu i WHERE i.id = :id"),
    @NamedQuery(name = "Individu.findByNom", query = "SELECT i FROM Individu i WHERE i.nom = :nom"),
    @NamedQuery(name = "Individu.findByPrenom", query = "SELECT i FROM Individu i WHERE i.prenom = :prenom"),
    @NamedQuery(name = "Individu.findByNomAr", query = "SELECT i FROM Individu i WHERE i.nomAr = :nomAr"),
    @NamedQuery(name = "Individu.findByPrenomAr", query = "SELECT i FROM Individu i WHERE i.prenomAr = :prenomAr"),
    @NamedQuery(name = "Individu.findByCin", query = "SELECT i FROM Individu i WHERE i.cin = :cin"),
    @NamedQuery(name = "Individu.findByDateNaissance", query = "SELECT i FROM Individu i WHERE i.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Individu.findByVilleNaissance", query = "SELECT i FROM Individu i WHERE i.villeNaissance = :villeNaissance"),
    @NamedQuery(name = "Individu.findByVilleNaissanceAr", query = "SELECT i FROM Individu i WHERE i.villeNaissanceAr = :villeNaissanceAr"),
    @NamedQuery(name = "Individu.findBySex", query = "SELECT i FROM Individu i WHERE i.sex = :sex"),
    @NamedQuery(name = "Individu.findByCne", query = "SELECT i FROM Individu i WHERE i.cne = :cne"),
    @NamedQuery(name = "Individu.findByAdresse", query = "SELECT i FROM Individu i WHERE i.adresse = :adresse"),
    @NamedQuery(name = "Individu.findByCodePays", query = "SELECT i FROM Individu i WHERE i.codePays = :codePays"),
    @NamedQuery(name = "Individu.findByCodeEtape", query = "SELECT i FROM Individu i WHERE i.codeEtape = :codeEtape"),
    @NamedQuery(name = "Individu.findByBacaleaureat", query = "SELECT i FROM Individu i WHERE i.bacaleaureat = :bacaleaureat"),
    @NamedQuery(name = "Individu.findByProvince", query = "SELECT i FROM Individu i WHERE i.province = :province"),
    @NamedQuery(name = "Individu.findByMension", query = "SELECT i FROM Individu i WHERE i.mension = :mension"),
    @NamedQuery(name = "Individu.findByNationalite", query = "SELECT i FROM Individu i WHERE i.nationalite = :nationalite"),
    @NamedQuery(name = "Individu.findByNumTelephonne", query = "SELECT i FROM Individu i WHERE i.numTelephonne = :numTelephonne"),
    @NamedQuery(name = "Individu.findByEmail", query = "SELECT i FROM Individu i WHERE i.email = :email"),
    @NamedQuery(name = "Individu.findByVille", query = "SELECT i FROM Individu i WHERE i.ville = :ville"),
    @NamedQuery(name = "Individu.findByPays", query = "SELECT i FROM Individu i WHERE i.pays = :pays"),
    @NamedQuery(name = "Individu.findByNomPere", query = "SELECT i FROM Individu i WHERE i.nomPere = :nomPere"),
    @NamedQuery(name = "Individu.findByPrenomPere", query = "SELECT i FROM Individu i WHERE i.prenomPere = :prenomPere"),
    @NamedQuery(name = "Individu.findByProfessionPere", query = "SELECT i FROM Individu i WHERE i.professionPere = :professionPere"),
    @NamedQuery(name = "Individu.findByNomMere", query = "SELECT i FROM Individu i WHERE i.nomMere = :nomMere"),
    @NamedQuery(name = "Individu.findByPrenomMere", query = "SELECT i FROM Individu i WHERE i.prenomMere = :prenomMere"),
    @NamedQuery(name = "Individu.findByProfessionMere", query = "SELECT i FROM Individu i WHERE i.professionMere = :professionMere")})
public class Individu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "nom")
    private String nom;
    @Size(max = 150)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 150)
    @Column(name = "nom_ar")
    private String nomAr;
    @Size(max = 150)
    @Column(name = "prenom_ar")
    private String prenomAr;
    @Size(max = 10)
    @Column(name = "cin")
    private String cin;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 50)
    @Column(name = "ville_naissance")
    private String villeNaissance;
    @Size(max = 50)
    @Column(name = "ville_naissance_ar")
    private String villeNaissanceAr;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "cne")
    private BigInteger cne;
    @Size(max = 500)
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code_pays")
    private Integer codePays;
    @Size(max = 45)
    @Column(name = "code_etape")
    private String codeEtape;
    @Size(max = 45)
    @Column(name = "bacaleaureat")
    private String bacaleaureat;
    @Size(max = 45)
    @Column(name = "province")
    private String province;
    @Size(max = 45)
    @Column(name = "mension")
    private String mension;
    @Size(max = 45)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 45)
    @Column(name = "num_telephonne")
    private String numTelephonne;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 75)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Size(max = 45)
    @Column(name = "pays")
    private String pays;
    @Size(max = 75)
    @Column(name = "nom_pere")
    private String nomPere;
    @Size(max = 75)
    @Column(name = "prenom_pere")
    private String prenomPere;
    @Size(max = 75)
    @Column(name = "profession_pere")
    private String professionPere;
    @Size(max = 75)
    @Column(name = "nom_mere")
    private String nomMere;
    @Size(max = 75)
    @Column(name = "prenom_mere")
    private String prenomMere;
    @Size(max = 75)
    @Column(name = "profession_mere")
    private String professionMere;

    public Individu() {
    }

    public Individu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public String getVilleNaissanceAr() {
        return villeNaissanceAr;
    }

    public void setVilleNaissanceAr(String villeNaissanceAr) {
        this.villeNaissanceAr = villeNaissanceAr;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public BigInteger getCne() {
        return cne;
    }

    public void setCne(BigInteger cne) {
        this.cne = cne;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCodePays() {
        return codePays;
    }

    public void setCodePays(Integer codePays) {
        this.codePays = codePays;
    }

    public String getCodeEtape() {
        return codeEtape;
    }

    public void setCodeEtape(String codeEtape) {
        this.codeEtape = codeEtape;
    }

    public String getBacaleaureat() {
        return bacaleaureat;
    }

    public void setBacaleaureat(String bacaleaureat) {
        this.bacaleaureat = bacaleaureat;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMension() {
        return mension;
    }

    public void setMension(String mension) {
        this.mension = mension;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNumTelephonne() {
        return numTelephonne;
    }

    public void setNumTelephonne(String numTelephonne) {
        this.numTelephonne = numTelephonne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getProfessionPere() {
        return professionPere;
    }

    public void setProfessionPere(String professionPere) {
        this.professionPere = professionPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getProfessionMere() {
        return professionMere;
    }

    public void setProfessionMere(String professionMere) {
        this.professionMere = professionMere;
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
        if (!(object instanceof Individu)) {
            return false;
        }
        Individu other = (Individu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.inscription.model.Individu[ id=" + id + " ]";
    }
    
}
