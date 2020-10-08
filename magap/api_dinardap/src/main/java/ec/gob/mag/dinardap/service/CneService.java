package ec.gob.mag.dinardap.service;

import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.mag.dinardap.dto.CneDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class CneService {

	public static CneDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato) throws ConsultarFaultException {
		CneDTO cneDTO = new CneDTO();

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		entidades.stream().forEach(e -> {
			cneDTO.setNombreEntidad(e.getNombre());
			e.getFilas().getFila().stream().forEach(f -> {
				f.getColumnas().getColumna().stream().forEach(c -> {

					if (c.getCampo().trim().equals("provincia"))
						cneDTO.setProvincia(c.getValor());

					if (c.getCampo().trim().equals("canton"))
						cneDTO.setCanton(c.getValor());

					if (c.getCampo().trim().equals("parroquia"))
						cneDTO.setParroquia(c.getValor());

					if (c.getCampo().trim().equals("cedula"))
						cneDTO.setCedula(c.getValor());

					if (c.getCampo().trim().equals("nombre"))
						cneDTO.setNombre(c.getValor());

					if (c.getCampo().trim().equals("multa"))
						cneDTO.setMulta(c.getValor());

					if (c.getCampo().trim().equals("codigoElectoral"))
						cneDTO.setCodigoElectoral(c.getValor());

					if (c.getCampo().trim().equals("fechaP"))
						cneDTO.setFechaP(c.getValor());

					if (c.getCampo().trim().equals("habilitadoTPublico"))
						cneDTO.setHabilitadoTPublico(c.getValor());
					
				});
			});
		});

		return cneDTO;

	}

}
