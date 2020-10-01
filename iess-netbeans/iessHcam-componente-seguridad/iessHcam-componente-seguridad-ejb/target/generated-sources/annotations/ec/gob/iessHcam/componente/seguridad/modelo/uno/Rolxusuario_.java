package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Roles;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxusuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Rolxusuario.class)
public class Rolxusuario_ { 

    public static volatile SingularAttribute<Rolxusuario, String> ruEstado;
    public static volatile SingularAttribute<Rolxusuario, Integer> ruIdRolxusu;
    public static volatile SingularAttribute<Rolxusuario, String> ipEquipo;
    public static volatile SingularAttribute<Rolxusuario, Roles> roIdRol;
    public static volatile SingularAttribute<Rolxusuario, Integer> idUsuCreacion;
    public static volatile SingularAttribute<Rolxusuario, Date> fecCreacion;
    public static volatile SingularAttribute<Rolxusuario, Usuario> usIdUsuario;

}