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
@Table(name = "COMMENTAIRE")
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c")})
public class Commentaire implements Serializable,Comparable<Commentaire> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_COMMENTAIRE")
    @SequenceGenerator(
            name = "SEQUENCE_COMMENTAIRE",
            sequenceName = "SEQUENCE_COMMENTAIRE",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_COMMENT")
    private BigDecimal idComment;
    @Size(max = 1000)
    @Column(name = "CONTENTS")
    private String contents;
    @Size(max = 20)
    @Column(name = "ID_USER")
    private String idUser;
    @Size(max = 50)
    @Column(name = "DATE_COMMENT")
    private String dateComment;
    @Size(max = 300)
    @Column(name = "SUJET_COMMENT")
    private String sujetComment;

    public Commentaire() {
    }

    public Commentaire(BigDecimal idComment) {
        this.idComment = idComment;
    }

    public BigDecimal getIdComment() {
        return idComment;
    }

    public void setIdComment(BigDecimal idComment) {
        this.idComment = idComment;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }

    public String getSujetComment() {
        return sujetComment;
    }

    public void setSujetComment(String sujetComment) {
        this.sujetComment = sujetComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComment != null ? idComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.idComment == null && other.idComment != null) || (this.idComment != null && !this.idComment.equals(other.idComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.Commentaire[ idComment=" + idComment + " ]";
    }

    @Override
    public int compareTo(Commentaire subject_comment) {
      String compareDate = ((Commentaire) subject_comment).getDateComment();  
         return this.dateComment.toLowerCase().compareTo(compareDate.toLowerCase());}
    
}
