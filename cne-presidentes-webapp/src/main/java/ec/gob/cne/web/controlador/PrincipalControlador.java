/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.web.controlador;

import ec.gob.cne.web.cliente.restful.WsClienteRestful;
import ec.gob.cne.ws.dto.Car;
import ec.gob.cne.ws.dto.GobernanteDto;
import ec.gob.cne.ws.dto.RespuestaGobernanteDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
@ManagedBean
@ViewScoped
public class PrincipalControlador implements Serializable {

    @Getter
    @Setter
    private RespuestaGobernanteDto respuestaGobernanteDto;


    WsClienteRestful cliente = new WsClienteRestful();

    /*
    @ManagedProperty("#{carService}")
    private CarService service;
     */
    @PostConstruct
    public void init() {
        setRespuestaGobernanteDto(new RespuestaGobernanteDto());
        setRespuestaGobernanteDto(getGorbernantes());
        
        getGorbernantes();
    }

    private RespuestaGobernanteDto getGorbernantes() {
        RespuestaGobernanteDto respuesta = new RespuestaGobernanteDto();
        respuesta = cliente.invocaWs("http://localhost:8080/gestion-presidentes-ws-webapp/resources/gobernateService/getGobernates", null, RespuestaGobernanteDto.class);
        return respuesta;
    }

}
