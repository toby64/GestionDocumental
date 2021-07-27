/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucho
 */
@Entity
@Table(name = "informaciondocumentallogs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informaciondocumentallogs.findAll", query = "SELECT i FROM Informaciondocumentallogs i")
    , @NamedQuery(name = "Informaciondocumentallogs.findByIdInformacionDocumentalLog", query = "SELECT i FROM Informaciondocumentallogs i WHERE i.idInformacionDocumentalLog = :idInformacionDocumentalLog")
    , @NamedQuery(name = "Informaciondocumentallogs.findByCreatedAt", query = "SELECT i FROM Informaciondocumentallogs i WHERE i.createdAt = :createdAt")
    , @NamedQuery(name = "Informaciondocumentallogs.findByUpdatedAt", query = "SELECT i FROM Informaciondocumentallogs i WHERE i.updatedAt = :updatedAt")
    , @NamedQuery(name = "Informaciondocumentallogs.findByDeletedAt", query = "SELECT i FROM Informaciondocumentallogs i WHERE i.deletedAt = :deletedAt")})
public class Informaciondocumentallogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInformacionDocumentalLog")
    private Integer idInformacionDocumentalLog;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @JoinColumn(name = "Estadoid", referencedColumnName = "idEstado")
    @ManyToOne(optional = false)
    private Estados estadoid;
    @JoinColumn(name = "idInformacionDocumental", referencedColumnName = "idInformacionDocumental")
    @ManyToOne(optional = false)
    private Informaciondocumental idInformacionDocumental;
    @JoinColumn(name = "Usuarioid", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuarioid;

    public Informaciondocumentallogs() {
    }

    public Informaciondocumentallogs(Integer idInformacionDocumentalLog) {
        this.idInformacionDocumentalLog = idInformacionDocumentalLog;
    }

    public Integer getIdInformacionDocumentalLog() {
        return idInformacionDocumentalLog;
    }

    public void setIdInformacionDocumentalLog(Integer idInformacionDocumentalLog) {
        this.idInformacionDocumentalLog = idInformacionDocumentalLog;
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

    public Estados getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Estados estadoid) {
        this.estadoid = estadoid;
    }

    public Informaciondocumental getIdInformacionDocumental() {
        return idInformacionDocumental;
    }

    public void setIdInformacionDocumental(Informaciondocumental idInformacionDocumental) {
        this.idInformacionDocumental = idInformacionDocumental;
    }

    public Usuarios getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuarios usuarioid) {
        this.usuarioid = usuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionDocumentalLog != null ? idInformacionDocumentalLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informaciondocumentallogs)) {
            return false;
        }
        Informaciondocumentallogs other = (Informaciondocumentallogs) object;
        if ((this.idInformacionDocumentalLog == null && other.idInformacionDocumentalLog != null) || (this.idInformacionDocumentalLog != null && !this.idInformacionDocumentalLog.equals(other.idInformacionDocumentalLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Informaciondocumentallogs[ idInformacionDocumentalLog=" + idInformacionDocumentalLog + " ]";
    }
    
}
