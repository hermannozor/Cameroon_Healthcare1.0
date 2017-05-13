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
@Table(name = "EMAIL_HEALTHCARE")
@NamedQueries({
    @NamedQuery(name = "EmailHealthcare.findAll", query = "SELECT e FROM EmailHealthcare e")})
public class EmailHealthcare implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EMAIL_HEALTHCARE")
    @SequenceGenerator(
            name = "SEQUENCE_EMAIL_HEALTHCARE",
            sequenceName = "SEQUENCE_EMAIL_HEALTHCARE",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "ID_EMAIL")
    private BigDecimal idEmail;
    @Size(max = 250)
    @Column(name = "SUJET_MSG")
    private String sujetMsg;
    @Size(max = 250)
    @Column(name = "DEST_MSG")
    private String destMsg;
    @Size(max = 300)
    @Column(name = "CPY_MSG")
    private String cpyMsg;
    @Size(max = 100)
    @Column(name = "DATE_MSG")
    private String dateMsg;
    @Size(max = 250)
    @Column(name = "EXPED_MSG")
    private String expedMsg;
    @Size(max = 100)
    @Column(name = "MAT_EXP_MSG")
    private String matExpMsg;
    @Size(max = 800)
    @Column(name = "MESSAGE")
    private String message;

    public EmailHealthcare() {
    }

    public EmailHealthcare(BigDecimal idEmail) {
        this.idEmail = idEmail;
    }

    public BigDecimal getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(BigDecimal idEmail) {
        this.idEmail = idEmail;
    }

    public String getSujetMsg() {
        return sujetMsg;
    }

    public void setSujetMsg(String sujetMsg) {
        this.sujetMsg = sujetMsg;
    }

    public String getDestMsg() {
        return destMsg;
    }

    public void setDestMsg(String destMsg) {
        this.destMsg = destMsg;
    }

    public String getCpyMsg() {
        return cpyMsg;
    }

    public void setCpyMsg(String cpyMsg) {
        this.cpyMsg = cpyMsg;
    }

    public String getDateMsg() {
        return dateMsg;
    }

    public void setDateMsg(String dateMsg) {
        this.dateMsg = dateMsg;
    }

    public String getExpedMsg() {
        return expedMsg;
    }

    public void setExpedMsg(String expedMsg) {
        this.expedMsg = expedMsg;
    }

    public String getMatExpMsg() {
        return matExpMsg;
    }

    public void setMatExpMsg(String matExpMsg) {
        this.matExpMsg = matExpMsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmail != null ? idEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailHealthcare)) {
            return false;
        }
        EmailHealthcare other = (EmailHealthcare) object;
        if ((this.idEmail == null && other.idEmail != null) || (this.idEmail != null && !this.idEmail.equals(other.idEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.camtel.healthcare.entities.EmailHealthcare[ idEmail=" + idEmail + " ]";
    }
    
}
