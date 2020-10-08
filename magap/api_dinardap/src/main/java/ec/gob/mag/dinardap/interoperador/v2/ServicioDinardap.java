package ec.gob.mag.dinardap.interoperador.v2;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import ec.gob.dinardap.interoperador.v2.wsdl.Consultar;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarResponse;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Interoperador;
import ec.gob.dinardap.interoperador.v2.wsdl.Parametro;
import ec.gob.dinardap.interoperador.v2.wsdl.Parametros;
import ec.gob.mag.dinardap.enumeration.DinardapEnum;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;

/**
 * @author Dinardap
 * @category Consumo Servicio Web WSDL
 * @see Edwin Zamora
 * @version version 2
 * 
 * 
 */
public class ServicioDinardap {

	/**
	 * @param codigoPaquete
	 * @param codigoPaqueteValor
	 * @param tipoDato           (identificacion(ci,ruc))
	 * @param tipoDatoValor      valor
	 * @return List<Entidad>
	 * @throws ConsultarFaultException
	 */

	public static List<Entidad> getDatosDINARDAP(String codigoPaquete, String codigoPaqueteValor, String tipoDato,
			String tipoDatoValor) throws ConsultarFaultException {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Interoperador.class);
		factory.setAddress(DinardapEnum.ADDRESS.getValue());
		factory.setUsername(DinardapEnum.USUARIO.getValue());
		factory.setPassword(DinardapEnum.PASSWORD.getValue());
		Interoperador port = (Interoperador) factory.create();
		Client client = ClientProxy.getClient(port);

		if (client != null) {
			HTTPConduit conduit = (HTTPConduit) client.getConduit();
			HTTPClientPolicy policy = new HTTPClientPolicy();
			policy.setAllowChunking(false);
			conduit.setClient(policy);

		}
		Parametro paramCodigoPaquete = new Parametro();
		paramCodigoPaquete.setNombre(codigoPaquete);
		paramCodigoPaquete.setValor(codigoPaqueteValor);
		Parametro paramIdent = new Parametro();
		paramIdent.setNombre(tipoDato);
		paramIdent.setValor(tipoDatoValor);

		Parametros parametros = new Parametros();
		parametros.getParametro().add(paramCodigoPaquete);
		parametros.getParametro().add(paramIdent);
		
		
		//Validar con Dinardap Si es constante
		if(codigoPaqueteValor.equals(DinardapTipoPeticionEnum.SRI_VI.getCodigoPaquete())) {
			Parametro srVi = new Parametro();
			srVi.setNombre(DinardapTipoPeticionEnum.SRI_VI.getCodigoTipoDocumento());
			srVi.setValor(DinardapTipoPeticionEnum.SRI_VI.getCodigoTipoDocumentoDato());
			parametros.getParametro().add(srVi);
			
		}
		
		Consultar consultar = new Consultar();
		consultar.setParametros(parametros);
		ConsultarResponse response = port.consultar(consultar);

		List<Entidad> entidades = response.getPaquete().getEntidades().getEntidad();

		return entidades;

	}
}
