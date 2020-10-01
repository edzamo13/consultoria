package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Roles;
import ec.gob.iessHcam.componente.seguridad.modelo.Tiporoles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Tiporoles.class)
public class Tiporoles_ { 

    public static volatile SingularAttribute<Tiporoles, String> trNombre;
    public static volatile SingularAttribute<Tiporoles, String> trEstado;
    public static volatile SingularAttribute<Tiporoles, Integer> trIdTiporol;
    public static volatile ListAttribute<Tiporoles, Roles> segRolesTblList;
    public static volatile SingularAttribute<Tiporoles, String> trDescripcion;

}