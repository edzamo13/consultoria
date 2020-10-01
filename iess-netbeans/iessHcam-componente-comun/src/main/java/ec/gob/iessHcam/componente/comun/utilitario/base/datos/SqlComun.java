/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.componente.comun.utilitario.base.datos;

/**
 *
 * @author root
 */
public class SqlComun {
    
    public static String CONSULTA_CODIGO_METODOS_SERVICIOS = "select MS_URL from SEG_METODOSXSERVICIO_TBL MS WHERE MS.MS_CODIGO = ?";
    
    public static final String OBTENER_METODO_X_SERVICIO_WEB = "Select * from seguridad.seg_metodosxservicio_tbl ms where ms.ms_estado='A' and ms.ms_codigo= ?";

}
