package ec.gob.iessHcam.componente.comun.utilitario.jsf;

public enum Pagina {
	
	LOGIN("http://172.16.98.130:8080/iessHcam-componente-seguridad-web/pages/public/login.jsf");
	
	String www;

	private Pagina(String www) {
		this.www = www;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}
	
	

}
