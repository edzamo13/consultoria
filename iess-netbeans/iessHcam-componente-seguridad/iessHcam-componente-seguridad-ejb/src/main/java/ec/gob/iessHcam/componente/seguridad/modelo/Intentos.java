/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.componente.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Desarrollo
 * <p>[$Author: Desarrollo $, $Date: 29-abr-2016]</p>
 */
@Entity
@Table(name = "seg_intentos_tbl", schema = "seguridad")

public class Intentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "in_id_intentos")
    @Getter
    @Setter
    private Integer inIdIntentos;
    
    @JoinColumn(name = "us_id_usuario", referencedColumnName = "us_id_usuario")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Usuario usIdUsuario;

    public Intentos() {
    }

   
}

