/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.unidadmedica.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 28/06/2017]
 * </p>
 */
public class AfiliadoSalida implements Serializable {

    private static final long serialVersionUID = 1968367431361760493L;

    @Getter
    @Setter
    private String cedAfil;
    @Getter
    @Setter
    private String hisAfil;
    @Getter
    @Setter
    private String codUmeAfil;
    @Getter
    @Setter
    private String nomUmeAfil;
    @Getter
    @Setter
    private String apellnomAfil;
    @Getter
    @Setter
    private String estDerAfil;
    @Getter
    @Setter
    private String estRegAfil;
    @Getter
    @Setter
    private String fecNacAfil;
    @Getter
    @Setter
    private String sexoAfil;
    @Getter
    @Setter
    private String cedCubre;
    @Getter
    @Setter
    private String nomCubre;
    @Getter
    @Setter
    private String relaCubre;
    @Getter
    @Setter
    private String provAfil;
    @Getter
    @Setter
    private String canAfil;
    @Getter
    @Setter
    private String parrAfil;
    @Getter
    @Setter
    private String dirAfil;
    @Getter
    @Setter
    private String telfAfil;
    @Getter
    @Setter
    private String nombreAvisar;
    @Getter
    @Setter
    private String relaAvisar;
    @Getter
    @Setter
    private String provAvisar;
    @Getter
    @Setter
    private String canAvisar;
    @Getter
    @Setter
    private String parrAvisar;
    @Getter
    @Setter
    private String dirAvisar;
    @Getter
    @Setter
    private String telfAvisar;
    @Getter
    @Setter
    private String Empresa;
    @Getter
    @Setter
    private String telfEmpresa;
    @Getter
    @Setter
    private String provEmpresa;
    @Getter
    @Setter
    private String canEmpresa;
    @Getter
    @Setter
    private String parrEmpresa;
    @Getter
    @Setter
    private String dirEmpresa;
    @Getter
    @Setter
    private String seguro;
    @Getter
    @Setter
    private String seguroDescrip;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     */
    public AfiliadoSalida() {
        //vacio
    }

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 05/07/2017]
     * </p>
     *
     * @param cedAfil texto
     * @param hisAfil texto
     * @param codUmeAfil texto
     * @param nomUmeAfil texto
     * @param apellnomAfil texto
     * @param estDerAfil texto
     * @param estRegAfil texto
     * @param fecNacAfil texto
     * @param sexoAfil texto
     * @param cedCubre texto
     * @param nomCubre texto
     * @param relaCubre texto
     * @param provAfil texto
     * @param canAfil texto
     * @param parrAfil texto
     * @param dirAfil texto
     * @param telfAfil texto
     * @param nombreAvisar texto
     * @param relaAvisar texto
     * @param provAvisar texto
     * @param canAvisar texto
     * @param parrAvisar texto
     * @param dirAvisar texto
     * @param telfAvisar texto
     * @param Empresa texto
     * @param telfEmpresa texto
     * @param provEmpresa texto
     * @param canEmpresa texto
     * @param parrEmpresa texto
     * @param dirEmpresa texto
     * @param seguro tipo seguro
     * @param seguroDescrip descripcion tipo seguro
     */
    public AfiliadoSalida(String cedAfil, String hisAfil, String codUmeAfil, String nomUmeAfil, String apellnomAfil, String estDerAfil, String estRegAfil, String fecNacAfil, String sexoAfil, String cedCubre, String nomCubre, String relaCubre, String provAfil, String canAfil, String parrAfil, String dirAfil, String telfAfil, String nombreAvisar, String relaAvisar, String provAvisar, String canAvisar, String parrAvisar, String dirAvisar, String telfAvisar, String Empresa, String telfEmpresa, String provEmpresa, String canEmpresa, String parrEmpresa, String dirEmpresa, String seguro, String seguroDescrip) {
        this.cedAfil = cedAfil;
        this.hisAfil = hisAfil;
        this.codUmeAfil = codUmeAfil;
        this.nomUmeAfil = nomUmeAfil;
        this.apellnomAfil = apellnomAfil;
        this.estDerAfil = estDerAfil;
        this.estRegAfil = estRegAfil;
        this.fecNacAfil = fecNacAfil;
        this.sexoAfil = sexoAfil;
        this.cedCubre = cedCubre;
        this.nomCubre = nomCubre;
        this.relaCubre = relaCubre;
        this.provAfil = provAfil;
        this.canAfil = canAfil;
        this.parrAfil = parrAfil;
        this.dirAfil = dirAfil;
        this.telfAfil = telfAfil;
        this.nombreAvisar = nombreAvisar;
        this.relaAvisar = relaAvisar;
        this.provAvisar = provAvisar;
        this.canAvisar = canAvisar;
        this.parrAvisar = parrAvisar;
        this.dirAvisar = dirAvisar;
        this.telfAvisar = telfAvisar;
        this.Empresa = Empresa;
        this.telfEmpresa = telfEmpresa;
        this.provEmpresa = provEmpresa;
        this.canEmpresa = canEmpresa;
        this.parrEmpresa = parrEmpresa;
        this.dirEmpresa = dirEmpresa;
        this.seguro = seguro;
        this.seguroDescrip = seguroDescrip;
    }
}
