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
@Table(name = "CONSULTATION")
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")})
public class Consultation implements Serializable,Comparable<Consultation> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CONSULTATION")
    @SequenceGenerator(
            name = "SEQUENCE_CONSULTATION",
            sequenceName = "SEQUENCE_CONSULTATION",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_CONSUL")
    private BigDecimal idConsul;
    @Size(max = 20)
    @Column(name = "DATE_CONSULT")
    private String dateConsult;
    @Size(max = 100)
    @Column(name = "ACTE_CONSULT")
    private String acteConsult;
    @Size(max = 100)
    @Column(name = "MOTIF_CONSULT")
    private String motifConsult;
    @Size(max = 20)
    @Column(name = "MAT_MED_CONSULT")
    private String matMedConsult;
    @Size(max = 20)
    @Column(name = "CNI_PATIENT")
    private String cniPatient;
    @Size(max = 20)
    @Column(name = "POIDS_CONSULT")
    private String poidsConsult;
    @Size(max = 20)
    @Column(name = "TENSION_CONSULT")
    private String tensionConsult;
    @Size(max = 20)
    @Column(name = "POULS_CONSULT")
    private String poulsConsult;
    @Size(max = 700)
    @Column(name = "OBSERV_CONSULT")
    private String observConsult;

    public Consultation() {
    }

    public Consultation(BigDecimal idConsul) {
        this.idConsul = idConsul;
    }

    public BigDecimal getIdConsul() {
        return idConsul;
    }

    public void setIdConsul(BigDecimal idConsul) {
        this.idConsul = idConsul;
    }

    public String getDateConsult() {
        return dateConsult;
    }

    public void setDateConsult(String dateConsult) {
        this.dateConsult = dateConsult;
    }

    public String getActeConsult() {
        return acteConsult;
    }

    public void setActeConsult(String acteConsult) {
        this.acteConsult = acteConsult;
    }

    public String getMotifConsult() {
        return motifConsult;
    }

    public void setMotifConsult(String motifConsult) {
        this.motifConsult = motifConsult;
    }

    public String getMatMedConsult() {
        return matMedConsult;
    }

    public void setMatMedConsult(String matMedConsult) {
        this.matMedConsult = matMedConsult;
    }

    public String getCniPatient() {
        return cniPatient;
    }

    public void setCniPatient(String cniPatient) {
        this.cniPatient = cniPatient;
    }

    public String getPoidsConsult() {
        return poidsConsult;
    }

    public void setPoidsConsult(String poidsConsult) {
        this.poidsConsult = poidsConsult;
    }

    public String getTensionConsult() {
        return tensionConsult;
    }

    public void setTensionConsult(String tensionConsult) {
        this.tensionConsult = tensionConsult;
    }

    public String getPoulsConsult() {
        return poulsConsult;
    }

    public void setPoulsConsult(String poulsConsult) {
        this.poulsConsult = poulsConsult;
    }

    public String getObservConsult() {
        return observConsult;
    }

    public void setObservConsult(String observConsult) {
        this.observConsult = observConsult;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsul != null ? idConsul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idConsul == null && other.idConsul != null) || (this.idConsul != null && !this.idConsul.equals(other.idConsul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Consultation[ idConsul=" + idConsul + " ]";
    }

    @Override
    public int compareTo(Consultation consultation) {
        String compareDate = ((Consultation) consultation).getDateConsult();
        
        return this.dateConsult.toUpperCase().compareTo(compareDate.toUpperCase());
    }
    
}
