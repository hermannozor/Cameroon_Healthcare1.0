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
@Table(name = "COURRIER")
@NamedQueries({
    @NamedQuery(name = "Courrier.findAll", query = "SELECT c FROM Courrier c")})
public class Courrier implements Serializable, Comparable<Courrier> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_COURRIER")
    @SequenceGenerator(
            name = "SEQUENCE_COURRIER",
            sequenceName = "SEQUENCE_COURRIER",
            initialValue = 100,
            allocationSize = 1
    )
  
    @Column(name = "ID_COURRIER")
    private BigDecimal idCourrier;
    @Size(max = 20)
    @Column(name = "DATE_COURRIER")
    private String dateCourrier;
    @Size(max = 20)
    @Column(name = "CATEGO_COURRIER")
    private String categoCourrier;
    @Size(max = 20)
    @Column(name = "MAT_MED_COUR")
    private String matMedCour;
    @Size(max = 20)
    @Column(name = "MAT_PAT_COUR")
    private String matPatCour;
    @Size(max = 800)
    @Column(name = "CONTENU_COUR")
    private String contenuCour;
    @Size(max = 100)
    @Column(name = "DESTIN_COUR")
    private String destinCour;

    public Courrier() {
    }

    public Courrier(BigDecimal idCourrier) {
        this.idCourrier = idCourrier;
    }

    public BigDecimal getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(BigDecimal idCourrier) {
        this.idCourrier = idCourrier;
    }

    public String getDateCourrier() {
        return dateCourrier;
    }

    public void setDateCourrier(String dateCourrier) {
        this.dateCourrier = dateCourrier;
    }

    public String getCategoCourrier() {
        return categoCourrier;
    }

    public void setCategoCourrier(String categoCourrier) {
        this.categoCourrier = categoCourrier;
    }

    public String getMatMedCour() {
        return matMedCour;
    }

    public void setMatMedCour(String matMedCour) {
        this.matMedCour = matMedCour;
    }

    public String getMatPatCour() {
        return matPatCour;
    }

    public void setMatPatCour(String matPatCour) {
        this.matPatCour = matPatCour;
    }

    public String getContenuCour() {
        return contenuCour;
    }

    public void setContenuCour(String contenuCour) {
        this.contenuCour = contenuCour;
    }

    public String getDestinCour() {
        return destinCour;
    }

    public void setDestinCour(String destinCour) {
        this.destinCour = destinCour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourrier != null ? idCourrier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courrier)) {
            return false;
        }
        Courrier other = (Courrier) object;
        if ((this.idCourrier == null && other.idCourrier != null) || (this.idCourrier != null && !this.idCourrier.equals(other.idCourrier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Courrier[ idCourrier=" + idCourrier + " ]";
    }

    @Override
    public int compareTo(Courrier courrier) {
      String compareDate = ((Courrier) courrier).getDateCourrier();
    return this.dateCourrier.toLowerCase().compareTo(compareDate.toLowerCase());
    }
    
}
