package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SercopDatoCampos;
import ec.gob.mag.dinardap.dto.SercopDTO;
import ec.gob.mag.dinardap.dto.SercopDato;
import ec.gob.mag.dinardap.dto.SercopTelefono;
import ec.gob.mag.dinardap.dto.SercopTelefonoCampos;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SercopService {

	private static final String DATOS = "Entidad (Sercop)";
	private static final String TELEFONO = "Teléfonos Entidad (Sercop)";

	/**
	 * 
	 * */
	public static SercopDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato) throws ConsultarFaultException {
		SercopDTO sercopDTO = new SercopDTO();
		sercopDTO.setDato(new SercopDato());
		sercopDTO.setTelefono(new SercopTelefono());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);
		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				sercopDTO.setDato(obtenerDatos(entidad.getFilas()));
			} else if (entidad.getNombre().equals(TELEFONO)) {
				sercopDTO.setTelefono(obtenerTelefono(entidad.getFilas()));
			}

		}

		return sercopDTO;

	}

	private static SercopDato obtenerDatos(Filas filas) {
		SercopDato sercopDato = new SercopDato();
		sercopDato.setNombreEntidadDato(DATOS);
		sercopDato.setDatos(new ArrayList<SercopDatoCampos>());
		SercopDatoCampos dato = new SercopDatoCampos();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("cedula")) {
					dato.setCedula(c.getValor());
				}
				if (c.getCampo().trim().equals("anioActividad")) {
					dato.setAnioActividad(c.getValor());
				}
				if (c.getCampo().trim().equals("calle")) {
					dato.setCalle(c.getValor());
				}
				if (c.getCampo().trim().equals("canton")) {
					dato.setCanton(c.getValor());
				}
				if (c.getCampo().trim().equals("departamento")) {
					dato.setDepartamento(c.getValor());
				}
				if (c.getCampo().trim().equals("edificio")) {
					dato.setEdificio(c.getValor());
				}
				if (c.getCampo().trim().equals("interseccion")) {
					dato.setInterseccion(c.getValor());
				}
				if (c.getCampo().trim().equals("nombreComercial")) {
					dato.setNombreComercial(c.getValor());
				}
				if (c.getCampo().trim().equals("numero")) {
					dato.setNumero(c.getValor());
				}
				if (c.getCampo().trim().equals("paginaWeb")) {
					dato.setPaginaWeb(c.getValor());
				}
				if (c.getCampo().trim().equals("parroquia")) {
					dato.setParroquia(c.getValor());
				}
				if (c.getCampo().trim().equals("razonSocial")) {
					dato.setRazonSocial(c.getValor());
				}
				if (c.getCampo().trim().equals("provincia")) {
					dato.setProvincia(c.getValor());
				}
				if (c.getCampo().trim().equals("ruc")) {
					dato.setRuc(c.getValor());
				}
				if (c.getCampo().trim().equals("tipoOrigen")) {
					dato.setTipoOrigen(c.getValor());
				}
				if (c.getCampo().trim().equals("tipoPersona")) {
					dato.setTipoPersona(c.getValor());
				}

			}
			sercopDato.getDatos().add(dato);
			dato = new SercopDatoCampos();

		}
		return sercopDato;
	}

	private static SercopTelefono obtenerTelefono(Filas filas) {
		SercopTelefono sercopTelefono = new SercopTelefono();
		sercopTelefono.setNombreEntidadTelefono(TELEFONO);
		sercopTelefono.setTelefonos(new ArrayList<SercopTelefonoCampos>());
		SercopTelefonoCampos telefono = new SercopTelefonoCampos();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {
				if (c.getCampo().trim().equals("telefono")) {
					telefono.setTelefono(c.getValor());
				}

			}
			sercopTelefono.getTelefonos().add(telefono);
			telefono = new SercopTelefonoCampos();

		}

		return sercopTelefono;
	}

}
