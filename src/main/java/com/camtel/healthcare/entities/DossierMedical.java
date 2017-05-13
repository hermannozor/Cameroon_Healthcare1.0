/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author herma
 */
@Entity
@Table(name = "DOSSIER_MEDICAL")
@NamedQueries({
    @NamedQuery(name = "DossierMedical.findAll", query = "SELECT d FROM DossierMedical d")})
public class DossierMedical implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_DOSSIER_MEDICAL ")
    @SequenceGenerator(
            name = "SEQUENCE_DOSSIER_MEDICAL ",
            sequenceName = "SEQUENCE_DOSSIER_MEDICAL ",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_DM")
    private BigDecimal idDm;
    @Size(max = 150)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 150)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 50)
    @Column(name = "DATE_NAISS")
    private String dateNaiss;
    @Size(max = 150)
    @Column(name = "LIEU_NAISS")
    private String lieuNaiss;
    @Size(max = 200)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 150)
    @Column(name = "CORRESPONDANT")
    private String correspondant;
    @Size(max = 50)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 250)
    @Column(name = "CAISS_PAT")
    private String caissPat;
    @Size(max = 250)
    @Column(name = "PROF_PAT")
    private String profPat;
    @Size(max = 50)
    @Column(name = "SITUATION_FAM_PAT")
    private String situationFamPat;
    @Size(max = 50)
    @Column(name = "MATRICULE")
    private String matricule;

    public DossierMedical() {
    }

    public DossierMedical(BigDecimal idDm) {
        this.idDm = idDm;
    }

    public BigDecimal getIdDm() {
        return idDm;
    }

    public void setIdDm(BigDecimal idDm) {
        this.idDm = idDm;
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

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCorrespondant() {
        return correspondant;
    }

    public void setCorrespondant(String correspondant) {
        this.correspondant = correspondant;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCaissPat() {
        return caissPat;
    }

    public void setCaissPat(String caissPat) {
        this.caissPat = caissPat;
    }

    public String getProfPat() {
        return profPat;
    }

    public void setProfPat(String profPat) {
        this.profPat = profPat;
    }

    public String getSituationFamPat() {
        return situationFamPat;
    }

    public void setSituationFamPat(String situationFamPat) {
        this.situationFamPat = situationFamPat;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDm != null ? idDm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DossierMedical)) {
            return false;
        }
        DossierMedical other = (DossierMedical) object;
        if ((this.idDm == null && other.idDm != null) || (this.idDm != null && !this.idDm.equals(other.idDm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.DossierMedical[ idDm=" + idDm + " ]";
    }
    
}
