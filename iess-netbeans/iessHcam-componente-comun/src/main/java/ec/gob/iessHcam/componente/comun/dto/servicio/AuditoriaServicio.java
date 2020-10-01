/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.dto.servicio;


import ec.gob.iessHcam.componente.comun.dto.AuditoriaDetalle;
import ec.gob.iessHcam.componente.comun.dto.Auditoria;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.EscuchaEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 <b>
 * Clase de Usuario será utilizada para la conexión con la capa web.
 * </b>
 *
 * @author ezamoram
 * <p>
 * [$Author: ezamoram $, $Date: 08/02/2016]</p>
 */
public class AuditoriaServicio <E,F, ID extends Serializable> extends UtilitarioJsf{

    
    //public Auditoria nuevoObjeto(E nuevo,String idEntidad, UsuarioSalida usuario) {
    public Auditoria nuevoObjeto(E nuevo,String idEntidad) {
        try {
            
            UsuarioSalida usuario = (UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto());
            
            String valorA;
            Method metodos[],ejecutaA;
            Field campos[];
            
            metodos= nuevo.getClass().getMethods();
            campos= nuevo.getClass().getDeclaredFields();
            
            Table table = (Table) nuevo.getClass().getAnnotation(Table.class); //captura el nombre de la tabla afectada
            Auditoria auditoria = new Auditoria();
            auditoria.setAudEsquema(table.schema());
            auditoria.setAudTabla(table.name());
            auditoria.setAudFecha(new Date());
            auditoria.setAudUsuario(usuario.getUsuario());
            auditoria.setAudCodunme(usuario.getCodUnme());
            //auditoria.setAudUsuario("comun");
            //auditoria.setAudCodunme("comun-1");
            auditoria.setAudIdEntidad(idEntidad);
            auditoria.setAudTipoTransaccion("Ingreso de registro");
            
            AuditoriaDetalle detalle = new AuditoriaDetalle();
            
            for(Method iterM:metodos){
                if(iterM.getName().substring(0,3).trim().equals("get".trim()) || 
								iterM.getName().substring(0,2).trim().equals("is".trim())){
                
                    String nombreCampo="";
                    
                    if(iterM.getName().substring(0,2).trim().equals("is".trim())){
                        nombreCampo = iterM.getName().substring(2);
                    }
                    
                    if(iterM.getName().substring(0,3).trim().equals("get".trim())){
                        nombreCampo = iterM.getName().substring(3);
                    }
                    
                    try {
				
                        if(!iterM.getReturnType().getName().trim().equalsIgnoreCase(List.class.getName().trim())){
                            ejecutaA=nuevo.getClass().getMethod(iterM.getName(), null);
                            valorA = ejecutaA.invoke(nuevo, null).toString();
					
                                    Field campo = null;
                                    
                                    for (Field f : campos){
                                        if (f.getName().toUpperCase().trim().equals(nombreCampo.toUpperCase().trim())){
                                            campo = f;
                                            break;
                                        }
                                    }
                                    
                                    detalle=new AuditoriaDetalle();
                                    
                                    
                                    Column columna = campo.getAnnotation(Column.class);
                                    JoinColumn joinColumn = campo.getAnnotation(JoinColumn.class);
                                    
                                    if(columna != null)
                                        detalle.setAdtCampoAfectado(columna.name());
                                    if(joinColumn != null)
                                        detalle.setAdtCampoAfectado(joinColumn.name());									
                                    //detalle.setAdtValorAnterior(valorA);
                                    //detalle.setAdtValorActual(valorB);
                                    detalle.setAdtValorAnterior("");
                                    detalle.setAdtValorActual(valorA);
                                    detalle.setAuditoria(auditoria);
                                    auditoria.getLista().add(detalle);
                        }else{
                            if(iterM.getReturnType().getName().trim().equals(List.class.getName().trim())){
                                    valorA = "Lista original de datos";
                                        Field campo = null;

                                        for (Field f : campos){
                                            if (f.getName().toUpperCase().trim().equals(nombreCampo.toUpperCase().trim())){
                                                campo = f;
                                                break;
                                            }
                                        }

                                        detalle=new AuditoriaDetalle();
                                        detalle.setAdtCampoAfectado(campo.getName());									
                                        detalle.setAdtValorAnterior("");
                                        detalle.setAdtValorActual(valorA);
                                        detalle.setAuditoria(auditoria);
                                        auditoria.getLista().add(detalle);	
                                }
                        }
                    } catch (SecurityException e2) {
                            e2.printStackTrace();
                    } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                    //} catch(LazyInitializationException lie){
                        //    valorA = "lista";
                        //    valorB = "lista";
                    }catch(java.lang.NullPointerException np){
                            valorA="null";
                    } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                    } catch (IllegalAccessException e) {
                            e.printStackTrace();
                    } catch (InvocationTargetException e) {
                            e.printStackTrace();
                    }
                    
                }
            }

        
            //this.guardar(auditoria);
            return auditoria;
        } catch (Exception ex) {
            Logger.getLogger(AuditoriaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
        
    }
    
    
    //public Auditoria actualizarObjeto(E origin, F updated, String idEntidad, UsuarioSalida usuario) {
    public Auditoria actualizarObjeto(E origin, F updated, String idEntidad) {
        try {
            UsuarioSalida usuario = (UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto());
            
            String valorA,valorB;
            Method metodos[],ejecutaA,ejecutaB;
            Field campos[];
            
            metodos= origin.getClass().getMethods();
            campos= origin.getClass().getDeclaredFields();
            
            Table table = (Table) origin.getClass().getAnnotation(Table.class); //captura el nombre de la tabla afectada

            Auditoria auditoria = new Auditoria();
            auditoria.setAudEsquema(table.schema());
            auditoria.setAudTabla(table.name());
            auditoria.setAudFecha(new Date());
            auditoria.setAudUsuario(usuario.getUsuario());
            auditoria.setAudCodunme(usuario.getCodUnme());
            //auditoria.setAudUsuario("COMUN");
            //auditoria.setAudCodunme("COMUN-2");
            auditoria.setAudIdEntidad(idEntidad);
            auditoria.setAudTipoTransaccion("Actualizacion de registro");
            
            AuditoriaDetalle detalle = new AuditoriaDetalle();
            
            for(Method iterM:metodos){
                if(iterM.getName().substring(0,3).trim().equals("get".trim()) || 
								iterM.getName().substring(0,2).trim().equals("is".trim())){
                
                    String nombreCampo="";
                    
                    if(iterM.getName().substring(0,2).trim().equals("is".trim())){
                        nombreCampo = iterM.getName().substring(2);
                    }
                    
                    if(iterM.getName().substring(0,3).trim().equals("get".trim())){
                        nombreCampo = iterM.getName().substring(3);
                    }
                    
                    try {
				
                            if(!iterM.getReturnType().getName().trim().equalsIgnoreCase(List.class.getName().trim())){
                            ejecutaA=origin.getClass().getMethod(iterM.getName(), null);
                            ejecutaB=updated.getClass().getMethod(iterM.getName(), null);
							
                            valorA = ejecutaA.invoke(origin, null).toString();
                            valorB = ejecutaB.invoke(updated, null).toString();
				
                                if(!valorA.trim().equals(valorB.trim()) && valorA.length()<255 && valorB.length()<255){
					
                                    Field campo = null;
                                    
                                    for (Field f : campos){
                                        if (f.getName().toUpperCase().trim().equals(nombreCampo.toUpperCase().trim())){
                                            campo = f;
                                            break;
                                        }
                                    }
                                    
                                    detalle=new AuditoriaDetalle();
                                    
                                    
                                    Column columna = campo.getAnnotation(Column.class);
                                    JoinColumn joinColumn = campo.getAnnotation(JoinColumn.class);
                                    
                                    if(columna != null)
                                        detalle.setAdtCampoAfectado(columna.name());
                                    if(joinColumn != null)
                                        detalle.setAdtCampoAfectado(joinColumn.name());									
                                    detalle.setAdtValorAnterior(valorA);
                                    detalle.setAdtValorActual(valorB);
                                    detalle.setAuditoria(auditoria);
                                    auditoria.getLista().add(detalle);								
                                }
                            }else{
                                
                                if(iterM.getReturnType().getName().trim().equals(List.class.getName().trim())){
                                    valorA = "Lista original de datos";
                                    valorB = "lista con nuevos objetos";

                                    //if(!valorA.trim().equals(valorB.trim()) && valorA.length()<255 && valorB.length()<255){

                                        Field campo = null;

                                        for (Field f : campos){
                                            if (f.getName().toUpperCase().trim().equals(nombreCampo.toUpperCase().trim())){
                                                campo = f;
                                                break;
                                            }
                                        }

                                        detalle=new AuditoriaDetalle();


                                        //Column columna = campo.getAnnotation(Column.class);
                                        //JoinColumn joinColumn = campo.getAnnotation(JoinColumn.class);

                                        //if(columna != null)
                                        //   detalle.setAdtCampoAfectado(columna.name());
                                        //if(joinColumn != null)
                                        //    detalle.setAdtCampoAfectado(joinColumn.name());									
                                        detalle.setAdtCampoAfectado(campo.getName());									
                                        detalle.setAdtValorAnterior(valorA);
                                        detalle.setAdtValorActual(valorB);
                                        detalle.setAuditoria(auditoria);
                                        auditoria.getLista().add(detalle);								
                                    //}
                                }
                            }
                           
                    } catch (SecurityException e2) {
                            e2.printStackTrace();
                    } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                    //} catch(LazyInitializationException lie){
                    //        valorA = "lista";
                    //        valorB = "lista";
                    }catch(java.lang.NullPointerException np){
                            valorA="null";
                    } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                    } catch (IllegalAccessException e) {
                            e.printStackTrace();
                    } catch (InvocationTargetException e) {
                            e.printStackTrace();
                    }
                    
                }
            }
            
            //this.guardar(auditoria);
            return auditoria;
        } catch (Exception ex) {
            Logger.getLogger(AuditoriaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
