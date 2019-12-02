/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Alumnos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leo
 */
@Stateless
public class EJBOperacionesAlumnos {

    @PersistenceContext
    EntityManager em; //objeto que controla el CRUD

    public String nuevoAlumno(
            int idusuario,
            String nombrealumno,
            String nombreusuario,
            String fechanacimiento,
            String nacionalidad,
            String telefono,
            String correo) {

        Alumnos a = new Alumnos();
        a.setIdalumno(idusuario);
        a.setNombrealumno(nombrealumno);
        a.setNombreusuario(nombreusuario);
        a.setFechanacimiento(fechanacimiento);
        a.setNacionalidad(nacionalidad);
        a.setTelefono(telefono);
        a.setCorreo(correo);

        String msj;
        try {
            em.persist(a);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";
        } catch (Exception e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }

    public String consultaAlumno() {
        try {
            Query q;
            List<Alumnos> listaAlumnos;
            q = em.createNamedQuery("Alumnos.findAll");
            listaAlumnos = q.getResultList(); // Ejecutar consulta

            //Convertir la lista a objetos JSON 
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaAlumnos);

        } catch (Exception e) {
            return "{msg:'Error'}";
        }

    } //Fin consultaRol

    public String actualizaAlumno(int idalumno, String nombrealumno, String nombreusuario, String fechanacimiento, String nacionalidad, String telefono, String correo) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
    {

         GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        Alumnos a = new Alumnos();
        try {
            a = em.find(Alumnos.class, idalumno);
            a.setNombrealumno(nombrealumno);
            a.setNombreusuario(nombreusuario);
            a.setFechanacimiento(fechanacimiento);
            a.setNacionalidad(nacionalidad);
            a.setTelefono(telefono);
            a.setCorreo(correo);
            em.merge(a);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";
        } catch (NumberFormatException e) {
            msj = "{codigo:400 msj-Error en los tipos de parametros}";
        }
        return msj;

    } //Fin actualiza Rol

    public String eliminarAlumno(int idalumno) {
        String msj;
        Alumnos a = new Alumnos();
        try 
        {
            a = (Alumnos) em.createNamedQuery("Alumnos.findByIdalumno").setParameter("idalumno", idalumno).getSingleResult();
            em.remove(a);
           msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente al eliminar\"}";
        } catch (NumberFormatException e) {
            msj = "{\"codigo\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }//fin del try

        return msj;
    }
}
