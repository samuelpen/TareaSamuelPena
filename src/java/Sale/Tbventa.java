/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sale;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Usuario
 */
@Entity
@Table(name = "tbventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbventa.findAll", query = "SELECT t FROM Tbventa t")
    , @NamedQuery(name = "Tbventa.findByVentaId", query = "SELECT t FROM Tbventa t WHERE t.ventaId = :ventaId")
    , @NamedQuery(name = "Tbventa.findByFecha", query = "SELECT t FROM Tbventa t WHERE t.fecha = :fecha")})
public class Tbventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VentaId")
    private Integer ventaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ProductoId", referencedColumnName = "ProductoId")
    @ManyToOne(optional = false)
    private Tbproducto productoId;
    @JoinColumn(name = "ClienteId", referencedColumnName = "ClienteId")
    @ManyToOne(optional = false)
    private Tbcliente clienteId;

    public Tbventa() {
    }

    public Tbventa(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Tbventa(Integer ventaId, Date fecha) {
        this.ventaId = ventaId;
        this.fecha = fecha;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tbproducto getProductoId() {
        return productoId;
    }

    public void setProductoId(Tbproducto productoId) {
        this.productoId = productoId;
    }

    public Tbcliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Tbcliente clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaId != null ? ventaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbventa)) {
            return false;
        }
        Tbventa other = (Tbventa) object;
        if ((this.ventaId == null && other.ventaId != null) || (this.ventaId != null && !this.ventaId.equals(other.ventaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale.Tbventa[ ventaId=" + ventaId + " ]";
    }
    
}
