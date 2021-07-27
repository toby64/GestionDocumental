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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucho
 */
@Entity
@Table(name = "documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d")
    , @NamedQuery(name = "Documentos.findByIdDocumento", query = "SELECT d FROM Documentos d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documentos.findByRadicado", query = "SELECT d FROM Documentos d WHERE d.radicado = :radicado")
    , @NamedQuery(name = "Documentos.findByNombreContribuyente", query = "SELECT d FROM Documentos d WHERE d.nombreContribuyente = :nombreContribuyente")
    , @NamedQuery(name = "Documentos.findByIdentificacionContribuyente", query = "SELECT d FROM Documentos d WHERE d.identificacionContribuyente = :identificacionContribuyente")
    , @NamedQuery(name = "Documentos.findByTipoRenta", query = "SELECT d FROM Documentos d WHERE d.tipoRenta = :tipoRenta")
    , @NamedQuery(name = "Documentos.findByAbogado", query = "SELECT d FROM Documentos d WHERE d.abogado = :abogado")
    , @NamedQuery(name = "Documentos.findByCreatedAt", query = "SELECT d FROM Documentos d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "Documentos.findByUpdatedAt", query = "SELECT d FROM Documentos d WHERE d.updatedAt = :updatedAt")
    , @NamedQuery(name = "Documentos.findByDeletedAt", query = "SELECT d FROM Documentos d WHERE d.deletedAt = :deletedAt")})
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocumento")
    private Integer idDocumento;
    @Size(max = 45)
    @Column(name = "radicado")
    private String radicado;
    @Size(max = 45)
    @Column(name = "nombreContribuyente")
    private String nombreContribuyente;
    @Column(name = "identificacionContribuyente")
    private Integer identificacionContribuyente;
    @Size(max = 250)
    @Column(name = "tipoRenta")
    private String tipoRenta;
    @Size(max = 45)
    @Column(name = "abogado")
    private String abogado;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @JoinColumn(name = "DocumentoCustodiaid", referencedColumnName = "idDocumentoCustodia")
    @ManyToOne
    private Documentoscustodia documentoCustodiaid;
    @JoinColumn(name = "Procesoid", referencedColumnName = "idProceso")
    @ManyToOne(optional = false)
    private Procesos procesoid;
    @JoinColumn(name = "TipoDocumentalid", referencedColumnName = "idTipoDocumental")
    @ManyToOne(optional = false)
    private Tiposdocumentales tipoDocumentalid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoid")
    private Collection<Informaciondocumental> informaciondocumentalCollection;

    public Documentos() {
    }

    public Documentos(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    public Integer getIdentificacionContribuyente() {
        return identificacionContribuyente;
    }

    public void setIdentificacionContribuyente(Integer identificacionContribuyente) {
        this.identificacionContribuyente = identificacionContribuyente;
    }

    public String getTipoRenta() {
        return tipoRenta;
    }

    public void setTipoRenta(String tipoRenta) {
        this.tipoRenta = tipoRenta;
    }

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
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

    public Documentoscustodia getDocumentoCustodiaid() {
        return documentoCustodiaid;
    }

    public void setDocumentoCustodiaid(Documentoscustodia documentoCustodiaid) {
        this.documentoCustodiaid = documentoCustodiaid;
    }

    public Procesos getProcesoid() {
        return procesoid;
    }

    public void setProcesoid(Procesos procesoid) {
        this.procesoid = procesoid;
    }

    public Tiposdocumentales getTipoDocumentalid() {
        return tipoDocumentalid;
    }

    public void setTipoDocumentalid(Tiposdocumentales tipoDocumentalid) {
        this.tipoDocumentalid = tipoDocumentalid;
    }

    @XmlTransient
    public Collection<Informaciondocumental> getInformaciondocumentalCollection() {
        return informaciondocumentalCollection;
    }

    public void setInformaciondocumentalCollection(Collection<Informaciondocumental> informaciondocumentalCollection) {
        this.informaciondocumentalCollection = informaciondocumentalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Documentos[ idDocumento=" + idDocumento + " ]";
    }
    
}
