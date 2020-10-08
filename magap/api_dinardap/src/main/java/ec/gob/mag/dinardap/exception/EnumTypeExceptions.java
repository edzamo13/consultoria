package ec.gob.mag.dinardap.exception;

import lombok.Getter;

@Getter
public enum EnumTypeExceptions {
    CRITICAL ("CRITICAL"),
    WARN ("WARN"),
    INFO("INFO")
    ;
    private final String value;
    
    EnumTypeExceptions(String value) {
        this.value = value;
    }
}