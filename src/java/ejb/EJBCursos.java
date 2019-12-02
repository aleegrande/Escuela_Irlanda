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
@Remote (EJBCursosRemote.class)
public class EJBCursos implements EJBCursosRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
