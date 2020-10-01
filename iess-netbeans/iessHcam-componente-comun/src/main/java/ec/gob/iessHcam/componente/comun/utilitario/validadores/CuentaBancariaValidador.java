/* 
 * Copyright 2010 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.validadores;

import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;



/**
 * <b> Clase para ejecutar validaciones jsf sobre la cuenta bancaria de la persona. </b>
 * <p>
 * Ejemplo de uso:
 * </p>
 * <pre>
 * {@code <h:inputText value="# bean.field}">
 *  <f:validator validatorId="cuentaBancoValidador" />
 *  </h:inputText>
 *  } </p>
 * </pre>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
@FacesValidator("cuentaBancoValidador")
public class CuentaBancariaValidador extends ValidadorBase {

    /**
    * 
    */
    private static final long serialVersionUID = 2835349062805544809L;

    @Override
    public void validate(FacesContext context, UIComponent uIcomponent, Object value) {
        if (!verificarNumeroCuenta(value.toString())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ComunEnum.MENSAJE_ERROR_CUENTA_BANCARIA.getDescripcion(),
                    ComunEnum.MENSAJE_ERROR_CUENTA_BANCARIA.getDescripcion()));

        }
    }

    /**
     * <b> Metodo utilitario para verificar el numero de cuenta bancaria. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param valor
     *            cadena de texto a validar
     * @return true si esta correcto
     */
    private static final boolean verificarNumeroCuenta(String valor) {

        String valorVerificar = valor.trim();
        if (valor.trim().isEmpty())
            return false;

        String textoPorValidar = valorVerificar;
        Pattern p = Pattern.compile(ComunEnum.PATRON_VALIDA_CUENTA_BANCARIA.getDescripcion());
        Matcher m = p.matcher(textoPorValidar);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
}