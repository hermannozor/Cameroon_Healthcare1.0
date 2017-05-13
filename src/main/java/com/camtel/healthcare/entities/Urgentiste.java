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
@Table(name = "URGENTISTE")
@NamedQueries({
    @NamedQuery(name = "Urgentiste.findAll", query = "SELECT u FROM Urgentiste u")})
public class Urgentiste implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_URGENTISTE")
    @SequenceGenerator(
            name = "SEQUENCE_URGENTISTE",
            sequenceName = "SEQUENCE_URGENTISTE",
            initialValue = 100000,
            allocationSize = 1
    )
    @Column(name = "ID_URG")
    private BigDecimal idUrg;
    @Size(max = 20)
    @Column(name = "NOM_URG")
    private String nomUrg;
    @Size(max = 20)
    @Column(name = "PRENOM_URG")
    private String prenomUrg;
    @Size(max = 1)
    @Column(name = "GENRE_URG")
    private String genreUrg;
    @Size(max = 20)
    @Column(name = "CATEGORIE_URG")
    private String categorieUrg;
    @Size(max = 20)
    @Column(name = "CNI_URG")
    private String cniUrg;
    @Size(max = 20)
    @Column(name = "TELEPHONE_URG")
    private String telephoneUrg;
    @Size(max = 20)
    @Column(name = "ADRESSE_URG")
    private String adresseUrg;
    @Size(max = 20)
    @Column(name = "MP_URGENTISTE")
    private String mpUrgentiste;
    @Size(max = 50)
    @Column(name = "MATRICULE_URG")
    private String matriculeUrg;

    public Urgentiste() {
    }

    public Urgentiste(BigDecimal idUrg) {
        this.idUrg = idUrg;
    }

    public BigDecimal getIdUrg() {
        return idUrg;
    }

    public void setIdUrg(BigDecimal idUrg) {
        this.idUrg = idUrg;
    }

    public String getNomUrg() {
        return nomUrg;
    }

    public void setNomUrg(String nomUrg) {
        this.nomUrg = nomUrg;
    }

    public String getPrenomUrg() {
        return prenomUrg;
    }

    public void setPrenomUrg(String prenomUrg) {
        this.prenomUrg = prenomUrg;
    }

    public String getGenreUrg() {
        return genreUrg;
    }

    public void setGenreUrg(String genreUrg) {
        this.genreUrg = genreUrg;
    }

    public String getCategorieUrg() {
        return categorieUrg;
    }

    public void setCategorieUrg(String categorieUrg) {
        this.categorieUrg = categorieUrg;
    }

    public String getCniUrg() {
        return cniUrg;
    }

    public void setCniUrg(String cniUrg) {
        this.cniUrg = cniUrg;
    }

    public String getTelephoneUrg() {
        return telephoneUrg;
    }

    public void setTelephoneUrg(String telephoneUrg) {
        this.telephoneUrg = telephoneUrg;
    }

    public String getAdresseUrg() {
        return adresseUrg;
    }

    public void setAdresseUrg(String adresseUrg) {
        this.adresseUrg = adresseUrg;
    }

    public String getMpUrgentiste() {
        return mpUrgentiste;
    }

    public void setMpUrgentiste(String mpUrgentiste) {
        this.mpUrgentiste = mpUrgentiste;
    }

    public String getMatriculeUrg() {
        return matriculeUrg;
    }

    public void setMatriculeUrg(String matriculeUrg) {
        this.matriculeUrg = matriculeUrg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUrg != null ? idUrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urgentiste)) {
            return false;
        }
        Urgentiste other = (Urgentiste) object;
        if ((this.idUrg == null && other.idUrg != null) || (this.idUrg != null && !this.idUrg.equals(other.idUrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Urgentiste[ idUrg=" + idUrg + " ]";
    }
    
}
