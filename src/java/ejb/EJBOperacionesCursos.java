/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Cursos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leo
 */
@Stateless
@LocalBean
public class EJBOperacionesCursos {

    @PersistenceContext
    EntityManager em; //objeto que controla el CRUD

    public String nuevoCurso(int idcurso, String nombrecurso, String nivel, int numeroalumnos, String periodo, String profesor, String horario) {
        // em.merge(r);
        Cursos c = new Cursos();
        c.setIdcurso(idcurso);
        c.setNombrecurso(nombrecurso);
        c.setNivel(nivel);
        c.setNumeroalumnos(numeroalumnos);
        c.setPeriodo(periodo);
        c.setProfesor(profesor);
        c.setHorario(horario);

        String msj;
        try {
            em.persist(c);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";
        } catch (Exception e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;

    }

    
    public String consultaCurso() {
        try {
            Query q;
            List<Cursos> listaCursos;
            q = em.createNamedQuery("Cursos.findAll");
            listaCursos = q.getResultList(); // ejecutar consulta
            //onvertir la lista a objetos JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaCursos);
        } catch (Exception e) {
            return "{msg:'Error'}";
        }
    }
    public String actualizaCurso(int idcurso, String nombrecurso, String nivel, int numeroalumnos, String periodo, String profesor, String horario) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        Cursos c = new Cursos();
        try {
            c = em.find(Cursos.class, idcurso);
            c.setNombrecurso(nombrecurso);
            c.setNivel(nivel);
            c.setNumeroalumnos(numeroalumnos);
            c.setPeriodo(periodo);
            c.setProfesor(profesor);
            c.setHorario(horario);
            em.merge(c);

            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";

        } catch (NumberFormatException e) {
            msj = "{\"codigo\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }//fin del try

        return msj;
    } //Fin actualiza Rol

    public String eliminarCurso(int idcurso) {
        String msj;
        Cursos c = new Cursos();
        try {
            c = (Cursos) em.createNamedQuery("Cursos.findByIdcurso").setParameter("idcurso", idcurso).getSingleResult();
            em.remove(c);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente al eliminar\"}";
        } catch (NumberFormatException e) {
            msj = "{\"codigo\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }//fin del try

        return msj;
    }
}
