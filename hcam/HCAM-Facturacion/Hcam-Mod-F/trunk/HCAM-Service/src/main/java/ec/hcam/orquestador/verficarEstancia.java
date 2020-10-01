package ec.hcam.orquestador;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import ec.hcam.entities.Cabtaritbl;
import ec.hcam.entities.Detplantbl;
import ec.hcam.orquestador.verificarEstanciaRemote;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

/**
 * Session Bean implementation class verficarEstancia
 */
@Stateless
@Remote(verificarEstanciaRemote.class)
@LocalBean
public class verficarEstancia implements verificarEstanciaRemote {

    /**
     * Default constructor.
     */
    public verficarEstancia() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see verificarEstanciaRemote#registrarDetallePlanillaje(Detplantbl)
     */
    public void registrarDetallePlanillaje() {
        Detplantbl detalle = new Detplantbl();
        detalle.setPlavto(aplicarRegla());
    }

    /**
     * @see verificarEstanciaRemote#obtenerCabeceraPlanillajeMensual(int)
     */
    public Cabtaritbl obtenerCabeceraPlanillajeMensual(int mes) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see verificarEstanciaRemote#obtenerCabeceraPlanillajeDiario(int)
     */
    public Cabtaritbl obtenerCabeceraPlanillajeDiario(int dia) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see verificarEstanciaRemote#consultarValorTarifario(String)
     */
    public int consultarValorTarifario(String codigoTarifario) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @see verificarEstanciaRemote#aplicarRegla()
     */
    public int aplicarRegla() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine groovy = scriptEngineManager
                .getEngineByExtension("groovy");

        try (Reader reader = new FileReader(new File(
                obtenerReglas()))) {
            ScriptContext scriptContext = new SimpleScriptContext();

            Engine result = (Engine) groovy.eval(reader, scriptContext);
            result.evaluar(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int valor = consultarValorTarifario("22222");

        return valor;
    }

    @Override
    public String obtenerReglas() {
        String direccionArchivo = "E:\\wshcam\\engine.groovy";
        return direccionArchivo;
    }

}
