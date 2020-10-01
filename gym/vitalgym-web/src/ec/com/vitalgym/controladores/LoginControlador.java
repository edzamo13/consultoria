package ec.com.vitalgym.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.com.vitalgym.local.RhGlbUsuPefLocal;
import ec.com.vitalgym.local.RhGlbUsuarioLocal;
import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.modelo.RhGlbUsuario;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Named
public class LoginControlador extends UtilitarioJsf implements Serializable {
	private static final long serialVersionUID = 7965455427888195913L;

	/*
	 * @EJB private RhGlbUsuarioLocal rhGlbUsuarioLocal;
	 */
	@EJB
	private RhGlbUsuarioLocal rhGlbUsuarioLocal;
	@EJB
	private RhGlbUsuPefLocal rhGlbUsuPefLocal;

	@Getter
	@Setter
	private String userName;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private Integer perfil;
	@Getter
	@Setter
	private RhGlbUsuario rhGlbUsuario;
	@Getter
	@Setter
	private RhGlbPerfil rhGlbPerfil;

	public String entrar() {
		String retorno = "fail";
		System.out.println("USUARIO ---> " + getUserName());
		System.out.println("CLAVE ---> " + sha1(getPassword()));
		setRhGlbUsuario(rhGlbUsuarioLocal.buscarUsuario(getUserName()));
		try {
			System.out.println("CLAVE BDD ---> " + rhGlbUsuario.getUsuContrasena());
			if ((rhGlbUsuario.getUsuContrasena().equals(sha1(getPassword())))) {
				// Jalar perfil desde la base
				rhGlbPerfil = rhGlbUsuPefLocal.buscarPerfilxUsuario(rhGlbUsuario);
				perfil = rhGlbPerfil.getPefCodigo();
				retorno = "success";
				System.out.println("Usuario Aceptado!! ---> " + rhGlbUsuario.getUsuUsuario());
			} else {
				System.out.println("Acceso Denegado!! ---> " + rhGlbUsuario.getUsuUsuario());
				ponerMensajeAlerta("Usuario o Contraseña incorrectos..");
			}
		} catch (Exception e) {
			/*
			 * if ((getPassword().equalsIgnoreCase("admin") && getUserName()
			 * .equalsIgnoreCase("admin"))) { retorno = "success"; }
			 */
			System.out.println(e.getMessage());
			System.out.println("Usuario Desconocido!! ---> " + getUserName());

		}
		return retorno;
	}

	public boolean isLoggedIn() {
		boolean retorno = false;
		// if (rhGlbUsuarioList.get(0).getUsuCodigo() != null)
		if (rhGlbUsuario.getUsuCodigo() != 0)
			retorno = true;
		return retorno;
	}

	public void logOut() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().redirect("../public/login.xhtml");
	}

	/**
	 * 
	 * @param clave
	 *            String que se quiere convertir
	 * @return String digerido en sha1
	 */
	private String sha1(String clave) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(clave.getBytes());
			byte[] output = md.digest();
			// sha1tmp();
			return bytesToHex(output);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return "";
	}

	/**
	 * 
	 * @param b
	 *            Arreglo de Bytes que quiere ser convertido a String
	 * @return String convertido
	 */
	private String bytesToHex(byte[] b) {
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'b', 'b', 'e', 'f' };
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}

	
}