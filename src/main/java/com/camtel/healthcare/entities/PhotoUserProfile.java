/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author herma
 */
@Entity
@Table(name = "PHOTO_USER_PROFILE")
@NamedQueries({
    @NamedQuery(name = "PhotoUserProfile.findAll", query = "SELECT p FROM PhotoUserProfile p")})
public class PhotoUserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PHOTO_USER_PROFILE")
    private BigDecimal idPhotoUserProfile;
    @Lob
    @Column(name = "PHOTO")
    private Serializable photo;
    @Size(max = 50)
    @Column(name = "LASTONE")
    private String lastone;
    @Column(name = "ID_USER")
    private BigInteger idUser;

    public PhotoUserProfile() {
    }

    public PhotoUserProfile(BigDecimal idPhotoUserProfile) {
        this.idPhotoUserProfile = idPhotoUserProfile;
    }

    public BigDecimal getIdPhotoUserProfile() {
        return idPhotoUserProfile;
    }

    public void setIdPhotoUserProfile(BigDecimal idPhotoUserProfile) {
        this.idPhotoUserProfile = idPhotoUserProfile;
    }

    public Serializable getPhoto() {
        return photo;
    }

    public void setPhoto(Serializable photo) {
        this.photo = photo;
    }

    public String getLastone() {
        return lastone;
    }

    public void setLastone(String lastone) {
        this.lastone = lastone;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhotoUserProfile != null ? idPhotoUserProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhotoUserProfile)) {
            return false;
        }
        PhotoUserProfile other = (PhotoUserProfile) object;
        if ((this.idPhotoUserProfile == null && other.idPhotoUserProfile != null) || (this.idPhotoUserProfile != null && !this.idPhotoUserProfile.equals(other.idPhotoUserProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.PhotoUserProfile[ idPhotoUserProfile=" + idPhotoUserProfile + " ]";
    }
    
}
