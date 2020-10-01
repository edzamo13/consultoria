/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class InformacionAfiliadoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String codUnidadMedica;
    @Getter
    @Setter
    private String numHistoria;
    @Getter
    @Setter
    private String nombreAfiliado;
    @Getter
    @Setter
    private String tipoIdent;
    @Getter
    @Setter
    private String identificacion;
    @Getter
    @Setter
    private String tipoBenefi;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String provincia;
    @Getter
    @Setter
    private String canton;
    @Getter
    @Setter
    private String parroquia;
    @Getter
    @Setter
    private String direccion;
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private String codMedico;
    @Getter
    @Setter
    private String usuarioMedico;
    @Getter
    @Setter
    private String nombreMedico;
    @Getter
    @Setter
    private String codDependencia;
    @Getter
    @Setter
    private String nombredependencia;

    @Getter
    @Setter
    private List<Diagnostico> diagnosticos;

    public InformacionAfiliadoSalida(String codUnidadMedica, String numHistoria, String nombreAfiliado, String tipoIdent, String identificacion, String tipoBenefi, String fechaNacimiento, String provincia, String canton, String parroquia, String direccion, String telefono, String codMedico, String usuarioMedico, String nombreMedico, String codDependencia, String nombredependencia) {
        this.codUnidadMedica = codUnidadMedica;
        this.numHistoria = numHistoria;
        this.nombreAfiliado = nombreAfiliado;
        this.tipoIdent = tipoIdent;
        this.identificacion = identificacion;
        this.tipoBenefi = tipoBenefi;
        this.fechaNacimiento = fechaNacimiento;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codMedico = codMedico;
        this.usuarioMedico = usuarioMedico;
        this.nombreMedico = nombreMedico;
        this.codDependencia = codDependencia;
        this.nombredependencia = nombredependencia;
    }
    
   

    
    public InformacionAfiliadoSalida() {
    }

   

}
