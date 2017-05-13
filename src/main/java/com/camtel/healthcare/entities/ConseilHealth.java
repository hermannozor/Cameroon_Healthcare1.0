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
@Table(name = "CONSEIL_HEALTH")
@NamedQueries({
    @NamedQuery(name = "ConseilHealth.findAll", query = "SELECT c FROM ConseilHealth c")})
public class ConseilHealth implements Serializable,Comparable<ConseilHealth> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CONSEIL")
    @SequenceGenerator(
            name = "SEQUENCE_CONSEIL",
            sequenceName = "SEQUENCE_CONSEIL",
            initialValue = 0,
            allocationSize = 1
    )
    @Column(name = "ID_CONSEIL")
    private BigDecimal idConseil;
    @Size(max = 50)
    @Column(name = "DATE_CONSULT_CONSEIL")
    private String dateConsultConseil;
    @Size(max = 50)
    @Column(name = "ACTE_CONSULT_CONSEIL")
    private String acteConsultConseil;
    @Size(max = 200)
    @Column(name = "MOTIF_CONSULT_CONSEIL")
    private String motifConsultConseil;
    @Size(max = 50)
    @Column(name = "MAT_MED_CONSEIL")
    private String matMedConseil;
    @Size(max = 50)
    @Column(name = "CNI_PATIENT_CONSEIL")
    private String cniPatientConseil;
    @Size(max = 50)
    @Column(name = "POIDS_CONSULT_CONSEIL")
    private String poidsConsultConseil;
    @Size(max = 50)
    @Column(name = "TENSION_CONSULT_CONSEIL")
    private String tensionConsultConseil;
    @Size(max = 50)
    @Column(name = "POUL_CONSULT_CONSEIL")
    private String poulConsultConseil;
    @Size(max = 800)
    @Column(name = "OBSERV_CONSULT_CONSEIL")
    private String observConsultConseil;
    @Size(max = 900)
    @Column(name = "CONTENU_CONSEIL")
    private String contenuConseil;
    @Size(max = 50)
    @Column(name = "NOM_DOCTEUR")
    private String nomDocteur;
    @Size(max = 50)
    @Column(name = "DATE_PUBLICATION")
    private String datePublication;

    public ConseilHealth() {
    }

    public ConseilHealth(BigDecimal idConseil) {
        this.idConseil = idConseil;
    }

    public BigDecimal getIdConseil() {
        return idConseil;
    }

    public void setIdConseil(BigDecimal idConseil) {
        this.idConseil = idConseil;
    }

    public String getDateConsultConseil() {
        return dateConsultConseil;
    }

    public void setDateConsultConseil(String dateConsultConseil) {
        this.dateConsultConseil = dateConsultConseil;
    }

    public String getActeConsultConseil() {
        return acteConsultConseil;
    }

    public void setActeConsultConseil(String acteConsultConseil) {
        this.acteConsultConseil = acteConsultConseil;
    }

    public String getMotifConsultConseil() {
        return motifConsultConseil;
    }

    public void setMotifConsultConseil(String motifConsultConseil) {
        this.motifConsultConseil = motifConsultConseil;
    }

    public String getMatMedConseil() {
        return matMedConseil;
    }

    public void setMatMedConseil(String matMedConseil) {
        this.matMedConseil = matMedConseil;
    }

    public String getCniPatientConseil() {
        return cniPatientConseil;
    }

    public void setCniPatientConseil(String cniPatientConseil) {
        this.cniPatientConseil = cniPatientConseil;
    }

    public String getPoidsConsultConseil() {
        return poidsConsultConseil;
    }

    public void setPoidsConsultConseil(String poidsConsultConseil) {
        this.poidsConsultConseil = poidsConsultConseil;
    }

    public String getTensionConsultConseil() {
        return tensionConsultConseil;
    }

    public void setTensionConsultConseil(String tensionConsultConseil) {
        this.tensionConsultConseil = tensionConsultConseil;
    }

    public String getPoulConsultConseil() {
        return poulConsultConseil;
    }

    public void setPoulConsultConseil(String poulConsultConseil) {
        this.poulConsultConseil = poulConsultConseil;
    }

    public String getObservConsultConseil() {
        return observConsultConseil;
    }

    public void setObservConsultConseil(String observConsultConseil) {
        this.observConsultConseil = observConsultConseil;
    }

    public String getContenuConseil() {
        return contenuConseil;
    }

    public void setContenuConseil(String contenuConseil) {
        this.contenuConseil = contenuConseil;
    }

    public String getNomDocteur() {
        return nomDocteur;
    }

    public void setNomDocteur(String nomDocteur) {
        this.nomDocteur = nomDocteur;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConseil != null ? idConseil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConseilHealth)) {
            return false;
        }
        ConseilHealth other = (ConseilHealth) object;
        if ((this.idConseil == null && other.idConseil != null) || (this.idConseil != null && !this.idConseil.equals(other.idConseil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.ConseilHealth[ idConseil=" + idConseil + " ]";
    }

    @Override
    public int compareTo(ConseilHealth conseil) {
       String compareDate = ((ConseilHealth) conseil).getDatePublication();
        
        return this.datePublication.toLowerCase().compareTo(compareDate.toLowerCase());
  }
    
}
