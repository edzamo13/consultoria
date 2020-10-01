/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

import ec.gob.iessHcam.componente.comun.utilitario.NumerosUtil;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;

/**
 * <b> Clase para ejecutar validaciones jsf sobre la cedula de la persona. </b>
 * <p>
 * Ejemplo de uso:
 * </p>
 * <pre>
 * 
 * <code><h:inputText value="# bean.field}"></code>
 * <code><f:validator validatorId="cedulaValidador" /></code>
 * <code></h:inputText></code>
 *
 * </pre>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
@FacesValidator("cedulaValidador")
public class CedulaValidador extends ValidadorBase {

    /**
    * 
    */
    private static final long serialVersionUID = 1794233699415245186L;

    @Override
    public void validate(FacesContext contexto, UIComponent componente, Object valor) {

        if (!verificarCedula(valor.toString())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ComunEnum.MENSAJE_ERROR_CEDULA_INVALIDA.getDescripcion(),
                    ComunEnum.MENSAJE_ERROR_CEDULA_INVALIDA.getDescripcion()));
        }

    }

    /**
     * <b> Metodo para validar el formato de la cedula de la persona </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cedula
     *            de la persona
     * @return true si esta correcto y false si no lo es
     */
    public static boolean verificarCedula(String cedula) {

        if (NumerosUtil.validarNumeroEntero(cedula)) {
            return ejecutarValidacionCedula(cedula);
        } else {
            return false;
        }

    }

    /**
     * <b> Metodo utilitario para ejecutar la validacion de la cedula. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cedula
     *            de la persona
     * @return true si es valido
     */
    private static final boolean ejecutarValidacionCedula(String cedula) {
        Integer resultado = new Integer(0);
        Integer[] resultados = NumerosUtil.convertirCadenaArrayNumeros(cedula);
        if (resultados.length <= 0) {
            return false;
        }
        for (int i = 0; i < resultados.length - 1; i++) {
            Integer numero = resultados[i];
            if ((i % 2) == 0) {
                if ((numero * 2) > 9) {
                    resultado = resultado + ((numero * 2) - 9);
                } else {
                    resultado = resultado + (numero * 2);
                }
            } else {
                resultado = resultado + numero;
            }
        }
        resultado = resultado + resultados[9];
        return (resultado % 10) == 0;

    }
}