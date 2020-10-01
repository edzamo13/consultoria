/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Codigos de error para respuestas en servicios web del IESS. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 4/8/2015 $]
 *          </p>
 */
public enum CodigoRetornoEnum {

    CORRECTO("1", "OK"), ERROR("2", "EXCEPCIÓN"), USUARIO_INCORRECTO("3", "USUARIO Y/O CLAVE NO EXISTE"), INFORMACION_NO_EXISTE(
            "4", "INFORMACIÓN SOLICITADA NO EXISTE"), EXCEPCION_CONTROLADA("5", "EXCEPCIÓN CONTROLADA");
    @Getter
    private String codigo;
    @Getter
    private String mensaje;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param codigo
     *            de retorno
     * @param mensaje
     *            de retorno
     */
    private CodigoRetornoEnum(final String codigo, final String mensaje) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    /**
     * <b> Metodo utilitario para validar la resṕuesta del servicio web en base al codigo y un mensaje. </b>
     * <p>
     * [Author: fochoac, Date: 17/8/2015]
     * </p>
     *
     * @param codigo
     *            de la respuesta del servicio web
     * @param mensajeEnviar
     *            en caso de caer en el error de CodigoRetornoEnum
     * @return Código no valido en caso de no estar el código en la enumeracion,
     */
    public static final String validarRespuesta(final String codigo, final String mensajeEnviar) {
        String respuesta = "Código no válido";
        ;
        switch (codigo) {
        case "1":
            respuesta = null;
            break;
        case "2":
            respuesta = ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion();
            break;

        case "4":
            respuesta = mensajeEnviar;

            break;
        case "5":
            respuesta = mensajeEnviar;
            break;

        default:
            respuesta = "El servicio no esta disponible";
            break;
        }
        return respuesta;
    }

}
