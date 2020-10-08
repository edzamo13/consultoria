package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SriAutorizacionEmisionCampos;
import ec.gob.mag.dinardap.dto.SriAutorizacionEmisionDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class SriAutorizacionEmisionService {

	private static final String DATOS = "Autorización Emisión (SRI)";

	public static SriAutorizacionEmisionDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {

		SriAutorizacionEmisionDTO sriAutorizacionEmisionDTO = new SriAutorizacionEmisionDTO();
		sriAutorizacionEmisionDTO.setAutorizacionEmisionCampos(new ArrayList<SriAutorizacionEmisionCampos>());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				sriAutorizacionEmisionDTO.setNombreEntidad(DATOS);
				sriAutorizacionEmisionDTO.setAutorizacionEmisionCampos(obtenerDatos(entidad.getFilas()));
			}
		}
		return sriAutorizacionEmisionDTO;
	}

	private static List<SriAutorizacionEmisionCampos> obtenerDatos(Filas filas) {
		SriAutorizacionEmisionCampos sriAutorizacionEmisionCampos = new SriAutorizacionEmisionCampos();
		List<SriAutorizacionEmisionCampos> listAutorizacionEmisionCampos= new ArrayList<SriAutorizacionEmisionCampos>();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("suspensionRuc"))
					sriAutorizacionEmisionCampos.setSuspensionRuc(c.getValor());
				
				if (c.getCampo().trim().equals("imprenta"))
				sriAutorizacionEmisionCampos.setImprenta(c.getValor());
				
				if (c.getCampo().trim().equals("suspensionEst"))
					sriAutorizacionEmisionCampos.setSuspensionEst(c.getValor());
				
				if (c.getCampo().trim().equals("fechaInicioDetalle"))
					sriAutorizacionEmisionCampos.setFechaInicioDetalle(c.getValor());
				
				if (c.getCampo().trim().equals("fechaFinDetalle"))
					sriAutorizacionEmisionCampos.setFechaFinDetalle(c.getValor());
				
				if (c.getCampo().trim().equals("id"))
					sriAutorizacionEmisionCampos.setId(c.getValor());
				
				if (c.getCampo().trim().equals("idModalidadEmision"))
					sriAutorizacionEmisionCampos.setIdModalidadEmision(c.getValor());
				
				if (c.getCampo().trim().equals("codigoAutorizacion"))
					sriAutorizacionEmisionCampos.setCodigoAutorizacion(c.getValor());
				
				if (c.getCampo().trim().equals("numeroRuc"))
					sriAutorizacionEmisionCampos.setNumeroRuc(c.getValor());
				
				if (c.getCampo().trim().equals("establecContribuyente"))
					sriAutorizacionEmisionCampos.setEstablecContribuyente(c.getValor());
				
				if (c.getCampo().trim().equals("puntoEmisionContribuyente"))
					sriAutorizacionEmisionCampos.setPuntoEmisionContribuyente(c.getValor());
				
				if (c.getCampo().trim().equals("idTipoDocumento"))
					sriAutorizacionEmisionCampos.setIdTipoDocumento(c.getValor());
				
				if (c.getCampo().trim().equals("numeroInicialImpreso"))
					sriAutorizacionEmisionCampos.setNumeroInicialImpreso(c.getValor());
				
				if (c.getCampo().trim().equals("numeroFinalImpreso"))
					sriAutorizacionEmisionCampos.setNumeroFinalImpreso(c.getValor());
				
				if (c.getCampo().trim().equals("idRangoImpreso"))
					sriAutorizacionEmisionCampos.setIdRangoImpreso(c.getValor());
				
				if (c.getCampo().trim().equals("numeroEstablecimientoBaja"))
					sriAutorizacionEmisionCampos.setNumeroEstablecimientoBaja(c.getValor());
				
				if (c.getCampo().trim().equals("numeroInicialBaja"))
					sriAutorizacionEmisionCampos.setNumeroInicialBaja(c.getValor());
					
				if (c.getCampo().trim().equals("numeroFinalBaja"))
					sriAutorizacionEmisionCampos.setNumeroFinalBaja(c.getValor());
				
				if (c.getCampo().trim().equals("numeroInicialAutoimpreso"))
					sriAutorizacionEmisionCampos.setNumeroInicialAutoimpreso(c.getValor());
				
				if (c.getCampo().trim().equals("numeroFinalAutoimpreso"))
					sriAutorizacionEmisionCampos.setNumeroFinalAutoimpreso(c.getValor());
				
				if (c.getCampo().trim().equals("numeroSerie"))
					sriAutorizacionEmisionCampos.setNumeroSerie(c.getValor());
				
				if (c.getCampo().trim().equals("idModeloRegistradora"))
					sriAutorizacionEmisionCampos.setIdModeloRegistradora(c.getValor());
				
				if (c.getCampo().trim().equals("idEstado"))
					sriAutorizacionEmisionCampos.setIdEstado(c.getValor());
				
				if (c.getCampo().trim().equals("fechaInicio"))
					sriAutorizacionEmisionCampos.setFechaInicio(c.getValor());
				
				if (c.getCampo().trim().equals("fechaFin"))
					sriAutorizacionEmisionCampos.setFechaFin(c.getValor());
				
				if (c.getCampo().trim().equals("codigoImprenta"))
					sriAutorizacionEmisionCampos.setCodigoImprenta(c.getValor());
				
				if (c.getCampo().trim().equals("fechaSuspensionRuc"))
					sriAutorizacionEmisionCampos.setFechaSuspensionRuc(c.getValor());
				
				if (c.getCampo().trim().equals("codigo"))
					sriAutorizacionEmisionCampos.setCodigo(c.getValor());
				
				if (c.getCampo().trim().equals("descripcion"))
					sriAutorizacionEmisionCampos.setDescripcion(c.getValor());
				
				if (c.getCampo().trim().equals("abreviacion"))
					sriAutorizacionEmisionCampos.setAbreviacion(c.getValor());
				
				if (c.getCampo().trim().equals("activo"))
					sriAutorizacionEmisionCampos.setActivo(c.getValor());
				
				
				if (c.getCampo().trim().equals("visualizar"))
					sriAutorizacionEmisionCampos.setVisualizar(c.getValor());

				
				
				
			}
			listAutorizacionEmisionCampos.add(sriAutorizacionEmisionCampos);
			sriAutorizacionEmisionCampos = new SriAutorizacionEmisionCampos();

		}
		return listAutorizacionEmisionCampos;
	}

}
