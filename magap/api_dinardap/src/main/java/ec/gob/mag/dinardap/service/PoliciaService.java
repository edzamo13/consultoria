package ec.gob.mag.dinardap.service;

import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.Policia;
import ec.gob.mag.dinardap.dto.PoliciaDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PoliciaService {

	private static final String DATOS = "Policía Nacional Antecedentes";

	/**
	 * 
	 * */
	public static PoliciaDTO obtenerDatos(DinardapTipoPeticionEnum param, String policia)
			throws ConsultarFaultException {
		PoliciaDTO policiaDTO = new PoliciaDTO();
		policiaDTO.setPolicia(new Policia());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), policia);
		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				policiaDTO.setNombreEntidad(DATOS);
				policiaDTO.setPolicia(obtenerpolicias(entidad.getFilas()));

			}
		}
		return policiaDTO;

	}

	private static Policia obtenerpolicias(Filas filas) {

		Policia policia = new Policia();

		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("documento")) {
					policia.setDocumento(c.getValor());
				}
				if (c.getCampo().trim().equals("ordenCaptura")) {
					policia.setOrdenCaptura(c.getValor());
				}
				if (c.getCampo().trim().equals("antecedentes")) {
					policia.setAntecedentes(c.getValor());
				}
				if (c.getCampo().trim().equals("impedimentoSalida")) {
					policia.setImpedimentoSalida(c.getValor());
				}
				if (c.getCampo().trim().equals("alertaMigratoria")) {
					policia.setAlertaMigratoria(c.getValor());
				}

			}
			// policiaDTO.setPolicia(policia);
			// policia = new Policia();

		}
		return policia;
	}

}
