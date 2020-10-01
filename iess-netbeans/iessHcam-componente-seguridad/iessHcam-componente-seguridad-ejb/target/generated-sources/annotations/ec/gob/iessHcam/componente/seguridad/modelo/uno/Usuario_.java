package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Intentos;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxusuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuarioshist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Usuarioshist> segUsuarioshistTblList;
    public static volatile ListAttribute<Usuario, Intentos> intentosList;
    public static volatile SingularAttribute<Usuario, String> usTelefono;
    public static volatile SingularAttribute<Usuario, Integer> usFuncionario;
    public static volatile SingularAttribute<Usuario, String> usCorreo;
    public static volatile SingularAttribute<Usuario, String> usCodUnme;
    public static volatile SingularAttribute<Usuario, Date> usFecCreacion;
    public static volatile SingularAttribute<Usuario, String> usUsuario;
    public static volatile SingularAttribute<Usuario, Date> usFecActualizacion;
    public static volatile SingularAttribute<Usuario, Date> usFecCaducidad;
    public static volatile SingularAttribute<Usuario, String> usClave;
    public static volatile SingularAttribute<Usuario, Integer> usClaveMig;
    public static volatile SingularAttribute<Usuario, Integer> usIdUsuarioCreacion;
    public static volatile SingularAttribute<Usuario, String> usEsBloqueo;
    public static volatile SingularAttribute<Usuario, Integer> caIdCategoria;
    public static volatile SingularAttribute<Usuario, String> usNombrePersona;
    public static volatile ListAttribute<Usuario, Rolxusuario> segRolxusuarioTblList;
    public static volatile SingularAttribute<Usuario, String> usClaveAnterior;
    public static volatile SingularAttribute<Usuario, Integer> catEstado;
    public static volatile SingularAttribute<Usuario, Integer> usIdUsuarioAct;
    public static volatile SingularAttribute<Usuario, Integer> usIdUsuario;
    public static volatile SingularAttribute<Usuario, String> usNumDocumento;
    public static volatile SingularAttribute<Usuario, byte[]> usFoto;

}