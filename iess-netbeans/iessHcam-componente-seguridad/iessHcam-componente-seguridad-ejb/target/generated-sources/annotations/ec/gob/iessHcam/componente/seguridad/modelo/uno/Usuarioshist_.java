package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuarioshist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Usuarioshist.class)
public class Usuarioshist_ { 

    public static volatile SingularAttribute<Usuarioshist, String> usClaveAnterior;
    public static volatile SingularAttribute<Usuarioshist, Integer> usIdUsuariohist;
    public static volatile SingularAttribute<Usuarioshist, String> usDireccionIp;
    public static volatile SingularAttribute<Usuarioshist, Date> usFecActualizacion;
    public static volatile SingularAttribute<Usuarioshist, String> usClaveActual;
    public static volatile SingularAttribute<Usuarioshist, Usuario> usIdUsuario;

}