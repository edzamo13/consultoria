/* 
 * Copyright 2010 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
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
 * <b> Clase para ejecutar validaciones jsf sobre el telefono de la persona dado el ingreso del numero de digitos </b>
 * <p>
 * Ejemplo de uso:
 * </p>
 * 
 * <pre>
 * {@code 
 * <h:inputText value="# bean.field}">
 * <f:validator validatorId="telefonoValidador" />
 *  <f:attribute name="numeroDigitos" value="<b>numeroDigitos</b>" />
 * </h:inputText>
 * }
 * </pre>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
@FacesValidator("telefonoValidador")
public class TelefonoValidador extends ValidadorBase {

    /**
    * 
    */
    private static final long serialVersionUID = -6997219920645742043L;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        Integer numeroDigitos = NumerosUtil.convertirCadenaNumero(component.getAttributes().get("numeroDigitos").toString());
        if (!verificarNumero((String) value, numeroDigitos) && NumerosUtil.validarNumeroEntero((String) value)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ComunEnum.MENSAJE_ERROR_VALIDA_TELEFONO.getDescripcion(), ComunEnum.MENSAJE_ERROR_VALIDA_TELEFONO.getDescripcion()));

        }
    }

    /**
     * <b> Metodo para validar un numero telefonico a partir del tamanio del numero que se ingresa como parametro en la pagina jsf. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param valor
     *            cadena a validar
     * @param tamanio
     *            del numeor de telefonos a validar
     * @return true si esta correcto
     */

    private static final boolean verificarNumero(String valor, Integer tamanio) {
        if (null != tamanio && tamanio.intValue() > 0) {
            return valor.matches("\\d{" + tamanio.intValue() + "}");
        } else {
            return false;
        }

    }

}