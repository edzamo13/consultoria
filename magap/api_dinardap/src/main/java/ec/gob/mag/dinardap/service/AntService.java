package ec.gob.mag.dinardap.service;

import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.mag.dinardap.dto.AntDTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class AntService {
 
	public static AntDTO obtenerDatos(DinardapTipoPeticionEnum param, String dato) throws ConsultarFaultException {
		AntDTO antDTO = new AntDTO();

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		entidades.stream().forEach(e -> {
			antDTO.setNombreEntidad(e.getNombre());
			e.getFilas().getFila().stream().forEach(f -> {
				f.getColumnas().getColumna().stream().forEach(c -> {

					// System.out.println(c.getCampo() + " = " + c.getValor());

					if (c.getCampo().trim().equals("anio"))
						antDTO.setAnio(c.getValor());

					if (c.getCampo().trim().equals("chasis"))
						antDTO.setChasis(c.getValor());

					if (c.getCampo().trim().equals("cilindraje"))
						antDTO.setCilindraje(c.getValor());

					if (c.getCampo().trim().equals("claseVehiculo"))
						antDTO.setClaseVehiculo(c.getValor());

					if (c.getCampo().trim().equals("color"))
						antDTO.setColor(c.getValor());

					if (c.getCampo().trim().equals("color2"))
						antDTO.setColor2(c.getValor());

					if (c.getCampo().trim().equals("combustible"))
						antDTO.setCombustible(c.getValor());

					if (c.getCampo().trim().equals("direccion"))
						antDTO.setDireccion(c.getValor());

					if (c.getCampo().trim().equals("docPropietario"))
						antDTO.setDocPropietario(c.getValor());

					if (c.getCampo().trim().equals("marca"))
						antDTO.setMarca(c.getValor());

					if (c.getCampo().trim().equals("modelo"))
						antDTO.setModelo(c.getValor());
					
					if (c.getCampo().trim().equals("motor"))
						antDTO.setMotor(c.getValor());
					
					if (c.getCampo().trim().equals("nombres"))
						antDTO.setNombres(c.getValor());
					
					if (c.getCampo().trim().equals("placaAnterior"))
						antDTO.setPlacaAnterior(c.getValor());
					
					if (c.getCampo().trim().equals("tipoVehiculo"))
						antDTO.setTipoVehiculo(c.getValor());
				});
			});
		});

		return antDTO;

	}

}
