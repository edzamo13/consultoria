/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.gestion.seguridad.jsf.bb;

import ec.gob.iessHcam.gestion.seguridad.modelo.AsignacionTbl;
import ec.gob.iessHcam.gestion.seguridad.modelo.ImpresoraTbl;
import ec.gob.iessHcam.gestion.seguridad.modelo.TipoManillaTbl;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 03-03-2016]</p>
 */
@Dependent
public class AsignacionImpresoraForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;
    
    @Getter
    @Setter
    private List<ImpresoraTbl> impresoras;
    
    @Getter
    @Setter
    private ImpresoraTbl impresora;
    
    @Getter
    @Setter
    private AsignacionTbl asignacion;
    
    @Getter
    @Setter
    private Integer tabIndex;
}

