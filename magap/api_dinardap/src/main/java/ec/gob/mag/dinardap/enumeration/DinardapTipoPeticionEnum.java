package ec.gob.mag.dinardap.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DinardapTipoPeticionEnum {
	
    REGISTRO_CIVIL(1,"48","codigoPaquete","identificacion","Registro Civil","codigoTipoDocumento",""),
    ANT_PETICION(2,"49","codigoPaquete","valor", "Ant peticion 1","codigoTipoDocumento",""),
    ANT_PETICION_II(3,"259","codigoPaquete","valor","Ant peticion 2","codigoTipoDocumento",""),
    CNE(4,"51","codigoPaquete","identificacion" ,"Cosejo Nacional Electoral","codigoTipoDocumento",""),
    SENESCYT_TITULOS(5,"53","codigoPaquete","identificacion","Senescyt consulta titulo","codigoTipoDocumento",""),
    SERCOP(6,"54","codigoPaquete","identificacion","Servicio Nacional de Contratación Pública","codigoTipoDocumento",""),
    IESS(7,"55","codigoPaquete","identificacion" ,"Instituto Ecuatoriano de Seguridad Social","codigoTipoDocumento",""),
    POLICIA(8,"56","codigoPaquete","identificacion","Policia","codigoTipoDocumento",""),
    SCIAS(9,"248","codigoPaquete","identificacion","Superintendencia de Compañias Datos Companía","codigoTipoDocumento",""),
    SRI_I(10,"260","codigoPaquete","identificacion","Servicio de Rentas Internas 101  ","codigoTipoDocumento",""),
    SRI_II(11,"261","codigoPaquete","identificacion","Servicio de Rentas Internas 102","codigoTipoDocumento",""),
    SRI_III(12,"262","codigoPaquete","identificacion","Servicio de Rentas Internas 104","codigoTipoDocumento",""),
    SRI_IV(13,"264","codigoPaquete","identificacion","Servicio de Rentas Internas 2","codigoTipoDocumento",""),
    SRI_V(14,"1324","codigoPaquete","identificacion","Servicio de Rentas Internas 1","codigoTipoDocumento",""),
    SRI_VI(15,"1032","codigoPaquete","codigoAutorizacion","Servicio de Rentas Internas AUTORIZACION EMISION","codigoTipoDocumento","1"),
    REGISTRO_CIVIL_PUNTOAPUNTO(16,"48","codigoPaquete","identificacion","Registro Civil","codigoTipoDocumento",""),
    ;
	
	private int id;
	private String codigoPaquete;
	private String tipoPaquete ;
	private String tipoIdentificacion ;
	private String descripcion;
	private String codigoTipoDocumento;
	private String codigoTipoDocumentoDato;


}
