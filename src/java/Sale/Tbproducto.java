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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tbproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbproducto.findAll", query = "SELECT t FROM Tbproducto t")
    , @NamedQuery(name = "Tbproducto.findByProductoId", query = "SELECT t FROM Tbproducto t WHERE t.productoId = :productoId")
    , @NamedQuery(name = "Tbproducto.findByNombre", query = "SELECT t FROM Tbproducto t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tbproducto.findByPrecio", query = "SELECT t FROM Tbproducto t WHERE t.precio = :precio")})
public class Tbproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductoId")
    private Integer productoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private float precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Tbventa> tbventaCollection;

    public Tbproducto() {
    }

    public Tbproducto(Integer productoId) {
        this.productoId = productoId;
    }

    public Tbproducto(Integer productoId, String nombre, float precio) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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
        hash += (productoId != null ? productoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbproducto)) {
            return false;
        }
        Tbproducto other = (Tbproducto) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale.Tbproducto[ productoId=" + productoId + " ]";
    }
    
}
