/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucho
 */
@Entity
@Table(name = "tiposdocumentales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposdocumentales.findAll", query = "SELECT t FROM Tiposdocumentales t")
    , @NamedQuery(name = "Tiposdocumentales.findByIdTipoDocumental", query = "SELECT t FROM Tiposdocumentales t WHERE t.idTipoDocumental = :idTipoDocumental")
    , @NamedQuery(name = "Tiposdocumentales.findByNombre", query = "SELECT t FROM Tiposdocumentales t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tiposdocumentales.findByFlujos", query = "SELECT t FROM Tiposdocumentales t WHERE t.flujos = :flujos")})
public class Tiposdocumentales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoDocumental")
    private Integer idTipoDocumental;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "flujos")
    private String flujos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumentalid")
    private Collection<Documentos> documentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumentalid")
    private Collection<Entidadesproductoras> entidadesproductorasCollection;

    public Tiposdocumentales() {
    }

    public Tiposdocumentales(Integer idTipoDocumental) {
        this.idTipoDocumental = idTipoDocumental;
    }

    public Integer getIdTipoDocumental() {
        return idTipoDocumental;
    }

    public void setIdTipoDocumental(Integer idTipoDocumental) {
        this.idTipoDocumental = idTipoDocumental;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFlujos() {
        return flujos;
    }

    public void setFlujos(String flujos) {
        this.flujos = flujos;
    }

    @XmlTransient
    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
    }

    @XmlTransient
    public Collection<Entidadesproductoras> getEntidadesproductorasCollection() {
        return entidadesproductorasCollection;
    }

    public void setEntidadesproductorasCollection(Collection<Entidadesproductoras> entidadesproductorasCollection) {
        this.entidadesproductorasCollection = entidadesproductorasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumental != null ? idTipoDocumental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposdocumentales)) {
            return false;
        }
        Tiposdocumentales other = (Tiposdocumentales) object;
        if ((this.idTipoDocumental == null && other.idTipoDocumental != null) || (this.idTipoDocumental != null && !this.idTipoDocumental.equals(other.idTipoDocumental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Tiposdocumentales[ idTipoDocumental=" + idTipoDocumental + " ]";
    }
    
}
