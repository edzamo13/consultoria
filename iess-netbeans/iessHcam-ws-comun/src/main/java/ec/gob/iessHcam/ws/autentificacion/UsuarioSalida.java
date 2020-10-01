/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;


import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaSalida;
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
public class UsuarioSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String idUsuario;
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String numDocumento;
    @Getter
    @Setter
    private String ipUsuario;
    @Getter
    @Setter
    private String idAplicacion;
    @Getter
    @Setter
    private String codUnme;
    @Getter
    @Setter
    private String nombrePersona;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private List<MenuSalida> menuSalidas;
    @Getter
    @Setter
    private UnidadMedicaSalida unidadMedicaSalida;

    @Getter
    @Setter
    private String aplicativo;
    /**
     *
     * <b>
     * Constructor de Clase.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 19/10/2016]</p>
     */
    public UsuarioSalida() {
    }

    /**
     *
     * <b>
     * cosntructur de String.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2016]</p>
     *
     * @param idUsuario idUsuario
     * @param usuario usuario
     * @param numDocumento numDocumento
     * @param codUnme codUnme
     * @param ipUsuario ipUsuario
     * @param idAplicacion idAplicacion
     * @param unidadMedica unidadMedica
     * @param nombrePersona nombrePersona
     * @param menuSalidas menuSalidas
     * @param historiaClinica historiaClinica
     * @param unidadMedicaSalida
     */
    public UsuarioSalida(String idUsuario, String usuario, String numDocumento, String ipUsuario, String idAplicacion, String codUnme, String nombrePersona, String historiaClinica, String unidadMedica, List<MenuSalida> menuSalidas, UnidadMedicaSalida unidadMedicaSalida, String aplicativo) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.numDocumento = numDocumento;
        this.ipUsuario = ipUsuario;
        this.idAplicacion = idAplicacion;
        this.codUnme = codUnme;
        this.nombrePersona = nombrePersona;
        this.historiaClinica = historiaClinica;
        this.unidadMedica = unidadMedica;
        this.menuSalidas = menuSalidas;
        this.unidadMedicaSalida = unidadMedicaSalida;
        this.aplicativo=aplicativo;
    }

}
