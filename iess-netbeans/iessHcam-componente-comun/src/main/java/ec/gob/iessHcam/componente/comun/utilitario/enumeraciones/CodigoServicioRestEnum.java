/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para listar los tipos de servicios JSON registrados en el IESS. </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 13/11/2015 $]
 *          </p>
 */
public enum CodigoServicioRestEnum {

    /**
     * Servicio para: Lista los menús de los aplicativos.
     */
    ACCMEN_001("iess-ws-acceso-menu", "ACCMEN-001", "listarMenus"),
    /**
     * Servicio para: Obtener los datos del usuario logeado.
     */
    ACCMEN_002("iess-ws-acceso-menu", "ACCMEN-002", "obtenerDatosLogeo"),
    /**
     * Servicio para: Lista las aplicaciones segun el o los roles del usuario.
     */
    ACCMEN_003("iess-ws-acceso-menu", "ACCMEN-003", "listarAplicaciones"),
    /**
     * Servicio para: Obtener la imagen de la aplicacion en base 64.
     */
    ACCMEN_004("iess-ws-acceso-menu", "ACCMEN-004", "obtenerImagenAplicacion"),
    /**
     * Servicio para: Lista las empresas del afiliado.
     */
    INFAFI_003("iess-ws-afiliado", "INFAFI-003", "listarEmpresasAfiliado"),
    /**
     * Servicio para: Lista los empleadores activos en los que se encuentra el afiliado.
     */
    INFAFI_005("iess-ws-afiliado", "INFAFI-005", "listarEmpleadoresActivos"),
    /**
     * Servicio para: Obtiene la información del afiliado.
     */
    INFAFI_001("iess-ws-afiliado", "INFAFI-001", "obtenerDatosAfiliado"),
    /**
     * Servicio para: Obtiene la información del último empleador del afiliado.
     */
    INFAFI_004("iess-ws-afiliado", "INFAFI-004", "obtenerUltimoEmpleador"),
    /**
     * Servicio para: Lista las empresas del afiliado por fecha.
     */
    INFAFI_002("iess-ws-afiliado", "INFAFI-002", "listarEmpresaPorFecha"),
    /**
     * Servicio para: Lista la información del afiliado Host.
     */
    HOSAFI_001("iess-ws-afiliado-host", "HOSAFI-001", "listarAfiliadosHostPorCedula"),
    /**
     * Servicio para: Lista la información del detalle del catálogo.
     */
    INFCAT_001("iess-ws-catalogo", "INFCAT-001", "listarCatalogo"),
    /**
     * Servicio para: Lista la información del detalle del catálogo del host.
     */
    INFCAT_002("iess-ws-catalogo", "INFCAT-002", "listarCatalogoHost"),
    /**
     * Servicio para: Obtiene la información de cuentas bancarias.
     */
    CUEBAN_001("iess-ws-cuenta-bancaria", "CUEBAN-001", "obtenerCuentaBancaria"),
    /**
     * Servicio para: Obtiene la división politica por código.
     */
    DIVPOL_003("iess-ws-division-politica", "DIVPOL-003", "obtenerDivisionesPorCodigo"),
    /**
     * Servicio para: Obtiene la división politica por código y texto.
     */
    DIVPOL_004("iess-ws-division-politica", "DIVPOL-004", "obtenerDivisionTextoPorCodigo"),
    /**
     * Servicio para: Obtiene la información de las provincias.
     */
    DIVPOL_001("iess-ws-division-politica", "DIVPOL-001", "obtenerProvincias"),
    /**
     * Servicio para: Obtiene la información de la división politica.
     */
    DIVPOL_002("iess-ws-division-politica", "DIVPOL-002", "obtenerDivisionesPoliticas"),
    /**
     * Servicio para: Obtiene la información de la relación de trabajo.
     */
    INFEMP_001("iess-ws-empleador", "INFEMP-001", "obtenerRelacionTrabajo"),
    /**
     * Servicio para: Obtiene la información del tipo de empleador.
     */
    INFEMP_003("iess-ws-empleador", "INFEMP-003", "obtenerTipoEmpleador"),
    /**
     * Servicio para: Obtiene la información del empleador.
     */
    INFEMP_002("iess-ws-empleador", "INFEMP-002", "obtenerEmpleador"),
    /**
     * Servicio para: Obtiene la información de la sucursal.
     */
    INFEMP_005("iess-ws-empleador", "INFEMP-005", "obtenerSucursal"),
    /**
     * Servicio para: Lista la información de los bancos.
     */
    INFEMP_004("iess-ws-empleador", "INFEMP-004", "listarBancos"),
    /**
     * Servicio para: Permite envia mail de forma asincrona.
     */
    ENVMAI_004("iess-ws-envio-mail", "ENVMAI-004", "enviarMail"),
    /**
     * Servicio para: Permite envia mail de forma normal.
     */
    ENVMAI_002("iess-ws-envio-mail", "ENVMAI-002", "enviarMail"),
    /**
     * Servicio para: Permite enviar mails en grupo de forma asíncrona.
     */
    ENVMAI_001("iess-ws-envio-mail", "ENVMAI-001", "enviarListaMail"),
    /**
     * Servicio para: Permite enviar mails en grupo de forma normal.
     */
    ENVMAI_003("iess-ws-envio-mail", "ENVMAI-003", "enviarListaMail"),
    /**
     * Servicio para: Lista las novedades de un afiliado.
     */
    INFNOV_001("iess-ws-novedad", "INFNOV-001", "listarNovedad"),
    /**
     * Servicio para: Obtiene la información si es jubilado.
     */
    INFPEN_005("iess-ws-pensiones-jubilado", "INFPEN-005", "esJubilado"),
    /**
     * Servicio para: Obtiene la información si es jubilable.
     */
    INFPEN_002("iess-ws-pensiones-jubilado", "INFPEN-002", "esJubilable"),
    /**
     * Servicio para: Obtiene la información de las imposiciones.
     */
    INFPEN_001("iess-ws-pensiones-jubilado", "INFPEN-001", "obtenerNumeroImposiciones"),
    /**
     * Servicio para: Obtiene la información de prestaciones en HL.
     */
    INFPEN_004("iess-ws-pensiones-jubilado", "INFPEN-004", "existenPrestacionesHl"),
    /**
     * Servicio para: Obtiene la información de prestaciones en el host.
     */
    INFPEN_003("iess-ws-pensiones-jubilado", "INFPEN-003", "existenPrestacionesHost"),
    /**
     * Servicio para: Obtiene la información de los dependientes de una persona.
     */
    PERDEP_001("iess-ws-persona-dependiente", "PERDEP-001", "obtenerPorNumeroDocumento"),
    /**
     * Servicio para: Obtiene la información de la politica corporativa.
     */
    POLCOR_002("iess-ws-politica-corporativa", "POLCOR-002", "obtenerPoliticaCorporativa"),
    /**
     * Servicio para: Obtiene la información del salario mínimo vigente.
     */
    POLCOR_001("iess-ws-politica-corporativa", "POLCOR-001", "obtenerSalarioMinimo"),
    /**
     * Servicio para: Obtiene la información de los parametros del compoennete de seguridad.
     */
    POLCOR_003("iess-ws-politica-corporativa", "POLCOR-003", "obtenerParametroSeguridad"),
    /**
     * Servicio para: Obtiene la información de la persona en el Registro Civil.
     */
    REGCIV_003("iess-ws-registro-civil", "REGCIV-003", "obtenerDatosPersonaNombre"),
    /**
     * Servicio para: Obtiene la información de la persona en el Registro Civil.
     */
    REGCIV_002("iess-ws-registro-civil", "REGCIV-002", "obtenerDatosPersona"),
    /**
     * Servicio para: Obtiene la información si el número de documento es extranjero.
     */
    REGCIV_001("iess-ws-registro-civil", "REGCIV-001", "obtenerDocumentoExtranjero"),
    /**
     * Servicio para: Obtiene la información por cédula del registro civil para entidades externas.
     */
    RCEXTE_001("iess-ws-registro-civil-externo", "RCEXTE-001", "obtenerPorCedula"),
    /**
     * Servicio para: Obtiene la información del reporte para poder generarlo.
     */
    GENREP_001("iess-ws-reportes-itext", "GENREP-001", "obtenerReporte"),
    /**
     * Servicio para: Obtiene la información de la tabla de errores.
     */
    UTIGEN_001("iess-ws-utilitario-generico", "UTIGEN-001", "obtenerError"),
    /**
     * Servicio para: Permite insertar la trama, para que se puedan conectar los aplicativos.
     */
    INFTRA_002("iess-ws-validar-autentificacion", "INFTRA-002", "insertarExpiracionTrama"),
    /**
     * Servicio para: Valida la trama enviada, para el ingreso a los aplicativos.
     */
    INFTRA_001("iess-ws-validar-autentificacion", "INFTRA-001", "validarTrama"),
    /**
     * Servicio para: Obtiene la información del certificado médico.
     */
    INFCER_001("iess-ws-certificado", "INFCER-001", "listarCertificado"),
    /**
     * Servicio para: Obtiene la información de los días de los certificados médicos.
     */
    INFCER_002("iess-ws-certificado", "INFCER-002", "listarCertificadoDias"),
    /**
     * Servicio para: Lista la información de los requisitos de acuerdo al código.
     */
    INFCAT_004("iess-ws-catalogo", "INFCAT-004", "listarRequisito"),
    /**
     * Servicio para: Lista la información del detalle del catálogo de parámetros.
     */
    INFCAT_003("iess-ws-catalogo", "INFCAT-003", "listarCatalogoParametro"),
    /**
     * Servicio para: Verifica si el usuario esta logeado dependiendo de la ip y el navegador.
     */
    LOGUNI_001("iess-ws-logeo-unico", "LOGUNI-001", "existeSesionIpNavegador"),
    /**
     * Servicio para: Cierra la sesion actualizando la tabla de eventos.
     */
    LOGUNI_002("iess-ws-logeo-unico", "LOGUNI-002", "eventoCerrarSesion"),
    /**
     * Servicio para: Consolida los aportes del afiliado.
     */
    INFAPO_001("iess-ws-aporte", "INFAPO-001", "consolidarAportesAfiliado"),
    /**
     * Servicio para: Calcula los cienco mejores anios de las aportaciones del afiliado.
     */
    SISPEN_001("iess-ws-pension", "SISPEN-001", "obtenerCincoMejoresAnios"),
    /**
     *
     */
    INAUDI_001("iess-ws-auditoria", "INAUDI-001", "registrarAuditoriaMenu"),
    /**
     *
     */
    PENPRE_001("iess-ws-pensiones-prestacion", "PENPRE-001", "listarPrestacionesIngresosAseguradoHl"),
    /**
     *
     */
    PENPRE_002("iess-ws-pensiones-prestacion", "PENPRE-002", "listarPrestacionesIngresosAseguradoHost"),
    /**
     *
     */
    PENPRE_003("iess-ws-pensiones-prestacion", "PENPRE-003", "listarPrestacionesIngresosAseguradoPorHostOrigen"),
    /**
     *
     */
    INFAFI_007("iess-ws-afiliado", "INFAFI-007", "obtenerInformacionBdh"),
    /**
     *
     */
    INFCAT_005("iess-ws-catalogo", "INFCAT-005", "obtenerCatalogoError"),
    /**
    * 
    */
    PERDEP_002("iess-ws-persona-dependiente", "PERDEP-002", "obtenerPersona"),
    /**
    * 
    */
    INFCAT_006("iess-ws-catalogo", "INFCAT-006", "obtenerUrlServicio"),
    /**
    * 
    */
    GAPROC_001("iess-ws-ga-procesos", "GAPROC-001", "listarSectores"),
    /**
    * 
    */
    GAAUTE_001("iess-ws-ga-logueo", "GAAUTE-001", "validarUsuario"),
    /**
            * 
            */
    CALDER_001("iess-ws-califica-derecho", "CALDER-001", "obtenerCalificacionSalud"),
    /**
            * 
            */
    GAASPR_001("iess-ws-ga-as400", "GAASPR-001", "consultarDisponibilidadCitasMedicas"),
    /**
            * 
            */
    GAPROC_002("iess-ws-ga-procesos", "GAPROC-002", "obtenerUltimoAgendamiento"),
    /**
            * 
            */
    GAASPR_002("iess-ws-ga-as400-1.0", "GAASPR-002", "listarCitaMedicaPorCedulaYFecha"),
    /**
            * 
            */
    GAASPR_003("iess-ws-ga-as400-1.0", "GAASPR-003", "cancelarCitaMedica"),
    /**
            * 
            */
    GAASPR_004("iess-ws-ga-as400-1.0", "GAASPR-004", "consultarHorariosCitaMedica"),
    /**
            * 
            */
    GAASPR_005("iess-ws-ga-as400-1.0", "GAASPR-005", "agendarCitaMedica"),
    /**
            * 
            */
    INFSUB_001("iess-ws-subsidio", "INFSUB-001", "listarSolicitudSubsidio"),
    /**
            * 
            */
    INFSUB_002("iess-ws-subsidio", "INFSUB-002", "listarPagoSubsidio"),
    /**
            * 
            */
    INFSUB_003("iess-ws-subsidio", "INFSUB-003", "listarLiquidacionDetalle"),
    /**
            * 
            */
    INFSUB_004("iess-ws-subsidio", "INFSUB-004", "listarDetallePago"),
    /**
            * 
            */
    INFSUB_005("iess-ws-subsidio", "INFSUB-005", "listarValorDisponible"),
    /**
            * 
            */
    LOGANT_001("iess-ws-logueo-anterior", "LOGANT-001", "validarUsuario"),
    /**
            * 
            */
    LOGANT_002("iess-ws-logueo-anterior", "LOGANT-002", "listarValorDisponible");

    @Getter
    private String nombre;
    @Getter
    private String codigo;
    @Getter
    private String metodo;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 13/11/2015]
     * </p>
     *
     * @param nombre
     *            del servicio
     * @param codigo
     *            del servicio
     * @param metodo
     *            del servicio
     */
    private CodigoServicioRestEnum(final String nombre, final String codigo, final String metodo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.metodo = metodo;
    }

}
