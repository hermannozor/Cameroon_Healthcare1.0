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
@Table(name = "PATIENT")
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")})
public class Patient implements Serializable, Comparable<Patient> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PATIENT")
    @SequenceGenerator(
            name = "SEQUENCE_PATIENT",
            sequenceName = "SEQUENCE_PATIENT",
            initialValue = 100000,
            allocationSize = 1
    )
    @Column(name = "ID_PATIENT")
    private BigDecimal idPatient;
    @Size(max = 20)
    @Column(name = "NOM_PATIENT")
    private String nomPatient;
    @Size(max = 20)
    @Column(name = "PRENOM_PATIENT")
    private String prenomPatient;
    @Size(max = 20)
    @Column(name = "DATE_NAISS_PATIENT")
    private String dateNaissPatient;
    @Size(max = 1)
    @Column(name = "GENRE_PATIENT")
    private String genrePatient;
    @Size(max = 20)
    @Column(name = "ADRESSE_PATIENT")
    private String adressePatient;
    @Size(max = 20)
    @Column(name = "TELEPHONE_PATIENT")
    private String telephonePatient;
    @Size(max = 20)
    @Column(name = "CNI_PATIENT")
    private String cniPatient;
    @Size(max = 20)
    @Column(name = "MP_PATIENT")
    private String mpPatient;
    @Size(max = 350)
    @Column(name = "LIEU_NAISS_PAT")
    private String lieuNaissPat;
    @Size(max = 50)
    @Column(name = "SITUATION_FAM_PAT")
    private String situationFamPat;
    @Size(max = 350)
    @Column(name = "PROF_PATIENT")
    private String profPatient;
    @Size(max = 350)
    @Column(name = "EMAIL_PAT")
    private String emailPat;
    @Size(max = 350)
    @Column(name = "CAISSE_PAT")
    private String caissePat;
    @Size(max = 350)
    @Column(name = "PARTICULARITE_PAT")
    private String particularitePat;
    @Size(max = 350)
    @Column(name = "MED_TRAIT_PAT")
    private String medTraitPat;
    @Size(max = 350)
    @Column(name = "CORRESPONDANT_PAT")
    private String correspondantPat;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;

    public Patient() {
    }

    public Patient(BigDecimal idPatient) {
        this.idPatient = idPatient;
    }

    public BigDecimal getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(BigDecimal idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public String getDateNaissPatient() {
        return dateNaissPatient;
    }

    public void setDateNaissPatient(String dateNaissPatient) {
        this.dateNaissPatient = dateNaissPatient;
    }

    public String getGenrePatient() {
        return genrePatient;
    }

    public void setGenrePatient(String genrePatient) {
        this.genrePatient = genrePatient;
    }

    public String getAdressePatient() {
        return adressePatient;
    }

    public void setAdressePatient(String adressePatient) {
        this.adressePatient = adressePatient;
    }

    public String getTelephonePatient() {
        return telephonePatient;
    }

    public void setTelephonePatient(String telephonePatient) {
        this.telephonePatient = telephonePatient;
    }

    public String getCniPatient() {
        return cniPatient;
    }

    public void setCniPatient(String cniPatient) {
        this.cniPatient = cniPatient;
    }

    public String getMpPatient() {
        return mpPatient;
    }

    public void setMpPatient(String mpPatient) {
        this.mpPatient = mpPatient;
    }

    public String getLieuNaissPat() {
        return lieuNaissPat;
    }

    public void setLieuNaissPat(String lieuNaissPat) {
        this.lieuNaissPat = lieuNaissPat;
    }

    public String getSituationFamPat() {
        return situationFamPat;
    }

    public void setSituationFamPat(String situationFamPat) {
        this.situationFamPat = situationFamPat;
    }

    public String getProfPatient() {
        return profPatient;
    }

    public void setProfPatient(String profPatient) {
        this.profPatient = profPatient;
    }

    public String getEmailPat() {
        return emailPat;
    }

    public void setEmailPat(String emailPat) {
        this.emailPat = emailPat;
    }

    public String getCaissePat() {
        return caissePat;
    }

    public void setCaissePat(String caissePat) {
        this.caissePat = caissePat;
    }

    public String getParticularitePat() {
        return particularitePat;
    }

    public void setParticularitePat(String particularitePat) {
        this.particularitePat = particularitePat;
    }

    public String getMedTraitPat() {
        return medTraitPat;
    }

    public void setMedTraitPat(String medTraitPat) {
        this.medTraitPat = medTraitPat;
    }

    public String getCorrespondantPat() {
        return correspondantPat;
    }

    public void setCorrespondantPat(String correspondantPat) {
        this.correspondantPat = correspondantPat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Patient[ idPatient=" + idPatient + " ]";
    }

    @Override
    public int compareTo(Patient patient) {
        String compareNom = ((Patient) patient).getNomPatient();
        
        return this.nomPatient.toLowerCase().compareTo(compareNom.toLowerCase());}
    
}
