package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.mag.dinardap.dto.SenescytDTO;
import ec.gob.mag.dinardap.dto.SenescytTituloDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class SenescytService {

	public static SenescytDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato) throws ConsultarFaultException {
		SenescytDTO senescytDTO = new SenescytDTO();
		senescytDTO.setSenescytTituloDTOs(new ArrayList<>());
		SenescytTituloDTO senescytTituloDTO = new SenescytTituloDTO();

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		for (Entidad e : entidades) {
			senescytDTO.setNombreEntidad(e.getNombre());
			for (Fila fila : e.getFilas().getFila()) {

				for (Columna c : fila.getColumnas().getColumna()) {

					if (c.getCampo().trim().equals("fechaGrado"))
						senescytTituloDTO.setFechaGrado(c.getValor());

					if (c.getCampo().trim().equals("fechaRegistro"))
						senescytTituloDTO.setFechaRegistro(c.getValor());

					if (c.getCampo().trim().equals("ies"))
						senescytTituloDTO.setIes(c.getValor());

					if (c.getCampo().trim().equals("nombreTitulo"))
						senescytTituloDTO.setNombreTitulo(c.getValor());

					if (c.getCampo().trim().equals("numeroIdentificacion"))
						senescytTituloDTO.setNumeroIdentificacion(c.getValor());

					if (c.getCampo().trim().equals("numeroRegistro"))
						senescytTituloDTO.setNumeroRegistro(c.getValor());

					if (c.getCampo().trim().equals("tipoExtranjeroColegio"))
						senescytTituloDTO.setTipoExtranjeroColegio(c.getValor());

					if (c.getCampo().trim().equals("tipoTitulo"))
						senescytTituloDTO.setTipoTitulo(c.getValor());
				}

				senescytDTO.getSenescytTituloDTOs().add(senescytTituloDTO);
				senescytTituloDTO = new SenescytTituloDTO();

			}

		}

		return senescytDTO;

	}

	

}
