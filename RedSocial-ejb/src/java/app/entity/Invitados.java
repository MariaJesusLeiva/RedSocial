/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Inma
 */
@Entity
@Table(name = "INVITADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invitados.findAll", query = "SELECT i FROM Invitados i"),
    @NamedQuery(name = "Invitados.findByIdInvitados", query = "SELECT i FROM Invitados i WHERE i.idInvitados = :idInvitados"),
    @NamedQuery(name = "Invitados.findByFecha", query = "SELECT i FROM Invitados i WHERE i.fecha = :fecha")})
public class Invitados implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INVITADOS")
    private BigDecimal idInvitados;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "ID_ESTADOSOLICITUD", referencedColumnName = "ID_ESTADOSOLICITUD")
    @ManyToOne(optional = false)
    private EstadoSolicitud idEstadosolicitud;

    public Invitados() {
    }

    public Invitados(BigDecimal idInvitados) {
        this.idInvitados = idInvitados;
    }

    public BigDecimal getIdInvitados() {
        return idInvitados;
    }

    public void setIdInvitados(BigDecimal idInvitados) {
        this.idInvitados = idInvitados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EstadoSolicitud getIdEstadosolicitud() {
        return idEstadosolicitud;
    }

    public void setIdEstadosolicitud(EstadoSolicitud idEstadosolicitud) {
        this.idEstadosolicitud = idEstadosolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvitados != null ? idInvitados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitados)) {
            return false;
        }
        Invitados other = (Invitados) object;
        if ((this.idInvitados == null && other.idInvitados != null) || (this.idInvitados != null && !this.idInvitados.equals(other.idInvitados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Invitados[ idInvitados=" + idInvitados + " ]";
    }
    
}
