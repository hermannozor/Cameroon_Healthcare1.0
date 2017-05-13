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
@Table(name = "FIL_DISCUSSION")
@NamedQueries({
    @NamedQuery(name = "FilDiscussion.findAll", query = "SELECT f FROM FilDiscussion f")})
public class FilDiscussion implements Serializable, Comparable<FilDiscussion> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_FIL_DISCUSSION")
    @SequenceGenerator(
            name = "SEQUENCE_FIL_DISCUSSION",
            sequenceName = "SEQUENCE_FIL_DISCUSSION",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_FIL_DISCUSSION")
    private BigDecimal idFilDiscussion;
    @Size(max = 300)
    @Column(name = "SUJET")
    private String sujet;
    @Size(max = 700)
    @Column(name = "CONTENTS")
    private String contents;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "ID_USER")
    private String idUser;
    @Size(max = 50)
    @Column(name = "CATEGORY_COMMENT")
    private String categoryComment;
    @Size(max = 50)
    @Column(name = "DATE_PUBLICATION")
    private String datePublication;
    @Size(max = 50)
    @Column(name = "ID_SUJET_FORUM")
    private String idSujetForum;

    public FilDiscussion() {
    }

    public FilDiscussion(BigDecimal idFilDiscussion) {
        this.idFilDiscussion = idFilDiscussion;
    }

    public BigDecimal getIdFilDiscussion() {
        return idFilDiscussion;
    }

    public void setIdFilDiscussion(BigDecimal idFilDiscussion) {
        this.idFilDiscussion = idFilDiscussion;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getCategoryComment() {
        return categoryComment;
    }

    public void setCategoryComment(String categoryComment) {
        this.categoryComment = categoryComment;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getIdSujetForum() {
        return idSujetForum;
    }

    public void setIdSujetForum(String idSujetForum) {
        this.idSujetForum = idSujetForum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFilDiscussion != null ? idFilDiscussion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilDiscussion)) {
            return false;
        }
        FilDiscussion other = (FilDiscussion) object;
        if ((this.idFilDiscussion == null && other.idFilDiscussion != null) || (this.idFilDiscussion != null && !this.idFilDiscussion.equals(other.idFilDiscussion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.FilDiscussion[ idFilDiscussion=" + idFilDiscussion + " ]";
    }

    @Override
    public int compareTo(FilDiscussion  fil_discussion) {
         String compareDate = ((FilDiscussion) fil_discussion).getDatePublication();  
         return this.datePublication.toLowerCase().compareTo(compareDate.toLowerCase());
 }

    
}
