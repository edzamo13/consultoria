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
public class PersonaRespuesta implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private Integer ETNID;
    @Getter
    @Setter
    private Integer GENID;
    @Getter
    @Setter
    private Integer PAIID;
    @Getter
    @Setter
    private String PERCEDULA;
    @Getter
    @Setter
    private Integer PERESTADO;
    @Getter
    @Setter
    private Integer PEREXTRANJERO;
    @Getter
    @Setter
    private Object PERFECHAFALLECIDO;
    @Getter
    @Setter
    private String PERFECHANACIMIENTO;
    @Getter
    @Setter
    private String PERFECHAREGISTRO;
    @Getter
    @Setter
    private Object PERHUELLA;
    @Getter
    @Setter
    private Integer PERID;
    @Getter
    @Setter
    private String PERNOMBRE;
    @Getter
    @Setter
    private String PERPAIS;
    @Getter
    @Setter
    private Object PERPASAPORTE;
    @Getter
    @Setter
    private Object PERPATRON;
    @Getter
    @Setter
    private Object PERREFERENCIANACIMIENTO;
    @Getter
    @Setter
    private Object PERREFUGIADO;
    @Getter
    @Setter
    private Object PERROSTRO;
    @Getter
    @Setter
    private Object PERTIPODOCUMENTO;
    @Getter
    @Setter
    private Object PRFID;
    @Getter
    @Setter
    private Object TISID;
    @Getter
    @Setter
    private Object UBICPK;

    public PersonaRespuesta(Integer ETNID, Integer GENID, Integer PAIID, String PERCEDULA, Integer PERESTADO, Integer PEREXTRANJERO, Object PERFECHAFALLECIDO, String PERFECHANACIMIENTO, String PERFECHAREGISTRO, Object PERHUELLA, Integer PERID, String PERNOMBRE, String PERPAIS, Object PERPASAPORTE, Object PERPATRON, Object PERREFERENCIANACIMIENTO, Object PERREFUGIADO, Object PERROSTRO, Object PERTIPODOCUMENTO, Object PRFID, Object TISID, Object UBICPK) {
        this.ETNID = ETNID;
        this.GENID = GENID;
        this.PAIID = PAIID;
        this.PERCEDULA = PERCEDULA;
        this.PERESTADO = PERESTADO;
        this.PEREXTRANJERO = PEREXTRANJERO;
        this.PERFECHAFALLECIDO = PERFECHAFALLECIDO;
        this.PERFECHANACIMIENTO = PERFECHANACIMIENTO;
        this.PERFECHAREGISTRO = PERFECHAREGISTRO;
        this.PERHUELLA = PERHUELLA;
        this.PERID = PERID;
        this.PERNOMBRE = PERNOMBRE;
        this.PERPAIS = PERPAIS;
        this.PERPASAPORTE = PERPASAPORTE;
        this.PERPATRON = PERPATRON;
        this.PERREFERENCIANACIMIENTO = PERREFERENCIANACIMIENTO;
        this.PERREFUGIADO = PERREFUGIADO;
        this.PERROSTRO = PERROSTRO;
        this.PERTIPODOCUMENTO = PERTIPODOCUMENTO;
        this.PRFID = PRFID;
        this.TISID = TISID;
        this.UBICPK = UBICPK;
    }

    public PersonaRespuesta() {
        super();
    }
    
}

