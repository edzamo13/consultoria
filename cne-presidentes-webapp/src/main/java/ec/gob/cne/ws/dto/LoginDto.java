/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
public class LoginDto {

    @Getter
    @Setter
    private String user;
    @Getter
    @Setter
    private String password;

}
