package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Roles;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxdependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxmenu;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxusuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Tiporoles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> roEstado;
    public static volatile SingularAttribute<Roles, Integer> roIdRol;
    public static volatile SingularAttribute<Roles, String> roNombre;
    public static volatile ListAttribute<Roles, Rolxusuario> segRolxusuarioTblList;
    public static volatile SingularAttribute<Roles, String> roDescripcion;
    public static volatile SingularAttribute<Roles, Tiporoles> trIdTiporol;
    public static volatile ListAttribute<Roles, Rolxmenu> segRolxmenuTblList;
    public static volatile ListAttribute<Roles, Rolxdependencias> segRolxdependenciasTblList;

}