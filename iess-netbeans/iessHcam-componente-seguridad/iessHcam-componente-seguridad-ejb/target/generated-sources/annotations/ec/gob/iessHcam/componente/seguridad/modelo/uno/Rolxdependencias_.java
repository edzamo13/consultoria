package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Roles;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxdependencias;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Rolxdependencias.class)
public class Rolxdependencias_ { 

    public static volatile SingularAttribute<Rolxdependencias, Roles> roIdRol;
    public static volatile SingularAttribute<Rolxdependencias, String> rdEstado;
    public static volatile SingularAttribute<Rolxdependencias, Dependencias> deIdDependencia;
    public static volatile SingularAttribute<Rolxdependencias, Integer> rdIdRolxdep;

}