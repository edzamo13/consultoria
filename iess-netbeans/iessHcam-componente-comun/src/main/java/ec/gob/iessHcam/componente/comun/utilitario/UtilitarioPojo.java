/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.componente.comun.utilitario;

/**
 *
 * @author root
 */
public class UtilitarioPojo {
    /*
    public static ReporteEntrada generarEntradaWsReporte(Object objetoDto) throws ServicioExcepcion {
        ReporteEntrada reporteEntrada = new ReporteEntrada();
        List<ReporteCampo> camposResporte = new ArrayList();

        Method[] metodos = objetoDto.getClass().getDeclaredMethods();
        Field[] campos = objetoDto.getClass().getDeclaredFields();

        for (Method metodo : metodos) {
            try {
                if (metodo.getName().startsWith("get")) {
                    ReporteCampo reporteCampo = new ReporteCampo();
                    reporteCampo.setLlave(getNombreCampo(campos, metodo.getName().substring(3)));
                    reporteCampo.setValor((String) metodo.invoke(objetoDto));
                    camposResporte.add(reporteCampo);
                }
            } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
                throw new ServicioExcepcion(e);
            }
        }

        reporteEntrada.setListaCamposReemplazar(camposResporte);

        return reporteEntrada;
    }

    public static MailEntrada generarEntradaWsMail(Object objetoDto, Class clasePojo) throws ServicioExcepcion {
        MailEntrada mailEntrada = new MailEntrada();
        List<MailVariable> camposMail = new ArrayList();

        Method[] metodos = objetoDto.getClass().getDeclaredMethods();
        Field[] campos = objetoDto.getClass().getDeclaredFields();

        for (Method metodo : metodos) {
            try {
                if (metodo.getName().startsWith("get")) {
                    MailVariable mailVariable = new MailVariable();
                    mailVariable.setNombre(getNombreCampo(campos, metodo.getName().substring(3)));
                    mailVariable.setValor((String) metodo.invoke(objetoDto));
                    camposMail.add(mailVariable);
                }
            } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
                throw new ServicioExcepcion(e);
            }
        }

        mailEntrada.setVariables(camposMail);

        return mailEntrada;
    }

    private static String getNombreCampo(Field[] campos, String nombreCampo) {
        for (Field campo : campos) {
            if (nombreCampo.toUpperCase().equals(campo.getName().toUpperCase())) {
                nombreCampo = campo.getName();
            }
        }

        return nombreCampo;
    }
     */
}
