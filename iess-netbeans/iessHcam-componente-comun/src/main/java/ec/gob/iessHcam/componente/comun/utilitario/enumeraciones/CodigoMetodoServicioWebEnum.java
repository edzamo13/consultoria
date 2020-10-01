/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 16/03/2016]</p>
 */
public enum CodigoMetodoServicioWebEnum {

    /**
     * Codigo Metodo ServicioWeb : Lista los pacientes Hospitalizados en el
     * Modulo de Enfermeria.
     */
    WS_IESS_HCAM_ENFERMERIA_PACIENTE_HOSPITALIZADO("obtenerPacienteEnfermeriaHO", "ENF-SW-001"),
    /**
     * Servicio para: Devuelve la lista de examenes de laboratorio de una orden
     * y unidad medica
     */
    WS_IESS_HCAM_OBTENER_EXAMENES_LABORATORIO("obtenerExamenesLaboratorio", "AS400-SW-015"),
    /**
     * Servicio para: Devuelve la lista de examenes de laboratorio de una orden
     * y unidad medica
     */
    WS_IESS_HCAM_OBTENER_EXAMENES_IMAGEN("obtenerExamenesImagen", "AS400-SW-019"),
    /**
     * Servicio para: Devuelve los datos del paciente de examenes de laboratorio
     * de una orden y unidad medica
     */
    WS_IESS_HCAM_OBTENER_PACIENTE_EXAMENES("obtenerPacienteExamenes", "AS400-SW-016"),
    /**
     * Servicio para: Devuelve los datos del afiliado con codigos de DPA
     */
    WS_IESS_HCAM_OBTENER_AFILIADO_CON_CODIGOS("obtenerAfiliadoConCodigos", "AS400-SW-017"),
    /**
     * Servicio para: Devuelve la lista de examenes de laboratorio de una orden
     * y unidad medica
     */
    WS_IESS_HCAM_OBTENER_RESULTADOS_EXAMENES_LABORATORIO("obtenerResultados", "AS400-SW-018"),
    /**
     * Servicio para: Devuelve los procedimientos de la unidad medica
     */
    WS_IESS_HCAM_OBTENER_PROCEDIMIENTOS("obtenerProcedimientos", "AS400-SW-020"),
    /**
     * Servicio para: Devuelve procedimientos por unidad medica, servicio, sub
     * servicio, nivel y procedimiento
     */
    WS_IESS_HCAM_OBTENER_PROCEDIMIENTO_CODIGOS("obtenerPProcedimientoCodigos", "AS400-SW-021"),
    /**
     * Codigo Metodo ServicioWeb : Lista Cirugia Espera obtener Usuario por
     * usario y unidaMedica.
     */
    WS_IESS_HCAM_LISTAESPERACIRUGIA_OBTENER_INFORMACION_AFILIADO("obtenerInformacionAfiliado", "LEC-01"),
    /**
     * Codigo Metodo ServicioWeb : Lista los menús de los aplicativos.
     */
    WS_IESS_HCAM_SEGURIDAD_OBTENER_APLICACION_IDAPP("obtenerAplicacionPorId", "SEG-APP-001"),
    /**
     * Codigo Metodo ServicioWeb : Lista los menús de los aplicativos.
     */
    WS_IESS_HCAM_SEGURIDAD_OBTENER_MENU("obtenerMenu", "SEG-M-001"),
    /**
     * Servicio para: Devuelve un timeStamp con la Fecha y hora Actual del
     * As400.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_CURRENT_TIMESTAMP("obtenerCurrentTimestamp", "AS400-SW-001"),
    /**
     * Servicio para: Devuelve el nombre completo de la unidad Médica por su
     * código.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_NOMBRE_UMIDAD_MEDICA("obtenerNombreUnidadMedica", "AS400-SW-002"),
    /**
     * Servicio para: Devuelve los tarifarios de cirugía de la unidad Médica
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_TARIFARIOS_CIRUGIA("obtenerTarifariosCirugia", "AS400-SW-014"),
    /**
     * Servicio para: Devuelve el nombre completo de la unidad Médica por su
     * código.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_UNIDADES_MEDICAS("obtenerUnidadesMedicas", "AS400-SW-003"),
    /**
     * Codigo Metodo ServicioWeb: Registro Civil Obtener por Cedula informacion
     */
    WS_IESS_DNTI_REGISTRO_CIVIL_OBTENER_CEDULA("obtenerPorCedula", "REG-CIVIL-SW-001"),
    /**
     * Codigo Metodo ServicioWeb: Conexion interna para busqueda de cedulas al
     * registro civil
     */
    WS_IESS_HCAM_DNTI_REGISTRO_CIVIL_OBTENER_CEDULA("obtenerPorCedulaHcam", "REG-CIVIL-SW-002"),
    /**
     * Servicio para: Devuelve la lista de afiliados e información básica de
     * estos de la tabla IAFI01.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_AFILIADOS("obtenerAfiliados", "AS400-SW-004"),
    /**
     * Servicio para: Devuelve la lista de médicos.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_MEDICOS("obtenerMedicos", "AS400-SW-005"),
    /**
     * Servicio para: Devuelve la lista de dependencias en una unidad médica.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_DEPENDENCIAS("obtenerDependencias", "AS400-SW-006"),
    /**
     * Servicio para: Devuelve la lista de atenciones médicas de un afiliado por
     * historia clínica y unidad médica.
     */
    WS_IESS_HCAM_UTILITARIO_OBTENER_ATENCIONES("obtenerAfiliados", "AS400-SW-007"),
    /**
     * Servicio para: Devuelve la lista de tipos de afiliado
     */
    WS_IESS_HCAM_UTILITARIO_LISTA_TIPOS_AFILIADOS("obtenerListaTiposAfiliados", "AS400-SW-008"),
    /**
     * Servicio para: Devuelve la lista de diagnosticos
     */
    WS_IESS_HCAM_UTILITARIO_LISTA_DIAGNOSTICO("obtenerListaTiposDiagnosticos", "AS400-SW-009"),
    /**
     * Servicio para: Devuelve la lista de diagnosticos
     */
    WS_IESS_HCAM_UTILITARIO_ATENCIONES_HOSPITALARIAS("obtenerListaAtencionesHospitalarias", "AS400-SW-010"),
    /**
     * Servicio para: Devuelve la lista de Pacientes Hospitalizados
     */
    WS_IESS_HCAM_UTILITARIO_PACIENTE_HOSPITALIZADO("obtenerPacientesHospitalizados", "AS400-SW-011"),
    /**
     * Servicio para: Devuelve fecha de ultima atencion de un afiliado y fecha
     * de fallecimeinto
     */
    WS_IESS_HCAM_FECHAS_AFILIADOS("fechasAfiliados", "AS400-SW-012"),
    /**
     * Servicio para: Devuelve fecha de ultima atencion de un afiliado y fecha
     * de fallecimeinto
     */
    WS_IESS_HCAM_SEGURIDAD_OBTENER_USUARIO("obtenerUsuario", "SEG-U-001"),
    /**
     * Servicio para: Devuelve la lista de Pacientes en lista de espera para ser
     * Hospitalizados
     */
    WS_IESS_HCAM_UTILITARIO_PACIENTE_LISTA_ESPERA("obtenerPacientesListaEspera", "AS400-SW-013"),
    /**
     * Servicio para: Devuelve la lista de Pacientes en lista de espera para ser
     * Hospitalizados
     */
    WS_IESS_HCAM_REGISTRAR_PID_APLICATIVO_INTERCONSULTAS_PENDIENTES("registrarPidAplicativoInterconsultasPendientes", "JAR-AS400-SW-01"),
    /**
     * Servicio para: Devuelve la lista de Pacientes en lista de espera para ser
     * Hospitalizados
     */
    WS_IESS_HCAM_OBTENER_CONTEO_INTERCONSULTAS_PENDIENTES("obtenerConteoInterconsultasPendientes", "JAR-AS400-SW-02"),
    /**
     * Servicio para: Devuelve la lista items del con sus respectivos saldos del
     * Kardex de nutricion
     */
    WS_IESS_HCAM_NUTRICION_OBTENER_SALDOS_ITEMS("obtenerSaldosItems", "NUT-SW-001"),
    /**
     * Servicio para: Devuelve ultimo id de transaccion del kardex de nutricion
     */
    WS_IESS_HCAM_NUTRICION_OBTENER_ULTIMO_ID_TRANSACCION("obtenerUltimoIdTransaccion", "NUT-SW-002"),
    /**
     * Servicio para: insertar el registro de transaccion en el kardex de
     * nutricion
     */
    WS_IESS_HCAM_NUTRICION_REGISTRO_KARDEX("registroKardexNutricion", "NUT-SW-003"),
    /**
     * Servicio para: actualizar el registro de transaccion en el kardex de
     * nutricion
     */
    WS_IESS_HCAM_NUTRICION_ACTUALIZACION_KARDEX("actualizacionKardexNutricion", "NUT-SW-004"),
    /**
     * Servicio para: consultar el registro de transaccion en el kardex de
     * nutricion
     */
    WS_IESS_HCAM_NUTRICION_CONSULTA_KARDEX("consultaKardexNutricion", "NUT-SW-005"),
    /**
     * Servicio para: eliminar el registro de transaccion en el kardex de
     * nutricion
     */
    WS_IESS_HCAM_NUTRICION_ELIMINAR_KARDEX("eliminacionKardexNutricion", "NUT-SW-006"),
    /**
     * Servicio para: obtener responsable del kardex de nutricion
     */
    WS_IESS_HCAM_NUTRICION_RESPONSABLE_KARDEX("obtenerResponsableKardexNutricion", "NUT-SW-007"),
    /**
     * Servicio para: obtener egresos desde bodega al kardex de nutricion
     */
    WS_IESS_HCAM_NUTRICION_EGRESOS_BODEGA_KARDEX("obtenerEgresosBodegaKardexNutricion", "NUT-SW-008"),
    /**
     * Servicio para: obtener items x egresos de bodega la kardex de nutricion
     */
    WS_IESS_HCAM_NUTRICION_EGRESOS_ITEMS_BODEGA_KARDEX("obtenerEgresosItemBodegaKardexNutricion", "NUT-SW-009"),
    /**
     * conexion a AS400 para modulo de triage
     */
    CONEXION_AS400("ConexionAS400", "AS400-CX-001"),
    /**
     * Envía correos de notificación de manera individual
     */
    ENVIO_CORREO_INDIVIDUAL("envioCorreoIndividual", "CORREO-SW-01"),
    /**
     * Envía correos de notificación mediante codigo en la base de datos
     */
    ENVIO_CORREO_NOTIFICACION_CODIGO("envioCorreoNotificacionCodigo", "CORREO-SW-02"),
    /**
     * Envía correos con archivo adjunto
     */
    ENVIO_CORREO_ARCHIVO_ADJUNTO("envioCorreoArchivoAdjunto", "CORREO-SW-03"),
    /**
     * GUarda huella digitales para enrolamiento
     */
    GUARDAR_HUELLA_ENROLAMIENTO("guardarHuellasDigitales", "ENROLAMIENTO-SW-001"),
    /**
     * Envía correos de notificación de manera individual con archivos adjuntos
     */
    ENVIO_CORREO_ARCHIVOS_ADJUNTOS("envioCorreoArchivosAdjuntos", "CORREO-SW-04"),
    /**
     * Codigo Metodo ServicioWeb : Lista los pacientes Hospitalizados en el
     * Modulo de Enfermeria.
     */
    WS_IESS_HCAM_ENFERMERIA_PACIENTES_HOSPITALIZADOS("obtenerPacientesEnfermeriaHO", "ENF-SW-002"),
    /**
     * Código método servicio web: Obtiene la lista ordenes laboratorio afiliado
     * en el módulo formularios
     */
    WS_IESS_HCAM_OBTENER_ORDENES_LAB_AFILIADO("obtenerOrdenesLabAfiliado", "AS400-SW-022"),
    /**
     * Envía correos de notificación de manera individual con archivos adjuntos
     */
    WS_IESS_HCAM_SEGURIDAD_BUSCAR_USUARIO("buscarUsuario", "SEG-U-002"),
    /**
     * Código método servicio web: Obtiene la lista ordenes imagen afiliado en
     * el módulo formularios
     */
    WS_IESS_HCAM_OBTENER_ORDENES_IMG_AFILIADO("obtenerOrdenesImgAfiliado", "AS400-SW-023"),
    /**
     * Enfermería paciente consulta externa
     */
    WS_IESS_HCAM_ENFERMERIA_PACIENTE_CEXTERNA("obtenerPacienteCe", "ENF-SW-003"),
    /**
     * Facturacion consulta Ume
     */
    WS_IESS_HCAM_FACTURACION_UME("obtenerUme", "FAC-SW-001"),
    /**
     * Conexion a carpeta compartida archivos Facturacion
     */
    CONEXION_FACTURACION("ConexionFacturacion", "FAC-CX-001"),
    /**
     * Camas hospitalarias, artes operatorios
     */
    WS_IESS_HCAM_OBTENER_PARTES_OPERATORIOS("obtenerDatos", "AS400-SW-024"),
    /**
     * Enfermería paciente consulta externa
     */
    WS_IESS_HCAM_ENFERMERIA_PACIENTE_REPORTE("obtenerPacienteReporte", "ENF-SW-004"),
    
    /**
     * ordenes de laboratorio pendiente
     */
    WS_IESS_HCAM_ORDENES_LABORATORIO_PENDIENTE("ordenesLaboratorioPendiente", "PED-001"),
    /**
     * ordenes de laboratorio pendiente
     */
    WS_IESS_HCAM_CITAS_MEDICAS_HISTORIA_CLINICA("citasMedicas", "PED-002");
    

    @Getter
    private String nombre;
    @Getter
    private String codigo;

    private CodigoMetodoServicioWebEnum(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

}
