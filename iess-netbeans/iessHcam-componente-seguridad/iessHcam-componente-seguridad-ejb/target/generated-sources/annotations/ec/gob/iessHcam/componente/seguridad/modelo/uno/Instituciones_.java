package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Instituciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Instituciones.class)
public class Instituciones_ { 

    public static volatile SingularAttribute<Instituciones, Integer> inIdInstitucion;
    public static volatile ListAttribute<Instituciones, Dependencias> segDependenciasTblList;
    public static volatile SingularAttribute<Instituciones, String> inEstado;
    public static volatile SingularAttribute<Instituciones, String> inNombre;

}