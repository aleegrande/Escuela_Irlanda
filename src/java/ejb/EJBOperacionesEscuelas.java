/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Escuelas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandra Grande
 */
@Stateless
@LocalBean
public class EJBOperacionesEscuelas {

    @PersistenceContext
    EntityManager em; //objeto que controla el CRUD
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String nuevoEscuela(int idescuela, String nombreescuela, String domicilio, String telefono, String numeroalumnos, String fundacion) {
        // em.merge(r);
        Escuelas es=new Escuelas();
        es.setIdescuela(idescuela);
        es.setNombreescuela(nombreescuela);
        es.setDomicilio(domicilio);
        es.setTelefono(telefono);
        es.setNumeroalumnos(numeroalumnos);
        es.setFundacion(fundacion);

        String msj;
        try {
            em.persist(es);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";
        } catch (Exception e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;

    }
    public String consultaEscuela() {
        try {
            Query q;
            List<Escuelas> listaEscuelas;
            q = em.createNamedQuery("Escuelas.findAll");
            listaEscuelas = q.getResultList();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaEscuelas);
        } catch (Exception e) {
            return "{msg:'Error'}";
        }

    } //Fin consultaRol

    public String actualizaEscuela(int idescuela, String nombreescuela, String domicilio, String telefono, String numeroalumnos, String fundacion) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        Escuelas es = new Escuelas();
        try {
            es = em.find(Escuelas.class, idescuela);
            
        es.setNombreescuela(nombreescuela);
        es.setDomicilio(domicilio);
        es.setTelefono(telefono);
        es.setNumeroalumnos(numeroalumnos);
        es.setFundacion(fundacion);
        
            em.merge(es);

            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente\"}";

        } catch (NumberFormatException e) {
            msj = "{\"codigo\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }//fin del try

        return msj;
    } //Fin actualiza Rol

    public String eliminarEscuela(int idescuela) {
        String msj;
        Escuelas es = new Escuelas();
        try {
            es= (Escuelas) em.createNamedQuery("Escuelas.findByIdescuela").setParameter("idescuela", idescuela).getSingleResult();
            em.remove(es);
            msj = "{\"code\":200,\"msj\":\"La operacion se realiza correctamente al eliminar\"}";
        } catch (NumberFormatException e) {
            msj = "{\"codigo\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }//fin del try

        return msj;
    }
}
