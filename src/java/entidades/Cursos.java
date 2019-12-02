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
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByIdcurso", query = "SELECT c FROM Cursos c WHERE c.idcurso = :idcurso")
    , @NamedQuery(name = "Cursos.findByNombrecurso", query = "SELECT c FROM Cursos c WHERE c.nombrecurso = :nombrecurso")
    , @NamedQuery(name = "Cursos.findByNivel", query = "SELECT c FROM Cursos c WHERE c.nivel = :nivel")
    , @NamedQuery(name = "Cursos.findByNumeroalumnos", query = "SELECT c FROM Cursos c WHERE c.numeroalumnos = :numeroalumnos")
    , @NamedQuery(name = "Cursos.findByPeriodo", query = "SELECT c FROM Cursos c WHERE c.periodo = :periodo")
    , @NamedQuery(name = "Cursos.findByProfesor", query = "SELECT c FROM Cursos c WHERE c.profesor = :profesor")
    , @NamedQuery(name = "Cursos.findByHorario", query = "SELECT c FROM Cursos c WHERE c.horario = :horario")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcurso")
    private Integer idcurso;
    @Size(max = 100)
    @Column(name = "nombrecurso")
    private String nombrecurso;
    @Size(max = 50)
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "numeroalumnos")
    private Integer numeroalumnos;
    @Size(max = 50)
    @Column(name = "periodo")
    private String periodo;
    @Size(max = 100)
    @Column(name = "profesor")
    private String profesor;
    @Size(max = 30)
    @Column(name = "horario")
    private String horario;

    public Cursos() {
    }

    public Cursos(Integer idcurso) {
        this.idcurso = idcurso;
    }
    public Cursos(Integer idcurso,
            String nombrecurso,
            String nivel,
            Integer numeroalumnos,
            String periodo,
            String profesor,
            String horario) {
        this.idcurso = idcurso;
        this.nombrecurso = nombrecurso;
        this.nivel = nivel;
        this.numeroalumnos = numeroalumnos;
        this.periodo = periodo;
        this.profesor = profesor;
        this.horario = horario;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getNumeroalumnos() {
        return numeroalumnos;
    }

    public void setNumeroalumnos(Integer numeroalumnos) {
        this.numeroalumnos = numeroalumnos;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cursos[ idcurso=" + idcurso + " ]";
    }
    
}
