/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 *
 * @author Leo
 */
@Stateful
@Remote (EJBAlumnosRemote.class)
public class EJBAlumnos implements EJBAlumnosRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
