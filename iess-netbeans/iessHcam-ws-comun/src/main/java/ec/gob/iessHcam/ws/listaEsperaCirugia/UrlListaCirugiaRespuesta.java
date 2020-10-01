/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;


import ec.gob.iessHcam.ws.aplicativosJarAs400.CronometroSalida;
import ec.gob.iessHcam.ws.aplicativosJarAs400.CronometroSalida;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class UrlListaCirugiaRespuesta implements Serializable {

    private static final long serialVersionUID = -400293974015938975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<UrlListaCirugiaSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public UrlListaCirugiaRespuesta() {
    }

}
