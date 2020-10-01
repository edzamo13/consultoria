/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.validadores;

import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;


/**
 * <b> CLase para validar una ip version 4 o 6. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 4/11/2015 $]
 *          </p>
 */
@FacesValidator("ipValidador")
public class IPValidador extends ValidadorBase {

    private static final long serialVersionUID = -7278538495292634499L;
    private static final Pattern IPV4_PATRON = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern IPV6_PATRON_NORMAL = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_PATRON_COMPRIMIDO = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    /*
     * (non-Javadoc)
     * @see ec.gob.iess.componente.comun.utilitario.validadores.ValidadorBase#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return;
        }
        if (!validarIP(value.toString())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ComunEnum.MENSAJE_ERROR_VALIDA_IP.getDescripcion(), ComunEnum.MENSAJE_ERROR_VALIDA_IP.getDescripcion()));

        }

    }

    /**
     * <b> Metodo utilitario para validar si la direccion es de tipo IPv4. </b>
     * <p>
     * [Author: fochoac, Date: 4/11/2015]
     * </p>
     *
     * @param ipv4
     * @return
     */
    private boolean validarIPv4(String ipv4) {
        return IPV4_PATRON.matcher(ipv4).matches();
    }

    /**
     * <b> Metodo utilitario para validar si la direccion es de tipo IPv6 comprimida. </b>
     * <p>
     * [Author: fochoac, Date: 4/11/2015]
     * </p>
     *
     * @param ipv6
     *            direccion
     * @return true o false
     */
    private boolean validarIPv6Extendida(final String ipv6) {
        return IPV6_PATRON_NORMAL.matcher(ipv6).matches();
    }

    /**
     * <b> Metodo utilitario para validar si la direccion es de tipo IPv6 esatndar. </b>
     * <p>
     * [Author: fochoac, Date: 4/11/2015]
     * </p>
     *
     * @param ipv6
     *            direccion
     * @return true o false
     */
    private boolean validarIPv6Comprimida(final String ipv6) {

        return IPV6_PATRON_COMPRIMIDO.matcher(ipv6).matches();
    }

    /**
     * <b> Metodo utilitario para validar si la direccion es de tipo IPv6 . </b>
     * <p>
     * [Author: fochoac, Date: 4/11/2015]
     * </p>
     *
     * @param ip
     *            direccion ip v5 o v6
     * @return true o false
     */
    private final boolean validarIP(final String ip) {
        return validarIPv4(ip) || validarIPv6Extendida(ip) || validarIPv6Comprimida(ip);
    }

}
