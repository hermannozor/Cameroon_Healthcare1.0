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
@Table(name = "FORUM_HEALTHCARE")
@NamedQueries({
    @NamedQuery(name = "ForumHealthcare.findAll", query = "SELECT f FROM ForumHealthcare f")})
public class ForumHealthcare implements Serializable,Comparable<ForumHealthcare> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_FORUM_HEALTHCARE")
    @SequenceGenerator(
            name = "SEQUENCE_FORUM_HEALTHCARE",
            sequenceName = "SEQUENCE_FORUM_HEALTHCARE",
            initialValue = 100,
            allocationSize = 1
    )

    @Column(name = "ID_FORUM")
    private BigDecimal idForum;
    @Size(max = 20)
    @Column(name = "ID_CREATOR")
    private String idCreator;
    @Size(max = 500)
    @Column(name = "SUJET")
    private String sujet;
    @Size(max = 100)
    @Column(name = "CATEGORIE_SUJET")
    private String categorieSujet;
    @Size(max = 300)
    @Column(name = "DESCRIPTION_SUJET")
    private String descriptionSujet;
    @Size(max = 20)
    @Column(name = "DATE_CREATION_SUJET")
    private String dateCreationSujet;

    public ForumHealthcare() {
    }

    public ForumHealthcare(BigDecimal idForum) {
        this.idForum = idForum;
    }

    public BigDecimal getIdForum() {
        return idForum;
    }

    public void setIdForum(BigDecimal idForum) {
        this.idForum = idForum;
    }

    public String getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getCategorieSujet() {
        return categorieSujet;
    }

    public void setCategorieSujet(String categorieSujet) {
        this.categorieSujet = categorieSujet;
    }

    public String getDescriptionSujet() {
        return descriptionSujet;
    }

    public void setDescriptionSujet(String descriptionSujet) {
        this.descriptionSujet = descriptionSujet;
    }

    public String getDateCreationSujet() {
        return dateCreationSujet;
    }

    public void setDateCreationSujet(String dateCreationSujet) {
        this.dateCreationSujet = dateCreationSujet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForum != null ? idForum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForumHealthcare)) {
            return false;
        }
        ForumHealthcare other = (ForumHealthcare) object;
        if ((this.idForum == null && other.idForum != null) || (this.idForum != null && !this.idForum.equals(other.idForum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.ForumHealthcare[ idForum=" + idForum + " ]";
    }

    @Override
    public int compareTo(ForumHealthcare forumHealthCare) {
        String compareDate = ((ForumHealthcare) forumHealthCare).getDateCreationSujet();
        
        return this.dateCreationSujet.toLowerCase().compareTo(compareDate.toLowerCase());
    }
    
}
