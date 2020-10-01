package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

public enum BaseProcesoBatchEnum {

    AP_IESS_USR("jdbc/ap-iess-usr-DS");
    @Getter
    private String valor;

    private BaseProcesoBatchEnum(String nombre) {
        this.valor = nombre;
    }
}
