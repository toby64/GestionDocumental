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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucho
 */
@Entity
@Table(name = "flujosdocumentales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flujosdocumentales.findAll", query = "SELECT f FROM Flujosdocumentales f")
    , @NamedQuery(name = "Flujosdocumentales.findByIdFlujoDocumental", query = "SELECT f FROM Flujosdocumentales f WHERE f.idFlujoDocumental = :idFlujoDocumental")
    , @NamedQuery(name = "Flujosdocumentales.findByNombre", query = "SELECT f FROM Flujosdocumentales f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Flujosdocumentales.findByDescripcion", query = "SELECT f FROM Flujosdocumentales f WHERE f.descripcion = :descripcion")})
public class Flujosdocumentales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFlujoDocumental")
    private Integer idFlujoDocumental;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flujoDocumentalid")
    private Collection<Usuarios> usuariosCollection;

    public Flujosdocumentales() {
    }

    public Flujosdocumentales(Integer idFlujoDocumental) {
        this.idFlujoDocumental = idFlujoDocumental;
    }

    public Integer getIdFlujoDocumental() {
        return idFlujoDocumental;
    }

    public void setIdFlujoDocumental(Integer idFlujoDocumental) {
        this.idFlujoDocumental = idFlujoDocumental;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFlujoDocumental != null ? idFlujoDocumental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flujosdocumentales)) {
            return false;
        }
        Flujosdocumentales other = (Flujosdocumentales) object;
        if ((this.idFlujoDocumental == null && other.idFlujoDocumental != null) || (this.idFlujoDocumental != null && !this.idFlujoDocumental.equals(other.idFlujoDocumental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Flujosdocumentales[ idFlujoDocumental=" + idFlujoDocumental + " ]";
    }
    
}
