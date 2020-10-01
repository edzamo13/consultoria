/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.servicio;

import ec.gob.cne.ws.crud.dao.GobernanteDao;
import ec.gob.cne.ws.modelo.Gobernante;
import ec.gob.cne.ws.modelo.dto.GobernanteDto;
import ec.gob.cne.ws.modelo.dto.LoginDto;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Path("securityService")
public class LoginService {

    @EJB
    @Getter
    private GobernanteDao gobernanteDao;
    @Getter
    @Setter
    private List<GobernanteDto> gobernanteDtos;

    @POST
    @Produces({"application/json"})
    @Path("/getLogin")
    @Lock(LockType.READ)
    public String getGobernates(LoginDto login) throws Exception {
        if (login.getUser().equals("admin") && login.getPassword().equals("admin")) {
            return "successful";
        } else {

            return "Failed";
        }
    }

}
