package ec.gob.mag.interoperabilidad.proamazonia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.gob.mag.interoperabilidad.proamazonia.domain.CabeceraGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DetalleGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.repository.DetalleGuiaPrimariaRepository;

@Service("detalleGuiaPrimariaService")
public class DetalleGuiaPrimariaService {

	@Autowired
	@Qualifier("detalleGuiaPrimariaRepository")
	private DetalleGuiaPrimariaRepository detalleGuiaPrimariaRepository;


	public List<DetalleGuiaPrimaria> buscarGmvId(CabeceraGuiaPrimaria gmvId) {
		return detalleGuiaPrimariaRepository.findBygmvIdEquals(gmvId);   
	}

	
	public List<DetalleGuiaPrimaria> findAll(){
		return (List<DetalleGuiaPrimaria>) detalleGuiaPrimariaRepository.findAll();
	}
	
}
