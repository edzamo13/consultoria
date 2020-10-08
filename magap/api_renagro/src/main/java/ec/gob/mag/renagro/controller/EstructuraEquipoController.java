package ec.gob.mag.renagro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.gob.mag.renagro.dto.FuncionarioDTO;
import ec.gob.mag.renagro.dto.FuncionariosPaginadoDTO;
import ec.gob.mag.renagro.dto.FuncionariosPaginadoTotalRecords;
import ec.gob.mag.renagro.dto.ProyectoDTO;
import ec.gob.mag.renagro.dto.UbicacionDTO;
import ec.gob.mag.renagro.dto.UbicacionFly;
import ec.gob.mag.renagro.dto.UsuarioPerfilDTO;
import ec.gob.mag.renagro.dto.UsuarioPerfilPsDTO;
import ec.gob.mag.renagro.pagination.AppUtil;
import ec.gob.mag.renagro.pagination.DataTableRequest;
import ec.gob.mag.renagro.pagination.DataTableResults;
import ec.gob.mag.renagro.pagination.PaginationCriteria;
import ec.gob.mag.renagro.services.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Api(value = "Estructura de Equipo", description = "ESTRUCTURA DE EQUIPO", tags = "ESTRUCTURA DE EQUIPO")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class EstructuraEquipoController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(EstructuraEquipoController.class);

	@Value("${url.personas}")
	private String urlMicroPersona;

	@Value("${url.usuarios}")
	private String urlMicroUsuario;

	@Value("${url.servidor_micro}")
	private String urlServidor;

	@Value("${url.ubicacion}")
	private String urlUbicacion;

	@Value("${url.usuarioperfilps}")
	private String urlUsuarioperfilps;

	@Value("${url.usuarioperfil}")
	private String urlUsuarioperfil;

	@Value("${url.funcionario}")
	private String urlMicrofuncionario;

	private String pathMicro;

	@Value("${url.catalogo}")
	private String urlMicroCatalogo;

	@Value("${url.seguridades}")
	private String urlMicroSeguridades;

	@Value("${url.renagro}")
	private String urlMicroRenagro;

	@Autowired
	@Qualifier("consumer")
	private Consumer consumer;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * ------------ ROL USUARIO
	 */
	@RequestMapping(value = "/rolUsuario/findByUsupId/{usupId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un usuario por el UsupID", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findByRolUsuario(@PathVariable Long usupId, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroSeguridades + "api/rolUsuario/findByUsupId/" + usupId;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	/**
	 * ------------ USUARIO
	 */
	@RequestMapping(value = "/usuario/findByUsupId/{usupId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un usuario por el UsupID", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findUsuarioByUsupId(@PathVariable Long usupId, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroUsuario + "usuario_persona/findById/" + usupId;
		System.out.println("http: " + pathMicro);
		Object responsePersona = consumer.doGet(pathMicro, token);
		return responsePersona;
	}

	@RequestMapping(value = "/usuariopersona/findByPerId/{perId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una persona por el per id ", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findPersonaByPerId(@PathVariable Long perId, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroUsuario + "usuario_persona/findByPerId/" + perId;
		Object responsePersona = consumer.doGet(pathMicro, token);
		return responsePersona;
	}

	/**
	 * ------------ PERSONA
	 */

	@RequestMapping(value = "/persona/findById/{idRna}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una persona por el id del Rna", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findPersonaById(@PathVariable Long idRna, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroPersona + "findById/" + idRna;
		Object responsePersona = consumer.doGet(pathMicro, token);
		return responsePersona;
	}

	@RequestMapping(value = "/persona/findByCedula/{cedula}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una persona por cedula", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findPersonaByCeduka(@PathVariable String cedula, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {

		pathMicro = null;
		pathMicro = urlServidor + urlMicroPersona + "findByCedula/" + cedula;
		Object responsePersona = consumer.doGet(pathMicro, token);
		return responsePersona;
	}

	/**
	 * ------------ USUARIO PERFIL
	 */
	@RequestMapping(value = "/usuarioperfil/findbyPerIdAnduPefId/{perId}/{upefId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un usuarioperfil por perif and upefId", response = UsuarioPerfilDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public UsuarioPerfilDTO findusuarioperfilbyperIdAndupefId(@Valid @PathVariable Long perId,
			@Valid @PathVariable Long upefId, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlUsuarioperfil + "findbyPerIdAndPefId/" + perId + "/" + upefId;
		System.out.println("----------> " + pathMicro);
		Object response = consumer.doGet(pathMicro, token);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(response);
		UsuarioPerfilDTO up = mapper.readValue(jsonString, UsuarioPerfilDTO.class);
		return up;
	}

	/**
	 * ------------ UBICACION
	 */
	@RequestMapping(value = "/ubicacion/findByUbiId/{ubiId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Ubicacion by ubiId", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findUbicacionByUbiId(@PathVariable Long ubiId, @RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlUbicacion + "findByUbiId/" + ubiId;
		Object responseUbicacion = consumer.doGet(pathMicro, token);
		return responseUbicacion;
	}

	@RequestMapping(value = "/ubicacion/findOnlyFirstLevelByUbiId/{ubiId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Ubicacion by ubiId", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findOnlyFirstLevelByUbiId(@PathVariable Long ubiId,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlUbicacion + "findOnlyFirstLevelByUbiId/" + ubiId;
		Object responseUbicacion = consumer.doGet(pathMicro, token);
		return responseUbicacion;
	}

	@RequestMapping(value = "/ubicacion/findChildrenByUbiId/{ubiId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Ubicacion by ubiId", response = UbicacionFly.class)
	@ResponseStatus(HttpStatus.OK)
	public List<UbicacionFly> findChildrenByUbiId(@PathVariable Long ubiId,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlUbicacion + "findChildrenByUbiId/" + ubiId;
		Object responseUbicacion = consumer.doGet(pathMicro, token);

		ObjectMapper mapperU = new ObjectMapper();
		List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
		try {
			String jsonStringU = mapperU.writeValueAsString(responseUbicacion);
			ubicaciones = mapperU.readValue(jsonStringU,
					mapperU.getTypeFactory().constructCollectionType(List.class, UbicacionDTO.class));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		List<UbicacionFly> ubicacionesFly = ubicaciones.stream().map(ubicacion -> {
			UbicacionFly ubicacionFly = new UbicacionFly();
			ubicacionFly.setUbiId(ubicacion.getUbiId());
			ubicacionFly.setUbiNombre(ubicacion.getUbiNombre());
			return ubicacionFly;
		}).collect(Collectors.toList());

		return ubicacionesFly;
	}

	@RequestMapping(value = "/ubicacion/findByRegiones/{catIdUbi}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Ubicacion by ubiId", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findByRegiones(@PathVariable Long catIdUbi, @RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlUbicacion + "findByRegiones/" + catIdUbi;
		Object responseUbicacion = consumer.doGet(pathMicro, token);
		return responseUbicacion;
	}

	@RequestMapping(value = "/ubicacion/findByProvinciasByRegiones/{ubiIdRegion}/{ubiIdPadre}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Ubicacion by ubiId", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findByProvinciasByRegiones(@PathVariable Long ubiIdRegion, @PathVariable Long ubiIdPadre,
			@RequestHeader(name = "Authorization") String token) {

		pathMicro = null;
		pathMicro = urlServidor + urlUbicacion + "findByProvinciasByRegiones/" + ubiIdRegion + "/" + ubiIdPadre;
		Object responseUbicacion = consumer.doGet(pathMicro, token);
		return responseUbicacion;
	}

	/**
	 * ------------ FUNCIONARIOS
	 */

	@RequestMapping(value = "/funcionario/findPadreByPerIdAndProyIdAndPefIdHijoAndPefIdPadre/{upsIdPadre}/{proyId}/{pefIdHijo}/{pefIdPadre}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca el funcionario responsable de una persona", response = FuncionarioDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public FuncionarioDTO findPadreByPerIdAndProyIdAndPefIdHijoAndPefIdPadre(@PathVariable Long upsIdPadre,
			@PathVariable Long proyId, @PathVariable Long pefIdHijo, @PathVariable Long pefIdPadre,
			@RequestHeader(name = "Authorization") String auth)
			throws JsonParseException, JsonMappingException, IOException {
		Object response = consumer
				.doGet(urlServidor + urlMicrofuncionario + "findPadreByPerIdAndProyIdAndPefIdHijoAndPefIdPadre/"
						+ upsIdPadre + "/" + proyId + "/" + pefIdHijo + "/" + pefIdPadre, auth);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(response);
		FuncionarioDTO funcionariosDto = mapper.readValue(jsonString, FuncionarioDTO.class);
		return funcionariosDto;
	}

	@RequestMapping(value = "/funcionario/findProyByPerId/{perId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca proyectos y perfiles por PerId", response = ProyectoDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public List<ProyectoDTO> findProyByPerId(@PathVariable Long perId,
			@RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {

		pathMicro = null;
		pathMicro = urlServidor + urlMicrofuncionario + "findProyByPerId/" + perId;
		Object response = consumer.doGet(urlServidor + urlMicrofuncionario + "findProyByPerId/" + perId, token);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(response);
		List<ProyectoDTO> proyectosDto = mapper.readValue(jsonString,
				mapper.getTypeFactory().constructCollectionType(List.class, ProyectoDTO.class));
		return proyectosDto;
	}

	@RequestMapping(value = "/funcionario/findByPerIdAndProyIdAndPefId/{perId}/{proyId}/{pefId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un funcionario por numero de perId, id del proyecto y perfil de usuario", response = FuncionarioDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public List<FuncionarioDTO> findByPerIdAndProyIdAndTpefId(@PathVariable Long perId, @PathVariable Long proyId,
			@PathVariable Long pefId, @RequestHeader(name = "Authorization") String token)
			throws JsonParseException, JsonMappingException, IOException {

		pathMicro = null;
		pathMicro = urlServidor + urlMicrofuncionario + "findByPerIdAndProyIdAndPefId/" + perId + "/" + proyId + "/"
				+ pefId;
		Object response = consumer.doGet(pathMicro, token);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(response);

		List<FuncionarioDTO> funcionariosDto = mapper.readValue(jsonString,
				mapper.getTypeFactory().constructCollectionType(List.class, FuncionarioDTO.class));
		return funcionariosDto;
	}

	@RequestMapping(value = "/funcionario/findBySupervisores/{perId}/{proyId}/{pefIdPadre}/{pefIdHijos}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca los funcionarios a cargo de perId", response = FuncionarioDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findBySupervisores(@PathVariable Long perId, @PathVariable Long proyId, @PathVariable Long pefIdPadre,
			@PathVariable Long pefIdHijos, @RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlMicrofuncionario + "findSupervisores/" + perId + "/" + pefIdPadre + "/"
				+ pefIdHijos + "/" + proyId;
		System.out.println("---> URL: " + pathMicro);
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/funcionario/findByPerIdAndProyIdAndPefIdPadrePefIdHijos/{perId}/{proyId}/{pefIdPadre}/{pefIdHijos}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca los funcionarios a cargo de perId", response = FuncionarioDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findByPerIdAndProyIdAndPefIdPadrePefIdHijos(@PathVariable Long perId, @PathVariable Long proyId,
			@PathVariable Long pefIdPadre, @PathVariable Long pefIdHijos,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlMicrofuncionario + "findByPerIdAndProyIdAndPefIdPadrePefIdHijos/" + perId + "/"
				+ proyId + "/" + pefIdPadre + "/" + pefIdHijos;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/funcionariosPaginated/{apliId}", method = RequestMethod.GET)
	@ResponseBody
	public String getFuncionariosPaginated(HttpServletRequest request, @PathVariable Long apliId,
			@RequestHeader(name = "Authorization") String token) {
		DataTableRequest<FuncionariosPaginadoDTO> dataTableInRQ = new DataTableRequest<FuncionariosPaginadoDTO>(
				request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		String baseQuery = "SELECT ROW_NUMBER() OVER (ORDER BY per.per_id ) AS nro, CAST(per.per_id AS TEXT) AS \"id\",up.usup_id AS \"usupId\", per_identificacion AS \"perIdentificacion\", per_nombres AS \"perNombres\", per_correo AS \"perCorreo\", upef.upef_id AS \"upefId\", perfil.pef_id AS \"pefId\", \n"
				+ "perfil.apli_id AS \"apliId\", usu.usu_id AS \"usuId\", tpef_nombre AS \"tpefNombre\",  ib.bri_id AS \"briId\", ps.ubi_id AS \"ubiId\", ubi.ubi_nombre AS \"ubiNombre\", bri.bri_codigo AS \"briCodigo\", \n"
				+ "secd.ubi_nombre_provincia AS \"brisUbiNombreProvincia\", secd.ubi_nombre_canton AS \"brisUbiNombreCanton\", "
				+ "secd.ubi_nombre_parroquia AS \"brisUbiNombreParroquia\", ib.usup_id_insert AS \"usupIdInsert\", ( SELECT COUNT(1) FROM sc_organizacion.persona per\r\n"
				+ "INNER JOIN sc_seguridad.usuario_persona up ON per.per_id = up.per_id\r\n"
				+ "INNER JOIN sc_seguridad.usuario usu ON usu.usup_id = up.usup_id\r\n"
				+ "INNER JOIN sc_seguridad.usuario_perfil upef ON upef.usu_id = usu.usu_id\r\n"
				+ "INNER JOIN sc_seguridad.perfil perfil ON perfil.pef_id = upef.pef_id\r\n"
				+ "INNER JOIN sc_seguridad.perfil_tipo perfilt ON perfilt.tpef_id = perfil.tpef_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.integrante_brigada ib ON up.usup_id = ib.usup_id AND intb_estado = 1\r\n"
				+ "LEFT OUTER JOIN sc_renagro.brigada bri ON bri.bri_id = ib.bri_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.brigada_sector bris ON bris.bri_id = bri.bri_id AND bris.bris_estado = 1\r\n"
				+ "LEFT OUTER JOIN sc_renagro.sector_disperso_periodo sedp ON sedp.sedp_id = bris.sedp_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.sector_disperso secd ON secd.secd_id = sedp.secd_id\r\n"
				+ "LEFT OUTER JOIN sc_seguridad.usuario_perfil_ps ps ON ps.upef_id = upef.upef_id\r\n"
				+ "LEFT OUTER JOIN ubicacion ubi ON ubi.ubi_id = ps.ubi_id\r\n" + "WHERE perfil.apli_id = " + apliId
				+ " AND up.usup_estado = 11 AND up.usup_eliminado = false\r\n"
				+ "AND upef.upef_estado = 11 AND upef.upef_eliminado = false\r\n"
				+ "AND perfil.pef_estado = 11 AND perfil.pef_eliminado = false) AS totalRecords\r\n"
				+ "FROM sc_organizacion.persona per\r\n"
				+ "INNER JOIN sc_seguridad.usuario_persona up ON per.per_id = up.per_id\r\n"
				+ "INNER JOIN sc_seguridad.usuario usu ON usu.usup_id = up.usup_id\r\n"
				+ "INNER JOIN sc_seguridad.usuario_perfil upef ON upef.usu_id = usu.usu_id\r\n"
				+ "INNER JOIN sc_seguridad.perfil perfil ON perfil.pef_id = upef.pef_id\r\n"
				+ "INNER JOIN sc_seguridad.perfil_tipo perfilt ON perfilt.tpef_id = perfil.tpef_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.integrante_brigada ib ON up.usup_id = ib.usup_id AND intb_estado = 1\r\n"
				+ "LEFT OUTER JOIN sc_renagro.brigada bri ON bri.bri_id = ib.bri_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.brigada_sector bris ON bris.bri_id = bri.bri_id AND bris.bris_estado = 1\r\n"
				+ "LEFT OUTER JOIN sc_renagro.sector_disperso_periodo sedp ON sedp.sedp_id = bris.sedp_id\r\n"
				+ "LEFT OUTER JOIN sc_renagro.sector_disperso secd ON secd.secd_id = sedp.secd_id\r\n"
				+ "LEFT OUTER JOIN sc_seguridad.usuario_perfil_ps ps ON ps.upef_id = upef.upef_id\r\n"
				+ "LEFT OUTER JOIN ubicacion ubi ON ubi.ubi_id = ps.ubi_id\r\n" + "WHERE perfil.apli_id =" + apliId
				+ " AND up.usup_estado = 11 AND up.usup_eliminado = false\r\n"
				+ " AND upef.upef_estado = 11 AND upef.upef_eliminado = false\r\n"
				+ " AND perfil.pef_estado = 11 AND perfil.pef_eliminado = false";
		String paginatedQuery = AppUtil.buildPaginatedQuery(baseQuery, pagination);
		Query query = entityManager.createNativeQuery(paginatedQuery, FuncionariosPaginadoTotalRecords.class);

		List<FuncionariosPaginadoTotalRecords> userList = query.getResultList();
		DataTableResults<FuncionariosPaginadoTotalRecords> dataTableResult = new DataTableResults<FuncionariosPaginadoTotalRecords>();
		dataTableResult.setDraw(dataTableInRQ.getDraw());
		dataTableResult.setListOfDataObjects(userList);
		if (!AppUtil.isObjectEmpty(userList)) {
			dataTableResult
					.setRecordsTotal(((FuncionariosPaginadoTotalRecords) userList.get(0)).getTotalRecords().toString());
			if (dataTableInRQ.getPaginationRequest().isFilterByEmpty())
				dataTableResult.setRecordsFiltered(
						((FuncionariosPaginadoTotalRecords) userList.get(0)).getTotalRecords().toString());
			else
				dataTableResult.setRecordsFiltered(Integer.toString(userList.size()));
		}
		return (new Gson()).toJson(dataTableResult);
	}

	/**
	 * ------------ USUARIO PERFIL PS
	 */

	@RequestMapping(value = "/usuarioperfilps/create", method = RequestMethod.POST)
	@ApiOperation(value = "Insertar un nuevo Usuarioperfilps", response = Long.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Object createUsuarioPerfilPs(@RequestBody String data, @RequestHeader(name = "Authorization") String auth)
			throws JsonParseException, JsonMappingException, IOException {
		Object responseObj = consumer.doPost(urlServidor + urlUsuarioperfilps + "create/", data, auth);
		return responseObj;
	}

	@RequestMapping(value = "/usuarioperfilps/upsidpadre/update/{upsidpadre}", method = RequestMethod.POST)
	@ApiOperation(value = "Actualiza padre de  Usuarioperfilps", response = Long.class)
	@ResponseStatus(HttpStatus.OK)
	public Object updatePadrePerfilPs(@PathVariable Long upsidpadre, @RequestBody String data,
			@RequestHeader(name = "Authorization") String auth)
			throws JsonParseException, JsonMappingException, IOException {
		Object response = consumer.doPost(urlServidor + urlUsuarioperfilps + "upsidpadre/update/" + upsidpadre, data,
				auth);
		return response;
	}

	@RequestMapping(value = "/usuarioperfilps/findbyperIdAnduPefId/{perId}/{upefId}/{psId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un usuarioperfilps por perif and upefId and ps", response = UsuarioPerfilPsDTO.class)
	public UsuarioPerfilPsDTO findbyperIdAndupefId(@Valid @PathVariable Long perId, @Valid @PathVariable Long upefId,
			@Valid @PathVariable Long psId, @RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlUsuarioperfil + "findbyPerIdAndPefId/" + perId + "/" + upefId;
		Object response = consumer.doGet(pathMicro, token);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(response);
		UsuarioPerfilDTO upps = mapper.readValue(jsonString, UsuarioPerfilDTO.class);

		pathMicro = null;
		pathMicro = urlServidor + urlUsuarioperfilps + "findbyUpefidAndPsId/" + upps.getId() + "/" + psId;
		Object response2 = consumer.doGet(pathMicro, token);
		String jsonString1 = mapper.writeValueAsString(response2);
		UsuarioPerfilPsDTO up = mapper.readValue(jsonString1, UsuarioPerfilPsDTO.class);
		return up;
	}

	/**
	 * LISTADO CATALOGOS
	 **/
	@RequestMapping(value = "/catalogo/findByIdTipoCatalogo/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene los catalogos dado un tipo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getCatalogo(@PathVariable Long id, @RequestHeader(name = "Authorization") String auth) {
		Object response = consumer.doGet(urlServidor + urlMicroCatalogo + "findByIdTipoCatalogo/" + id, auth);
		return response;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

}
