package ec.gob.mag.dinardap.service;

import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.mag.dinardap.dto.SriContribuyenteDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap; 

public class SriContribuyenteService {

	public static SriContribuyenteDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {
		SriContribuyenteDTO sriContribuyenteDTO = new SriContribuyenteDTO();
		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		entidades.stream().forEach(e -> {
			sriContribuyenteDTO.setNombreEntidad(e.getNombre());
			e.getFilas().getFila().stream().forEach(f -> {
				f.getColumnas().getColumna().stream().forEach(c -> {

					if (c.getCampo().trim().equals("actividadEconomica"))
						sriContribuyenteDTO.setActividadEconomica(c.getValor());

					if (c.getCampo().trim().equals("codigoActividadEconomica"))
						sriContribuyenteDTO.setCodigoActividadEconomica(c.getValor());

					if (c.getCampo().trim().equals("estadoContribuyente"))
						sriContribuyenteDTO.setEstadoContribuyente(c.getValor());

					if (c.getCampo().trim().equals("claseContribuyente"))
						sriContribuyenteDTO.setClaseContribuyente(c.getValor());

					if (c.getCampo().trim().equals("numeroRuc"))
						sriContribuyenteDTO.setNumeroRuc(c.getValor());

					if (c.getCampo().trim().equals("tipoContribuyente"))
						sriContribuyenteDTO.setTipoContribuyente(c.getValor());

					if (c.getCampo().trim().equals("estadoPersona"))
						sriContribuyenteDTO.setEstadoPersona(c.getValor());

					if (c.getCampo().trim().equals("estadoSociedad"))
						sriContribuyenteDTO.setEstadoSociedad(c.getValor());

					if (c.getCampo().trim().equals("fechaActualizacion"))
						sriContribuyenteDTO.setFechaActualizacion(c.getValor());

					if (c.getCampo().trim().equals("fechaCancelacion"))
						sriContribuyenteDTO.setFechaCancelacion(c.getValor());

					if (c.getCampo().trim().equals("fechaInicioActividades"))
						sriContribuyenteDTO.setFechaInicioActividades(c.getValor());

					if (c.getCampo().trim().equals("fechaReinicioActividades"))
						sriContribuyenteDTO.setFechaReinicioActividades(c.getValor());

					if (c.getCampo().trim().equals("fechaSuspensionDefinitiva"))
						sriContribuyenteDTO.setFechaSuspensionDefinitiva(c.getValor());

					if (c.getCampo().trim().equals("obligado"))
						sriContribuyenteDTO.setObligado(c.getValor());

					if (c.getCampo().trim().equals("personaSociedad"))
						sriContribuyenteDTO.setPersonaSociedad(c.getValor());
					
					if (c.getCampo().trim().equals("razonSocial"))
						sriContribuyenteDTO.setRazonSocial(c.getValor());
					
					if (c.getCampo().trim().equals("listaBlanca"))
						sriContribuyenteDTO.setListaBlanca(c.getValor());
				});
			});
		});

		return sriContribuyenteDTO;

	}

}
