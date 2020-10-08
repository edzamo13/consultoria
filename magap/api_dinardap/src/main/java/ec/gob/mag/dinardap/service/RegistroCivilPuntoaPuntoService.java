package ec.gob.mag.dinardap.service;

import java.net.MalformedURLException;
import java.net.URL;

import ec.gob.mag.dinardap.dto.RegistroCivilCiudadanoDTO;
import ec.gob.mag.dinardap.util.Util;
import ec.gob.registroCivil.puntoapunto.wsdl.BusquedaPorNui;
import ec.gob.registroCivil.puntoapunto.wsdl.BusquedaPorNuiResponse;
import ec.gob.registroCivil.puntoapunto.wsdl.ConsultaCiudadano;
import ec.gob.registroCivil.puntoapunto.wsdl.ConsultaCiudadano_Service;

public class RegistroCivilPuntoaPuntoService {

	public static RegistroCivilCiudadanoDTO obtenerDatos(String cedula) {

		RegistroCivilCiudadanoDTO ciudadanoDTO = new RegistroCivilCiudadanoDTO();
		try {

			BusquedaPorNui porNui = new BusquedaPorNui();
			porNui.setCodigoInstitucion("51");
			porNui.setCodigoAgencia("52");
			porNui.setUsuario("magap12");
			porNui.setContrasenia("M@SzNj6%x");
			porNui.setNUI(cedula);
			String edad = "";

			ConsultaCiudadano_Service servicio = new ConsultaCiudadano_Service(
					new URL("https://wsprodu.registrocivil.gob.ec/WsRegistroCivil/ConsultaCiudadano?wsdl"));
			ConsultaCiudadano port = servicio.getConsultaCiudadanoPort();
			BusquedaPorNuiResponse busquedaPorNuiResponse = port.busquedaPorNui(porNui);
			if (busquedaPorNuiResponse.getReturn() != null) {
				ciudadanoDTO.setCalle(busquedaPorNuiResponse.getReturn().getCalle());
				ciudadanoDTO.setCodigoDomicilio(busquedaPorNuiResponse.getReturn().getCodigoDomicilio());
				ciudadanoDTO.setCodigoError(busquedaPorNuiResponse.getReturn().getCodigoError());
				ciudadanoDTO.setCondicionCedulado(busquedaPorNuiResponse.getReturn().getCondicionCedulado());
				ciudadanoDTO.setConyuge(busquedaPorNuiResponse.getReturn().getConyuge());
				ciudadanoDTO.setDomicilio(busquedaPorNuiResponse.getReturn().getDomicilio());
				ciudadanoDTO.setError(busquedaPorNuiResponse.getReturn().getError());
				ciudadanoDTO.setEstadoCivil(busquedaPorNuiResponse.getReturn().getEstadoCivil());
				ciudadanoDTO.setFechaInscripcionGenero(busquedaPorNuiResponse.getReturn().getFechaInscripcionGenero());
				ciudadanoDTO.setFechaNacimiento(busquedaPorNuiResponse.getReturn().getFechaNacimiento());
				edad = Util.calcularEdad(busquedaPorNuiResponse.getReturn().getFechaNacimiento());
				ciudadanoDTO.setEdad(edad);
				ciudadanoDTO.setLugarNacimiento(busquedaPorNuiResponse.getReturn().getLugarNacimiento());
				ciudadanoDTO.setFechaNacimiento(busquedaPorNuiResponse.getReturn().getFechaNacimiento());
				ciudadanoDTO.setGenero(busquedaPorNuiResponse.getReturn().getGenero());
				ciudadanoDTO.setInstruccion(busquedaPorNuiResponse.getReturn().getInstruccion());
				ciudadanoDTO.setLugarInscripcionGenero(busquedaPorNuiResponse.getReturn().getLugarInscripcionGenero());
				ciudadanoDTO.setNUI(busquedaPorNuiResponse.getReturn().getNUI());
				ciudadanoDTO.setNombre(busquedaPorNuiResponse.getReturn().getNombre());
				ciudadanoDTO.setNumeroCasa(busquedaPorNuiResponse.getReturn().getNumeroCasa());
				ciudadanoDTO.setSexo(busquedaPorNuiResponse.getReturn().getSexo());
				ciudadanoDTO.setNombrePadre(busquedaPorNuiResponse.getReturn().getNombrePadre());
				ciudadanoDTO.setNombreMadre(busquedaPorNuiResponse.getReturn().getNombreMadre());
				ciudadanoDTO.setFechaDefuncion(busquedaPorNuiResponse.getReturn().getActaDefuncion());
				ciudadanoDTO.setNacionalidad(busquedaPorNuiResponse.getReturn().getNacionalidad());
				ciudadanoDTO.setOrigen("Servicio Punto a Punto Registro Civil ");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ciudadanoDTO;
	}

}
