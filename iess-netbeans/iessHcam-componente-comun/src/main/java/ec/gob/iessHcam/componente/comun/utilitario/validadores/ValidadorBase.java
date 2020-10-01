/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.validadores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

/**
 * <b> Clase generica para gestionar la validacion sobre componentes de JSF </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
public abstract class ValidadorBase implements Validator, Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = -3200043166813231904L;

    @Override
    public abstract void validate(FacesContext context, UIComponent component, Object value);

}