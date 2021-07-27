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
@Table(name = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesos.findAll", query = "SELECT p FROM Procesos p")
    , @NamedQuery(name = "Procesos.findByIdProceso", query = "SELECT p FROM Procesos p WHERE p.idProceso = :idProceso")
    , @NamedQuery(name = "Procesos.findByEntidadRemitente", query = "SELECT p FROM Procesos p WHERE p.entidadRemitente = :entidadRemitente")
    , @NamedQuery(name = "Procesos.findByEntidadProductora", query = "SELECT p FROM Procesos p WHERE p.entidadProductora = :entidadProductora")
    , @NamedQuery(name = "Procesos.findByUnidadAdministrativa", query = "SELECT p FROM Procesos p WHERE p.unidadAdministrativa = :unidadAdministrativa")
    , @NamedQuery(name = "Procesos.findByOficinaProductora", query = "SELECT p FROM Procesos p WHERE p.oficinaProductora = :oficinaProductora")
    , @NamedQuery(name = "Procesos.findByMotivoProceso", query = "SELECT p FROM Procesos p WHERE p.motivoProceso = :motivoProceso")
    , @NamedQuery(name = "Procesos.findByCreatedAt", query = "SELECT p FROM Procesos p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Procesos.findByUpdatedAt", query = "SELECT p FROM Procesos p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Procesos.findByDeletedAt", query = "SELECT p FROM Procesos p WHERE p.deletedAt = :deletedAt")})
public class Procesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProceso")
    private Integer idProceso;
    @Size(max = 250)
    @Column(name = "entidadRemitente")
    private String entidadRemitente;
    @Size(max = 250)
    @Column(name = "entidadProductora")
    private String entidadProductora;
    @Size(max = 250)
    @Column(name = "unidadAdministrativa")
    private String unidadAdministrativa;
    @Size(max = 250)
    @Column(name = "oficinaProductora")
    private String oficinaProductora;
    @Size(max = 250)
    @Column(name = "motivoProceso")
    private String motivoProceso;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoid")
    private Collection<Documentos> documentosCollection;
    @JoinColumn(name = "EntidadProductoraid", referencedColumnName = "idEntidadProductora")
    @ManyToOne(optional = false)
    private Entidadesproductoras entidadProductoraid;

    public Procesos() {
    }

    public Procesos(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getEntidadRemitente() {
        return entidadRemitente;
    }

    public void setEntidadRemitente(String entidadRemitente) {
        this.entidadRemitente = entidadRemitente;
    }

    public String getEntidadProductora() {
        return entidadProductora;
    }

    public void setEntidadProductora(String entidadProductora) {
        this.entidadProductora = entidadProductora;
    }

    public String getUnidadAdministrativa() {
        return unidadAdministrativa;
    }

    public void setUnidadAdministrativa(String unidadAdministrativa) {
        this.unidadAdministrativa = unidadAdministrativa;
    }

    public String getOficinaProductora() {
        return oficinaProductora;
    }

    public void setOficinaProductora(String oficinaProductora) {
        this.oficinaProductora = oficinaProductora;
    }

    public String getMotivoProceso() {
        return motivoProceso;
    }

    public void setMotivoProceso(String motivoProceso) {
        this.motivoProceso = motivoProceso;
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

    public Entidadesproductoras getEntidadProductoraid() {
        return entidadProductoraid;
    }

    public void setEntidadProductoraid(Entidadesproductoras entidadProductoraid) {
        this.entidadProductoraid = entidadProductoraid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesos)) {
            return false;
        }
        Procesos other = (Procesos) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Procesos[ idProceso=" + idProceso + " ]";
    }
    
}
