/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.ws.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class ProductoRespuesta {
    
    @Getter
    @Setter
    private List<Producto> productos;

    public ProductoRespuesta() {
    }
     
    
    
}
