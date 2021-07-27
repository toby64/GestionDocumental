/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucho
 */
@Entity
@Table(name = "documentoscustodia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoscustodia.findAll", query = "SELECT d FROM Documentoscustodia d")
    , @NamedQuery(name = "Documentoscustodia.findByIdDocumentoCustodia", query = "SELECT d FROM Documentoscustodia d WHERE d.idDocumentoCustodia = :idDocumentoCustodia")
    , @NamedQuery(name = "Documentoscustodia.findByIdUsuario", query = "SELECT d FROM Documentoscustodia d WHERE d.idUsuario = :idUsuario")
    , @NamedQuery(name = "Documentoscustodia.findByRemitente", query = "SELECT d FROM Documentoscustodia d WHERE d.remitente = :remitente")
    , @NamedQuery(name = "Documentoscustodia.findByBodega", query = "SELECT d FROM Documentoscustodia d WHERE d.bodega = :bodega")
    , @NamedQuery(name = "Documentoscustodia.findByCodigoCustodia", query = "SELECT d FROM Documentoscustodia d WHERE d.codigoCustodia = :codigoCustodia")
    , @NamedQuery(name = "Documentoscustodia.findByFechaCustodia", query = "SELECT d FROM Documentoscustodia d WHERE d.fechaCustodia = :fechaCustodia")
    , @NamedQuery(name = "Documentoscustodia.findByCreatedAt", query = "SELECT d FROM Documentoscustodia d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "Documentoscustodia.findByUpdatedAt", query = "SELECT d FROM Documentoscustodia d WHERE d.updatedAt = :updatedAt")
    , @NamedQuery(name = "Documentoscustodia.findByDeletedAt", query = "SELECT d FROM Documentoscustodia d WHERE d.deletedAt = :deletedAt")})
public class Documentoscustodia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumentoCustodia")
    private Integer idDocumentoCustodia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Size(max = 45)
    @Column(name = "remitente")
    private String remitente;
    @Size(max = 45)
    @Column(name = "bodega")
    private String bodega;
    @Size(max = 250)
    @Column(name = "codigoCustodia")
    private String codigoCustodia;
    @Column(name = "fechaCustodia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCustodia;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @OneToMany(mappedBy = "documentoCustodiaid")
    private Collection<Documentos> documentosCollection;

    public Documentoscustodia() {
    }

    public Documentoscustodia(Integer idDocumentoCustodia) {
        this.idDocumentoCustodia = idDocumentoCustodia;
    }

    public Documentoscustodia(Integer idDocumentoCustodia, int idUsuario) {
        this.idDocumentoCustodia = idDocumentoCustodia;
        this.idUsuario = idUsuario;
    }

    public Integer getIdDocumentoCustodia() {
        return idDocumentoCustodia;
    }

    public void setIdDocumentoCustodia(Integer idDocumentoCustodia) {
        this.idDocumentoCustodia = idDocumentoCustodia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getCodigoCustodia() {
        return codigoCustodia;
    }

    public void setCodigoCustodia(String codigoCustodia) {
        this.codigoCustodia = codigoCustodia;
    }

    public Date getFechaCustodia() {
        return fechaCustodia;
    }

    public void setFechaCustodia(Date fechaCustodia) {
        this.fechaCustodia = fechaCustodia;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @XmlTransient
    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoCustodia != null ? idDocumentoCustodia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoscustodia)) {
            return false;
        }
        Documentoscustodia other = (Documentoscustodia) object;
        if ((this.idDocumentoCustodia == null && other.idDocumentoCustodia != null) || (this.idDocumentoCustodia != null && !this.idDocumentoCustodia.equals(other.idDocumentoCustodia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Documentoscustodia[ idDocumentoCustodia=" + idDocumentoCustodia + " ]";
    }
    
}
