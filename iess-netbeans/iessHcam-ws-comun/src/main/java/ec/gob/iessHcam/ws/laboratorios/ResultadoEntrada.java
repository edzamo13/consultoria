/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Parámetro de entrada para pase de resultados DATALAB - MIS AS400 La
 * nomenclatura no coincide debido a que el cliente RIPS tiene quemado en su
 * código la nomenclatura de la clase.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [$Author: fsalazarn@iess.gob.ec $, $Date: 25/02/2016]</p>
 */
public class ResultadoEntrada {

    @Getter
    @Setter
    String OrdenHis;
    @Getter
    @Setter
    String OrderSendMIS;
    @Getter
    @Setter
    String Historia;
    @Getter
    @Setter
    String IdExamen;
    @Getter
    @Setter
    String IdPerfil;
    @Getter
    @Setter
    String FechaValidacion;
    @Getter
    @Setter
    String Minimo;
    @Getter
    @Setter
    String Maximo;
    @Getter
    @Setter
    String Resultado;
    @Getter
    @Setter
    String Comentario;
    @Getter
    @Setter
    String MuestraMicrobiologia;
    @Getter
    @Setter
    String Microorganismo;
    @Getter
    @Setter
    String Antibiotico;
    @Getter
    @Setter
    String Sensibilidad;
    @Getter
    @Setter
    String UsuarioValidacion;
    @Getter
    @Setter
    String NombreMedico;
    @Getter
    @Setter
    String CodigoMedico;
    @Getter
    @Setter
    String Patologico;
    @Getter
    @Setter
    String physicianUnit;
    @Getter
    @Setter
    String HoraValidacion;
    
    public ResultadoEntrada(String OrdenHis, String OrderSendMIS, String Historia, String IdExamen, String IdPerfil, String FechaValidacion, String Minimo, String Maximo, String Resultado, String Comentario, String MuestraMicrobiologia, String Microorganismo, String Antibiotico, String Sensibilidad, String UsuarioValidacion, String NombreMedico, String CodigoMedico, String Patologico, String physicianUnit, String HoraValidacion) {
        this.OrdenHis = OrdenHis;
        this.OrderSendMIS = OrderSendMIS;
        this.Historia = Historia;
        this.IdExamen = IdExamen;
        this.IdPerfil = IdPerfil;
        this.FechaValidacion = FechaValidacion;
        this.Minimo = Minimo;
        this.Maximo = Maximo;
        this.Resultado = Resultado;
        this.Comentario = Comentario;
        this.MuestraMicrobiologia = MuestraMicrobiologia;
        this.Microorganismo = Microorganismo;
        this.Antibiotico = Antibiotico;
        this.Sensibilidad = Sensibilidad;
        this.UsuarioValidacion = UsuarioValidacion;
        this.NombreMedico = NombreMedico;
        this.CodigoMedico = CodigoMedico;
        this.Patologico = Patologico;
        this.physicianUnit = physicianUnit;
        this.HoraValidacion = HoraValidacion;
    }
    
    @Override
    public String toString() {
        
        return "OrdenHis: " + OrdenHis + ", OrderSendMIS :" + OrderSendMIS 
                + ", Historia:" + Historia + ", IdExamen:" + IdExamen 
                + ", IdPerfil: " + IdPerfil + ", FechaValidacion:" + FechaValidacion
                + ", Minimo: " + Minimo + ", Maximo: " + Maximo + ", Resultado: " + Resultado 
                + ", Comentario: " + Comentario +  ", MuestraMicrobiologia: "+ MuestraMicrobiologia 
                + ", Microorganismo: " + Microorganismo + ", Antibiotico: " + Antibiotico 
                + ", Sensibilidad: " + Sensibilidad + ", UsuarioValidacion: " + UsuarioValidacion
                + ", NombreMedico: "+ NombreMedico + ", CodigoMedico:" + CodigoMedico 
                + ", Patologico: " + Patologico + ", physicianUnit: "  + physicianUnit 
                + ", HoraValidacion: " + HoraValidacion;
        
    }

}
