/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.servicio;

import ec.gob.cne.ws.crud.dao.GobernanteDao;
import ec.gob.cne.ws.modelo.Gobernante;
import ec.gob.cne.ws.modelo.dto.GobernanteDto;
import ec.gob.cne.ws.modelo.dto.PersonaDto;
import ec.gob.cne.ws.modelo.dto.RespuestaGobernanteDto;
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
@Path("gobernateService")
public class GobernanteService {

    @EJB
    @Getter
    private GobernanteDao gobernanteDao;
    @Getter
    @Setter
    private List<GobernanteDto> gobernanteDtos;

    @POST
    @Produces({"application/json"})
    @Path("/getGobernates")
    @Lock(LockType.READ)
    public RespuestaGobernanteDto getGobernates() throws Exception {
        List<Gobernante> gobernantes = new ArrayList<>();
        setGobernanteDtos(new ArrayList<GobernanteDto>());
        RespuestaGobernanteDto respuesta = new RespuestaGobernanteDto();
        gobernantes = gobernanteDao.getAllGobernates();
        gobernantes.forEach(x -> getGobernatesDtos(x));
        respuesta.setGobernanteDtos(gobernanteDtos);
        return respuesta;
    }

    private void getGobernatesDtos(Gobernante gobernante) {
        GobernanteDto gDto = new GobernanteDto();
        gDto.setPersonaDto(new PersonaDto());
        gDto.setIdGobernate(gobernante.getIdGobernate().toString());
        gDto.setCtgIdTipogobierno(gobernante.getCtgIdTipogobierno().toString());
        gDto.setTituloMandato(gobernante.getTituloMandato());
        gDto.setTipoPeriodo(gobernante.getTipoPeriodo());
        gDto.setPartidoPolitico(gobernante.getPartidoPolitico());
        gDto.setFechaMandatoinicio(gobernante.getFechaMandatoinicio().toString());
        gDto.setFechaMandatofin(gobernante.getFechaMandatofin().toString());
        gDto.setFechaCreacionr("fecha");
        gDto.setIdUsr("idUsr");
        gDto.setEstado(String.valueOf(gobernante.getEstado()));
        //Persona
        gDto.getPersonaDto().setIdPersona(gobernante.getIdPersona().getIdPersona().toString());
        gDto.getPersonaDto().setCedula(gobernante.getIdPersona().getCedula());
        gDto.getPersonaDto().setNombres(gobernante.getIdPersona().getNombres());
        gDto.getPersonaDto().setApellidos(gobernante.getIdPersona().getApellidos());
        gDto.getPersonaDto().setFechaNacimiento(gobernante.getIdPersona().getFechaNacimiento().toString());
        gDto.getPersonaDto().setFechaFallecimiento(gobernante.getIdPersona().getFechaFallecimiento().toString());
        gDto.getPersonaDto().setReligion(gobernante.getIdPersona().getReligion().toString());
        gDto.getPersonaDto().setGenero(gobernante.getIdPersona().getGenero().toString());
        gDto.getPersonaDto().setNacionalidad(gobernante.getIdPersona().getNacionalidad());
        gDto.getPersonaDto().setImagen("imagen");

        gobernanteDtos.add(gDto);
    }

}
