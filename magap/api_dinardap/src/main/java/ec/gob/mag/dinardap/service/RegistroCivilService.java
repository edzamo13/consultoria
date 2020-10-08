package ec.gob.mag.dinardap.service;

import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.mag.dinardap.dto.RegistroCivilCiudadanoDTO;
import ec.gob.mag.dinardap.dto.RegistroCivilDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;
import ec.gob.mag.dinardap.util.Util;

public class RegistroCivilService {

	public static RegistroCivilDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {
		RegistroCivilDTO registroCivilDTO = new RegistroCivilDTO();
		RegistroCivilDTO registroCivilDTOFinal = new RegistroCivilDTO();

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		entidades.stream().forEach(e -> {
			registroCivilDTO.setNombreEntidad(e.getNombre());
			e.getFilas().getFila().stream().forEach(f -> {
				registroCivilDTO.setOrigen("Dinardap cod1");
				f.getColumnas().getColumna().stream().forEach(c -> {

					// System.out.println(c.getCampo() + " = " + c.getValor());

					if (c.getCampo().trim().equals("cedula"))
						registroCivilDTO.setCedula(c.getValor());

					if (c.getCampo().trim().equals("condicionCiudadano"))
						registroCivilDTO.setCondicionCiudadano(c.getValor());

					if (c.getCampo().trim().equals("conyuge"))
						registroCivilDTO.setConyuge(c.getValor());

					if (c.getCampo().trim().equals("estadoCivil"))
						registroCivilDTO.setEstadoCivil(c.getValor());

					if (c.getCampo().trim().equals("fechaDefuncion"))
						registroCivilDTO.setFechaDefuncion(c.getValor());

					if (c.getCampo().trim().equals("fechaNacimiento")) {
						registroCivilDTO.setFechaNacimiento(c.getValor());
						registroCivilDTO.setEdad(Util.calcularEdad(c.getValor()));
					}
					if (c.getCampo().trim().equals("lugarNacimiento"))
						registroCivilDTO.setLugarNacimiento(c.getValor());

					if (c.getCampo().trim().equals("nombre"))
						registroCivilDTO.setNombre(c.getValor());

					if (c.getCampo().trim().equals("nombreMadre"))
						registroCivilDTO.setNombreMadre(c.getValor());

					if (c.getCampo().trim().equals("nombrePadre"))
						registroCivilDTO.setNombrePadre(c.getValor());

					if (c.getCampo().trim().equals("nacionalidad"))
						registroCivilDTO.setNacionalidad(c.getValor());
				});
			});
		});

		registroCivilDTOFinal = completarCamposPuntoaPuntoRegistroCivil(dato, registroCivilDTO);

		return registroCivilDTO;

	}

	private static RegistroCivilDTO completarCamposPuntoaPuntoRegistroCivil(String dato,
			RegistroCivilDTO registroCivilDTO) {
		RegistroCivilCiudadanoDTO ciudadanoDTO = RegistroCivilPuntoaPuntoService.obtenerDatos(dato);

		registroCivilDTO.setCalle(ciudadanoDTO.getCalle());
		registroCivilDTO.setCodigoDomicilio(ciudadanoDTO.getCodigoDomicilio());
		registroCivilDTO.setDomicilio(ciudadanoDTO.getDomicilio());
		registroCivilDTO.setFechaInscripcionGenero(ciudadanoDTO.getFechaInscripcionGenero());
		registroCivilDTO.setGenero(ciudadanoDTO.getGenero());
		registroCivilDTO.setLugarInscripcionGenero(ciudadanoDTO.getLugarInscripcionGenero());
		registroCivilDTO.setInstruccion(ciudadanoDTO.getInstruccion());
		registroCivilDTO.setNumeroCasa(ciudadanoDTO.getNumeroCasa());
		registroCivilDTO.setSexo(ciudadanoDTO.getSexo());

		return registroCivilDTO;

	}

}
