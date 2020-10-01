/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
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
 * <b> Clase para ejecutar validaciones jsf sobre la correo electronico de la persona. </b>
 * <p>
 * Ejemplo de uso:
 * </p>
 * <pre>
 * {@code <h:inputText value="# bean.field}">
 *  <f:validator validatorId="correoValidador" />
 *  </h:inputText>
 *  }
 * </pre>
 * 
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
@FacesValidator("correoValidador")
public class CorreoElectronicoValidador extends ValidadorBase {

    /**
    * 
    */
    private static final long serialVersionUID = 8458690169024728906L;

    @Override
    public void validate(FacesContext context, UIComponent uIcomponent, Object value) {

        if (!verificarEmail(value.toString())) {

            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ComunEnum.MENSAJE_ERROR_VALIDA_CORREO.getDescripcion(),
                    ComunEnum.MENSAJE_ERROR_VALIDA_CORREO.getDescripcion()));

        }
    }

    /**
     * <b> Metodo utilitario para ejecutar la validacion de la cedula. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param valor
     *            cadena de texto a validar
     * @return true si esta correcto
     */
    private static final boolean verificarEmail(String valor) {
        if (null != valor && !valor.isEmpty()) {

            Pattern p = Pattern.compile(ComunEnum.PATRON_VALIDA_CORREO.getDescripcion());
            Matcher m = p.matcher(valor);
            boolean matchFound = m.matches();

            if (!matchFound) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }
}