/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandra Grande
 */
@Entity
@Table(name = "escuelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuelas.findAll", query = "SELECT e FROM Escuelas e")
    , @NamedQuery(name = "Escuelas.findByIdescuela", query = "SELECT e FROM Escuelas e WHERE e.idescuela = :idescuela")
    , @NamedQuery(name = "Escuelas.findByNombreescuela", query = "SELECT e FROM Escuelas e WHERE e.nombreescuela = :nombreescuela")
    , @NamedQuery(name = "Escuelas.findByDomicilio", query = "SELECT e FROM Escuelas e WHERE e.domicilio = :domicilio")
    , @NamedQuery(name = "Escuelas.findByTelefono", query = "SELECT e FROM Escuelas e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Escuelas.findByNumeroalumnos", query = "SELECT e FROM Escuelas e WHERE e.numeroalumnos = :numeroalumnos")
    , @NamedQuery(name = "Escuelas.findByFundacion", query = "SELECT e FROM Escuelas e WHERE e.fundacion = :fundacion")})
public class Escuelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idescuela")
    private Integer idescuela;
    @Size(max = 100)
    @Column(name = "nombreescuela")
    private String nombreescuela;
    @Size(max = 70)
    @Column(name = "domicilio")
    private String domicilio;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 5)
    @Column(name = "numeroalumnos")
    private String numeroalumnos;
    @Size(max = 5)
    @Column(name = "fundacion")
    private String fundacion;

    public Escuelas() {
    }

    public Escuelas(Integer idescuela) {
        this.idescuela = idescuela;
    }

    public Escuelas(Integer idescuela,
            String nombreescuela,
            String domicilio,
            String telefono,
            String numeroalumnos,
            String fundacion) {
        this.idescuela = idescuela;
        this.nombreescuela = nombreescuela;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.numeroalumnos = numeroalumnos;
        this.fundacion = fundacion;
    }
    public Integer getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(Integer idescuela) {
        this.idescuela = idescuela;
    }

    public String getNombreescuela() {
        return nombreescuela;
    }

    public void setNombreescuela(String nombreescuela) {
        this.nombreescuela = nombreescuela;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroalumnos() {
        return numeroalumnos;
    }

    public void setNumeroalumnos(String numeroalumnos) {
        this.numeroalumnos = numeroalumnos;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idescuela != null ? idescuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuelas)) {
            return false;
        }
        Escuelas other = (Escuelas) object;
        if ((this.idescuela == null && other.idescuela != null) || (this.idescuela != null && !this.idescuela.equals(other.idescuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Escuelas[ idescuela=" + idescuela + " ]";
    }
    
}
