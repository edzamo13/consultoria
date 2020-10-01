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
public class FamiliarRespuesta implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private int FAM_ID;
    @Getter
    @Setter
    private int PER_ID;
    @Getter
    @Setter
    private int PER_PER_ID;
    @Getter
    @Setter
    private int PAR_ID;
    @Getter
    @Setter
    private String TIPO;

    public FamiliarRespuesta(int FAM_ID, int PER_ID, int PER_PER_ID, int PAR_ID, String TIPO) {
        super();
        this.FAM_ID = FAM_ID;
        this.PER_ID = PER_ID;
        this.PER_PER_ID = PER_PER_ID;
        this.PAR_ID = PAR_ID;
        this.TIPO = TIPO;
    }

    

   

    
    
}

