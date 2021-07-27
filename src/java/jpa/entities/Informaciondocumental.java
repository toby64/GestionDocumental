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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "informaciondocumental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informaciondocumental.findAll", query = "SELECT i FROM Informaciondocumental i")
    , @NamedQuery(name = "Informaciondocumental.findByIdInformacionDocumental", query = "SELECT i FROM Informaciondocumental i WHERE i.idInformacionDocumental = :idInformacionDocumental")
    , @NamedQuery(name = "Informaciondocumental.findByNoFolios", query = "SELECT i FROM Informaciondocumental i WHERE i.noFolios = :noFolios")
    , @NamedQuery(name = "Informaciondocumental.findByNoImagenes", query = "SELECT i FROM Informaciondocumental i WHERE i.noImagenes = :noImagenes")
    , @NamedQuery(name = "Informaciondocumental.findByCarpeta", query = "SELECT i FROM Informaciondocumental i WHERE i.carpeta = :carpeta")
    , @NamedQuery(name = "Informaciondocumental.findByCaja", query = "SELECT i FROM Informaciondocumental i WHERE i.caja = :caja")})
public class Informaciondocumental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInformacionDocumental")
    private Integer idInformacionDocumental;
    @Column(name = "noFolios")
    private Integer noFolios;
    @Column(name = "noImagenes")
    private Integer noImagenes;
    @Column(name = "carpeta")
    private Integer carpeta;
    @Size(max = 45)
    @Column(name = "caja")
    private String caja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformacionDocumental")
    private Collection<Informaciondocumentallogs> informaciondocumentallogsCollection;
    @JoinColumn(name = "Documentoid", referencedColumnName = "idDocumento")
    @ManyToOne(optional = false)
    private Documentos documentoid;

    public Informaciondocumental() {
    }

    public Informaciondocumental(Integer idInformacionDocumental) {
        this.idInformacionDocumental = idInformacionDocumental;
    }

    public Integer getIdInformacionDocumental() {
        return idInformacionDocumental;
    }

    public void setIdInformacionDocumental(Integer idInformacionDocumental) {
        this.idInformacionDocumental = idInformacionDocumental;
    }

    public Integer getNoFolios() {
        return noFolios;
    }

    public void setNoFolios(Integer noFolios) {
        this.noFolios = noFolios;
    }

    public Integer getNoImagenes() {
        return noImagenes;
    }

    public void setNoImagenes(Integer noImagenes) {
        this.noImagenes = noImagenes;
    }

    public Integer getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(Integer carpeta) {
        this.carpeta = carpeta;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    @XmlTransient
    public Collection<Informaciondocumentallogs> getInformaciondocumentallogsCollection() {
        return informaciondocumentallogsCollection;
    }

    public void setInformaciondocumentallogsCollection(Collection<Informaciondocumentallogs> informaciondocumentallogsCollection) {
        this.informaciondocumentallogsCollection = informaciondocumentallogsCollection;
    }

    public Documentos getDocumentoid() {
        return documentoid;
    }

    public void setDocumentoid(Documentos documentoid) {
        this.documentoid = documentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionDocumental != null ? idInformacionDocumental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informaciondocumental)) {
            return false;
        }
        Informaciondocumental other = (Informaciondocumental) object;
        if ((this.idInformacionDocumental == null && other.idInformacionDocumental != null) || (this.idInformacionDocumental != null && !this.idInformacionDocumental.equals(other.idInformacionDocumental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Informaciondocumental[ idInformacionDocumental=" + idInformacionDocumental + " ]";
    }
    
}
