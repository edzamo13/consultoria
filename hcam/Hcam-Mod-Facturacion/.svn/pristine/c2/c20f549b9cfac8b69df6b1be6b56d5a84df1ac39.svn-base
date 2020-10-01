/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.CodigoUnidMedica;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class ObtenerUnidadMedicaService extends Basica implements ObtenerUnidadMedicaServiceRemote {

    @Override
    public List<CodigoUnidMedica> obtenerNivelTarifario(){
        
        String sqlNivelTarifario="SELECT A.CTUMIDPK AS CTUMIDPK, A.UNIDPK AS IDUNIDMED, B.UNCODIGO AS CODIGO, C.CTIDPK AS NIVEL, B.UBICAPK AS IDUBICA FROM FACWEB.CT_UMTBL A JOIN FACWEB.UNIDMEDTBL B ON A.UNIDPK = B.UNIDPK JOIN FACWEB.CABTARITBL C ON A.CTIDPK = C.CTIDPK WHERE A.CTUMEST =:estado";
        Map<String, Object> paramsNivel = new HashMap<>();
        paramsNivel.put("estado", 'A');
        List<CodigoUnidMedica> nivelList = queryExecutor.executeQuery(sqlNivelTarifario, paramsNivel, CodigoUnidMedica.class);
        //int pknivel= nivelList.get(0).getNivelTarifario();
        return nivelList;
    }
    
}
