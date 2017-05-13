/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author herma
 */
@Entity
@Table(name = "POMPIER")
@NamedQueries({
    @NamedQuery(name = "Pompier.findAll", query = "SELECT p FROM Pompier p")})
public class Pompier implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_POMPIER")
    @SequenceGenerator(
            name = "SEQUENCE_POMPIER",
            sequenceName = "SEQUENCE_POMPIER",
            initialValue = 100000,
            allocationSize = 1
    )
    @Column(name = "ID_POMPIER")
    private BigDecimal idPompier;
    @Size(max = 20)
    @Column(name = "NOM_POMPIER")
    private String nomPompier;
    @Size(max = 20)
    @Column(name = "PRENOM_POMPIER")
    private String prenomPompier;
    @Size(max = 1)
    @Column(name = "GENRE_POMPIER")
    private String genrePompier;
    @Size(max = 20)
    @Column(name = "ADRESSE_POMPIER")
    private String adressePompier;
    @Size(max = 20)
    @Column(name = "TELEPHONE_POMPIER")
    private String telephonePompier;
    @Size(max = 20)
    @Column(name = "CATEGORIE_POMPIER")
    private String categoriePompier;
    @Size(max = 20)
    @Column(name = "MATRICULE_POMPIER")
    private String matriculePompier;
    @Size(max = 20)
    @Column(name = "CNI_POMPIER")
    private String cniPompier;
    @Size(max = 20)
    @Column(name = "MP_POMPIER")
    private String mpPompier;

    public Pompier() {
    }

    public Pompier(BigDecimal idPompier) {
        this.idPompier = idPompier;
    }

    public BigDecimal getIdPompier() {
        return idPompier;
    }

    public void setIdPompier(BigDecimal idPompier) {
        this.idPompier = idPompier;
    }

    public String getNomPompier() {
        return nomPompier;
    }

    public void setNomPompier(String nomPompier) {
        this.nomPompier = nomPompier;
    }

    public String getPrenomPompier() {
        return prenomPompier;
    }

    public void setPrenomPompier(String prenomPompier) {
        this.prenomPompier = prenomPompier;
    }

    public String getGenrePompier() {
        return genrePompier;
    }

    public void setGenrePompier(String genrePompier) {
        this.genrePompier = genrePompier;
    }

    public String getAdressePompier() {
        return adressePompier;
    }

    public void setAdressePompier(String adressePompier) {
        this.adressePompier = adressePompier;
    }

    public String getTelephonePompier() {
        return telephonePompier;
    }

    public void setTelephonePompier(String telephonePompier) {
        this.telephonePompier = telephonePompier;
    }

    public String getCategoriePompier() {
        return categoriePompier;
    }

    public void setCategoriePompier(String categoriePompier) {
        this.categoriePompier = categoriePompier;
    }

    public String getMatriculePompier() {
        return matriculePompier;
    }

    public void setMatriculePompier(String matriculePompier) {
        this.matriculePompier = matriculePompier;
    }

    public String getCniPompier() {
        return cniPompier;
    }

    public void setCniPompier(String cniPompier) {
        this.cniPompier = cniPompier;
    }

    public String getMpPompier() {
        return mpPompier;
    }

    public void setMpPompier(String mpPompier) {
        this.mpPompier = mpPompier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPompier != null ? idPompier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pompier)) {
            return false;
        }
        Pompier other = (Pompier) object;
        if ((this.idPompier == null && other.idPompier != null) || (this.idPompier != null && !this.idPompier.equals(other.idPompier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Pompier[ idPompier=" + idPompier + " ]";
    }
    
}
