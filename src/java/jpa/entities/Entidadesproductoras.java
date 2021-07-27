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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "entidadesproductoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidadesproductoras.findAll", query = "SELECT e FROM Entidadesproductoras e")
    , @NamedQuery(name = "Entidadesproductoras.findByIdEntidadProductora", query = "SELECT e FROM Entidadesproductoras e WHERE e.idEntidadProductora = :idEntidadProductora")
    , @NamedQuery(name = "Entidadesproductoras.findByEntidadAdministrativa", query = "SELECT e FROM Entidadesproductoras e WHERE e.entidadAdministrativa = :entidadAdministrativa")
    , @NamedQuery(name = "Entidadesproductoras.findBySecretaria", query = "SELECT e FROM Entidadesproductoras e WHERE e.secretaria = :secretaria")
    , @NamedQuery(name = "Entidadesproductoras.findBySubsecretaria", query = "SELECT e FROM Entidadesproductoras e WHERE e.subsecretaria = :subsecretaria")
    , @NamedQuery(name = "Entidadesproductoras.findByFechaEntrega", query = "SELECT e FROM Entidadesproductoras e WHERE e.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Entidadesproductoras.findByTipoDocumentoGenerado", query = "SELECT e FROM Entidadesproductoras e WHERE e.tipoDocumentoGenerado = :tipoDocumentoGenerado")
    , @NamedQuery(name = "Entidadesproductoras.findByCreatedAt", query = "SELECT e FROM Entidadesproductoras e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "Entidadesproductoras.findByUpdatedAt", query = "SELECT e FROM Entidadesproductoras e WHERE e.updatedAt = :updatedAt")
    , @NamedQuery(name = "Entidadesproductoras.findByDeletedAt", query = "SELECT e FROM Entidadesproductoras e WHERE e.deletedAt = :deletedAt")})
public class Entidadesproductoras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEntidadProductora")
    private Integer idEntidadProductora;
    @Size(max = 250)
    @Column(name = "entidadAdministrativa")
    private String entidadAdministrativa;
    @Size(max = 250)
    @Column(name = "secretaria")
    private String secretaria;
    @Size(max = 250)
    @Column(name = "subsecretaria")
    private String subsecretaria;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Size(max = 250)
    @Column(name = "tipoDocumentoGenerado")
    private String tipoDocumentoGenerado;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @JoinColumn(name = "TipoDocumentalid", referencedColumnName = "idTipoDocumental")
    @ManyToOne(optional = false)
    private Tiposdocumentales tipoDocumentalid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadProductoraid")
    private Collection<Procesos> procesosCollection;

    public Entidadesproductoras() {
    }

    public Entidadesproductoras(Integer idEntidadProductora) {
        this.idEntidadProductora = idEntidadProductora;
    }

    public Integer getIdEntidadProductora() {
        return idEntidadProductora;
    }

    public void setIdEntidadProductora(Integer idEntidadProductora) {
        this.idEntidadProductora = idEntidadProductora;
    }

    public String getEntidadAdministrativa() {
        return entidadAdministrativa;
    }

    public void setEntidadAdministrativa(String entidadAdministrativa) {
        this.entidadAdministrativa = entidadAdministrativa;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getSubsecretaria() {
        return subsecretaria;
    }

    public void setSubsecretaria(String subsecretaria) {
        this.subsecretaria = subsecretaria;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getTipoDocumentoGenerado() {
        return tipoDocumentoGenerado;
    }

    public void setTipoDocumentoGenerado(String tipoDocumentoGenerado) {
        this.tipoDocumentoGenerado = tipoDocumentoGenerado;
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

    public Tiposdocumentales getTipoDocumentalid() {
        return tipoDocumentalid;
    }

    public void setTipoDocumentalid(Tiposdocumentales tipoDocumentalid) {
        this.tipoDocumentalid = tipoDocumentalid;
    }

    @XmlTransient
    public Collection<Procesos> getProcesosCollection() {
        return procesosCollection;
    }

    public void setProcesosCollection(Collection<Procesos> procesosCollection) {
        this.procesosCollection = procesosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidadProductora != null ? idEntidadProductora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidadesproductoras)) {
            return false;
        }
        Entidadesproductoras other = (Entidadesproductoras) object;
        if ((this.idEntidadProductora == null && other.idEntidadProductora != null) || (this.idEntidadProductora != null && !this.idEntidadProductora.equals(other.idEntidadProductora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Entidadesproductoras[ idEntidadProductora=" + idEntidadProductora + " ]";
    }
    
}
