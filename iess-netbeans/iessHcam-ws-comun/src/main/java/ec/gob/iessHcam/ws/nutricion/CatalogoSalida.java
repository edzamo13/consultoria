package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase que determina los parámetros de entrada del Web Service.
 * </b>
 *
 * @author ezamoram
 * <p>
 * [$Author: ezamoram $, $Date: 23/03/2016]</p>
 */
@XmlRootElement
public class CatalogoSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String idPadre;
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String horaToma;

    public CatalogoSalida() {
    }

    public CatalogoSalida(String id, String idPadre, String codigo, String descripcion, String horaToma) {
        this.id = id;
        this.idPadre = idPadre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.horaToma = horaToma;
    }

    
    
    
}
