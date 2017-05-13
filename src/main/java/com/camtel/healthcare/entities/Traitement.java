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
@Table(name = "TRAITEMENT")
@NamedQueries({
    @NamedQuery(name = "Traitement.findAll", query = "SELECT t FROM Traitement t")})
public class Traitement implements Serializable, Comparable<Traitement> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TRAITEMENT")
    @SequenceGenerator(
            name = "SEQUENCE_TRAITEMENT",
            sequenceName = "SEQUENCE_TRAITEMENT",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_TRAIT")
    private BigDecimal idTrait;
    @Size(max = 20)
    @Column(name = "CNI_PAT_TRAITE")
    private String cniPatTraite;
    @Size(max = 20)
    @Column(name = "MAT_MED_TRAITE")
    private String matMedTraite;
    @Size(max = 350)
    @Column(name = "NOM_COMPRIME")
    private String nomComprime;
    @Size(max = 350)
    @Column(name = "POSOLOGIE")
    private String posologie;
    @Size(max = 30)
    @Column(name = "DATE_DEBUT_TRAIT")
    private String dateDebutTrait;

    public Traitement() {
    }

    public Traitement(BigDecimal idTrait) {
        this.idTrait = idTrait;
    }

    public BigDecimal getIdTrait() {
        return idTrait;
    }

    public void setIdTrait(BigDecimal idTrait) {
        this.idTrait = idTrait;
    }

    public String getCniPatTraite() {
        return cniPatTraite;
    }

    public void setCniPatTraite(String cniPatTraite) {
        this.cniPatTraite = cniPatTraite;
    }

    public String getMatMedTraite() {
        return matMedTraite;
    }

    public void setMatMedTraite(String matMedTraite) {
        this.matMedTraite = matMedTraite;
    }

    public String getNomComprime() {
        return nomComprime;
    }

    public void setNomComprime(String nomComprime) {
        this.nomComprime = nomComprime;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public String getDateDebutTrait() {
        return dateDebutTrait;
    }

    public void setDateDebutTrait(String dateDebutTrait) {
        this.dateDebutTrait = dateDebutTrait;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrait != null ? idTrait.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traitement)) {
            return false;
        }
        Traitement other = (Traitement) object;
        if ((this.idTrait == null && other.idTrait != null) || (this.idTrait != null && !this.idTrait.equals(other.idTrait))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Traitement[ idTrait=" + idTrait + " ]";
    }

    @Override
    public int compareTo(Traitement traitement) {
       String compareDateTraitement = ((Traitement) traitement).getDateDebutTrait();
        
        return this.dateDebutTrait.toLowerCase().compareTo(compareDateTraitement.toLowerCase());
    }
    
}
