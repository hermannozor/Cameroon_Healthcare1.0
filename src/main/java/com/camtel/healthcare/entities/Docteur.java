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
@Table(name = "DOCTEUR")
@NamedQueries({
    @NamedQuery(name = "Docteur.findAll", query = "SELECT d FROM Docteur d")})
public class Docteur implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_DOCTEUR")
    @SequenceGenerator(
            name = "SEQUENCE_DOCTEUR",
            sequenceName = "SEQUENCE_DOCTEUR",
            initialValue = 100000,
            allocationSize = 1
    )
    @Column(name = "ID_DOCTEUR")
    private BigDecimal idDocteur;
    @Size(max = 30)
    @Column(name = "NOM_DOCTEUR")
    private String nomDocteur;
    @Size(max = 30)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 1)
    @Column(name = "GENRE_DOCTEUR")
    private String genreDocteur;
    @Size(max = 30)
    @Column(name = "TELEPHONE_DOCTEUR")
    private String telephoneDocteur;
    @Size(max = 20)
    @Column(name = "TELPHONE_PROFESSIONEL_DOCTEUR")
    private String telphoneProfessionelDocteur;
    @Size(max = 30)
    @Column(name = "ADRESSE_PRO_DOCTEUR")
    private String adresseProDocteur;
    @Size(max = 20)
    @Column(name = "SPECIALITE_DOCTEUR")
    private String specialiteDocteur;
    @Size(max = 20)
    @Column(name = "STRUCTURE_DOCTEUR")
    private String structureDocteur;
    @Size(max = 20)
    @Column(name = "CNI_DOCTEUR")
    private String cniDocteur;
    @Size(max = 20)
    @Column(name = "MATRICULE_DOCTEUR")
    private String matriculeDocteur;
    @Size(max = 20)
    @Column(name = "MP_DOCTEUR")
    private String mpDocteur;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "EMAIL")
    private String email;

    public Docteur() {
    }

    public Docteur(BigDecimal idDocteur) {
        this.idDocteur = idDocteur;
    }

    public BigDecimal getIdDocteur() {
        return idDocteur;
    }

    public void setIdDocteur(BigDecimal idDocteur) {
        this.idDocteur = idDocteur;
    }

    public String getNomDocteur() {
        return nomDocteur;
    }

    public void setNomDocteur(String nomDocteur) {
        this.nomDocteur = nomDocteur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenreDocteur() {
        return genreDocteur;
    }

    public void setGenreDocteur(String genreDocteur) {
        this.genreDocteur = genreDocteur;
    }

    public String getTelephoneDocteur() {
        return telephoneDocteur;
    }

    public void setTelephoneDocteur(String telephoneDocteur) {
        this.telephoneDocteur = telephoneDocteur;
    }

    public String getTelphoneProfessionelDocteur() {
        return telphoneProfessionelDocteur;
    }

    public void setTelphoneProfessionelDocteur(String telphoneProfessionelDocteur) {
        this.telphoneProfessionelDocteur = telphoneProfessionelDocteur;
    }

    public String getAdresseProDocteur() {
        return adresseProDocteur;
    }

    public void setAdresseProDocteur(String adresseProDocteur) {
        this.adresseProDocteur = adresseProDocteur;
    }

    public String getSpecialiteDocteur() {
        return specialiteDocteur;
    }

    public void setSpecialiteDocteur(String specialiteDocteur) {
        this.specialiteDocteur = specialiteDocteur;
    }

    public String getStructureDocteur() {
        return structureDocteur;
    }

    public void setStructureDocteur(String structureDocteur) {
        this.structureDocteur = structureDocteur;
    }

    public String getCniDocteur() {
        return cniDocteur;
    }

    public void setCniDocteur(String cniDocteur) {
        this.cniDocteur = cniDocteur;
    }

    public String getMatriculeDocteur() {
        return matriculeDocteur;
    }

    public void setMatriculeDocteur(String matriculeDocteur) {
        this.matriculeDocteur = matriculeDocteur;
    }

    public String getMpDocteur() {
        return mpDocteur;
    }

    public void setMpDocteur(String mpDocteur) {
        this.mpDocteur = mpDocteur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocteur != null ? idDocteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docteur)) {
            return false;
        }
        Docteur other = (Docteur) object;
        if ((this.idDocteur == null && other.idDocteur != null) || (this.idDocteur != null && !this.idDocteur.equals(other.idDocteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Docteur[ idDocteur=" + idDocteur + " ]";
    }
    
}
