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
@Table(name = "ANTECEDENT")
@NamedQueries({
    @NamedQuery(name = "Antecedent.findAll", query = "SELECT a FROM Antecedent a")})
public class Antecedent implements Serializable, Comparable<Antecedent> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ANTECEDENT")
    @SequenceGenerator(
            name = "SEQUENCE_ANTECEDENT",
            sequenceName = "SEQUENCE_ANTECEDENT",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_ANTE")
    private BigDecimal idAnte;
    @Size(max = 50)
    @Column(name = "ANTE_MED_RIS")
    private String anteMedRis;
    @Size(max = 50)
    @Column(name = "ANTE_CHIR_OBSTE")
    private String anteChirObste;
    @Size(max = 50)
    @Column(name = "ANTE_FAML")
    private String anteFaml;
    @Size(max = 50)
    @Column(name = "ALLERG_INTOLE")
    private String allergIntole;
    @Size(max = 20)
    @Column(name = "MAT_PATIENT")
    private String matPatient;
    @Size(max = 30)
    @Column(name = "NOM_PATIENT")
    private String nomPatient;

    public Antecedent() {
    }

    public Antecedent(BigDecimal idAnte) {
        this.idAnte = idAnte;
    }

    public BigDecimal getIdAnte() {
        return idAnte;
    }

    public void setIdAnte(BigDecimal idAnte) {
        this.idAnte = idAnte;
    }

    public String getAnteMedRis() {
        return anteMedRis;
    }

    public void setAnteMedRis(String anteMedRis) {
        this.anteMedRis = anteMedRis;
    }

    public String getAnteChirObste() {
        return anteChirObste;
    }

    public void setAnteChirObste(String anteChirObste) {
        this.anteChirObste = anteChirObste;
    }

    public String getAnteFaml() {
        return anteFaml;
    }

    public void setAnteFaml(String anteFaml) {
        this.anteFaml = anteFaml;
    }

    public String getAllergIntole() {
        return allergIntole;
    }

    public void setAllergIntole(String allergIntole) {
        this.allergIntole = allergIntole;
    }

    public String getMatPatient() {
        return matPatient;
    }

    public void setMatPatient(String matPatient) {
        this.matPatient = matPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnte != null ? idAnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedent)) {
            return false;
        }
        Antecedent other = (Antecedent) object;
        if ((this.idAnte == null && other.idAnte != null) || (this.idAnte != null && !this.idAnte.equals(other.idAnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Antecedent[ idAnte=" + idAnte + " ]";
    }

    @Override
    public int compareTo(Antecedent antecedent) {
              String compareNom = ((Antecedent) antecedent).getAnteFaml();
        
        return this.anteFaml.toLowerCase().compareTo(compareNom.toLowerCase());
        }
    
}
