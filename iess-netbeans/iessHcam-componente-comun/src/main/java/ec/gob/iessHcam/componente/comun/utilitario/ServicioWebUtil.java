/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.util.List;

import javax.persistence.Query;

/**
 *
 * @author root
 */
public class ServicioWebUtil{
    public static String obtenerUrlServicio(Query query, String codigoServicio){
        query.setParameter(1, codigoServicio);
        List<Object> resultado = query.getResultList();
        if(resultado != null && !resultado.isEmpty()){
            return resultado.get(0).toString();
        }else{
            return null;
        }
    }
}
