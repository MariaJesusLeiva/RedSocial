/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "MIEMBROSGRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembrosgrupo.findAll", query = "SELECT m FROM Miembrosgrupo m"),
    @NamedQuery(name = "Miembrosgrupo.findByIdMiembrogrupo", query = "SELECT m FROM Miembrosgrupo m WHERE m.idMiembrogrupo = :idMiembrogrupo")})
public class Miembrosgrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MIEMBROGRUPO")
    private BigDecimal idMiembrogrupo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_GRUPO")
    @ManyToOne(optional = false)
    private Grupo idGrupo;

    public Miembrosgrupo() {
    }

    public Miembrosgrupo(BigDecimal idMiembrogrupo) {
        this.idMiembrogrupo = idMiembrogrupo;
    }

    public BigDecimal getIdMiembrogrupo() {
        return idMiembrogrupo;
    }

    public void setIdMiembrogrupo(BigDecimal idMiembrogrupo) {
        this.idMiembrogrupo = idMiembrogrupo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembrogrupo != null ? idMiembrogrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembrosgrupo)) {
            return false;
        }
        Miembrosgrupo other = (Miembrosgrupo) object;
        if ((this.idMiembrogrupo == null && other.idMiembrogrupo != null) || (this.idMiembrogrupo != null && !this.idMiembrogrupo.equals(other.idMiembrogrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Miembrosgrupo[ idMiembrogrupo=" + idMiembrogrupo + " ]";
    }
    
}
