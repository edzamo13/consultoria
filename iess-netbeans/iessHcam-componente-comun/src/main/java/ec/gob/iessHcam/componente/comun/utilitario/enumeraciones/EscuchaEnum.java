/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeración a ocuparse unicamente con los servicios de escucha para el
 * proceso de autenticación </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: fochoac $, $Date: 28/8/2015 $]
 * </p>
 */
public enum EscuchaEnum {
    CREDENCIAL_OBJETO_SESION("CREDENCIALES"),
    LISTA_CIRUGIA_OBJETO_SESION("DatosListaCirugia"),
    ENFERMERIA_DATOS_PACIENTE_HOSPITALIZADO("PACIENTEHOSPITALIZADO"),
    ENFERMERIA_DATOS_PACIENTE_CEXTERNA("PACIENTECONSULTAEXTERNA"),
    PERFIL_OBJETO_SESION("PERFILES"),;

    @Getter
    private String objeto;
    public static final Integer TIEMPO_ESPERA = 30;
    public static final Integer TIEMPO_ESPERA_SERVLET_MILISEGUNDOS = 30000;

    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]</p>
     *
     * @param objeto cadena
     */
    private EscuchaEnum(String objeto) {
        this.objeto = objeto;
    }
}
