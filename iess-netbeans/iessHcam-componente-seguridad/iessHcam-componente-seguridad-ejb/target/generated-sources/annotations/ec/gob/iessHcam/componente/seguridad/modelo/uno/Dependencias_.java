package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Instituciones;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxdependencias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Dependencias.class)
public class Dependencias_ { 

    public static volatile SingularAttribute<Dependencias, Instituciones> inIdInstitucion;
    public static volatile SingularAttribute<Dependencias, String> deEstado;
    public static volatile SingularAttribute<Dependencias, Integer> deIdDependenciaPadre;
    public static volatile SingularAttribute<Dependencias, Integer> deIdDependencia;
    public static volatile ListAttribute<Dependencias, Aplicacion> segAplicacionesTblList;
    public static volatile SingularAttribute<Dependencias, String> deTipoDependencia;
    public static volatile SingularAttribute<Dependencias, String> deNombre;
    public static volatile ListAttribute<Dependencias, Rolxdependencias> segRolxdependenciasTblList;

}