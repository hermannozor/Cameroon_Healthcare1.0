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
@Table(name = "PLANIFICATION")
@NamedQueries({
    @NamedQuery(name = "Planification.findAll", query = "SELECT p FROM Planification p")})
public class Planification implements Serializable, Comparable<Planification> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PLANIFICATION")
    @SequenceGenerator(
            name = "SEQUENCE_PLANIFICATION",
            sequenceName = "SEQUENCE_PLANIFICATION",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_PLAN")
    private BigDecimal idPlan;
    @Size(max = 20)
    @Column(name = "PREVU_LE")
    private String prevuLe;
    @Size(max = 100)
    @Column(name = "OBJET_PLAN")
    private String objetPlan;
    @Size(max = 20)
    @Column(name = "PERIODICITE_PLAN")
    private String periodicitePlan;
    @Size(max = 200)
    @Column(name = "COMMENTAIRE_PLAN")
    private String commentairePlan;
    @Size(max = 20)
    @Column(name = "MAT_MED_PLAN")
    private String matMedPlan;
    @Size(max = 20)
    @Column(name = "CNI_PAT_PLAN")
    private String cniPatPlan;

    public Planification() {
    }

    public Planification(BigDecimal idPlan) {
        this.idPlan = idPlan;
    }

    public BigDecimal getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(BigDecimal idPlan) {
        this.idPlan = idPlan;
    }

    public String getPrevuLe() {
        return prevuLe;
    }

    public void setPrevuLe(String prevuLe) {
        this.prevuLe = prevuLe;
    }

    public String getObjetPlan() {
        return objetPlan;
    }

    public void setObjetPlan(String objetPlan) {
        this.objetPlan = objetPlan;
    }

    public String getPeriodicitePlan() {
        return periodicitePlan;
    }

    public void setPeriodicitePlan(String periodicitePlan) {
        this.periodicitePlan = periodicitePlan;
    }

    public String getCommentairePlan() {
        return commentairePlan;
    }

    public void setCommentairePlan(String commentairePlan) {
        this.commentairePlan = commentairePlan;
    }

    public String getMatMedPlan() {
        return matMedPlan;
    }

    public void setMatMedPlan(String matMedPlan) {
        this.matMedPlan = matMedPlan;
    }

    public String getCniPatPlan() {
        return cniPatPlan;
    }

    public void setCniPatPlan(String cniPatPlan) {
        this.cniPatPlan = cniPatPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planification)) {
            return false;
        }
        Planification other = (Planification) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Planification[ idPlan=" + idPlan + " ]";
    }

    @Override
    public int compareTo(Planification planification) {
        String compareObjet = ((Planification) planification).getObjetPlan();
        
        return this.objetPlan.toLowerCase().compareTo(compareObjet.toLowerCase());
  }
    
}
