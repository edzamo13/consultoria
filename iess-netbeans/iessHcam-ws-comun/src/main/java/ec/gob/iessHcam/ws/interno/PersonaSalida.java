/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.interno;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENIN
 * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
 */
public class PersonaSalida implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private String PERID;
    @Getter
    @Setter
    private String TISID;
    @Getter
    @Setter
    private String PRFID;
    @Getter
    @Setter
    private String GENID;
    @Getter
    @Setter
    private String UBICPK;
    @Getter
    @Setter
    private String PERNOMBRE;
    @Getter
    @Setter
    private String PERCEDULA;
    @Getter
    @Setter
    private String PEREXTRANJERO;
    @Getter
    @Setter
    private String PERPAIS;
    @Getter
    @Setter
    private String PERFECHANACIMIENTO;
    @Getter
    @Setter
    private String PERFECHAREGISTRO;
    @Getter
    @Setter
    private String PERFECHAFALLECIDO;
    @Getter
    @Setter
    private String PERHUELLA;
    @Getter
    @Setter
    private String PERROSTRO;
    @Getter
    @Setter
    private String PERREFUGIADO;
    @Getter
    @Setter
    private String PERPATRON;
    @Getter
    @Setter
    private String PERESTADO;
    @Getter
    @Setter
    private String ETNID;
    @Getter
    @Setter
    private String PAIID;
    @Getter
    @Setter
    private String PERREFERENCIANACIMIENTO;
    @Getter
    @Setter
    private String PERTIPODOCUMENTO;
    @Getter
    @Setter
    private String PERPASAPORTE;

    public PersonaSalida(String PERID, String TISID, String PRFID, String GENID, String UBICPK, String PERNOMBRE, String PERCEDULA, String PEREXTRANJERO, String PERPAIS, String PERFECHANACIMIENTO, String PERFECHAREGISTRO, String PERFECHAFALLECIDO, String PERHUELLA, String PERROSTRO, String PERREFUGIADO, String PERPATRON, String PERESTADO, String ETNID, String PAIID, String PERREFERENCIANACIMIENTO, String PERTIPODOCUMENTO, String PERPASAPORTE) {
        this.PERID = PERID;
        this.TISID = TISID;
        this.PRFID = PRFID;
        this.GENID = GENID;
        this.UBICPK = UBICPK;
        this.PERNOMBRE = PERNOMBRE;
        this.PERCEDULA = PERCEDULA;
        this.PEREXTRANJERO = PEREXTRANJERO;
        this.PERPAIS = PERPAIS;
        this.PERFECHANACIMIENTO = PERFECHANACIMIENTO;
        this.PERFECHAREGISTRO = PERFECHAREGISTRO;
        this.PERFECHAFALLECIDO = PERFECHAFALLECIDO;
        this.PERHUELLA = PERHUELLA;
        this.PERROSTRO = PERROSTRO;
        this.PERREFUGIADO = PERREFUGIADO;
        this.PERPATRON = PERPATRON;
        this.PERESTADO = PERESTADO;
        this.ETNID = ETNID;
        this.PAIID = PAIID;
        this.PERREFERENCIANACIMIENTO = PERREFERENCIANACIMIENTO;
        this.PERTIPODOCUMENTO = PERTIPODOCUMENTO;
        this.PERPASAPORTE = PERPASAPORTE;
    }
    
    
    
}

