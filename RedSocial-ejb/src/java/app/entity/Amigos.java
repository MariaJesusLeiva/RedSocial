/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoseAntonio
 */
@Entity
@Table(name = "AMIGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigos.findAll", query = "SELECT a FROM Amigos a"),
    @NamedQuery(name = "Amigos.findByIdAmigo", query = "SELECT a FROM Amigos a WHERE a.idAmigo = :idAmigo"),
    @NamedQuery(name = "Amigos.findByFecha", query = "SELECT a FROM Amigos a WHERE a.fecha = :fecha")})
public class Amigos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AMIGO")
    private Short idAmigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID2_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario id2Usuario;
    @JoinColumn(name = "ID1_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario id1Usuario;

    public Amigos() {
    }

    public Amigos(Short idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Short getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Short idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getId2Usuario() {
        return id2Usuario;
    }

    public void setId2Usuario(Usuario id2Usuario) {
        this.id2Usuario = id2Usuario;
    }

    public Usuario getId1Usuario() {
        return id1Usuario;
    }

    public void setId1Usuario(Usuario id1Usuario) {
        this.id1Usuario = id1Usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmigo != null ? idAmigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigos)) {
            return false;
        }
        Amigos other = (Amigos) object;
        if ((this.idAmigo == null && other.idAmigo != null) || (this.idAmigo != null && !this.idAmigo.equals(other.idAmigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Amigos[ idAmigo=" + idAmigo + " ]";
    }
    
}
