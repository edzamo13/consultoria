
package ec.com.vitalgym.util;

import java.math.RoundingMode;
import java.util.Locale;
import java.util.TimeZone;

import lombok.Getter;

/**
 * <b> Clase para manejar valores constantes genericos para todos los aplicativos. </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
public enum ComunEnum {

    /**
     * Constante para mostrar: Registro actualizado.
     */
    REGISTRO_ACTUALIZADO("Registro actualizado."),
    /**
     * Constante para mostrar: Error al actualizar el registro, por favor intente nuevamente más tarde.
     */
    ERROR_REGISTRO_ACTUALIZADO("Error al actualizar el registro, por favor intente nuevamente más tarde."),
    /**
     * Constante para mostrar: Error al recuperar el registro, por favor intente nuevamente más tarde.
     */
    ERROR_RECUPERAR_REGISTRO("Error al recuperar el registro, por favor intente nuevamente más tarde."),
    /**
     * Constante para mostrar: Usuario no existe.
     */
    USUARIO_NO_EXISTENTE("Usuario no existe."),
    /**
     * Constante para mostrar: Seleccione
     */
    SELECCIONE("Seleccione"),
    /**
     * Constante para mostrar: Usuario ya existe.
     */
    USUARIO_EXISTENTE("Usuario ya existe."),
    /**
     * Constante para mostrar: Url no existe.
     */
    ERROR_REDIRECCION("Url no existe."),
    /**
     * Constante para mostrar: No se puede cerrar la sesión.
     */
    ERROR_CERRAR_SESION("No se puede cerrar la sesión."),
    /**
     * Constante para mostrar: 1
     */
    EXITO("1"),
    /**
     * Constante para mostrar: 0
     */
    NO_EXITO("0"),
    /**
     * Constante para mostrar: Error al inicializar los datos de la pantalla, intente mas tarde.
     */
    MENSAJE_ERROR_INICIALIZACION("Error al inicializar los datos de la pantalla, intente mas tarde."),
    /**
     * Constante para mostrar: Falló la operación, intente mas tarde.
     */
    MENSAJE_ERROR_FALLO_OPERACION("Falló la operación, intente mas tarde."),
    /**
     * Constante para mostrar: La operación se realizó con éxito.
     */
    MENSAJE_INFO_OPERACION_EXITOSA("La operación se realizó con éxito."),
    /**
     * Constante para mostrar: Cédula Inválida
     */
    MENSAJE_ERROR_CEDULA_INVALIDA("Cédula Inválida"),
    /**
     * Constante para mostrar: Cuenta bancaria inváĺida
     */
    MENSAJE_ERROR_CUENTA_BANCARIA("Cuenta bancaria inváĺida"),
    /**
     * Patron para validar una cuenta bancaria: [0-9]+
     */
    PATRON_VALIDA_CUENTA_BANCARIA("[0-9]+"),
    /**
     * Patron de fecha en formato yyyy/MM/dd
     */
    PATRON_FECHA1("yyyy/MM/dd"),
    /**
     * Patron de fecha en formato yyyyMMdd
     */
    PATRON_FECHA2("yyyyMMdd"),
    /**
     * Patron de fecha en formato yyyyMM
     */
    PATRON_FECHA3("yyyyMM"),
    /**
     * Patron de fecha en formato yyyy-MM
     */
    PATRON_FECHA4("yyyy-MM"),
    /**
     * Patron de fecha en formato dd/MM/yyyy hh:mm:ss
     */
    PATRON_TIMESTAMP("dd/MM/yyyy hh:mm:ss"),
    /**
     * Patron de fecha en formato dd/MM/yyyy
     */
    PATRON_FECHA5("dd/MM/yyyy"),
    /**
     * Patron de fecha en formato d/M/yy H:mm:ss.SSS
     */
    PATRON_TIMESTAMP_PERIODO("d/M/yy H:mm:ss.SSS"),
    /**
     * Ptron de fecha en formato yyyy-MM-dd
     */
    PATRON_FECHA6("yyyy-MM-dd"),
    /**
     * Patron para validar una cuenta de correo electronico
     */
    PATRON_VALIDA_CORREO("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
    /**
     * Constantre para mostrar: La cuenta de correo electronica ingresada no es válida
     */
    MENSAJE_ERROR_VALIDA_CORREO("La cuenta de correo electrónica ingresada no es válida."),
    /**
     * Constante para mostrar: El número de teléfono ingresado no es válido.
     */
    MENSAJE_ERROR_VALIDA_TELEFONO("El número de teléfono ingresado no es válido."),
    /**
     * Constante para mostrar:La dirección ip ingresada no es válida.
     */
    MENSAJE_ERROR_VALIDA_IP("La dirección ip ingresada no es válida."),

    /**
     * Constantes para mostrar: El alfabeto en minusculas sin la ñ
     */
    ALFABETO_BASICO("abcdefghijklmnopqrstuvwxyz"),
    /**
     * Constantes para mostrar: El alfabeto numerico
     */
    ALFABETO_NUMERICO("0123456789"),
    /**
     * Constantes para mostrar: El alfabeto en minusculas sin la ñ mas el alfabeto numerico
     */
    ALFABETO_COMPLETO(ALFABETO_BASICO.getDescripcion() + ALFABETO_NUMERICO.getDescripcion()),
    /**
     * Constantes para mostrar: Usuario ó clave incorrecta.
     */
    MENSAJE_ERROR_INGRESO("Usuario ó clave incorrecta."),
    /**
     * Constantes para mostrar: El servicio solicitado no se encuentra disponible, por favor intente más tarde.
     */
    MENSAJE_ERROR_PING("El servicio solicitado no se encuentra disponible, por favor intente más tarde."),
    /**
     * Constantes para mostrar: La base de datos no esta disponible, por favor intente más tarde
     */
    MENSAJE_ERROR_BASE_NO_DISPONIBLE("La base de datos no esta disponible, por favor intente más tarde"), MENSAJE_ERROR_ENTRADA_WS_INVALIDA("Los datos de entrada son invalidos"),
    /**
     * Constantes para mostrar: MENSAJE DE AUTENCIACION OK
     */
    AUTENTICACION_OK("OK"), ES_CODIGO_QR_REPORTE("esCodigoQr"), ES_IMAGEN_REPORTE("esImagen"),
    /**
     * Constantes para mostrar: E (EXITOSO)
     */
    TIPO_EVENTO_LOGUEO_EXITOSO("E"),
    /**
     * Constantes para mostrar: F (FALLIDO)
     */
    TIPO_EVENTO_LOGUEO_FALLIDO("F"),
    /**
     * Constantes para mostrar: SI
     */
    SI("SI"),
    /**
     * Constantes para mostrar: NO
     */
    NO("NO");
    @Getter
    private String descripcion;

    /**
     * Constante del TIMEZONE para Ecuador
     */
    public static final TimeZone TIMEZONE_ECUADOR = TimeZone.getTimeZone("America/Guayaquil");

    /**
     * Constante del LOCALE para Ecuador
     */
    public static final Locale LOCALE_ECUADOR = new Locale("es_EC");

    /**
     * Constante para numero de decimales para calculos de montos de dinero
     */
    public static final int NUMERO_DECIMALES = 2;

    /**
     * Constante para modo de redondeo para numeros decimales
     */
    public static final RoundingMode MODO_REDONDEO = RoundingMode.HALF_UP;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param descripcion
     *            de la constante
     */
    private ComunEnum(String descripcion) {
        this.descripcion = descripcion;
    }
}
