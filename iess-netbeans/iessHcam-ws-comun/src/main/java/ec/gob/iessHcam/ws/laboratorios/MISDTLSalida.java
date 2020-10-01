/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.laboratorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Parámetro de salida para MISDTL.  Se mantienen los nombres de los atributos con
 *   letras mayúsuculas, debido a que el cliente "RIPS" de datalab está programado
 *   para recibir un JSON con esos atributos.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 19/02/2016]</p>
 */
public class MISDTLSalida implements Serializable {

    private static final long serialVersionUID = -1422461130529850887L;
    
    @Getter
    @Setter
    private String DLCBEN; // Tipo beneficiario
    @Getter
    @Setter
    private String DLCACT; // Activo
    @Getter
    @Setter
    private String DLCDEP; // Dependiente
    @Getter
    @Setter
    private String DLCOTR; // Otros
    @Getter
    @Setter
    private String DLCEDU; // Cédula
    @Getter
    @Setter
    private String DLCPRO; // Procedencia
    @Getter
    @Setter
    private String DLCSER; // Servicio
    @Getter
    @Setter
    private String DLCMED; // Médico
    @Getter
    @Setter
    private String DLCDIS; // Dispensario
    @Getter
    @Setter
    private String DLNUOR; // Numero Orden His
    @Getter
    @Setter
    private String DLAPEL; // Apellidos
    @Getter
    @Setter
    private String DLNOMB; // Nombres
    @Getter
    @Setter
    private String DLSEXO; // Sexo
    @Getter
    @Setter
    private String DLFECN; // Fecha Nacimiento
    @Getter
    @Setter
    private String DLHIST; // Historia
    @Getter
    @Setter
    private String DLTIDO; // Prioridad
    @Getter
    @Setter
    private String DLCEXA; // Código Exámen
    
    public MISDTLSalida (String DLCBEN, String DLCACT,
            String DLCDEP, String DLCOTR, String DLCEDU,
            String DLCPRO, String DLCSER, String DLCMED, 
            String DLCDIS, String DLNUOR, String DLAPEL, 
            String DLNOMB, String DLSEXO, String DLFECN, 
            String DLHIST, String DLTIDO, String DLCEXA) {
            
            this.DLCBEN = DLCBEN;
            this.DLCACT = DLCACT;
            this.DLCDEP = DLCDEP;
            this.DLCOTR = DLCOTR;
            this.DLCEDU = DLCEDU;
            this.DLCPRO = DLCPRO;
            this.DLCSER = DLCSER;
            this.DLCMED = DLCMED;
            this.DLCDIS = DLCDIS;
            this.DLNUOR = DLNUOR;
            this.DLAPEL = DLAPEL;
            this.DLNOMB = DLNOMB;
            this.DLSEXO = DLSEXO;
            this.DLFECN = DLFECN;
            this.DLHIST = DLHIST;
            this.DLTIDO = DLTIDO;
            this.DLCEXA = DLCEXA;
        
    }

}