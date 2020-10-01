/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class UrlListaCirugiaSalida implements Serializable {

    private static final long serialVersionUID = 187964554665132L;
    @Getter
    @Setter
    private String urlIdRegistro;
    @Getter
    @Setter
    private String urlIdUsuario;
    @Getter
    @Setter
    private String urlUnidadMedica;
    @Getter
    @Setter
    private String urlHistoriaClinica;
    @Getter
    @Setter
    private String urlIdAplicacion;
    @Getter
    @Setter
    private String urlCodDependencia;
    @Getter
    @Setter
    private String urlFecha;
    @Getter
    @Setter
    private String urlHora;

    public UrlListaCirugiaSalida() {
    }

    @Override
    public String toString() {
        return "UrlListaCirugiaSalida{" + "urlIdRegistro=" + urlIdRegistro + ", urlIdUsuario=" + urlIdUsuario + ", urlUnidadMedica=" + urlUnidadMedica + ", urlHistoriaClinica=" + urlHistoriaClinica + ", urlIdAplicacion=" + urlIdAplicacion + ", urlCodDependencia=" + urlCodDependencia + ", urlFecha=" + urlFecha + ", urlHora=" + urlHora + '}';
    }

    public UrlListaCirugiaSalida(String urlIdRegistro, String urlIdUsuario, String urlUnidadMedica, String urlHistoriaClinica, String urlIdAplicacion, String urlCodDependencia, String urlFecha, String urlHora) {
        this.urlIdRegistro = urlIdRegistro;
        this.urlIdUsuario = urlIdUsuario;
        this.urlUnidadMedica = urlUnidadMedica;
        this.urlHistoriaClinica = urlHistoriaClinica;
        this.urlIdAplicacion = urlIdAplicacion;
        this.urlCodDependencia = urlCodDependencia;
        this.urlFecha = urlFecha;
        this.urlHora = urlHora;
    }

}
