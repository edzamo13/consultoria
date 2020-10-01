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

import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;

/**
 * <b>
 *   Objeto que se utiliza para ser llenados por formularios de ingreso de Aplicaciones
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 25-feb-2016]</p>
 */
@Dependent
public class AplicacionForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String descripcion;
    
    @Getter
    @Setter
    private String url;
    
    @Getter
    @Setter
    private String tipoAplicacion;
    
    @Getter
    @Setter
    private String estado;
    
    @Getter
    @Setter
    private String visible;
    
    @Getter
    @Setter
    private String codAplicacion;
   
    @Getter
    @Setter
    private List<Institucion> instituciones;

    @Getter
    @Setter
    private Institucion institucion;

    @Getter
    @Setter
    private List<Dependencia> dependencias;

    @Getter
    @Setter
    private Dependencia dependencia;

    @Getter
    @Setter
    private List<Aplicacion> aplicaciones;

    @Getter
    @Setter
    private Aplicacion aplicacion;

    @Getter
    @Setter
    private UploadedFile imagen;

    @Getter
    @Setter
    private Boolean muestraPanel;
}

