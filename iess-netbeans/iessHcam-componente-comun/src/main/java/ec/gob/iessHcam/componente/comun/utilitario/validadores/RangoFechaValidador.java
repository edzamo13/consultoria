/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.validadores;

import ec.gob.iessHcam.componente.comun.utilitario.FechasUtil;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;



/**
 * <b> Valida entre dos calendar un rango de fechas. </b>
 * <p>
 * Para utilizar esto se debe especificar en los p:calendar de la fecha de inicio el evento ajax.+ {@code <p:ajax event="dateSelect" update="endDate" />}
 * 
 * </p>
 * <p>
 * En el p:calendar de la fecha fin se debe especificar lo sigueinte: {@code <f:attribute name="fechaInicio" value="# myBean.fechaInicio}" /> <br/>
 * <f:validator validatorId="primeDateRangeValidator" />}
 * </p>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 4/11/2015 $]
 *          </p>
 */
@FacesValidator("rangoFechasValidador")
public class RangoFechaValidador extends ValidadorBase {

    private static final long serialVersionUID = 4578459789402851345L;

    /*
     * (non-Javadoc)
     * @see ec.gob.iess.componente.comun.utilitario.validadores.ValidadorBase#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return;
        }

        // Leave the null handling of startDate to required="true"
        Object startDateValue = component.getAttributes().get("fechaInicio");
        if (startDateValue == null) {
            return;
        }
        Date startDate = (Date) startDateValue;
        Date endDate = (Date) value;
        if (endDate.before(startDate)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "La fecha final: " + FechasUtil.formateadorfechaAString(ComunEnum.PATRON_FECHA5.getDescripcion(), endDate) + " debe ser mayor que la fecha de inicio: "
                    + FechasUtil.formateadorfechaAString(ComunEnum.PATRON_FECHA5.getDescripcion(), startDate), "La fecha final: " + FechasUtil.formateadorfechaAString(ComunEnum.PATRON_FECHA5.getDescripcion(), endDate) + " debe ser mayor que la fecha de inicio: "
                    + FechasUtil.formateadorfechaAString(ComunEnum.PATRON_FECHA5.getDescripcion(), startDate)));

        }

    }
}
