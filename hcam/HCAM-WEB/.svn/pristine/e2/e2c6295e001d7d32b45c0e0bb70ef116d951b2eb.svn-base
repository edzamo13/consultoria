package ec.hcam;


import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;

import ec.hcam.entity.Tarifaftbl;
import ec.hcam.data.TarifaftblDao;
import ec.hcam.entity.Servtbl;

import org.sql2o.logging.SysOutLogger;

//@ViewScoped
//@SessionScoped
@ViewScoped
@ManagedBean(name = "tarifarioController")
public class TarifarioController {

	@EJB
	private TarifaftblFacadeRemote obtenerInformacionService;
	private List<Tarifaftbl> tarifarioLista;

    public List<Tarifaftbl> getTarifarioLista() {
        return tarifarioLista;
    }

    public void setTarifarioLista(List<Tarifaftbl> tarifarioLista) {
        this.tarifarioLista = tarifarioLista;
    }

        @PostConstruct
	public void postConstruct() {
		try{
		//archivosFacturaD = new ArrayList<>();
		recuperaTodosLosTarifarios();
		}
		catch(NullPointerException npee){
			System.out.println(npee.getMessage());
		}
	}

        public void recuperaTarifario(){
        //Tarifaftbl tarif = obtenerInformacionService.buscarTarifario();
        //int clave = tarif.getTaidpk();
        //String codigo = tarif.getTacodigo();
           // System.out.print("El codigo es"+clave+"El codigo String es:"+codigo);
        }
        public void recuperaTodosLosTarifarios(){
        tarifarioLista = obtenerInformacionService.findAll();
        
        for(int i=0; i<tarifarioLista.size();i++){
        System.out.print("El id es:"+tarifarioLista.get(i).getTaidpk());
        System.out.print("El codigo es:"+tarifarioLista.get(i).getTacodigo());
        }
        //int clave = tarif.getTaidpk();
        //String codigo = tarif.getTacodigo();
        //    System.out.print("El codigo es"+clave+"El codigo String es:"+codigo);
        }
}
