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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByFlujos", query = "SELECT u FROM Usuarios u WHERE u.flujos = :flujos")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellido", query = "SELECT u FROM Usuarios u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByDocumento", query = "SELECT u FROM Usuarios u WHERE u.documento = :documento")
    , @NamedQuery(name = "Usuarios.findBySecretaria", query = "SELECT u FROM Usuarios u WHERE u.secretaria = :secretaria")
    , @NamedQuery(name = "Usuarios.findBySubsecretaria", query = "SELECT u FROM Usuarios u WHERE u.subsecretaria = :subsecretaria")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "flujos")
    private String flujos;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "documento")
    private String documento;
    @Size(max = 250)
    @Column(name = "secretaria")
    private String secretaria;
    @Size(max = 250)
    @Column(name = "subsecretaria")
    private String subsecretaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioid")
    private Collection<Informaciondocumentallogs> informaciondocumentallogsCollection;
    @JoinColumn(name = "FlujoDocumentalid", referencedColumnName = "idFlujoDocumental")
    @ManyToOne(optional = false)
    private Flujosdocumentales flujoDocumentalid;
    @JoinColumn(name = "Roleid", referencedColumnName = "idRole")
    @ManyToOne(optional = false)
    private Role roleid;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFlujos() {
        return flujos;
    }

    public void setFlujos(String flujos) {
        this.flujos = flujos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    @XmlTransient
    public Collection<Informaciondocumentallogs> getInformaciondocumentallogsCollection() {
        return informaciondocumentallogsCollection;
    }

    public void setInformaciondocumentallogsCollection(Collection<Informaciondocumentallogs> informaciondocumentallogsCollection) {
        this.informaciondocumentallogsCollection = informaciondocumentallogsCollection;
    }

    public Flujosdocumentales getFlujoDocumentalid() {
        return flujoDocumentalid;
    }

    public void setFlujoDocumentalid(Flujosdocumentales flujoDocumentalid) {
        this.flujoDocumentalid = flujoDocumentalid;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
