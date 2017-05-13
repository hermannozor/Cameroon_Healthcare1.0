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
@Table(name = "ORDONNANCE")
@NamedQueries({
    @NamedQuery(name = "Ordonnance.findAll", query = "SELECT o FROM Ordonnance o")})
public class Ordonnance implements Serializable,Comparable<Ordonnance> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ORDONNANCE")
    @SequenceGenerator(
            name = "SEQUENCE_ORDONNANCE",
            sequenceName = "SEQUENCE_ORDONNANCE",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_ORDO")
    private BigDecimal idOrdo;
    @Size(max = 20)
    @Column(name = "DATE_ORDO")
    private String dateOrdo;
    @Size(max = 20)
    @Column(name = "CATEGORIE_ORDO")
    private String categorieOrdo;
    @Size(max = 20)
    @Column(name = "MATRICULE_PAT")
    private String matriculePat;
    @Size(max = 20)
    @Column(name = "MATRICULE_MED")
    private String matriculeMed;
    @Size(max = 800)
    @Column(name = "PRESCRIPTION_ORDO")
    private String prescriptionOrdo;

    public Ordonnance() {
    }

    public Ordonnance(BigDecimal idOrdo) {
        this.idOrdo = idOrdo;
    }

    public BigDecimal getIdOrdo() {
        return idOrdo;
    }

    public void setIdOrdo(BigDecimal idOrdo) {
        this.idOrdo = idOrdo;
    }

    public String getDateOrdo() {
        return dateOrdo;
    }

    public void setDateOrdo(String dateOrdo) {
        this.dateOrdo = dateOrdo;
    }

    public String getCategorieOrdo() {
        return categorieOrdo;
    }

    public void setCategorieOrdo(String categorieOrdo) {
        this.categorieOrdo = categorieOrdo;
    }

    public String getMatriculePat() {
        return matriculePat;
    }

    public void setMatriculePat(String matriculePat) {
        this.matriculePat = matriculePat;
    }

    public String getMatriculeMed() {
        return matriculeMed;
    }

    public void setMatriculeMed(String matriculeMed) {
        this.matriculeMed = matriculeMed;
    }

    public String getPrescriptionOrdo() {
        return prescriptionOrdo;
    }

    public void setPrescriptionOrdo(String prescriptionOrdo) {
        this.prescriptionOrdo = prescriptionOrdo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdo != null ? idOrdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordonnance)) {
            return false;
        }
        Ordonnance other = (Ordonnance) object;
        if ((this.idOrdo == null && other.idOrdo != null) || (this.idOrdo != null && !this.idOrdo.equals(other.idOrdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Ordonnance[ idOrdo=" + idOrdo + " ]";
    }

    @Override
    public int compareTo(Ordonnance ordonnance) {
       String compareDate = ((Ordonnance) ordonnance).getDateOrdo();
        
        return this.dateOrdo.toLowerCase().compareTo(compareDate.toLowerCase()); 
    }
    
}
