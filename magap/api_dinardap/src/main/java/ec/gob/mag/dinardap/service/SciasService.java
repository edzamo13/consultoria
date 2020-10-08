package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SciasAccionistas;
import ec.gob.mag.dinardap.dto.SciasAccionistasCampos;
import ec.gob.mag.dinardap.dto.SciasActividadEconomica;
import ec.gob.mag.dinardap.dto.SciasActividadEconomicaCampos;
import ec.gob.mag.dinardap.dto.SciasAdministrador;
import ec.gob.mag.dinardap.dto.SciasAdministradorCampos;
import ec.gob.mag.dinardap.dto.SciasDTO;
import ec.gob.mag.dinardap.dto.SciasDato;
import ec.gob.mag.dinardap.dto.SciasDatoCampos;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SciasService {

	private static final String DATOS = "Superintendencia de Compañias Datos Companía";
	private static final String ACCIONISTAS = "Superintendencia de Compañias Datos Accionistas";
	private static final String ACTIVIDAD_ECONOMICA = "Superintendencia de Compañias Datos Actividades Económicas";
	private static final String ADMINISTRADOR = "Superintendencia de Compañias Datos Administradores";

	/**
	 * 
	 * */
	public static SciasDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato) throws ConsultarFaultException {
		SciasDTO sciasDTO = new SciasDTO();
		sciasDTO.setSciasDato(new SciasDato());
		sciasDTO.setSciasAccionistas(new SciasAccionistas());
		sciasDTO.setSciasActividadEconomica(new SciasActividadEconomica());
		sciasDTO.setSciasAdministrador(new SciasAdministrador());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);
		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				sciasDTO.setSciasDato(obtenerDatos(entidad.getFilas()));
			} else if (entidad.getNombre().equals(ACCIONISTAS)) {
				sciasDTO.setSciasAccionistas(obtenerAccionistas(entidad.getFilas()));
			} else if (entidad.getNombre().equals(ACTIVIDAD_ECONOMICA)) {
				sciasDTO.setSciasActividadEconomica(obtenerActividadesEconomicas(entidad.getFilas()));
			} else if (entidad.getNombre().equals(ADMINISTRADOR)) {
				sciasDTO.setSciasAdministrador(obtenerAdministradores(entidad.getFilas()));
			}

		}

		return sciasDTO;

	}

	private static SciasDato obtenerDatos(Filas filas) {
		SciasDato sciasDato = new SciasDato();
		sciasDato.setDatos(new ArrayList<SciasDatoCampos>());
		sciasDato.setCompaniasDatos(DATOS);
		SciasDatoCampos dato = new SciasDatoCampos();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("fecha_constitucion")) {
					dato.setFechaConstitucion(c.getValor());
				}

			}
			sciasDato.getDatos().add(dato);
			dato = new SciasDatoCampos();

		}
		return sciasDato;
	}

	private static SciasAccionistas obtenerAccionistas(Filas filas) {
		SciasAccionistas sciasAccionistas = new SciasAccionistas();
		sciasAccionistas.setCompaniasDatosAccionistas(ACCIONISTAS);
		sciasAccionistas.setAccionistasCampos(new ArrayList<SciasAccionistasCampos>());
		SciasAccionistasCampos accionistasCampos = new SciasAccionistasCampos();

		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {
				if (c.getCampo().trim().equals("nombre")) {
					accionistasCampos.setNombre(c.getValor());
				}
				if (c.getCampo().trim().equals("identificacion_accionista")) {
					accionistasCampos.setIdentificacionAccionista(c.getValor());
				}
				if (c.getCampo().trim().equals("nombre_accionista")) {
					accionistasCampos.setNombreAccionista(c.getValor());
				}

			}
			sciasAccionistas.getAccionistasCampos().add(accionistasCampos);
			accionistasCampos = new SciasAccionistasCampos();

		}

		return sciasAccionistas;
	}

	private static SciasActividadEconomica obtenerActividadesEconomicas(Filas filas) {
		SciasActividadEconomica actividadEconomica = new SciasActividadEconomica();
		actividadEconomica.setCompaniasDatosActividadesEconomicas(ACTIVIDAD_ECONOMICA);
		actividadEconomica.setSciasActividadEconomicaCampos(new ArrayList<SciasActividadEconomicaCampos>());
		SciasActividadEconomicaCampos actividadEconomicaCampos = new SciasActividadEconomicaCampos();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {
				if (c.getCampo().trim().equals("")) {
					actividadEconomicaCampos.setDato(c.getValor());
				}

			}
			actividadEconomica.getSciasActividadEconomicaCampos().add(actividadEconomicaCampos);
			actividadEconomicaCampos = new SciasActividadEconomicaCampos();

		}

		return actividadEconomica;
	}

	private static SciasAdministrador obtenerAdministradores(Filas filas) {
		SciasAdministrador sciasAdministrador = new SciasAdministrador();
		sciasAdministrador.setCompaniasDatosAdministradores(ADMINISTRADOR);
		sciasAdministrador.setAdministradorCampos(new ArrayList<SciasAdministradorCampos>());
		SciasAdministradorCampos administradorCampos = new SciasAdministradorCampos();

		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {
				if (c.getCampo().trim().equals("cargo")) {
					administradorCampos.setCargo(c.getValor());
				}
				if (c.getCampo().trim().equals("fecha_nombramiento")) {
					administradorCampos.setFechaNombramiento(c.getValor());
				}
				if (c.getCampo().trim().equals("cedula_administrador")) {
					administradorCampos.setCedulaAdministrador(c.getValor());
				}
				if (c.getCampo().trim().equals("nombre")) {
					administradorCampos.setNombre(c.getValor());
				}
				if (c.getCampo().trim().equals("representante_legal")) {
					administradorCampos.setRepresentanteLegal(c.getValor());
				}

			}
			sciasAdministrador.getAdministradorCampos().add(administradorCampos);
			administradorCampos = new SciasAdministradorCampos();

		}

		return sciasAdministrador;
	}

}
