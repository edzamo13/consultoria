package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SriFormulario104Campos;
import ec.gob.mag.dinardap.dto.SriFormulario104DTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class SriFormulario104Service {

	private static final String DATOS = "Formulario 104 (SRI)";

	public static SriFormulario104DTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {

		SriFormulario104DTO formulario104dto = new SriFormulario104DTO();
		formulario104dto.setSriFormulario104Campos(new ArrayList<SriFormulario104Campos>());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				formulario104dto.setNombreEntidad(DATOS);
				formulario104dto.setSriFormulario104Campos(obtenerDatos(entidad.getFilas()));
			}
		}
		return formulario104dto;
	}

	private static List<SriFormulario104Campos> obtenerDatos(Filas filas) {
		SriFormulario104Campos formulario104Campos = new SriFormulario104Campos();
		List<SriFormulario104Campos> listFormulario104Campos = new ArrayList<SriFormulario104Campos>();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("anioFiscal"))
					formulario104Campos.setAnioFiscal(c.getValor());

				if (c.getCampo().trim().equals("exportacionesNetasBienes800"))
					formulario104Campos.setExportacionesNetasBienes800(c.getValor());

				if (c.getCampo().trim().equals("razonSocial"))
					formulario104Campos.setRazonSocial(c.getValor());
				
				if (c.getCampo().trim().equals("totImpVtEipIafTdc890"))
					formulario104Campos.setTotImpVtEipIafTdc890(c.getValor());
				
				if (c.getCampo().trim().equals("totVtExpBruIaf860"))
					formulario104Campos.setTotVtExpBruIaf860(c.getValor());
				
				if (c.getCampo().trim().equals("totVtExpNtaIafTcd870"))
					formulario104Campos.setTotVtExpNtaIafTcd870(c.getValor());
				
				
			}
			listFormulario104Campos.add(formulario104Campos);
			formulario104Campos = new SriFormulario104Campos();

		}
		return listFormulario104Campos;
	}

}
