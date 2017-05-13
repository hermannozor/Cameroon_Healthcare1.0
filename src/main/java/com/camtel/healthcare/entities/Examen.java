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
@Table(name = "EXAMEN")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")})
public class Examen implements Serializable, Comparable<Examen> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EXAMEN")
    @SequenceGenerator(
            name = "SEQUENCE_EXAMEN",
            sequenceName = "SEQUENCE_EXAMEN",
            initialValue = 100,
            allocationSize = 1
    )  
    @Column(name = "ID_EXAM")
    private BigDecimal idExam;
    @Size(max = 20)
    @Column(name = "DATE_EXAM")
    private String dateExam;
    @Size(max = 20)
    @Column(name = "MAT_MED_EXAM")
    private String matMedExam;
    @Size(max = 20)
    @Column(name = "CNI_PAT_EXAM")
    private String cniPatExam;
    @Size(max = 20)
    @Column(name = "NOM_PAT_EXAM")
    private String nomPatExam;
    @Size(max = 600)
    @Column(name = "CONTENU_EXAM")
    private String contenuExam;

    public Examen() {
    }

    public Examen(BigDecimal idExam) {
        this.idExam = idExam;
    }

    public BigDecimal getIdExam() {
        return idExam;
    }

    public void setIdExam(BigDecimal idExam) {
        this.idExam = idExam;
    }

    public String getDateExam() {
        return dateExam;
    }

    public void setDateExam(String dateExam) {
        this.dateExam = dateExam;
    }

    public String getMatMedExam() {
        return matMedExam;
    }

    public void setMatMedExam(String matMedExam) {
        this.matMedExam = matMedExam;
    }

    public String getCniPatExam() {
        return cniPatExam;
    }

    public void setCniPatExam(String cniPatExam) {
        this.cniPatExam = cniPatExam;
    }

    public String getNomPatExam() {
        return nomPatExam;
    }

    public void setNomPatExam(String nomPatExam) {
        this.nomPatExam = nomPatExam;
    }

    public String getContenuExam() {
        return contenuExam;
    }

    public void setContenuExam(String contenuExam) {
        this.contenuExam = contenuExam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExam != null ? idExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Examen[ idExam=" + idExam + " ]";
    }

    @Override
    public int compareTo(Examen examen) {
        String compareDate= ((Examen) examen).getDateExam();
        
        return this.dateExam.toLowerCase().compareTo(compareDate.toLowerCase());
  }
    
}
