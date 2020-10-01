package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

public enum CodigoReporteEnum {

    /**
     * Solicitud de acumulacion de fondos de reserva
     */
    FR_SAFR001("SAFR001"),
    /**
     * Formulario de derivacion
     */
    SOLDERV01("SOLDERV01"),
    /**
     * Solicitud de derivacion
     */
    SOLDERV02("SOLDERV02"),
    /**
     * Solicitud de autorizacion
     */
    SOLDERV03("SOLDERV03");

    @Getter
    private String codigo;

    /**
     * <b> Constructor de la enumeracion. </b>
     * <p>
     * [Author: fochoac, Date: 17/8/2015]
     * </p>
     *
     * @param codigo
     *            del reporte
     */
    private CodigoReporteEnum(String codigo) {
        this.codigo = codigo;
    }

}
