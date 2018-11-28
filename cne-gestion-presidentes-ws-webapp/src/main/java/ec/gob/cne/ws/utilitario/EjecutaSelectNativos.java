/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.utilitario;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ezamora
 */
public class EjecutaSelectNativos {
    
     private EjecutaSelectNativos() {
        super();
    }

   
    public static <T> List<T> listarPorSentenciaSql(final Query query, final Class claseRetorno)
            throws Exception {
        try {
            return (List<T>) RetornoListaSql.retornar(query.getResultList(), claseRetorno);
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
    }
    
}
