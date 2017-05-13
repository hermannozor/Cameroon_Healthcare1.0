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
@Table(name = "CONTACT_SERVICE")
@NamedQueries({
    @NamedQuery(name = "ContactService.findAll", query = "SELECT c FROM ContactService c")})
public class ContactService implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CONTACT_HEALTH ")
    @SequenceGenerator(
            name = "SEQUENCE_CONTACT_HEALTH ",
            sequenceName = "SEQUENCE_CONTACT_HEALTH ",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_CONTACT")
    private BigDecimal idContact;
    @Size(max = 60)
    @Column(name = "NOM_CONTACT")
    private String nomContact;
    @Size(max = 60)
    @Column(name = "EMAIL_CONTACT")
    private String emailContact;
    @Size(max = 250)
    @Column(name = "SUJET_CONTACT")
    private String sujetContact;
    @Size(max = 400)
    @Column(name = "CONTENT_MSG")
    private String contentMsg;

    public ContactService() {
    }

    public ContactService(BigDecimal idContact) {
        this.idContact = idContact;
    }

    public BigDecimal getIdContact() {
        return idContact;
    }

    public void setIdContact(BigDecimal idContact) {
        this.idContact = idContact;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getSujetContact() {
        return sujetContact;
    }

    public void setSujetContact(String sujetContact) {
        this.sujetContact = sujetContact;
    }

    public String getContentMsg() {
        return contentMsg;
    }

    public void setContentMsg(String contentMsg) {
        this.contentMsg = contentMsg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContact != null ? idContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactService)) {
            return false;
        }
        ContactService other = (ContactService) object;
        if ((this.idContact == null && other.idContact != null) || (this.idContact != null && !this.idContact.equals(other.idContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.ContactService[ idContact=" + idContact + " ]";
    }
    
}
