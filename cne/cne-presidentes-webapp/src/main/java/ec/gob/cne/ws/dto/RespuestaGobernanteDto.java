/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
public class RespuestaGobernanteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private List<GobernanteDto> gobernanteDtos;

    public RespuestaGobernanteDto() {
    }

}
