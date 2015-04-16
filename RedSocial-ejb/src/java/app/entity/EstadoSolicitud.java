/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Inma
 */
@Entity
@Table(name = "ESTADO_SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoSolicitud.findAll", query = "SELECT e FROM EstadoSolicitud e"),
    @NamedQuery(name = "EstadoSolicitud.findByIdEstadosolicitud", query = "SELECT e FROM EstadoSolicitud e WHERE e.idEstadosolicitud = :idEstadosolicitud"),
    @NamedQuery(name = "EstadoSolicitud.findByTipoEstado", query = "SELECT e FROM EstadoSolicitud e WHERE e.tipoEstado = :tipoEstado")})
public class EstadoSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADOSOLICITUD")
    private BigDecimal idEstadosolicitud;
    @Size(max = 50)
    @Column(name = "TIPO_ESTADO")
    private String tipoEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadosolicitud")
    private Collection<Invitados> invitadosCollection;

    public EstadoSolicitud() {
    }

    public EstadoSolicitud(BigDecimal idEstadosolicitud) {
        this.idEstadosolicitud = idEstadosolicitud;
    }

    public BigDecimal getIdEstadosolicitud() {
        return idEstadosolicitud;
    }

    public void setIdEstadosolicitud(BigDecimal idEstadosolicitud) {
        this.idEstadosolicitud = idEstadosolicitud;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @XmlTransient
    public Collection<Invitados> getInvitadosCollection() {
        return invitadosCollection;
    }

    public void setInvitadosCollection(Collection<Invitados> invitadosCollection) {
        this.invitadosCollection = invitadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosolicitud != null ? idEstadosolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSolicitud)) {
            return false;
        }
        EstadoSolicitud other = (EstadoSolicitud) object;
        if ((this.idEstadosolicitud == null && other.idEstadosolicitud != null) || (this.idEstadosolicitud != null && !this.idEstadosolicitud.equals(other.idEstadosolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.EstadoSolicitud[ idEstadosolicitud=" + idEstadosolicitud + " ]";
    }
    
}
