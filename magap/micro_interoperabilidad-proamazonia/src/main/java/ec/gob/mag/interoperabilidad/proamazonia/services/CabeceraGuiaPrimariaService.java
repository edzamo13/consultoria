package ec.gob.mag.interoperabilidad.proamazonia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.gob.mag.interoperabilidad.proamazonia.domain.CabeceraGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.repository.CabeceraGuiaPrimariaRepository;


@Service("cabeceraGuiaPrimariaService")
public class CabeceraGuiaPrimariaService {

	@Autowired
	@Qualifier("cabeceraGuiaPrimariaRepository")
	private CabeceraGuiaPrimariaRepository cabeceraGuiaPrimariaRepository;


	public List<CabeceraGuiaPrimaria> buscarCabecera() {
		List<CabeceraGuiaPrimaria> cabeceraGuiaPrimarias =  (List<CabeceraGuiaPrimaria>) cabeceraGuiaPrimariaRepository.findAll();
		return cabeceraGuiaPrimarias;
	}

	/**
	 * Guarda un registro
	 * 
	 * @param entidad: Contiene todos campos de la entidad para guardar
	 * @return catalogo: La entidad Guardada
	 */
	public CabeceraGuiaPrimaria save(CabeceraGuiaPrimaria cabeceraGuiaPrimaria) {
		return cabeceraGuiaPrimariaRepository.save(cabeceraGuiaPrimaria);
	}
}
