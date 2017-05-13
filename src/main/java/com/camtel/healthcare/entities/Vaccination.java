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
@Table(name = "VACCINATION")
@NamedQueries({
    @NamedQuery(name = "Vaccination.findAll", query = "SELECT v FROM Vaccination v")})
public class Vaccination implements Serializable,Comparable<Vaccination> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_VACCINATION")
    @SequenceGenerator(
            name = "SEQUENCE_VACCINATION",
            sequenceName = "SEQUENCE_VACCINATION",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_VACC")
    private BigDecimal idVacc;
    @Size(max = 20)
    @Column(name = "DATE_VACC")
    private String dateVacc;
    @Size(max = 20)
    @Column(name = "INJECTION_VACC")
    private String injectionVacc;
    @Size(max = 20)
    @Column(name = "LOT_VACC")
    private String lotVacc;
    @Size(max = 20)
    @Column(name = "RAPPEL_VACC")
    private String rappelVacc;
    @Size(max = 20)
    @Column(name = "CNI_PATIENT")
    private String cniPatient;
    @Size(max = 20)
    @Column(name = "MAT_MED_VACC")
    private String matMedVacc;
    @Size(max = 500)
    @Column(name = "RESULTAT_VACC")
    private String resultatVacc;
    @Size(max = 100)
    @Column(name = "NOM_VACCIN")
    private String nomVaccin;
    @Size(max = 70)
    @Column(name = "METHODE_VACC")
    private String methodeVacc;

    public Vaccination() {
    }

    public Vaccination(BigDecimal idVacc) {
        this.idVacc = idVacc;
    }

    public BigDecimal getIdVacc() {
        return idVacc;
    }

    public void setIdVacc(BigDecimal idVacc) {
        this.idVacc = idVacc;
    }

    public String getDateVacc() {
        return dateVacc;
    }

    public void setDateVacc(String dateVacc) {
        this.dateVacc = dateVacc;
    }

    public String getInjectionVacc() {
        return injectionVacc;
    }

    public void setInjectionVacc(String injectionVacc) {
        this.injectionVacc = injectionVacc;
    }

    public String getLotVacc() {
        return lotVacc;
    }

    public void setLotVacc(String lotVacc) {
        this.lotVacc = lotVacc;
    }

    public String getRappelVacc() {
        return rappelVacc;
    }

    public void setRappelVacc(String rappelVacc) {
        this.rappelVacc = rappelVacc;
    }

    public String getCniPatient() {
        return cniPatient;
    }

    public void setCniPatient(String cniPatient) {
        this.cniPatient = cniPatient;
    }

    public String getMatMedVacc() {
        return matMedVacc;
    }

    public void setMatMedVacc(String matMedVacc) {
        this.matMedVacc = matMedVacc;
    }

    public String getResultatVacc() {
        return resultatVacc;
    }

    public void setResultatVacc(String resultatVacc) {
        this.resultatVacc = resultatVacc;
    }

    public String getNomVaccin() {
        return nomVaccin;
    }

    public void setNomVaccin(String nomVaccin) {
        this.nomVaccin = nomVaccin;
    }

    public String getMethodeVacc() {
        return methodeVacc;
    }

    public void setMethodeVacc(String methodeVacc) {
        this.methodeVacc = methodeVacc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacc != null ? idVacc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaccination)) {
            return false;
        }
        Vaccination other = (Vaccination) object;
        if ((this.idVacc == null && other.idVacc != null) || (this.idVacc != null && !this.idVacc.equals(other.idVacc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Vaccination[ idVacc=" + idVacc + " ]";
    }

    @Override
    public int compareTo(Vaccination vaccination) {
        String compareDate = ((Vaccination) vaccination).getDateVacc();
        
        return this.dateVacc.toLowerCase().compareTo(dateVacc.toLowerCase());
  }
    
}
