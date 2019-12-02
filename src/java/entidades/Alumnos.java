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
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findByIdalumno", query = "SELECT a FROM Alumnos a WHERE a.idalumno = :idalumno")
    , @NamedQuery(name = "Alumnos.findByNombrealumno", query = "SELECT a FROM Alumnos a WHERE a.nombrealumno = :nombrealumno")
    , @NamedQuery(name = "Alumnos.findByNombreusuario", query = "SELECT a FROM Alumnos a WHERE a.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Alumnos.findByFechanacimiento", query = "SELECT a FROM Alumnos a WHERE a.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Alumnos.findByNacionalidad", query = "SELECT a FROM Alumnos a WHERE a.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumnos.findByCorreo", query = "SELECT a FROM Alumnos a WHERE a.correo = :correo")})
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private Integer idalumno;
    @Size(max = 100)
    @Column(name = "nombrealumno")
    private String nombrealumno;
    @Size(max = 25)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @Size(max = 20)
    @Column(name = "fechanacimiento")
    private String fechanacimiento;
    @Size(max = 50)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;

    public Alumnos() {
    }

    public Alumnos(Integer idalumno) {
        this.idalumno = idalumno;
    }
     public Alumnos(Integer idalumno,
                     String nombrealumno,
                     String nombreusuario,
                     String fechanacimiento,
                     String nacionalidad,
                     String telefono,
                     String correo)
     {
        this.idalumno = idalumno;
        this.nombrealumno = nombrealumno;
        this.nombreusuario = nombreusuario;
        this.fechanacimiento = fechanacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alumnos[ idalumno=" + idalumno + " ]";
    }
    
}
