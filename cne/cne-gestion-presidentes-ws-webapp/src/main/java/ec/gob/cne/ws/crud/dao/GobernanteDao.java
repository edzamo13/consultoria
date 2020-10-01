/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.crud.dao;

import ec.gob.cne.ws.crud.dao.impl.DaoImpl;
import ec.gob.cne.ws.modelo.Gobernante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ezamora
 */
@Stateless
public class GobernanteDao extends DaoImpl<Gobernante> {

    public List<Gobernante> getAllGobernates() throws Exception {
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("usuario", usuario.getUsrUsuario());
        List<Gobernante> gobernates = new ArrayList<>();
        gobernates = getDao().listarPorConsultaJpaNombrada(Gobernante.GET_ALL_GOBERNATES, null);
        if (gobernates.isEmpty()) {
            return new ArrayList<>();
        } else {
            return gobernates;
        }

    }

  
}
