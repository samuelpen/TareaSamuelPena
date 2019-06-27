/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sale;

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
 * @author Usuario
 */
@Entity
@Table(name = "tbcliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcliente.findAll", query = "SELECT t FROM Tbcliente t")
    , @NamedQuery(name = "Tbcliente.findByClienteId", query = "SELECT t FROM Tbcliente t WHERE t.clienteId = :clienteId")
    , @NamedQuery(name = "Tbcliente.findByNombre", query = "SELECT t FROM Tbcliente t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tbcliente.findByCorreo", query = "SELECT t FROM Tbcliente t WHERE t.correo = :correo")})
public class Tbcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClienteId")
    private Integer clienteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private Collection<Tbventa> tbventaCollection;

    public Tbcliente() {
    }

    public Tbcliente(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Tbcliente(Integer clienteId, String nombre, String correo) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Tbventa> getTbventaCollection() {
        return tbventaCollection;
    }

    public void setTbventaCollection(Collection<Tbventa> tbventaCollection) {
        this.tbventaCollection = tbventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcliente)) {
            return false;
        }
        Tbcliente other = (Tbcliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale.Tbcliente[ clienteId=" + clienteId + " ]";
    }
    
}
