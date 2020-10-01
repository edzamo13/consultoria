package ec.com.vitalgym.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ec.com.vitalgym.local.RhGlbPerfilLocal;
import ec.com.vitalgym.modelo.RhGlbPerfil;


/**
 * 
 *
 */
@ManagedBean
public class PerfilConvertor implements Converter {
	@EJB
	private RhGlbPerfilLocal perfiles;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		int id = new Integer(value);
		return perfiles.buscarId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Integer id = ((RhGlbPerfil) value).getPefCodigo();
		return (id == null) ? null : id.toString();
	}

}