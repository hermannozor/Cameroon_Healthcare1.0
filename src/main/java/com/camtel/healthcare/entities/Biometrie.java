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
@Table(name = "BIOMETRIE")
@NamedQueries({
    @NamedQuery(name = "Biometrie.findAll", query = "SELECT b FROM Biometrie b")})
public class Biometrie implements Serializable, Comparable<Biometrie> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_BIOMETRIE")
    @SequenceGenerator(
            name = "SEQUENCE_BIOMETRIE",
            sequenceName = "SEQUENCE_BIOMETRIE",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_BIOMETRIE")
    private BigDecimal idBiometrie;
    @Size(max = 3)
    @Column(name = "TAILLE")
    private String taille;
    @Size(max = 3)
    @Column(name = "POIDS")
    private String poids;
    @Size(max = 20)
    @Column(name = "GROUP_SANGUIN")
    private String groupSanguin;
    @Size(max = 4)
    @Column(name = "IMC_BIO")
    private String imcBio;
    @Size(max = 20)
    @Column(name = "CNI_PATIENT_BIO")
    private String cniPatientBio;
    @Size(max = 20)
    @Column(name = "NOM_PATIENT")
    private String nomPatient;
    @Size(max = 350)
    @Column(name = "INDICATEUR_BIO")
    private String indicateurBio;

    public Biometrie() {
    }

    public Biometrie(BigDecimal idBiometrie) {
        this.idBiometrie = idBiometrie;
    }

    public BigDecimal getIdBiometrie() {
        return idBiometrie;
    }

    public void setIdBiometrie(BigDecimal idBiometrie) {
        this.idBiometrie = idBiometrie;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getGroupSanguin() {
        return groupSanguin;
    }

    public void setGroupSanguin(String groupSanguin) {
        this.groupSanguin = groupSanguin;
    }

    public String getImcBio() {
        return imcBio;
    }

    public void setImcBio(String imcBio) {
        this.imcBio = imcBio;
    }

    public String getCniPatientBio() {
        return cniPatientBio;
    }

    public void setCniPatientBio(String cniPatientBio) {
        this.cniPatientBio = cniPatientBio;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getIndicateurBio() {
        return indicateurBio;
    }

    public void setIndicateurBio(String indicateurBio) {
        this.indicateurBio = indicateurBio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBiometrie != null ? idBiometrie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biometrie)) {
            return false;
        }
        Biometrie other = (Biometrie) object;
        if ((this.idBiometrie == null && other.idBiometrie != null) || (this.idBiometrie != null && !this.idBiometrie.equals(other.idBiometrie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Biometrie[ idBiometrie=" + idBiometrie + " ]";
    }

    @Override
    public int compareTo(Biometrie biometrie) {
         String compareNom = (((Biometrie) biometrie).getNomPatient());
        
        return this.nomPatient.toLowerCase().compareTo(compareNom.toLowerCase());
    }
    
}
